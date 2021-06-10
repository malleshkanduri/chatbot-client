package org.test.chatbotclient.webhook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.chatbotclient.chat.ChatUtil;

import com.ciscospark.Message;

@RestController
public class Webhook {

	private static final String MESSAGE_ID = "";
	private static final String ROOM_ID = null;


	@PostMapping(path = "/webhook")
	public String webhook(@RequestBody String req) {
		System.out.println("chatbot-client : Message received: " + req);
		
		Message message = ChatUtil.getMessage(MESSAGE_ID, ROOM_ID); 
		
		System.out.println("PostInside - MessageText: " + message.getText()  + ", MessageId: " + message.getId());
		
		return "PostCall"; 
	}
	
 	@GetMapping(path = "/webhook")
 	public String getwebhook() {
		System.out.println("getInside");
		return "GetCall";
	}
	
	@PostMapping(path = "/sendMessage")
	public String sendMessage(@RequestParam String text) {
		
		System.out.println("Send Message");
		Message sendMessage = ChatUtil.sendMessage(text, ROOM_ID);

		return "Message Sent :" + sendMessage.getText() ;
	}
	

	@PostMapping(path = "/setwebhook")
	public String setWebhook(@RequestParam String url) {
		
		System.out.println("Set Webhook");
		
		String webhookname = "spark webhook";
		
		com.ciscospark.Webhook webhook = ChatUtil.setWebhook(url, webhookname);

		return "Message Sent :" + webhook.getName();
	}
	
	
}
