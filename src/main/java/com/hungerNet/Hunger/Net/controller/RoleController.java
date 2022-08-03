package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import com.hungerNet.Hunger.Net.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("getAll")
    public ResponseEntity<List<RoleDTO>> findAllRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }
    @GetMapping("roleId/{roleId}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable UUID roleId) {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }
    @PostMapping("addNewRole")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleService.addNewRole(roleDTO));
    }
    @PutMapping("updateRole")
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.updateRole(roleDTO));
    }
    @DeleteMapping("delete/{roleId}")
    public void deleteRole(@PathVariable UUID roleId) {
        roleService.deleteRole(roleId);
    }
}
