package rms.service;

import rms.entity.MenuItem;

import java.io.File;
import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(Integer id);
    MenuItem addMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Integer id, MenuItem menuItem);
    void deleteMenuItem(Integer id);
}
