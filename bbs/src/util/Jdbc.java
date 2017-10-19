package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * ���ݿ�����
 */
public class Jdbc {
	private static final String URL = "jdbc:mysql://localhost:3306/shoppingcar";
	private static final String USER = "root";
	private static final String PW = "1234";
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	/**
	 * ����mysql����
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ��������ز��ɹ�");
		}
	}

	/**
	 * ��ȡmysql���ӳ�
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر����ӳ�
	 * 
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void getClose(Connection conn, PreparedStatement pst, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
