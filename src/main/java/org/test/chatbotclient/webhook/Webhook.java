package org.test.chatbotclient.webhook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.chatbotclient.chat.ChatUtil;
import org.test.chatbotclient.model.WebhookMessage;
import org.test.chatbotclient.service.WebhookMessageProcessor;

@RestController
public class Webhook {

	static Logger log = LogManager.getLogger(Webhook.class);

	
	@Autowired
	WebhookMessageProcessor webhookMessageProcessor;

	@PostMapping(path = "/webhook")
	public void webhook(@RequestBody WebhookMessage message) {
		log.info("chatbot-client : Webhook Message: " + message);
		
		webhookMessageProcessor.processWebhookMessage(message);
		
	}
	
	/*
	 * @PostMapping(path = "/webhookold") public String webhookold(@RequestBody
	 * WebhookMessage req) { log.info("chatbot-client : Webhook Message: " + req);
	 * 
	 * if (req.getData().getPersonId().equals(BOT_PERSON_ID)) {
	 * log.info("Ignore this message. This message was sent by Bot"); return
	 * "Partial post call"; }
	 * 
	 * log.trace("get message details for messageID " + req.getData().getId());
	 * 
	 * String firstAndLastName =
	 * ChatUtil.getFirstAndLastName(req.getData().getPersonId());
	 * 
	 * log.info("Person First/Last Name:::  " + firstAndLastName);
	 * 
	 * Message message = ChatUtil.getMessage(req.getData().getId());
	 * 
	 * 
	 * log.info("Webhook Message Details : " + message.getText() + ", MessageId: " +
	 * message.getId());
	 * 
	 * log.trace("processing webhook message");
	 * 
	 * String processWebhookMessage =
	 * webhookMessageProcessor.processWebhookMessage(message.getText());
	 * 
	 * log.trace("Replay back to sender with message : " + processWebhookMessage);
	 * 
	 * Message sendMessage = ChatUtil.sendMessage(processWebhookMessage,
	 * req.getData().getRoomId());
	 * 
	 * log.info("Message sent " + sendMessage.getId() );
	 * 
	 * return "PostCall"; }
	 */
	


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
