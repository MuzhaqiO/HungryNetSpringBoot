package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import com.hungerNet.Hunger.Net.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO (Role role);
    List<RoleDTO> toDTOs (List<Role> roles);
    Role toModel (RoleDTO roleDTO);
    List<Role> toModels (List<RoleDTO> roleDTOs);
}
