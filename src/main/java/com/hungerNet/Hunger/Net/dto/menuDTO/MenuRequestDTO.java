package com.hungerNet.Hunger.Net.dto.menuDTO;

import com.hungerNet.Hunger.Net.enums.MenuNames;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
public class MenuRequestDTO {
    private UUID restaurantId;
    private UUID menuId;
    @Enumerated(EnumType.STRING)
    private MenuNames menuName;
    private String startTime;
    private String endTime;
}
