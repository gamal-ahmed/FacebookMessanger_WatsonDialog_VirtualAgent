package messanger.virtualagent.bot.jsonwrapers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Payload {

	String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String template_type;

	public String getTemplate_type() {
		return template_type;
	}

	public void setTemplate_type(String template_type) {
		this.template_type = template_type;
	}
	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private List<Element> elements;

	private List<Button> buttons;

	public Payload(String string) {
		setUrl(string);
	}

	public Payload() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return The elements
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * 
	 * @param elements
	 *            The elements
	 */
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	/**
	 * 
	 * @return The buttons
	 */
	public List<Button> getButtons() {
		return buttons;
	}

	/**
	 * 
	 * @param buttons
	 *            The buttons
	 */
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

}
