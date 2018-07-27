package com.zhangli;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "addServlet",urlPatterns = "/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String subTitle = request.getParameter("subTitle");
        String name = request.getParameter("name");
        String content = request.getParameter("content");

        Date date=new Date();
        Timestamp myDate = new Timestamp(date.getTime());

        insert(new Guestbook(title,subTitle,name,myDate,content));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private static int insert(Guestbook guestbook) {
        JsonServlet con = new JsonServlet();
        Connection conn = con.getConn();
        int i = 0;
        String sql = "insert into guestbook (title,subTitle,name,date,content) values(?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guestbook.getTitle());
            pstmt.setString(2, guestbook.getSubTitle());
            pstmt.setString(3,guestbook.getName());
            pstmt.setTimestamp(4, guestbook.getDate());
            pstmt.setString(5, guestbook.getContent());

            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
