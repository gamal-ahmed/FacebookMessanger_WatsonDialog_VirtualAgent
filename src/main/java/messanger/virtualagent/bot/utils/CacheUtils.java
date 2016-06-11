package messanger.virtualagent.bot.utils;


import java.util.HashMap;

import messanger.virtualagent.bot.jsonwrapers.FaceBookUser;

public class CacheUtils {

	private static HashMap<String, FaceBookUser> users = new HashMap<>();

	public static void cacheUser(String userID, FaceBookUser user) {

		users.put(userID, user);

	}

	public static FaceBookUser getCachedUser(String userID) {
		return users.get(userID);

	}

	public static void clearTheCache() {

		users.clear();
	}

}
