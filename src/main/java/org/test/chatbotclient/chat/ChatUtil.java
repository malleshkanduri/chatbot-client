package org.test.chatbotclient.chat;

import java.net.URI;

import com.ciscospark.Message;
import com.ciscospark.RequestBuilder;
import com.ciscospark.Spark;
import com.ciscospark.Webhook;


public class ChatUtil {
	 
private static final String ROOMID = "";

private static final String ACCESS_TOKEN = "";

private static Spark spark;

    static {
	    spark = Spark.builder()
	    	      .baseUrl(URI.create("https://webexapis.com/v1"))
	    	      .accessToken(ACCESS_TOKEN)
	    	      .build();
	}

	public static Message sendMessage(String text, String roomId) { 
	   
		Message message = new Message();
	    message.setText(text);
	    message.setRoomId(roomId);
	    
	    spark.messages().post(message);
	    
	    return message;
	}
	
	public static Webhook setWebhook(String url, String webhookname) { 
	
	    Webhook webhook = new Webhook(); 
	    
	    webhook.setEvent("all");
	    webhook.setResource("messages");
	    webhook.setName(webhookname);
	    //URI baseUrl = URI.create("https://26e06a084d7c.eu.ngrok.io/webhook");
	    URI baseUrl = URI.create(url);
	    webhook.setTargetUrl(baseUrl);
	   	    
	    spark.webhooks().post(webhook);
	    
	    
	    RequestBuilder<Webhook> webhooks = spark.webhooks();
	    Webhook listhook = webhooks.get();
	  
	    return listhook;
	  
	}
  
	public static Message getMessage(String messageId, String roomId) { 

		Message message = new Message();
	    
	    message.setId(messageId);
	    message.setRoomId(roomId);
	    
	    Message post = spark.messages().path("/" +messageId).get();
	    
	    return post;
	}
}