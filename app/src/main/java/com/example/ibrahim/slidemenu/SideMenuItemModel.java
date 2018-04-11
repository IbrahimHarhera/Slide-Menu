package com.example.ibrahim.slidemenu;

/**
 * Created by Ahmed on 5/31/2017.
 */

public class SideMenuItemModel {


    private int imageResource;
    private String menuItemName;

    public SideMenuItemModel(int image, String name) {
        this.imageResource = image;
        this.menuItemName = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }
}
