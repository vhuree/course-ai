package com.elearning.ai.util;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;
import java.time.Duration;
import java.util.Arrays;

public class CookieUtil {

    public static String readServletCookie(HttpServletRequest request){
        return Arrays.stream(request.getCookies())
                .filter(cookie->"auth-token".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny().orElse(null);
    }

    public static ResponseCookie generateCookie(String jwtToken){
        // Building cookies
        ResponseCookie cookie = ResponseCookie.from("auth-token", jwtToken)
                .httpOnly(true)
                .secure(false)
                .path("/")      // path
                .maxAge(Duration.ofHours(8))
                .sameSite("Strict")  // sameSite
                .build();

        return cookie;
    }

}
