package Controller;

import Model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/index.html";
        if(action == null) {
            action = "join";
        }
        else if(action.equals("join")) {
            url = "/index.html";
        }
        else if(action.equals("add")) {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String bietDen = null;
            String bietDenThongQua = req.getParameter("rspOfYou");
            if (bietDenThongQua != null) {
                switch (bietDenThongQua) {
                    case "Search engine":
                        bietDen = "Search engine";
                        break;
                    case "Word of mouth":
                        bietDen = "Word of mouth";
                        break;
                    case "Social Media":
                        bietDen = "Social Media";
                        break;
                    case "Other":
                        bietDen = "Other";
                        break;
                    default:
                        break;
                }
            }

            String[] luaChonNhanThongTinsArray = req.getParameterValues("receiveAnnouncement");
            List<String> luaChonNhanThongBaos = new ArrayList<>();

            if (luaChonNhanThongTinsArray != null) {
                luaChonNhanThongBaos = Arrays.asList(luaChonNhanThongTinsArray);
            }

            String[] contactMethods = req.getParameterValues("contactMethod");
            List<String> lienHes = new ArrayList<>();
            if (contactMethods != null) {
                lienHes = Arrays.asList(contactMethods);
            }

            //Xử lý ngày tháng năm
            String dateString = req.getParameter("dateOfBirth");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = null;
            try {
                // Phân tích chuỗi thành java.util.Date
                utilDate = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
                // Xử lý lỗi phân tích ngày, có thể trả về thông báo lỗi cho người dùng
                req.setAttribute("error", "Ngày không hợp lệ");
                req.getRequestDispatcher(url).forward(req, resp);
                return;
            }
            // Chuyển đổi java.util.Date thành java.sql.Date
            Date sqlDate = new Date(utilDate.getTime());
            
            Person person = new Person(firstName, lastName, email, sqlDate, bietDen, luaChonNhanThongBaos,lienHes);

            // set User object in request object and set URL
            req.setAttribute("person", person);
            url = "/join.jsp";   // the "thanks" page
        }
        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
}
