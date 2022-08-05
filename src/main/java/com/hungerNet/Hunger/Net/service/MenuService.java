package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.menuDTO.MenuDTO;
import com.hungerNet.Hunger.Net.dto.menuDTO.MenuListDTO;
import com.hungerNet.Hunger.Net.enums.MenuNames;
import com.hungerNet.Hunger.Net.mapper.MenuMapper;
import com.hungerNet.Hunger.Net.model.Menu;
import com.hungerNet.Hunger.Net.repository.MenuRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class MenuService {

    private final MenuRepo menuRepo;
    private final MenuMapper menuMapper;

    public MenuDTO getMenuById(UUID menuId) {
        return menuMapper.toDTO(menuRepo.getReferenceById(menuId));
    }

    @Scheduled(fixedDelay = 100000)
    public void changeMenuStatus(){
        List<Menu> menus = menuRepo.findAll();
        LocalTime target = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        for (Menu menu : menus) {
            Boolean isMenuActive = target.isAfter(menu.getStartTime())
                    && target.isBefore(menu.getEndTime());
            menu.setMenuStatus(isMenuActive);
            menuRepo.save(menu);
        }
    }

    public List<MenuDTO> getMenus() {
        return menuMapper.toDTOs(menuRepo.findAll());
    }
    public MenuDTO addNewMenu(MenuDTO menuDTO){
        Menu createdMenu = menuRepo.save(menuMapper.toModel(menuDTO));
        return menuMapper.toDTO(createdMenu);
    }
    public MenuDTO updateMenu(MenuDTO menuDTO) {
        Menu menu = menuMapper.toModel(menuDTO);
        menuRepo.save(menu);
        return menuMapper.toDTO(menu);
    }
    public void deleteMenu(UUID menuId) {
        menuRepo.deleteById(menuId);
    }
    public List<MenuDTO> getMenusByRestaurant(UUID restaurantId) {
        return menuMapper.toDTOs(menuRepo.getMenuByRestaurantsRestaurantId(restaurantId));
    }
    public List<MenuDTO> getMenusByRestaurantAndUser(MenuListDTO menuListDTO) {
        return menuMapper.toDTOs(menuRepo.getMenusByRestaurantAndUser(menuListDTO.getRestaurantId(), menuListDTO.getUserId()));
    }
}
