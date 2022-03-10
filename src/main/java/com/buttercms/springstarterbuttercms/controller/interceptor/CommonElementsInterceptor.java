package com.buttercms.springstarterbuttercms.controller.interceptor;

import com.buttercms.springstarterbuttercms.service.ButterCMSService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CommonElementsInterceptor implements HandlerInterceptor {

    private final ButterCMSService butterCMSService;

    public CommonElementsInterceptor(ButterCMSService butterCMSService) {
        this.butterCMSService = butterCMSService;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        modelAndView.getModel().put(
                "menuItems", butterCMSService.retrieveNavigation()
        );
    }
}
