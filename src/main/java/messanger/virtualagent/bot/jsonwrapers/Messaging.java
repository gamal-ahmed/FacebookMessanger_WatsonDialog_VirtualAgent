
package messanger.virtualagent.bot.jsonwrapers;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Messaging {

    @SerializedName("sender")
    @Expose
    private Sender sender;
    @SerializedName("recipient")
    @Expose
    private Recipient recipient;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("message")
    @Expose
    private Message message;

    private Read read;
    public Read getRead() {
		return read;
	}

	public void setRead(Read read) {
		this.read = read;
	}

	private Postback postback;
    public Postback getPostback() {
		return postback;
	}

	public void setPostback(Postback postback) {
		this.postback = postback;
	}

	/**
     * 
     * @return
     *     The sender
     */
    public Sender getSender() {
        return sender;
    }

    /**
     * 
     * @param sender
     *     The sender
     */
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    /**
     * 
     * @return
     *     The recipient
     */
    public Recipient getRecipient() {
        return recipient;
    }

    /**
     * 
     * @param recipient
     *     The recipient
     */
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    /**
     * 
     * @return
     *     The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * @return
     *     The message
     */
    public Message getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(Message message) {
        this.message = message;
    }

}
