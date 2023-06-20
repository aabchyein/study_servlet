package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CheckoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String address2 = request.getParameter("address2");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");


            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "    <title>Form</title>\r\n" + //
                    "\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"m-5\">\r\n" + //
                    "        <h3>Billing address</h3>\r\n" + //
                    "    <form action=\"/CheckoutResponseServlet\" method=\"get\">\r\n" + //
                    "    <div class=\"row\">\r\n" + //
                    "        \r\n" + //
                    "        <div class=\"col-4 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"firstname\">First name</label><input class=\"form-control\" type=\"text\" name="+first_name+" id=\"firstname\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-4 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"lastname\">Last name</label><input class=\"form-control\" type=\"text\" name="+last_name+" id=\"lastname\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"username\">User name</label><input class=\"form-control\" type=\"text\" name="+username+" id=\"username\" placeholder=\"Username\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"email\">Email</label><input class=\"form-control\" type=\"text\" name="+email+" id=\"+email\" placeholder=\"you@example.com\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"address\">Address</label><input class=\"form-control\" type=\"text\" name="+address+" id=\"address\" placeholder=\"1234 Main St\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"address2\">Address2</label><input class=\"form-control\" type=\"text\" name="+address2+" id=\"address2\" placeholder=\"Apartment or suite\">\r\n" + //
                    "        </div>\r\n" + //
                    "        \r\n" + //
                    "        <div class=\"row\">\r\n" + //
                    "        <div class=\"col-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"\">Country</label>\r\n" + //
                    "            <select class=\"form-select\" name="+country+" id=\"Country\">\r\n" + //
                    "                <option value=\"\" selected>Choose...</option>\r\n" + //
                    "                <option value=\"southkorea\">South Korea</option>\r\n" + //
                    "                <option value=\"unitedstates\">United States</option>\r\n" + //
                    "                <option value=\"france\">France</option>\r\n" + //
                    "            </select>\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"\">State</label>\r\n" + //
                    "            <select class=\"form-select\" name="+state+" id=\"state\">\r\n" + //
                    "                <option value=\"\" selected>Choose...</option>\r\n" + //
                    "                <option value=\"washington\">Washington</option>\r\n" + //
                    "                <option value=\"california\">California</option>\r\n" + //
                    "                <option value=\"utah\">Utah</option>\r\n" + //
                    "            </select>\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"zip\">Zip</label><input class=\"form-control\" type=\"text\" name="+zip+" id=\"zip\">\r\n" + //
                    "        </div>\r\n" + //
                    "        </div>\r\n" + //
                    "        <div>\r\n" + //
                    "            <button type=\"submit\">submit</button>\r\n" + //
                    "        </div>\r\n" + //
                    "    </div>\r\n" + //
                    "    </form>\r\n" + //
                    "    </div>\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>\r\n" + //
                    "\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
