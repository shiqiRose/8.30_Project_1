package com.lingzhuo.common.datasouce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection conn;
	private final String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	private final String driver ="oracle.jdbc.OracleDriver";
	private final String username ="scott";
	private final String pwd="admin";

	public DBConnection(){
		
		try {
			Class.forName(driver);//����  ������
			conn =DriverManager.getConnection(url,username,pwd);//������ݿ�
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConn(){
		return conn;
	}
	
	public static void main(String[] args){
	DBConnection db =new DBConnection();
	System.out.println(db.getConn()==null);
	
	
}
}


