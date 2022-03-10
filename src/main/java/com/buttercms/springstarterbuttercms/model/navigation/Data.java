package com.buttercms.springstarterbuttercms.model.navigation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    @JsonProperty("navigation_menu")
    private List<NavigationMenu> navigationMenu;

    public List<NavigationMenu> getNavigationMenu() {
        return navigationMenu;
    }

    public void setNavigationMenu(List<NavigationMenu> navigationMenu) {
        this.navigationMenu = navigationMenu;
    }
}
