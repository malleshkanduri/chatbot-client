package org.test.chatbotclient.stories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Story {
	
	String GREETING = "Hello %s. How can I help you?";
	String BOT_QUESTION = "Hello %s. Would you be interested in watching a one minute video on reducing employee burnout?";
	String EAP="EAP benefits are provided by Optum. The memeber services numbers is (877) 950-5075.\nIs there anything else I can help you with today?";
	String[] eap = {"what","number", "eap?"};
	List<String> greetList = Arrays.asList("hello","hey");
	
	public String getCustomGreetingMessage(String name) {
		return GREETING.formatted(name);
	}
	
	public String getBotQuestion(String name) {
		return BOT_QUESTION.formatted(name);
	}
 

	public boolean isAffirm(String text) {
		
		String message = text.trim().toLowerCase();
		
		if (message.equals("yes") || message.equals("no") || message.equals("1") ||  message.equals("0") || message.equals("y") || message.equals("n")) {
			return true;
		}
		
		return false;
	}
	
	private static boolean searchPattern(String input, String[] pattern) {
		String[] split = input.toLowerCase().split(" ");
		boolean flag=false;
		for (String story : pattern) {
			for (String word : split) {
				if (word.equals(story)) {
					flag=true;
					continue;
				}
			}
			if (flag) {
				flag = false;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isItGreetMessage(String messageText) {
		return greetList.contains(messageText.toLowerCase().trim());
	}

	public String processMessage(String messageText) {
		messageText = messageText.toLowerCase();
		if (searchPattern(messageText, eap)) {
			return EAP;
			
		} else if (messageText.equals("yes") || messageText.equals("1") || messageText.equals("y")) {
			return "Here you go, http://benefitsURL.com !";
			
		} else if (messageText.equals("no")  || messageText.equals("0") || messageText.equals("n") ) {
			return "That's Okay. Is there anything I can help you with today?";
			
		} else {
			return "Sorry, I didn't understand your question";
		}
	}
}
