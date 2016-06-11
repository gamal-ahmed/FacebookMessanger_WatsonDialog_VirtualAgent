package messanger.virtualagent.bot.jsonwrapers;



import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DialogRespo {

    @SerializedName("conversation_id")
    @Expose
    private Integer conversationId;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;
    @SerializedName("input")
    @Expose
    private String input;
    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("response")
    @Expose
    private List<String> response = new ArrayList<String>();

    /**
     * 
     * @return
     *     The conversationId
     */
    public Integer getConversationId() {
        return conversationId;
    }

    /**
     * 
     * @param conversationId
     *     The conversation_id
     */
    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * 
     * @return
     *     The clientId
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * 
     * @param clientId
     *     The client_id
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * 
     * @return
     *     The input
     */
    public String getInput() {
        return input;
    }

    /**
     * 
     * @param input
     *     The input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * 
     * @return
     *     The confidence
     */
    public Double getConfidence() {
        return confidence;
    }

    /**
     * 
     * @param confidence
     *     The confidence
     */
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    /**
     * 
     * @return
     *     The response
     */
    public List<String> getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(List<String> response) {
        this.response = response;
    }

}
