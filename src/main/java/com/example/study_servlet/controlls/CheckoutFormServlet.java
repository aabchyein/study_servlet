package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CheckoutFormServlet")
public class CheckoutFormServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
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
                    "            <label class=\"form-label\" for=\"firstname\">First name</label><input class=\"form-control\" type=\"text\" name=\"first_name\" id=\"firstname\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-4 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"lastname\">Last name</label><input class=\"form-control\" type=\"text\" name=\"last_name\" id=\"lastname\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"username\">User name</label><input class=\"form-control\" type=\"text\" name=\"user_name\" id=\"username\" placeholder=\"Username\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"email\">Email</label><input class=\"form-control\" type=\"text\" name=\"email\" id=\"email\" placeholder=\"you@example.com\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"address\">Address</label><input class=\"form-control\" type=\"text\" name=\"address\" id=\"address\" placeholder=\"1234 Main St\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-8 mb-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"address2\">Address2</label><input class=\"form-control\" type=\"text\" name=\"address2\" id=\"address2\" placeholder=\"Apartment or suite\">\r\n" + //
                    "        </div>\r\n" + //
                    "        \r\n" + //
                    "        <div class=\"row\">\r\n" + //
                    "        <div class=\"col-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"\">Country</label>\r\n" + //
                    "            <select class=\"form-select\" name=\"country\" id=\"Country\">\r\n" + //
                    "                <option value=\"\" selected>Choose...</option>\r\n" + //
                    "                <option value=\"southkorea\">South Korea</option>\r\n" + //
                    "                <option value=\"unitedstates\">United States</option>\r\n" + //
                    "                <option value=\"france\">France</option>\r\n" + //
                    "            </select>\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"\">State</label>\r\n" + //
                    "            <select class=\"form-select\" name=\"state\" id=\"state\">\r\n" + //
                    "                <option value=\"\" selected>Choose...</option>\r\n" + //
                    "                <option value=\"washington\">Washington</option>\r\n" + //
                    "                <option value=\"california\">California</option>\r\n" + //
                    "                <option value=\"utah\">Utah</option>\r\n" + //
                    "            </select>\r\n" + //
                    "        </div>\r\n" + //
                    "        <div class=\"col-3\">\r\n" + //
                    "            <label class=\"form-label\" for=\"zip\">Zip</label><input class=\"form-control\" type=\"text\" name=\"zip\" id=\"zip\">\r\n" + //
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
// @WebServlet(urlPatterns = "/CheckoutFormServlet") //폼테그 띄우기 위한 것 
// public class CheckoutFormServlet extends HttpServlet {
//   @Override
//   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    try {
//      PrintWriter printWriter = response.getWriter();
//      String contents = "<!DOCTYPE html>\r\n" + //
//          "<html lang=\"en\">\r\n" + //
//          "\r\n" + //
//          "<head>\r\n" + //
//          "    <meta charset=\"UTF-8\">\r\n" + //
//          "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
//          "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
//          "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
//          "    <title>Forms</title>\r\n" + //
//          "</head>\r\n" + //
//          "\r\n" + //
//          "<body>\r\n" + //
//          "    <div>\r\n" + //
//          "        <form action=\"http://192.168.0.39:8080/CheckoutResponseServlet\" method=\"get\"> \r\n" + //
//          "            <div class=\"w-50\">\r\n" + //
//          "               \r\n" + //
//          "                <div class=\"p-3\"><h3>Billing address</h3></div>\r\n" + //
//          "                \r\n" + //
//          "              \r\n" + //
//          "                      <div class=\"row m-2\">\r\n" + //
//          "                    <div class=\"col-6\">\r\n" + //
//          "                        <label class=\"form-label\" for=\"\">First name</label><input name=\"First name\" class=\"form-control\" type=\"text\" >\r\n" + //
//          "                    </div>\r\n" + //
//          "                    \r\n" + //
//          "                    <div class=\"col-6\">\r\n" + //
//          "                        <label class=\"form-label\" for=\"\">Last name</label><input name=\"Last name\" class=\"form-control\" type=\"text\">\r\n" + //
//          "                    </div>\r\n" + //
//          "                </div>\r\n" + //
//          "\r\n" + //
//          "                   \r\n" + //
//          "                <div class=\"p-3\">\r\n" + //
//          "                    <label class=\"form-label \" for=\"\">Username</label><input name=\"Username\" class=\"form-control\" type=\"text\" placeholder=\"Username\">\r\n" + //
//          "                </div>\r\n" + //
//          "               \r\n" + //
//          "                <div class=\"m-3\">\r\n" + //
//          "                    <label class=\"form-label\" for=\"\">Email (Optional)</label><input name=\"Email (Optional)\" class=\"form-control\" type=\"text\" placeholder=\"you@example.com\">\r\n" + //
//          "                </div>\r\n" + //
//          "              \r\n" + //
//          "                <div class=\"m-3\">\r\n" + //
//          "                    <label class=\"form-label\" for=\"\">Address</label><input name=\"Address\" class=\"form-control\" type=\"text\" placeholder=\"1234 Main St\">\r\n" + //
//          "                </div>\r\n" + //
//          "                \r\n" + //
//          "                <div class=\"m-3\">\r\n" + //
//          "                    <label class=\"form-label\" for=\"\">Address 2 (Optional)</label><input name=\"Address 2 (Optional)\"class=\"form-control\" \r\n" + //
//          "                        type=\"text\" placeholder=\"Apartment or suite\">\r\n" + //
//          "                </div>\r\n" + //
//          "                \r\n" + //
//          "                <div>\r\n" + //
//          "\r\n" + //
//          "                    <div class=\"row m-2\">\r\n" + //
//          "                        <div class=\"col-5\">\r\n" + //
//          "                            <label class=\"form-label\" for=\"\">Country</label>\r\n" + //
//          "                            <select class=\"form-select\" name=\"country\" id=\"Country\">\r\n" + //
//          "                                <option value=\"\" selected>Choose...</option>\r\n" + //
//          "                                <option value=\"southkorea\">South Korea</option>\r\n" + //
//          "                                <option value=\"unitedstates\">United States</option>\r\n" + //
//          "                                <option value=\"france\">France</option>\r\n" + //
//          "                            </select>\r\n" + //
//          "                        </div>\r\n" + //
//          "\r\n" + //
//          "                        <div class=\"col-4\">\r\n" + //
//          "                            <label class=\"form-label\" for=\"\">State</label>\r\n" + //
//          "                            <select class=\"form-select\" name=\"State\" id=\"State\">\r\n" + //
//          "                                <option value=\"\" selected>Choose...</option>\r\n" + //
//          "                                <option value=\"southkorea\">Washington</option>\r\n" + //
//          "                                <option value=\"unitedstates\">California</option>\r\n" + //
//          "                                <option value=\"france\">Utah</option>\r\n" + //
//          "                            </select>\r\n" + //
//          "                        </div>\r\n" + //
//          "                        <div class=\"col-3\">\r\n" + //
//          "                            <label class=\"form-label\" for=\"\">Zip</label><input name=\"Zip\" class=\"form-control\" type=\"text\">\r\n" + //
//          "                        </div>\r\n" + //
//          "\r\n" + //
//          "                        <div class=\"m-2\">\r\n" + //
//          "                            <button type=\"submit\">Submit </button>\r\n" + //
//          "                        </div>\r\n" + //
//          "                    </div>\r\n" + //
//          "\r\n" + //
//          "                    \r\n" + //
//          "\r\n" + //
//          "                \r\n" + //
//          "                   \r\n" + //
//          "               \r\n" + //
//          "        </form>\r\n" + //
//          "    </div>\r\n" + //
//          "</body>\r\n" + //
//          "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>\r\n" + //
//          "\r\n" + //
//          "\r\n" + //
//          "</html>";
//      printWriter.println(contents);
//      printWriter.close();

//    } catch (Exception e) {
//     System.out.println(e.getMessage());
//    }
//   }
}
