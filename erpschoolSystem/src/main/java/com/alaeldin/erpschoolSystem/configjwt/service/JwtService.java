package com.alaeldin.erpschoolSystem.configjwt.service;

import com.alaeldin.erpschoolSystem.security.dto.user.response.UserResponseDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import com.alaeldin.erpschoolSystem.security.entity.user.User;
import com.alaeldin.erpschoolSystem.security.repository.role.RoleRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
@AllArgsConstructor
@Service
public class JwtService {
    public static final String SECRET_KEY = "48404D635166546A576E5A7234753778217A25432A462D4A614E645267556B58";
    private final RoleRepository roleRepository;


    public String extractEmail(String token){

        return extractClaim(token,Claims::getSubject);
    }
   public String generateToken(User userDetails, Role role){
        return generateToken(new HashMap<>(),userDetails,role);
   }

   public boolean isTokenValid(String token , UserDetails userDetails){
   final String userName = extractEmail(token);
   final Object role = getRole(token);
       UserResponseDto userResponseDto = new UserResponseDto();
   return ((userName.equals(userDetails.getUsername()))&& (!isTokenExpired(token)));
   }


    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Object getRole(String token){

        extractAllClaims(token);
        return extractAllClaims(token).get("role");
    }
    public Date extractExpiration(String token ){
        return extractClaim(token,Claims::getExpiration);
   }

    public <T> T extractClaim(String token, Function<Claims,T> claimResolver ) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
      Claims   extractAllClaims =  Jwts.parserBuilder()
              .setSigningKey(getSignKey())
              .build().
              parseClaimsJws(token)
              .getBody();
      return extractAllClaims;
    }



    public String generateToken(Map<String,String>extractClaims,User userDetails ,Role role){

        Role roleName = roleRepository.findByRoleName(role.getRoleName()).orElseThrow();
        extractClaims.put("role",roleName.getRoleName());
        String generateToken = Jwts.builder()
                .setClaims(extractClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 * 10))
            .signWith(getSignKey(), SignatureAlgorithm.HS256)
            .compact();
      return generateToken;
}
 private Key getSignKey() {
    String keyBytes = Encoders.BASE64URL.encode(SECRET_KEY.getBytes());
    return Keys.hmacShaKeyFor(keyBytes.getBytes());
    }
}
