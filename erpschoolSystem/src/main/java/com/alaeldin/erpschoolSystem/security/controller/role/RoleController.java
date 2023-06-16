package com.alaeldin.erpschoolSystem.security.controller.role;


import com.alaeldin.erpschoolSystem.security.dto.role.RoleDto;
import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import com.alaeldin.erpschoolSystem.security.serviceimpl.role.RoleServiceImpl;
import com.alaeldin.erpschoolSystem.security.serviceimpl.user.UserServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/admin/roles")
public class RoleController {
    Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private final RoleServiceImpl roleService;
     @PostMapping("/create")
     public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleDto roleDto) {
        RoleDto saveRole = roleService.saveRole(roleDto);
        return new ResponseEntity<>(saveRole, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Integer roleId) {
        RoleDto roleDto = roleService.getRoleById(roleId);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> rolesDto = roleService.getAllRole();
        return new ResponseEntity<>(rolesDto, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable("id") Integer roleId, @RequestBody @Valid RoleDto role) {
        role.setId(roleId);
        RoleDto updateRole = roleService.updateRole(role);
        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Integer roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>("Role successfully deleted!", HttpStatus.OK);
    }

}
