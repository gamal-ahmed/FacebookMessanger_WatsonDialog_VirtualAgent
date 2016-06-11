package messanger.virtualagent.bot.jsonwrapers;



import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SendMessageReq {

    @SerializedName("recipient")
    @Expose
    private Recipient recipient;
    @SerializedName("message")
    @Expose
    private MessageBody message;

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
     *     The message
     */
    public MessageBody getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(MessageBody message) {
        this.message = message;
    }

}
