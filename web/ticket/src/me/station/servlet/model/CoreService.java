package me.station.servlet.model;

import java.util.List;

import me.station.request.MySQLUtil;
import me.station.response.Browser;
import me.station.response.XMLUtil;
import me.station.train.Train;

public class CoreService {

	public static List<Train> getBalance(String from_station_name,
			String to_station_name, String month, String day) {

		List<Train> trainList = null;

		// String dateString = DateUtil.createDate(Integer.parseInt(increment));
		String from_station_telecode = MySQLUtil
				.nameToTelecode(from_station_name);
		String to_station_telecode = MySQLUtil.nameToTelecode(to_station_name);
		String ticket_type = "ADULT";

		String queryUrl = "https://kyfw.12306.cn/otn/lcxxcx/query?"
				+ "purpose_codes=" + ticket_type + "&queryDate=" + "2015-"
				+ month + "-" + day + "&from_station=" + from_station_telecode
				+ "&to_station=" + to_station_telecode;

		String xml = Browser.searchXML(queryUrl);
		try {
			trainList = XMLUtil.parseXML(xml);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return trainList;
	}

}
