package org.test.chatbotclient.chat;

import java.net.URI;
import java.time.LocalDateTime;

import com.ciscospark.Message;
import com.ciscospark.RequestBuilder;
import com.ciscospark.Spark;
import com.ciscospark.Webhook;

public class ChatUtil {
	 
private static final String ROOMID = "";
private static final String ACCESS_TOKEN = "";


public static Message sendMessage() { 
    // To obtain a developer access token, visit http://developer.webex.com
 

    // Initialize the client
    Spark spark = Spark.builder()
      .baseUrl(URI.create("https://webexapis.com/v1"))
      .accessToken(ACCESS_TOKEN)
      .build();

    Message message = new Message();
    message.setText("Hello : " + LocalDateTime.now());
    message.setRoomId(ROOMID);
    spark.messages().post(message);
    
    return message;
    
	/*
	 * // Create a new room Room room = new Room(); room.setTitle("Hello World");
	 * room = spark.rooms().post(room);
	 * 
	 * // Post a text message to the room Message message = new Message();
	 * message.setRoomId(room.getId()); message.setText("Hello World!");
	 * spark.messages().post(message);
	 */
  }
  public static Webhook setWebhook() { 
	    // To obtain a developer access token, visit http://developer.webex.com
	    

	    // Initialize the client
	    Spark spark = Spark.builder()
	      .baseUrl(URI.create("https://webexapis.com/v1"))
	      .accessToken(ACCESS_TOKEN)
	      .build();

	    Webhook webhook = new Webhook(); 
	    webhook.setEvent("all");
	    webhook.setResource("messages");
	    webhook.setName("firsthook");
	    URI baseUrl = URI.create("https://26e06a084d7c.eu.ngrok.io/webhook");
	    webhook.setTargetUrl(baseUrl);
	   
	    
	    spark.webhooks().post(webhook);
	    
	    
	    RequestBuilder<Webhook> webhooks = spark.webhooks();
	    
	    Webhook listhook = webhooks.get();
	    return listhook;
	    
		/*
		 * // Create a new room Room room = new Room(); room.setTitle("Hello World");
		 * room = spark.rooms().post(room);
		 * 
		 * // Post a text message to the room Message message = new Message();
		 * message.setRoomId(room.getId()); message.setText("Hello World!");
		 * spark.messages().post(message);
		 */
	    
	    
	    
	  }
  
  
  public static Message getMessage(String messageId) { 
	    // To obtain a developer access token, visit http://developer.webex.com
	   

	    // Initialize the client
	    Spark spark = Spark.builder()
	      .baseUrl(URI.create("https://webexapis.com/v1"))
	      .accessToken(ACCESS_TOKEN)
	      .build();

	    Message message = new Message();
	    message.setId(messageId);
	    message.setRoomId(ROOMID);
	    
	    Message post = spark.messages().path("/" +messageId).get();
	    
	   return post;
	   
	   
	    
	    
	  }
}