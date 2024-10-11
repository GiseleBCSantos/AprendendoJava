package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

public class OiMundo extends HttpServlet {

    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Oi Mundo</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
