package messanger.virtualagent.bot.jsonwrapers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Entry {

	
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("time")
	@Expose
	private String time;
	@SerializedName("messaging")
	@Expose
	private List<Messaging> messaging = new ArrayList<Messaging>();

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 
	 * @param time
	 *            The time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 
	 * @return The messaging
	 */
	public List<Messaging> getMessaging() {
		return messaging;
	}

	/**
	 * 
	 * @param messaging
	 *            The messaging
	 */
	public void setMessaging(List<Messaging> messaging) {
		this.messaging = messaging;
	}

}
