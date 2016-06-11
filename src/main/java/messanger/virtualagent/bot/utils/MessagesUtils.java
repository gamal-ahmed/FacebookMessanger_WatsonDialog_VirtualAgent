package messanger.virtualagent.bot.utils;

import java.util.ArrayList;
import java.util.List;

import messanger.virtualagent.bot.jsonwrapers.Attachment;
import messanger.virtualagent.bot.jsonwrapers.Button;
import messanger.virtualagent.bot.jsonwrapers.CallToAction;
import messanger.virtualagent.bot.jsonwrapers.Element;
import messanger.virtualagent.bot.jsonwrapers.FaceBookUser;
import messanger.virtualagent.bot.jsonwrapers.Message;
import messanger.virtualagent.bot.jsonwrapers.MessageBody;
import messanger.virtualagent.bot.jsonwrapers.Payload;
import messanger.virtualagent.bot.jsonwrapers.SendMessageReq;
import messanger.virtualagent.bot.jsonwrapers.WelcomeMessageRequest;

public class MessagesUtils {
	public static void replyWithMenuActions(SendMessageReq re, String questionTag) {
		MessageBody message = new MessageBody();
		Attachment a = new Attachment();
		a.setType("template");
		Payload payl = new Payload();
		payl.setTemplate_type("button");

		ArrayList<Button> buttons = new ArrayList<>();
		//buttons.add(new Button("web_url", "http://www.etisalat.eg/", "Etisalat Wallet"));

		Button w = new Button("postback", "معلومات عن باقات الانترنت");
		w.setPayload("packages");
		Button ww = new Button("postback", "معرفة العروض الحالية");
		ww.setPayload("USER_DEFINED_PAYLOAD1");
		Button wa = new Button("postback", "اشتراك في باقة للإنترنت");
		wa.setPayload("USER_DEFINED_PAYLOAD2");
		Button hesabi = new Button("postback", "حسابي");
		hesabi.setPayload("USER_DEFINED_PAYLOAD3");
		Button sh7n = new Button("postback", "الشحن");
		sh7n.setPayload("USER_DEFINED_PAYLOAD4");

//		Button w = new Button("postback", "sd");
//		w.setPayload("packages");
//		Button ww = new Button("postback", "ewqeqwiheoi");
//		ww.setPayload("USER_DEFINED_PAYLOAD");
//		Button wa = new Button("postback", "wqe");
//		wa.setPayload("USER_DEFINED_PAYLOAD");
//		Button hesabi = new Button("postback", "");
//		hesabi.setPayload("USER_DEFINED_PAYLOAD");
//		Button sh7n = new Button("postback", "d");
//		sh7n.setPayload("USER_DEFINED_PAYLOAD");
		buttons.add(w);
		buttons.add(wa);
		buttons.add(ww);
		buttons.add(hesabi);

		buttons.add(sh7n);

		payl.setButtons(buttons);
		payl.setText(questionTag);
		a.setPayload(payl);

		message.setAttachment(a);
		re.setMessage(message);

		RestClientUtils.replyToUser(re);

	}
	public static void replyConfirmationessage(SendMessageReq re, String questionTag) {
		MessageBody message = new MessageBody();

		Attachment a = new Attachment();

		a.setType("template");
		Payload payl = new Payload();
		payl.setTemplate_type("button");

		ArrayList<Button> buttons = new ArrayList<>();
		//buttons.add(new Button("web_url", "http://www.etisalat.eg/", "Etisalat Wallet"));

		Button w = new Button("postback", "اشترك الان");
		w.setPayload("done");
		Button ww = new Button("postback", "مش دقولتى");
		ww.setPayload("USER_DEFINED_PAYLOAD");
		
		
		buttons.add(w);
		buttons.add(ww);
	

		payl.setButtons(buttons);
		payl.setText(questionTag);
		a.setPayload(payl);

		message.setAttachment(a);
		re.setMessage(message);

		RestClientUtils.replyToUser(re);

	}

	public static void replyWithImage(SendMessageReq re) {
		MessageBody message = new MessageBody();
		// String splits[]=ra.getResponse().get(0).split("_");

		/*
		 * SendMessageReq re = new SendMessageReq(); Recipient r = new
		 * Recipient(); r.setId("1688320191433025"); re.setRecipient(r);
		 * MessageBody message = new MessageBody(); //message.setText("Hello");
		 * Attachment a = new Attachment(); a.setType("image"); a.setPayload(new
		 * Payload(
		 * "http://storage2.pictub.club/2016/06/02/CoconutIn-browser288-5-1629.jpg"
		 * )); message.setAttachment(a);
		 * 
		 * re.setMessage(message);
		 * 
		 * replyToUser(token, re);
		 */
		// message.setText(ra.getResponse().get(0));
		Attachment a = new Attachment();
		a.setType("image");
		a.setPayload(new Payload("http://storage2.pictub.club/2016/06/02/CoconutIn-browser288-5-1629.jpg"));
		message.setAttachment(a);

		re.setMessage(message);

		RestClientUtils.replyToUser(re);

	}

	public static void replyWithText(SendMessageReq re, String Message) {
		MessageBody message = new MessageBody();
		message.setText(Message);
		re.setMessage(message);
		RestClientUtils.replyToUser(re);

	}

	public static void sendMultipleImagesWithButtons(SendMessageReq re, List<Element> elements, List<Button> buttons) {

		MessageBody message = new MessageBody();
		// create tempalte
		Attachment a = new Attachment();
		a.setType("template");

		// create payload
		Payload payl = new Payload();
		payl.setTemplate_type("generic");

		if (buttons == null) {
			buttons = new ArrayList<>();
			buttons.add(new Button("web_url", "http://www.etisalat.eg/", "اعرف اكتر"));
			Button w = new Button("postback", "اشترك");
			w.setPayload("subscribe");
			buttons.add(w);

		}
		if (elements == null) {
			elements = new ArrayList<>();
			Element d = new Element("Connect System",
					"http://storage2.pictub.club/2016/06/02/CoconutIn-browser288-5-1629.jpg",
					"باقات سوشيل طول اليوم استخدم الفس والواتس وتويتر واستمتع بحاجات تانيه كتير");
			Element d2 = new Element("daily bundlle", "http://st5.pictub.club/2016/06/09/Connect_Daily.png",
					"استخدم كل يوم 200 ميجا استخدام غير عادل");
			Element d3 = new Element("Super social", "http://storage1.pictub.club/2016/06/03/1.png",
					"سوبر سوشيل استخدم كل السوشيال طول الشهر وكمان 100 ميجا");
			d.setButtons(buttons);
			d2.setButtons(buttons);
			d3.setButtons(buttons);
			elements.add(d);
			elements.add(d2);
			elements.add(d3);
		}

		else {
			if (buttons != null)
				for (Element element : elements) {
					element.setButtons(buttons);
				}
		}
		payl.setElements(elements);
		a.setPayload(payl);
		message.setAttachment(a);
		re.setMessage(message);
		RestClientUtils.replyToUser(re);

	}

	public static FaceBookUser getUserFromFBGraph(String userID) {
		FaceBookUser user = RestClientUtils.getUserFromGraphApis(userID);
		if (user != null) {
			return user;
		}
		return null;

	}
	/*
	 * In order to set the Welcome Message, make a POST call to
	 * https://graph.facebook.com/v2.6/<PAGE_ID>/thread_settings?access_token=<
	 * PAGE_ACCESS_TOKEN>
	 */

	public static void setWelcomeMessage(String messageText) {

		WelcomeMessageRequest welcome = new WelcomeMessageRequest();
		welcome.setSettingType("call_to_actions");
		welcome.setThreadState("new_thread");

		ArrayList<CallToAction> callToActions = new ArrayList<>();
		CallToAction action = new CallToAction();
	//	action.setMessage(new Message(messageText));

		welcome.setCallToActions(callToActions);

	}

	/*
	 * In order to set the Welcome Message, make a POST call to
	 * https://graph.facebook.com/v2.6/<PAGE_ID>/thread_settings?access_token=<
	 * PAGE_ACCESS_TOKEN>
	 */
	public static void setWelcomeMessage(Message messag, String questionTag) {

		ArrayList<Element>elements=new ArrayList<>();
		Element s=new Element("sa", "dsadwq", "wq");
	
		
		WelcomeMessageRequest welcome = new WelcomeMessageRequest();
		welcome.setSettingType("call_to_actions");
		welcome.setThreadState("new_thread");
		MessageBody message = new MessageBody();

		Attachment a = new Attachment();

		a.setType("template");
		Payload payl = new Payload();
		payl.setTemplate_type("button");

		ArrayList<Button> buttons = new ArrayList<>();
		buttons.add(new Button("web_url", "http://www.etisalat.eg/", "Etisalat Wallet"));

		Button w = new Button("postback", "معلومات عن باقات الانترنت");
		w.setPayload("packages");
		Button ww = new Button("postback", "معرفة العروض الحالية");
		ww.setPayload("USER_DEFINED_PAYLOAD");
		Button wa = new Button("postback", "اشتراك في باقة للإنترنت");
		wa.setPayload("USER_DEFINED_PAYLOAD");
		Button hesabi = new Button("postback", "حسابي");
		hesabi.setPayload("USER_DEFINED_PAYLOAD");
		Button sh7n = new Button("postback", "الشحن");
		sh7n.setPayload("USER_DEFINED_PAYLOAD");
		buttons.add(w);
		buttons.add(wa);
		buttons.add(ww);
		buttons.add(hesabi);

		buttons.add(sh7n);

		payl.setElements(elements);;
		payl.setText(questionTag);
		a.setPayload(payl);
		s.setButtons(buttons);
		elements.add(s);
		message.setAttachment(a);
		
		ArrayList<CallToAction> callToActions = new ArrayList<>();
		CallToAction action = new CallToAction();
		if (message != null)
			action.setMessage(message);

		callToActions.add(action);
		welcome.setCallToActions(callToActions);
		RestClientUtils.setWelcomeMessage(welcome);

	}
}
