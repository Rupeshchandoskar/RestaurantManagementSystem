package rms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.entity.MenuItem;
import rms.repository.MenuItemRepository;
import rms.service.MenuItemService;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Integer id) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(id);
        if (menuItem.isPresent()){
            return menuItem.get();
        }else throw new RuntimeException("Menu item with such id doesn't exist: " +id);
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(Integer id, MenuItem menuItem) {
        Optional<MenuItem> existingMenuItem = menuItemRepository.findById(id);
        if (existingMenuItem.isPresent()) {
            MenuItem updatedMenuItem = existingMenuItem.get();
            updatedMenuItem.setItemName(menuItem.getItemName());
            updatedMenuItem.setItemPrice(menuItem.getItemPrice());
            updatedMenuItem.setItemCategory(menuItem.getItemCategory());
            updatedMenuItem.setItemDescription(menuItem.getItemDescription());
            return menuItemRepository.save(updatedMenuItem);
        } else {
            throw new RuntimeException("Menu item not found with id " + id);
        }
    }

    @Override
    public void deleteMenuItem(Integer id) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(id);
        if (menuItem.isPresent()) {
            menuItemRepository.delete(menuItem.get());
        } else {
            throw new RuntimeException("Menu item not found with id " + id);
        }
    }
}
