package me.station.request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 参数：站点的中文名称
 * 返回值：站点的英文电码
 * 
 */

public class MySQLUtil {

	public static String nameToTelecode(String station_name) {
		
		String station_telecode = null;//站点电码默认值

		String host = "sqld.duapp.com";
		String port = "4050";
		String dbName = "";// 数据库名
		String username = "";// 用户名(api key)
		String password = "";// 密码(secret key)

		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, dbName);
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username,
					password);
			Statement statement = connection.createStatement();
			//检索表station_names获取对应的站点电码
			String sql = "SELECT telecode FROM station_names WHERE name = \'"
					+ station_name + "\'";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				
				station_telecode = result.getString(1);

			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return station_telecode;
	}

}
