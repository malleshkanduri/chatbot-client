package org.test.chatbotclient.chat;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ciscospark.Message;
import com.ciscospark.Person;
import com.ciscospark.RequestBuilder;
import com.ciscospark.Spark;
import com.ciscospark.Webhook;

@Component
public class ChatUtil {
 
	@Value("${webexteams.access.token}")
	String ACCESS_TOKEN;

	static Logger log = org.apache.logging.log4j.LogManager.getLogger(ChatUtil.class);
	
	public static Spark spark;

	@PostConstruct
	public void postContructor() {
		
		spark = Spark.builder()
				.baseUrl(URI.create("https://webexapis.com/v1"))
				.accessToken(ACCESS_TOKEN).build();
	}

	
	public static Message sendMessage(String text, String roomId) {
	  
	  Message message = new Message(); 
	  message.setText(text);
	  message.setRoomId(roomId);
	  
	  Message posted = spark.messages().post(message);
	  
	  return posted; 
	}

	public static Webhook setWebhook(String url, String webhookname) {

		Webhook webhook = new Webhook();

		webhook.setEvent("all");
		webhook.setResource("messages");
		webhook.setName(webhookname);
		URI baseUrl = URI.create(url);
		webhook.setTargetUrl(baseUrl);

		spark.webhooks().post(webhook);

		RequestBuilder<Webhook> webhooks = spark.webhooks();
		Webhook listhook = webhooks.get();

		return listhook;

	}

	public static Message getMessage(String messageId) {

		Message message = new Message();

		message.setId(messageId);

		Message post = spark.messages().path("/" + messageId).get();

		return post;
	}


	public static Person getPersonDetails(String personId) {
		Person person = spark.people().path("/"+personId).get();
		return person;
	}
	
	public static String getFirstAndLastName(String personId) {
		Person person = spark.people().path("/"+personId).get();
		return person.getFirstName() + " " + person.getLastName();
	}
}