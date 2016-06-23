package messanger.virtualagent.bot.serlvet;

import java.awt.image.ReplicateScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import messanger.virtualagent.bot.jsonwrapers.DialogRespo;
import messanger.virtualagent.bot.jsonwrapers.Example;
import messanger.virtualagent.bot.jsonwrapers.FaceBookUser;
import messanger.virtualagent.bot.jsonwrapers.Recipient;
import messanger.virtualagent.bot.jsonwrapers.SendMessageReq;
import messanger.virtualagent.bot.utils.CacheUtils;
import messanger.virtualagent.bot.utils.MessagesUtils;
import messanger.virtualagent.bot.utils.RestClientUtils;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/MessangerBot")
public class MessangerBot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String token = "<Page Token>";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 
		String token = req.getParameter("hub.verify_token");
		if (token != null) {
			resp.setContentType("text/html");

			if (token.equals("{verified_token}")) {
				String challenge = req.getParameter("hub.challenge");
				System.out.println("I am WebHock Verification -------->  ");

				resp.getWriter().print(challenge);
			} else {
				System.out.println("WebHock Verification ERRO -------->  ");

				resp.getWriter().print("Erro You are not facebook bot");
			}
		}

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("request from BOT -------->  " + jb.toString());

		Gson g = new Gson();
		Example reqe = g.fromJson(jb.toString(), Example.class);

		System.out.println(
				"Processing request on dialog side >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		// get sender id
		String senderID = reqe.getEntry().get(0).getMessaging().get(0).getSender().getId();
	
		SendMessageReq re = new SendMessageReq();
		Recipient r = new Recipient();
		r.setId(senderID);
		re.setRecipient(r);

		// Get USer Info ,,, add personalization in the conversation like call the user with his name ,, Done Ahmed

		FaceBookUser user = CacheUtils.getCachedUser(senderID);
		if (user == null) {
			user = MessagesUtils.getUserFromFBGraph(senderID);
			CacheUtils.cacheUser(senderID, user);
		}
		
		// check for postback requests
		if (reqe.getEntry().get(0).getMessaging().get(0).getPostback() != null) {
			System.out.println("-------------> I am PostBack Request");

			if (reqe.getEntry().get(0).getMessaging().get(0).getPostback().getPayload().equals("menu")) {
				MessagesUtils.sendMultipleImagesWithButtons(re, null, null);

			} else if (reqe.getEntry().get(0).getMessaging().get(0).getPostback().getPayload().equals("subscribe")) {
				MessagesUtils.replyConfirmationessage(re, "Do you need this kind of pizz ?!"); //replyWithText(re, "Done , thanks " + user.getFirst_name());
			}
			else if (reqe.getEntry().get(0).getMessaging().get(0).getPostback().getPayload().equals("done")) {
				MessagesUtils.replyWithText(re, "Order Is under Processing"); //replyWithText(re, "Done , thanks " + user.getFirst_name());
				MessagesUtils.replyWithText(re, "thanks"+" "+user.getFirst_name());
			}

		} else {

			// check that if there more than one message received
			if (reqe.getEntry().get(0).getMessaging().get(0).getRead() == null) {
				System.out.println("-------------> I have one message");
				//get the message
				String recivedMessageText = reqe.getEntry().get(0).getMessaging().get(0).getMessage().getText();
				// send to the ibm waston dialog and reply to user
				reply(recivedMessageText, re);

			} else {
				System.out.println("-------------> I have more than one message");

				for (int i = 1; i < reqe.getEntry().get(0).getMessaging().size(); i++) {
					String recivedMessageText = reqe.getEntry().get(0).getMessaging().get(i).getMessage().getText();
					reply(recivedMessageText, re);
				}
			}
		}

	}

	public static void reply(String recivedMessageText, SendMessageReq re) {
		String replayMessage;

		DialogRespo dialogReply = null;
		if (recivedMessageText.toLowerCase().contains("menu")) {
			MessagesUtils.sendMultipleImagesWithButtons(re, null, null);

		}  else {
			dialogReply = RestClientUtils.sendMessageDialog(recivedMessageText);
			replayMessage = dialogReply.getResponse().get(0);
			if (replayMessage.contains("connect"))
				MessagesUtils.replyWithImage(re);
			else
				MessagesUtils.replyWithText(re, replayMessage);
		

		}
	}

}
