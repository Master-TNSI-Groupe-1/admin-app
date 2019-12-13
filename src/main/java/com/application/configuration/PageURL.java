package com.application.configuration;

public interface PageURL {
    String all = "/";
    String login = "/login";
    String loginError = "/login-error";
    String logout = "/logout";
    String home = "/home";

    String place = "/places";
    String createPlace = "/create";
    String updatePlace = "/update";

    String css = "/css/**";
    String js = "/js/**";
    String webjars = "/webjars/**";
}
