package messanger.virtualagent.bot.jsonwrapers;

public class MessageBody {

	String text;
	Attachment attachment;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
}
