package me.follow.action;

import java.util.HashMap;
import java.util.HashSet;

public class VirtualDB {
	private static HashMap<String, HashSet<String>> map;
	static {
		publish("m150521245");
		publish("m150521036");
		publish("m150520506");
	}

	// 判断用户是否关注了心情
	public static boolean[] isFollower(String uid, String[] mids) {
		boolean[] bs = new boolean[mids.length];
		for (int i = 0; i < mids.length; i++)
			bs[i] = map.get(mids[i]).contains(uid);

		return bs;
	}

	// 用户关注心情
	public static void follow(String uid, String mid) {
		map.get(mid).add(uid);
		PageController.operationTip(1, mid, uid);
	}

	// 用户取消关注心情
	public static void cancel(String uid, String mid) {
		map.get(mid).remove(uid);
		PageController.operationTip(0, mid, uid);
	}

	// 新发表1个心情，将心情添加到map
	public static void publish(String mid) {
		// map中的心情数量为0
		if (map == null)
			map = new HashMap<String, HashSet<String>>();

		map.put(mid, new HashSet<String>());
	}
}
