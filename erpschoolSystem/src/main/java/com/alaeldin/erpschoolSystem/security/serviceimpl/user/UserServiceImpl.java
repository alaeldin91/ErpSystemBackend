package com.alaeldin.erpschoolSystem.security.serviceimpl.user;

import com.alaeldin.erpschoolSystem.configjwt.service.JwtService;
import com.alaeldin.erpschoolSystem.exception.existdata.EmailAlreadyExistsException;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.security.dto.user.request.UserLoginRequest;
import com.alaeldin.erpschoolSystem.security.dto.user.request.UserRegisterRequestDto;
import com.alaeldin.erpschoolSystem.security.dto.user.response.UserResponseDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import com.alaeldin.erpschoolSystem.security.entity.user.User;
import com.alaeldin.erpschoolSystem.security.mapper.UserMapper;
import com.alaeldin.erpschoolSystem.security.repository.role.RoleRepository;
import com.alaeldin.erpschoolSystem.security.repository.user.UserRepository;
import com.alaeldin.erpschoolSystem.security.service.user.UserService;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    public    String SECRET_KEY = "48404D635166546A576E5A7234753778217A25432A462D4A614E645267556B58";

    private final PasswordEncoder passwordEncoder;
   public static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponseDto register(UserRegisterRequestDto userRegisterRequestDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userRegisterRequestDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email is Already Exist");
        }
        List<Role> roles = roleRepository.findAll();
        Role role = null  ;
        for(int i=0;i<roles.size();i++){
            role = roles.get(i);
        }
        Set<Role> roleSet = new HashSet<>();

        roleSet.add(role);
        logger.info("***************jdjhhd");
        logger.info(roleSet+" "+roles);

        User user = User.builder().firstName(userRegisterRequestDto.getFirstName())
                .lastName(userRegisterRequestDto.getLastName()).email(userRegisterRequestDto.getEmail()).password(passwordEncoder.encode(userRegisterRequestDto.getPassword())).roles(roleSet).build();

        User userSave = userRepository.save(user);
        var token = jwtService.generateToken(user, role);

        return UserResponseDto.builder().token(token).lastName(userSave.getLastName()).firstName(userSave.getFirstName()).email(userSave.getEmail()).build();
    }

    @Override
    public UserResponseDto authenticate(UserLoginRequest userLoginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest

                .getEmail(), userLoginRequest.getPassword()));

        var user = userRepository.findByEmail(userLoginRequest.getEmail()).orElseThrow();
        Role role = null;
        Set<Role> roles = user.getRoles();
        ArrayList<Role> roleList = new ArrayList<>(roles);
        for (int i = 0; i < roleList.size(); i++) {

            role = roleRepository.findByRoleName(roleList.get(i).getRoleName()).orElseThrow();
        }
        System.out.println("*******_Role:"+role);
        System.out.println("*******_User:"+user.getEmail());
        var token = jwtService.generateToken(user, role);
        System.out.println("*******_Token:"+token);
        assert role != null;
        return UserResponseDto.builder().firstName(user.getFirstName()).lastName(user.getLastName())
                .email(user.getEmail()).token(token).build();
    }

    @Override
    public void deleteAccount(Integer id) {
        User existingAccount = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("user", "id", id));
        userRepository.delete(existingAccount);
    }

    @Override
    public Page<User> getAllAccount(int page,int size) {
        Pageable pageable  = PageRequest.of(page,size);
        Page<User> users = userRepository.findAll(pageable);
        System.out.println("*************** ");
        System.out.println(users);

        return users;
    }



    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
       // UserResponseDto userResponseDto = new UserResponseDto(user.getLastName(),);

        return user;
    }

    @Override
    public UserResponseDto validateToken(String token) {
        logger.info("####### token #############");
        logger.info(token);
        logger.info("####### token #############");
        String extractToken = extractToken(token);
       String userName = jwtService.extractEmail(extractToken);
        logger.info(userName);
        try {
            logger.info("####### LOGIN #############");
            logger.info("login:" + userName.toString());
            Optional<User> emailOptinal = userRepository.findByEmail(userName);
            if (emailOptinal.isEmpty()) {
                throw new ResourceNotFoundException("user", "email", 1);
            }
            User user = emailOptinal.get();

            Role role = null;
            Set<Role> roles = user.getRoles();
            ArrayList<Role> roleArrayList = new ArrayList<>(roles);
            for (int i = 0; i < roleArrayList.size(); i++) {
                role = roleRepository.findByRoleName(roleArrayList.get(i).getRoleName()).orElseThrow();
            }

            return UserResponseDto.builder().firstName(user.getFirstName()).lastName(user.getLastName())
                    .email(user.getEmail()).token(token).build();


        } catch (Exception e) {
            logger.info("IAM HERE EROOR ________________________");
            logger.info(e.getMessage());
            return null;
        }
    }

    @Override
    public UserResponseDto updateUser(UserRegisterRequestDto userRegisterRequestDto) {
        User userExist = userRepository.findById(userRegisterRequestDto.getId())
                .orElseThrow(()->new ResourceNotFoundException("user","userId",userRegisterRequestDto.getId()));
        userExist.setFirstName(userRegisterRequestDto.getFirstName());
        userExist.setLastName(userRegisterRequestDto.getLastName());
        userExist.setEmail(userRegisterRequestDto.getEmail());

        System.out.println("*******************************");
        System.out.println(userRegisterRequestDto.getRoles());

        userExist.setRoles(userRegisterRequestDto.getRoles());

        User userSave = userRepository.save(userExist);
        return UserMapper.touserResponseDto(userSave);
    }

    private static String extractToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            logger.info( bearerToken.substring(7));
            return bearerToken.substring(7);

        }
        return "Error Invalid";
    }
    private Key getSignKey() {
        String keyBytes = Encoders.BASE64URL.encode(SECRET_KEY.getBytes());
        return Keys.hmacShaKeyFor(keyBytes.getBytes());
    }

}
