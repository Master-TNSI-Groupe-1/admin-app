package com.application.configuration;

public interface PageURL {
    String all = "/";
    String login = "/login";
    String loginError = "/login-error";
    String logout = "/logout";
    String home = "/home";

    String location = "/location";
    String locationFind = "/find";
    String locationUpdate = "/update";
    String locationCreate = "/create";

    String pointXY = "/pointxy";
    String createPointXY = "/create";
    String removePointXY = "/delete";

//    Spring securirty

    String homeAuthorization = "/home/**";
    String pointXYAuthorization = "/pointxy/**";
    String locationAuthorization = "/location/**";

    String css = "/css/**";
    String js = "/js/**";
    String webjars = "/webjars/**";
}
