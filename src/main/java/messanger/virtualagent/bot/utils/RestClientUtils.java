package messanger.virtualagent.bot.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import messanger.virtualagent.bot.jsonwrapers.Attachment;
import messanger.virtualagent.bot.jsonwrapers.DialogRespo;
import messanger.virtualagent.bot.jsonwrapers.FaceBookUser;
import messanger.virtualagent.bot.jsonwrapers.MessageBody;
import messanger.virtualagent.bot.jsonwrapers.Recipient;
import messanger.virtualagent.bot.jsonwrapers.SendMessageReq;
import messanger.virtualagent.bot.jsonwrapers.WelcomeMessageRequest;

public class RestClientUtils {
	final static String appUrl = "https://watson-api-explorer.mybluemix.net/dialog/api/v1/dialogs/<dialog id>/conversation";
	private static final String token = "<page token>";

	public static DialogRespo sendMessageDialog(String message) {
		try {
			URL obj = new URL(appUrl);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "conversation_id=<conv id>&client_id=<client id>&input=" + message;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + appUrl);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			Gson s = new Gson();
			return s.fromJson(response.toString(), DialogRespo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static FaceBookUser getUserFromGraphApis(String userID) {
		try {
			URL obj = new URL("https://graph.facebook.com/v2.6/" + userID
					+ "?fields=first_name,last_name,profile_pic,locale,timezone,gender&access_token=" + token);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			// Send post request

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + appUrl);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			Gson s = new Gson();
			return s.fromJson(response.toString(), FaceBookUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static DialogRespo replyToUser(SendMessageReq send) {
		try {
			URL obj = new URL("https://graph.facebook.com/v2.6/me/messages?access_token=" + token);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			con.setRequestProperty("Content-Type", "application/json");
			// Send post request
			con.setDoOutput(true);
			Gson g = new Gson();
			String j = g.toJson(send);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
			bw.write(j);
			bw.flush();
			bw.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + appUrl);
			System.out.println("Post parameters : " + j);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			Gson s = new Gson();
			return s.fromJson(response.toString(), DialogRespo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;


	}

	private void consumePostRequest(Object t, String ClassName, String url) {
		//
		// URL obj = new URL(url);
		// HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		//
		// // add reuqest header
		// con.setRequestMethod("POST");
		// con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		//
		// con.setRequestProperty("Content-Type", "application/json");
		// // Send post request
		// con.setDoOutput(true);
		// Gson g = new Gson();
		// Class cl=Class.forName(ClassName);
		// ClassLoader clLoader=cl.getClassLoader();
		// Object newObj=cl.cast(t);
		// String j = g.toJson(send);
		// DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		// wr.writeBytes(j);
		// wr.flush();
		// wr.close();
		//
		// int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'POST' request to URL : " + appUrl);
		// System.out.println("Post parameters : " + j);
		// System.out.println("Response Code : " + responseCode);
		//
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(con.getInputStream()));
		// String inputLine;
		// StringBuffer response = new StringBuffer();
		//
		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }
		// in.close();
		//
		// // print result
		// System.out.println(response.toString());
		// Gson s = new Gson();
		// return s.fromJson(response.toString(), DialogRespo.class);
		// }catch(
		//
		// Exception e)
		// {
		// e.printStackTrace();
		// }
	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	public static void main(String[] args) {

		
		SendMessageReq re = new SendMessageReq();
		Recipient r = new Recipient();
		r.setId("1688320191433025");
		re.setRecipient(r);
		
		
		//MessagesUtils.replyWithMenuActions(re, "القائمه");
		MessagesUtils.sendMultipleImagesWithButtons(re, null, null);
		
	}

	public static WelcomeMessageRequest setWelcomeMessage(WelcomeMessageRequest welcome) {
		try {
			URL obj = new URL("https://graph.facebook.com/v2.6/287699708239708/thread_settings?access_token=" + token);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			con.setRequestProperty("Content-Type", "application/json");
			// Send post request
			con.setDoOutput(true);
			Gson g = new Gson();
			String j = g.toJson(welcome);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(j);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + appUrl);
			System.out.println("Post parameters : " + j);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			Gson s = new Gson();
			return s.fromJson(response.toString(), WelcomeMessageRequest.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
