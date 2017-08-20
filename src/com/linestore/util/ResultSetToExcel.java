package com.linestore.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.linestore.util.DataBase;

/***
* 将数据库中的数据导出成Excel 说明：该类是在apache的poi组件来实现的
* 用户只要提供给writeExcel方法文件名，列名,和一个sql查询语句就可以导出数据到excel文件
* 
*/

public class ResultSetToExcel {
	/**
     * 写Excel操作
     * @param fileName文件名，但不需要后缀名
     * @param coloumItems字段名，即表中的每一列的名称
     * @param sql数据库查询语句
     */
	public static String path="D:/data_copy/";
	public static void writeExcel(String fileName, String[] coloumItems,String sql) {
		//写文件
		File folder=new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}
		//连接数据库
		Connection connection=DataBase.createConn();
		PreparedStatement preparedStatement=DataBase.prepare(connection, sql);
		ResultSet resultSet=null;
		try {
			resultSet=preparedStatement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//文件输出流
		FileOutputStream fileOutputStream=null;
		 try {
	            fileOutputStream = new FileOutputStream(path + fileName+".xls");
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            HSSFSheet sheet = workbook.createSheet();
	            createTag(coloumItems, sheet);// 写表格的列名
	            createValue(resultSet, sheet);// 获取数据集，然后获得数据，写文件
	            workbook.write(fileOutputStream);
	            fileOutputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (fileOutputStream != null) {
	                try {
	                    fileOutputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		 DataBase.close(preparedStatement);
		 DataBase.close(connection);
	}
	/**
     * 创建表格表头
     * 
     * @param tags
     * @param s
     */
    private static void createTag(String[] tags, HSSFSheet s) {
        HSSFRow row = s.createRow(0);
        HSSFCell cell = null;
        for (int i = 0; i < tags.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(tags[i]);
        }
    }
 
    /**
     * 设置表格内容
     * 
     * @param res
     * @param s
     */
    private static void createValue(java.sql.ResultSet res, HSSFSheet s) {
        try {
            int flag = 1;
            int count = res.getMetaData().getColumnCount();
            HSSFRow row = null;
            HSSFCell cell = null;
            while (res.next()) {
                row = s.createRow(flag);
                for (int i = 1; i <= count; i++) {
                    cell = row.createCell(i - 1);
                    Object obj = res.getObject(i);
                    cell.setCellValue(obj + "");
                }
                flag++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
