package com.flyhero.flyapi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	public String dbUrl = "";
	public String dbName = "";
	public String dbDriver = "";
	public String dbRoot = "";
	public String dbPassword = "";
	public StringBuffer sql = new StringBuffer("SELECT TABLE_SCHEMA,TABLE_NAME,COLUMN_NAME,IS_NULLABLE,COLUMN_TYPE,"
			+ "COLUMN_KEY,COLUMN_DEFAULT,COLUMN_COMMENT FROM INFORMATION_SCHEMA.COLUMNS "
			+ "WHERE table_schema = '");
	public Connection conn = null;
	public PreparedStatement pst = null;
	public ResultSet ret = null;

	public DBHelper(String dbUrl, String dbName, String dbDriver,
			String dbRoot, String dbPassword) {
		super();
		this.dbUrl = dbUrl;
		this.dbName = dbName;
		this.dbDriver = dbDriver;
		this.dbRoot = dbRoot;
		this.dbPassword = dbPassword;
		this.sql.append(dbName+"'");
	}

	public ResultSet executeQuery() {
		try {
			Class.forName(dbDriver);// 指定连接类型
			conn = DriverManager.getConnection(dbUrl+"/"+dbName, dbRoot, dbPassword);// 获取连接
			pst = conn.prepareStatement(sql.toString());// 准备执行语句
			ret=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}