package com.sare.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorType {

    BADREQUEST(4002, "Girilen parametreler hatalıdır.",BAD_REQUEST),
    SIFREHATASI(4003, "Girilen şifreler uyuşmamaktadır.",BAD_REQUEST),
    EMAILSIFREHATASI(4004, "Hasta adı ya da şifre hatalıdır.",BAD_REQUEST),
    YETKIHATASI(4005,"Bu islemi yapma yetkiniz yoktur.",BAD_REQUEST),
    INVALIDTOKEN(4999, "Geçersiz token bilgisi.",FORBIDDEN),
    INTERNALSERVER(5000, "Sunucuda beklenmeyen bir hata oluştu.",INTERNAL_SERVER_ERROR);

    int code;
    String message;
    HttpStatus httpStatus;

}
