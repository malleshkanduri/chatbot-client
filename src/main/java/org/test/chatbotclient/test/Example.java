package org.test.chatbotclient.test;

import com.ciscospark.*;
import java.net.URI;

class Example {
  private static void main(String[] args) {
    // To obtain a developer access token, visit http://developer.webex.com
    String accessToken = "";

    // Initialize the client
    Spark spark = Spark.builder()
      .baseUrl(URI.create("https://webexapis.com/v1"))
      .accessToken(accessToken)
      .build();

    Message message = new Message();
    message.setText("Hello");
    message.setRoomId("Y2lzY29zcGFyazovL3VzL1JPT00vYzIxOTVlMjAtYzU3NS0xMWViLWE1ZWMtZTM0MDM0NjY3N2Yz");
    spark.messages().post(message);
    
    
	/*
	 * // Create a new room Room room = new Room(); room.setTitle("Hello World");
	 * room = spark.rooms().post(room);
	 * 
	 * // Post a text message to the room Message message = new Message();
	 * message.setRoomId(room.getId()); message.setText("Hello World!");
	 * spark.messages().post(message);
	 */
  }
}