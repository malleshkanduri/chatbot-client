package org.test.chatbotclient.stories;

import org.springframework.stereotype.Component;

@Component
public class Story {
	
	public String getGreetingMessage() {
		return "Are you interested to watch one of the 'America got talent show'?";
	}
	
	public String getAffirmMessge(String text) {
		
		String message = text.trim().toLowerCase();
		
		if (message.equals("yes") || message.equals("1") || message.equals("y")) {
			return "www.youtube.com";
		}
		
		if (message.equals("no")  || message.equals("0") || message.equals("n") ) {
			return "That's fine. Have a good day";
		}
		
		return "";
	}

	public boolean isAffirm(String text) {
		
		String message = text.trim().toLowerCase();
		
		if (message.equals("yes") || message.equals("no") || message.equals("1") ||  message.equals("0") || message.equals("y") || message.equals("n")) {
			return true;
		}
		
		return false;
	}
	
	
}
