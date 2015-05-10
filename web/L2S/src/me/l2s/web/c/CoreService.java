package me.l2s.web.c;

import me.l2s.jackson.C2J;
import me.l2s.jedis.L2P;
import me.l2s.jedis.L2R;

public class CoreService {

	public static String service(String q) {
		String[] suris = L2R.plantString(q);
		String path = L2P.mapPath(suris, q);
		String json = C2J.mapClazz(path);

		return json;
	}

}
