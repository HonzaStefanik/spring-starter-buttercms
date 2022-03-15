package com.buttercms.springstarterbuttercms.service;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PostsResponse;
import com.buttercms.springstarterbuttercms.model.landingpage.Field;
import com.buttercms.springstarterbuttercms.model.landingpage.Fields;
import com.buttercms.springstarterbuttercms.model.landingpage.Section;
import com.buttercms.springstarterbuttercms.model.navigation.MenuItem;
import com.buttercms.springstarterbuttercms.model.navigation.NavigationMenu;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PageCollectionService {

    private final IButterCMSClient butterCMSClient;

    public PageCollectionService(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    public void addDataToLandingPage(Model model) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("page", "1");
            put("page_size", "2");
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        Fields landingPage = fetchLandingPage();
        List<Section> sections = extractSections(landingPage);
        model.addAttribute("posts", posts.getData());
        model.addAttribute("seoTitle", landingPage.getSeo().getTitle());
        model.addAttribute("seoDescription", landingPage.getSeo().getDescription());
        model.addAttribute("sections", sections);
    }

    public List<MenuItem> fetchNavigation() {
        List<NavigationMenu> nav = butterCMSClient.getCollection(
                "navigation_menu",
                Collections.emptyMap(),
                NavigationMenu.class
        ).getData().getItems();
        return nav.stream()
                .filter(Objects::nonNull)
                .flatMap(navMenu -> navMenu.getMenuItems().stream())
                .collect(Collectors.toList());
    }

    private Fields fetchLandingPage() {
        return butterCMSClient.getPage("*",
                        "landing-page-with-components"
                        , Collections.emptyMap(),
                        Fields.class
                ).getData().getFields();
    }

    private List<Section> extractSections(Fields fields) {
        return fields.getFields()
                .stream()
                .map(Field::getSection)
                .collect(Collectors.toList());
    }
}
