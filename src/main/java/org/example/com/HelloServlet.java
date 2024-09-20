package org.example.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/index")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

//        response.sendRedirect("https://www.google.com");

//        response.sendRedirect("index.html");
        response.setContentType("text/html");
        try {
            request.getRequestDispatcher("index.html").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            throw new ServletException("Error forwarding to index.html", e);
        }
    }

    public void destroy() {
    }
}