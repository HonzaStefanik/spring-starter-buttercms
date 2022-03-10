package com.buttercms.springstarterbuttercms.service;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PageResponse;
import com.buttercms.springstarterbuttercms.model.navigation.MenuItem;
import com.buttercms.springstarterbuttercms.model.navigation.Data;
import com.buttercms.springstarterbuttercms.model.navigation.NavigationMenu;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ButterCMSService {

    private final IButterCMSClient butterCMSClient;

    public ButterCMSService(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    public List<MenuItem> retrieveNavigation() {
        List<NavigationMenu> nav = butterCMSClient.getCollection("navigation_menu", Collections.emptyMap(), NavigationMenu.class)
                .getData().getItems();
        return nav.stream()
                .filter(Objects::nonNull)
                .flatMap(navMenu -> navMenu.getMenuItems().stream())
                .collect(Collectors.toList());
    }

    public void retrieveLandingPage() {

    }

    // todo maybe add methods to expose client's other methods? probably not needed
    public <T> PageResponse<T> retrievePage() {
        return null;
    }
}
