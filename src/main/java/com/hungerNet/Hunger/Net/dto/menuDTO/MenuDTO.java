package com.hungerNet.Hunger.Net.dto.menuDTO;

import com.hungerNet.Hunger.Net.dto.itemDTO.UpdateItemDTO;
import com.hungerNet.Hunger.Net.enums.MenuNames;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.UUID;

@Data
public class MenuDTO {
    private UUID restaurantId;
    private UUID menuId;
    @Enumerated(EnumType.STRING)
    private MenuNames menuName;
    private String startTime;
    private String endTime;
    private Boolean menuStatus;
    private List<UpdateItemDTO> items;
}
