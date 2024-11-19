package murach.util;

import jakarta.servlet.http.Cookie;

public class CookieUtil {
    public CookieUtil() {
    }

    public static String getCookieValue(Cookie[] cookies, String cookieName) {
        String cookieValue = "";
        if (cookies != null) {
            Cookie[] var3 = cookies;
            int var4 = cookies.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Cookie cookie = var3[var5];
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }

        return cookieValue;
    }
}
