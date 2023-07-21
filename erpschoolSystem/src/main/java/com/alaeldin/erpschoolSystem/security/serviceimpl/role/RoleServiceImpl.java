package com.alaeldin.erpschoolSystem.security.serviceimpl.role;

import com.alaeldin.erpschoolSystem.exception.existdata.RoleAlreadyExist;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.security.dto.role.RoleDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import com.alaeldin.erpschoolSystem.security.mapper.RoleMapper;
import com.alaeldin.erpschoolSystem.security.repository.role.RoleRepository;
import com.alaeldin.erpschoolSystem.security.service.role.RoleService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
   private final Logger logger = LogManager.getLogger(RoleServiceImpl.class);

   @Override
    public Page<RoleDto> getAllRole( int pageNumber,int pageSize) {
       Pageable pageable = PageRequest.of(pageNumber, pageSize);
       Page<Role> roles = roleRepository.findAll(pageable);
       Page<RoleDto> roleDtoList = roles.map(role -> RoleMapper.mapToRoleDto(role));

       return roleDtoList;

   }

    @Override
    public List<RoleDto> getRoleList() {
        List<Role> roleList = roleRepository.findAll();
        return roleList.stream().map(RoleMapper::mapToRoleDto).toList();
    }

    @Override
    public RoleDto getRoleById(Integer roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() ->
                new ResourceNotFoundException("Role", "id", roleId));
        return RoleMapper.mapToRoleDto(role);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Optional<Role> optionalRole = roleRepository.findByRoleName(roleDto.getRoleName());
        if (optionalRole.isPresent()) {
            throw new RoleAlreadyExist("Role Already Exist");
        }
        Role role = RoleMapper.mapToRole(roleDto);

        Role saveRole = roleRepository.save(role);
        logger.info(saveRole.getRoleName());

        RoleDto roleDto1 = RoleMapper.mapToRoleDto(saveRole);
        return roleDto1;
    }

    @Override
    public RoleDto updateRole(RoleDto role) {
        Role roleExisting = roleRepository.findById(role.getId()).orElseThrow(() ->
                new ResourceNotFoundException("role", "id", role.getId()));
        roleExisting.setRoleName(role.getRoleName());
        roleExisting.setRoleDescription(role.getRoleDescription());
        Role saveRole = roleRepository.save(roleExisting);
        return RoleMapper.mapToRoleDto(saveRole);
    }

    @Override
    public RoleDto findByNameContaining(String roleName) {
        return null;
    }

    @Override
    public void deleteRole(Integer id) {
    Role existingRole = roleRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("role","id",id));
    roleRepository.delete(existingRole);
    }


}
