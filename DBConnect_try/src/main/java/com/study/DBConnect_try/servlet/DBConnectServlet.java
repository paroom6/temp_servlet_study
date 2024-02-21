package com.study.DBConnect_try.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.DBConnect_try.config.DBConnectionMgr;

@WebServlet("/DBConnect/addition")
public class DBConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBConnectServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		String content = request.getParameter("text");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = pool.getConnection();
			String sql = "insert into connection_test_table(text) values (?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.execute();
			response.getWriter().println("실행");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {					
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
		}
		
		
	}

}
