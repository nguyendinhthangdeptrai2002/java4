package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	public static void addCookie(String name, String val, int seconds, String efftectedPath, HttpServletResponse resp) {
		Cookie cookie = new Cookie(name, val);
		cookie.setMaxAge(seconds);
		cookie.setPath(efftectedPath);
		resp.addCookie(cookie);
	}

	public static void addCookie(String name, String val, int seconds, HttpServletResponse resp) {
		addCookie(name, val, seconds, "/", resp);
	}

	public static Cookie getCookie(String name, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies)
				if (c.getName().equalsIgnoreCase(name))
					return c;
		}
		return new Cookie(name, "");
	}

	public static String getValue(String name, HttpServletRequest req) {
		Cookie c = getCookie(name, req);
		return c != null ? c.getValue() : "";
	}
	
	public static void destroy(String name, HttpServletRequest req) {
		getCookie(name, req).setMaxAge(0);
	}
}
