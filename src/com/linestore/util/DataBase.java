package com.linestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 封装数据库的相关的操作
 * @author Administrator
 *
 */

public class DataBase {
	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection createConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/so", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 数据库的读取
     * @param conn
     * @param sql
     * @return
     */
    public static PreparedStatement prepare(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    /**
     * 关闭连接 
     * @param conn
     */
    public static void close(Connection conn) {
         
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement stmt) {
        try {
            stmt.close();
            stmt = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs) {
        try {
            rs.close();
            rs = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
