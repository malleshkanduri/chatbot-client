package org.test.chatbotclient.stories;

import org.springframework.stereotype.Component;

@Component
public class Story {
	
	public String getGreetingMessage() {
		return "Are you interested to watch 'famous Tom & Jerry Cartoon'?";
	}
	
	public String getAffirmMessge(String text) {
		
		String message = text.trim().toLowerCase();
		
		if (message.equals("yes") || message.equals("1") || message.equals("y")) {
			return "Here you go! https://www.youtube.com/watch?v=cqyziA30whE";
		}
		
		if (message.equals("no")  || message.equals("0") || message.equals("n") ) {
			return "That's Okay. Is there anything I can help you on?";
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
