package me.l2s.jackson;

import java.io.IOException;

import me.l2s.clazz.L2S;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class C2J {

	public static String mapClazz(String path) {
		L2S l2s = new L2S();
		l2s.setPath(path);

		String json = null;
		try {
			// 转换L2S实例到JSON数据
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(l2s);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}

}
