package com.sare.config;

public class RestApis {

    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String BASE_URL = DEV + VERSION;

    public static final String KULLANICI = BASE_URL + "/kullanici";
    public static final String RANDEVU = BASE_URL + "/randevu";
    public static final String ROL = BASE_URL + "/rol";

    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";

    public static final String ROLEKLE = "/rol-ekle";
    public static final String RANDEVUEKLE = "/randevu-ekle";
}