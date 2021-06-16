package org.test.chatbotclient.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.test.chatbotclient.chat.ChatUtil;
import org.test.chatbotclient.model.WebhookMessage;
import org.test.chatbotclient.stories.Story;

import com.ciscospark.Message;

@Component
public class WebhookMessageProcessor {
	
	@Autowired
	Story story;
	
	@Value("${webexteams.bot.personId}")
	String BOT_PERSON_ID;
	
	static Logger log = LogManager.getLogger(WebhookMessageProcessor.class);
	
 	public void processWebhookMessage(WebhookMessage message) {
 		
 		log.info("Processing Message : " + message);
 		
 		String resourceType = message.getResource();

 		// Do nothing for resource types other than Rooms and Messages.
		if (! (resourceType.equals("rooms") || resourceType.equals("messages"))) {
			log.error("Unexpected Resource Type :" + resourceType + ". Expecting Resoure types of Rooms/Messages.Skipping this message" + message);
			return;
		}
		// Respond to Direct rooms. Don't respond to rooms with a group.
		if (resourceType.equals("rooms")) { 
				if (message.getData().getType().equals("direct") 
						&& message.getCreatedBy().equals(BOT_PERSON_ID)) {
					 	// Bot added to room. send initial message;
						String botQuestion = story.getBotQuestion(ChatUtil.getFirstAndLastName(message.getData().getCreatorId()));
						sendMessageToRoom(message.getData().getId(), botQuestion);
						return;
				} else {
					log.error("This is not 1 on 1 room. Ignoring this message" + message);
					return;
				}
		}
		
		// Ignore messages sent by Bot. Webhook triggers for every message sent to room, it don't care message sent by user or bot.
		// This check is to ignore all the message bot sent to user/room.
		if (message.getData().getPersonId().equals(BOT_PERSON_ID)) {
			log.info("Ignore SELF messages");
			return;
		}
		
 		String messageText = getMessageText(message.getData().getId());
 		
 		if (story.isItGreetMessage(messageText)) {
 			sendMessageToRoom(message.getData().getRoomId(), 
 					story.getCustomGreetingMessage(ChatUtil.getFirstAndLastName(message.getData().getPersonId())));
 			return;
 		}
 		
 		sendMessageToRoom(message.getData().getRoomId(), 
 				story.processMessage(messageText));
	}

	private void sendMessageToRoom(String roomId, String botQuestion) {
		log.trace("Send message to room " +  roomId + ". send message : :" + botQuestion );
		
		Message sendMessage = ChatUtil.sendMessage(botQuestion, roomId);

		log.info("Message sent " + sendMessage.getId() );
	}
 	
 	public String getMessageText(String messageId) {
 		log.trace("Get message details for messageID " + messageId);
 		
		Message msg = ChatUtil.getMessage(messageId); 
		
		log.info("Webhook Message Details : " + msg.getText()  + ", MessageId: " + msg.getId());
		
		return msg.getText();
 	}
 	
	public Message getMessageDetails(WebhookMessage req) {
		Message message = ChatUtil.getMessage(req.getData().getId()); 
		
		log.info("Webhook Message Details : " + message.getText()  + ", MessageId: " + message.getId());
		return message;
	}
}
