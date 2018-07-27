package com.zhangli;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@WebServlet(name = "JsonServlet",urlPatterns = "/json.z")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("list", getAll());

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");//转发时，路径不要带项目名
        rd.forward(request, response);

    }


    public static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/guestbook?useSSL=false";
        String username = "root";
        String password = "Zhangli!123";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static ArrayList getAll() {
        Connection conn = getConn();
        String sql = "select * from guestbook";
        PreparedStatement pstmt;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList() ;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Guestbook sc = new Guestbook() ;
                sc.setId(rs.getInt("id")) ;
                sc.setTitle(rs.getString("title"));
                sc.setSubTitle(rs.getString("subTitle"));
                sc.setName(rs.getString("name"));
                sc.setDate(rs.getTimestamp("date"));
                sc.setContent(rs.getString("content"));
                arrayList.add(sc) ;
            }
            return arrayList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
