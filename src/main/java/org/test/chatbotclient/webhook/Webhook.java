package org.test.chatbotclient.webhook;

 

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.chatbotclient.chat.ChatUtil;

import com.ciscospark.Message;

@RestController
public class Webhook {

	private static final String MESSAGE_ID = "";


	@PostMapping(path = "/webhook")
	public String root(@RequestBody String req) {
		System.out.println(" Message received: " + req);
		Message message = ChatUtil.getMessage(MESSAGE_ID); 
		System.out.println("PostInside - MessageText: " + message.getText()  + ", MessageId: " + message.getId());
		return "PostCall"; 
	}
	
	private void readStream(HttpServletRequest req) {
		Enumeration<String> parameterNames = req.getParameterNames();
		Enumeration<String> attributeNames = req.getAttributeNames();
		
		while (parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			System.out.println(nextElement);
		}
		
		System.out.println(" === Attributes ==");

		while (attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			System.out.println(nextElement);
		}
		
		System.out.println("====");
		
	}

	@GetMapping(path = "/webhook")
	public String getRoot() {
		System.out.println("getInside");
		return "GetCall";
	}
	
	@PostMapping(path = "/sendMessage")
	public String sendMessage() {
		System.out.println("Send Message");
		
		Message sendMessage = ChatUtil.sendMessage();

		return "Message Sent :" + sendMessage.getText() ;
	}
	

	@PostMapping(path = "/setwebhook")
	public String setWebhook() {
		System.out.println("Set Webhook");
		
		com.ciscospark.Webhook webhook = ChatUtil.setWebhook();

		return "Message Sent :" + webhook.getName();
	}
	
	
}
