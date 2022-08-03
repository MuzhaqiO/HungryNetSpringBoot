package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import com.hungerNet.Hunger.Net.mapper.RoleMapper;
import com.hungerNet.Hunger.Net.model.Role;
import com.hungerNet.Hunger.Net.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;
    private final RoleMapper roleMapper;

    public RoleDTO getRoleById(UUID roleId) {
        return roleMapper.toDTO(roleRepo.getReferenceById(roleId));
    }
    public List<RoleDTO> getRoles() {
        return roleMapper.toDTOs(roleRepo.findAll());
    }
    public RoleDTO addNewRole(RoleDTO roleDTO){
        Role createdRole = roleRepo.save(roleMapper.toModel(roleDTO));
        return roleMapper.toDTO(createdRole);
    }
    public RoleDTO updateRole(RoleDTO roleDTO) {
        Role role = roleMapper.toModel(roleDTO);
        roleRepo.save(role);
        return roleMapper.toDTO(role);
    }
    public void deleteRole(UUID roleId) {
        roleRepo.deleteById(roleId);
    }
}
