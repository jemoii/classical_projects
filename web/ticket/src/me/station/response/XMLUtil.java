package me.station.response;

import java.util.ArrayList;
import java.util.List;

import me.station.train.Status;
import me.station.train.Train;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLUtil {

	public static List<Train> parseXML(String xml) throws Exception {

		List<Train> trainList = null;
		Status status = new Status();

		try {

			Document document = DocumentHelper.parseText(xml);

			Element root = document.getRootElement();
			// ��ȡ����״��status
			status.setStatus(root.element("status").getText());
			// ��ȡ<data>
			Element data = root.element("data");
			// ��ȡ��ѯ״��flag
			status.setFlag(data.element("flag").getText());
			// ��ȡ<datas>
			Element datas = data.element("datas");
			// ��ѯ״��Ϊtrue,��ȡ<e>
			if (status.getFlag().equals("true")) {
				@SuppressWarnings("unchecked")
				List<Element> eArray = datas.elements("e");

				if (eArray.size() > 0) {

					trainList = new ArrayList<Train>();

					Element station_train_code_element;// ����
					Element from_station_telecode_element; // ����վ����
					Element from_station_name_element;// ����վ
					Element to_station_telecode_element;// ����վ����
					Element to_station_name_element;// ����վ
					Element start_time_element;// ����ʱ��
					Element arrive_time_element;// ����ʱ��
					Element lishi_element;// ��ʱ
					Element canWebBuy_element;// �Ƿ����Ԥ��,Y/N
					Element note_element;// ��ע
					Element gr_num_element;// �߼�����
					Element qt_num_element;// ����
					Element rw_num_element;// ����
					Element rz_num_element;// ����
					Element tz_num_element;// �ص���
					Element wz_num_element;// ����
					Element yw_num_element;// Ӳ��
					Element yz_num_element;// Ӳ��
					Element ze_num_element;// ������
					Element zy_num_element;// һ����
					Element swz_num_element;// ������

					for (Element e : eArray) {
						station_train_code_element = e
								.element("station_train_code");
						from_station_telecode_element = e
								.element("from_station_telecode");
						from_station_name_element = e
								.element("from_station_name");
						to_station_telecode_element = e
								.element("to_station_telecode");
						to_station_name_element = e.element("to_station_name");
						start_time_element = e.element("start_time");
						arrive_time_element = e.element("arrive_time");
						lishi_element = e.element("lishi");
						canWebBuy_element = e.element("canWebBuy");
						note_element = e.element("note");
						gr_num_element = e.element("gr_num");
						qt_num_element = e.element("qt_num");
						rw_num_element = e.element("rw_num");
						rz_num_element = e.element("rz_num");
						tz_num_element = e.element("tz_num");
						wz_num_element = e.element("wz_num");
						yw_num_element = e.element("yw_num");
						yz_num_element = e.element("yz_num");
						ze_num_element = e.element("ze_num");
						zy_num_element = e.element("zy_num");
						swz_num_element = e.element("swz_num");

						Train train = new Train();

						train.setStation_train_code(station_train_code_element
								.getText());
						train.setFrom_station_name(from_station_name_element
								.getText());
						train.setTo_station_name(to_station_name_element
								.getText());
						train.setFrom_station_telecode(from_station_telecode_element
								.getText());
						train.setTo_station_telecode(to_station_telecode_element
								.getText());
						train.setStart_time(start_time_element.getText());
						train.setArrive_time(arrive_time_element.getText());
						train.setLishi(lishi_element.getText());
						train.setCanWebBuy(canWebBuy_element.getText());
						train.setNote(note_element.getText());
						train.setGr_num(gr_num_element.getText());
						train.setQt_num(qt_num_element.getText());
						train.setRw_num(rw_num_element.getText());
						train.setRz_num(rz_num_element.getText());
						train.setTz_num(tz_num_element.getText());
						train.setWz_num(wz_num_element.getText());
						train.setYw_num(yw_num_element.getText());
						train.setYz_num(yz_num_element.getText());
						train.setZe_num(ze_num_element.getText());
						train.setZy_num(zy_num_element.getText());
						train.setSwz_num(swz_num_element.getText());

						trainList.add(train);

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return trainList;

	}
}
