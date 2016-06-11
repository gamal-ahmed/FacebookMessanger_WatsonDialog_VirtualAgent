package messanger.virtualagent.bot.jsonwrapers;

/*
 * "read": {
				"watermark": 1465425468336,
				"seq": 26
			}*/
public class Read {

	String watermark;
	String seq;

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

}
