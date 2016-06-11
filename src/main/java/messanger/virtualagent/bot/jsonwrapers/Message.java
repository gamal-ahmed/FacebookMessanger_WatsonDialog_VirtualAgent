
package messanger.virtualagent.bot.jsonwrapers;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Message {

	@SerializedName("mid")
	@Expose
	private String mid;
	@SerializedName("seq")
	@Expose
	private String seq;
	@SerializedName("text")
	@Expose
	private String text;

	public Message(String messageText) {

	this.text = messageText;
	}

	/**
	 * 
	 * @return The mid
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * 
	 * @param mid
	 *            The mid
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * 
	 * @return The seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * 
	 * @param seq
	 *            The seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * 
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text
	 *            The text
	 */
	public void setText(String text) {
		this.text = text;
	}

}
