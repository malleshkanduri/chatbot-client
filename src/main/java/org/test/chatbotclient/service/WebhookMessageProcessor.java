package org.test.chatbotclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.chatbotclient.stories.Story;

@Component
public class WebhookMessageProcessor {
	
	@Autowired
	Story story;
	
 	public String processWebhookMessage(String message) {
 		boolean affirm = story.isAffirm(message);
 		
 		if (affirm) {
 			return story.getAffirmMessge(message);
 		}
		
 		return story.getGreetingMessage();
	}
}
