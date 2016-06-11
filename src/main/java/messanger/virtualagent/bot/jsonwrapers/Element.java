package messanger.virtualagent.bot.jsonwrapers;



import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Element {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("buttons")
    @Expose
    private List<Button> buttons = new ArrayList<Button>();

    public Element(String string, String string2, String string3) {
		setTitle(string);
		setImageUrl(string2);
		setSubtitle(string3);
	}

	/**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 
     * @param subtitle
     *     The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 
     * @return
     *     The buttons
     */
    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * 
     * @param buttons
     *     The buttons
     */
    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

}
