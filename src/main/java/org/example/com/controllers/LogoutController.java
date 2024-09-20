package org.example.com.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp
    ) throws ServletException, IOException {
        // Xóa session
        HttpSession session = req.getSession(false);
        if (session != null)
            session.invalidate(); // Remove session

        // Xóa cookie nhớ đăng nhập
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookie.setMaxAge(0); // Remove cookie
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/auth/login");
    }
}
