package rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rms.entity.MenuItem;

import rms.service.impl.MenuItemServiceImpl;

import java.io.File;
import java.util.List;

@RestController
public class MenuItemController {
    @Autowired
    private MenuItemServiceImpl menuItemService;

    @GetMapping("/MenuList")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Integer id) {
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        return new ResponseEntity<>(menuItem, HttpStatus.OK);
    }

    @PostMapping("/Menuitems")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem addedMenuItem = menuItemService.addMenuItem(menuItem);
        return new ResponseEntity<>(addedMenuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Integer id, @RequestBody MenuItem menuItem) {
        MenuItem updatedMenuItem = menuItemService.updateMenuItem(id, menuItem);
        return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Integer id) {
        menuItemService.deleteMenuItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}