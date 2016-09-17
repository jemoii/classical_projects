package me.voler.classical.l2s.web.c;

import me.voler.classical.l2s.jackson.C2J;
import me.voler.classical.l2s.jedis.L2P;
import me.voler.classical.l2s.jedis.L2R;

public class CoreService {

	public static String service(String q) {
		String[] suris = L2R.plantString(q);
		String path = L2P.mapPath(suris, q);
		String json = C2J.mapClazz(path);

		return json;
	}

}
