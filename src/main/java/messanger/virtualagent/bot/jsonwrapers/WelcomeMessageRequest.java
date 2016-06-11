
package messanger.virtualagent.bot.jsonwrapers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class WelcomeMessageRequest {

    @SerializedName("setting_type")
    @Expose
    private String settingType;
    @SerializedName("thread_state")
    @Expose
    private String threadState;
    @SerializedName("call_to_actions")
    @Expose
    private List<CallToAction> callToActions = new ArrayList<CallToAction>();

    /**
     * 
     * @return
     *     The settingType
     */
    public String getSettingType() {
        return settingType;
    }

    /**
     * 
     * @param settingType
     *     The setting_type
     */
    public void setSettingType(String settingType) {
        this.settingType = settingType;
    }

    /**
     * 
     * @return
     *     The threadState
     */
    public String getThreadState() {
        return threadState;
    }

    /**
     * 
     * @param threadState
     *     The thread_state
     */
    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }

    /**
     * 
     * @return
     *     The callToActions
     */
    public List<CallToAction> getCallToActions() {
        return callToActions;
    }

    /**
     * 
     * @param callToActions
     *     The call_to_actions
     */
    public void setCallToActions(List<CallToAction> callToActions) {
        this.callToActions = callToActions;
    }

}
