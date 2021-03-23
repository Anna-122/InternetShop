package servlets;

import entity.Users;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexPageServlet extends HttpServlet {

//
//    private final static String index = "/WEB-INF/index.jsp";
//
//    private List<Users> users;
//
//    @Override
//    public void init() throws ServletException {
//        users = new CopyOnWriteArrayList<>();
//        users.add(new Users( 1, "Anna", "Goncharova","Sergeevna","F","@eerrrr","an123","12345","12.08.2001",1,1,"Green_Street","12f","1",1));
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        req.setAttribute("users", users);
//        req.getRequestDispatcher(index).forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        req.setCharacterEncoding("UTF8");
//
//        if (!requestIsValid(req)) {
//            doGet(req, resp);
//        }
//
//
//
//        final int user_id = Integer.parseInt(req.getParameter("user_id"));
//        final String user_name =  req.getParameter("user_name");
//        final String user_surname  = req.getParameter("user_surname");
//        final String user_middle_name = req.getParameter("user_middle_name");
//        final String user_sex = req.getParameter("user_sex");
//        final String user_email = req.getParameter("user_email");
//        final String user_username = req.getParameter("user_username");
//        final String user_password = req.getParameter("user_password");
//        final String user_birthday = req.getParameter("user_birthday");
//        final int user_country_id  = Integer.parseInt(req.getParameter("user_country_id"));
//        final int user_city_id = Integer.parseInt(req.getParameter("user_city_id"));
//        final String user_street = req.getParameter("user_street");
//        final String user_house_number = req.getParameter("user_house_number") ;
//        final String user_flat_number = req.getParameter("user_flat_number");
//        final int user_type_id = Integer.parseInt(req.getParameter("user_type_id"));
//
//
//        final Users user = new Users(user_id, user_name,  user_surname,  user_middle_name, user_sex,  user_email,  user_username,  user_password,  user_birthday,  user_country_id,
//         user_city_id,  user_street,  user_house_number,  user_flat_number,  user_type_id );
//
//        users.add(user);
//
//        doGet(req, resp);
//    }
//
//    private boolean requestIsValid(final HttpServletRequest req) {
//
//        final String user_name = req.getParameter("user_name");
//        final String user_birthday = req.getParameter("user_birthday");
//
//        return user_name != null && user_name.length() > 0 &&
//                user_birthday != null && user_birthday.length() > 0 &&
//                user_birthday.matches("[+]?\\d+");
//    }
}