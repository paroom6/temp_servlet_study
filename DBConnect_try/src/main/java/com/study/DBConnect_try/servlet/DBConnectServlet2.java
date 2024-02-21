package com.study.DBConnect_try.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DBConnect2")
public class DBConnectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DBConnectServlet2() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String text = request.getParameter("text");
		Connection con = null;
		String url = "jdbc:mysql://mysql-db.cr0mkw8s2iwu.ap-northeast-2.rds.amazonaws.com/db_study";
		String username = "aws";
		String password = "1q2w3e4r!!";
		
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String sql = "insert into connection_test_table(text) values (?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.execute();
			response.getWriter().println("실행");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
