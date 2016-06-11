package messanger.virtualagent.bot.jsonwrapers;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Button {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("payload")
	@Expose
	private String payload;

	public Button(String string, String string2, String string3) {
		setType(string);
		setUrl(string2);
		setTitle(string3);
	}

	public Button(String string, String string2) {
		setType(string);
		setTitle(string2);
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param url
	 *            The url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * 
	 * @param payload
	 *            The payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

}
