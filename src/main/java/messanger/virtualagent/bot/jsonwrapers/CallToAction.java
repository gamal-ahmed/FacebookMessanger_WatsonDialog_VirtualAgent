
package messanger.virtualagent.bot.jsonwrapers;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CallToAction {

    @SerializedName("message")
    @Expose
    private MessageBody message;

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
