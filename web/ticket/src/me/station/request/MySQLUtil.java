package me.station.request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ������վ�����������
 * ����ֵ��վ���Ӣ�ĵ���
 * 
 */

public class MySQLUtil {

	public static String nameToTelecode(String station_name) {
		
		String station_telecode = null;//վ�����Ĭ��ֵ

		String host = "sqld.duapp.com";
		String port = "4050";
		String dbName = "";// ���ݿ���
		String username = "";// �û���(api key)
		String password = "";// ����(secret key)

		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, dbName);
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username,
					password);
			Statement statement = connection.createStatement();
			//������station_names��ȡ��Ӧ��վ�����
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
