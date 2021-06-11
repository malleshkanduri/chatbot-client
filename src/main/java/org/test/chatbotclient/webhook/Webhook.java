package org.test.chatbotclient.webhook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.chatbotclient.chat.ChatUtil;
import org.test.chatbotclient.model.WebhookMessage;
import org.test.chatbotclient.service.WebhookMessageProcessor;

import com.ciscospark.Message;

@RestController
public class Webhook {

	static Logger log = LogManager.getLogger(Webhook.class);
	
	@Value("${webexteams.bot.personId}")
	String BOT_PERSON_ID;
	
	@Autowired
	WebhookMessageProcessor webhookMessageProcessor;

	@PostMapping(path = "/webhook")
	public String webhook(@RequestBody WebhookMessage req) {
		log.info("chatbot-client : Webhook Message: " + req);
		
		if (req.getData().getPersonId().equals(BOT_PERSON_ID)) {
			log.info("Ignore this message. This message was sent by Bot");
			return "Partial post call";
		}
		
		log.trace("get message details for messageID " + req.getData().getId());
		
		Message message = ChatUtil.getMessage(req.getData().getId()); 
		
		
		log.info("Webhook Message Details : " + message.getText()  + ", MessageId: " + message.getId());
		
		log.trace("processing webhook message");
		
		String processWebhookMessage = webhookMessageProcessor.processWebhookMessage(message.getText());
		
		log.trace("Replay back to sender with message : " + processWebhookMessage);
		
		Message sendMessage = ChatUtil.sendMessage(processWebhookMessage, req.getData().getRoomId());
		
		log.info("Message sent " + sendMessage.getId() );
		
		return "PostCall"; 
	}
	


	@GetMapping(path = "/webhook")
 	public String getwebhook() {
		log.info("getInside");
		return "GetCall";
	}
	
	/*
	 * @PostMapping(path = "/sendMessage") public String sendMessage(@RequestParam
	 * String text) {
	 * 
	 * log.info("Send Message"); Message sendMessage = ChatUtil.sendMessage(text,
	 * ROOM_ID);
	 * 
	 * return "Message Sent :" + sendMessage.getText() ; }
	 */
	

	@PostMapping(path = "/setwebhook")
	public String setWebhook(@RequestParam String url) {
		
		log.info("Set Webhook");
		
		String webhookname = "spark webhook";
		
		com.ciscospark.Webhook webhook = ChatUtil.setWebhook(url, webhookname);

		return "Message Sent :" + webhook.getName();
	}
	
	
}
