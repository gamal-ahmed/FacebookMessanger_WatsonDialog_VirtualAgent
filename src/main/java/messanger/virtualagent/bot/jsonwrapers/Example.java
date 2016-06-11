package messanger.virtualagent.bot.jsonwrapers;



import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Example {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("entry")
    @Expose
    private List<Entry> entry = new ArrayList<Entry>();

    /**
     * 
     * @return
     *     The object
     */
    public String getObject() {
        return object;
    }

    /**
     * 
     * @param object
     *     The object
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * 
     * @return
     *     The entry
     */
    public List<Entry> getEntry() {
        return entry;
    }

    /**
     * 
     * @param entry
     *     The entry
     */
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

}
