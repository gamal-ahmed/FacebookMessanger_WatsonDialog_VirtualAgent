package messanger.virtualagent.bot.jsonwrapers;

public class Attachment {

	String type;
	Payload payload;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
}
