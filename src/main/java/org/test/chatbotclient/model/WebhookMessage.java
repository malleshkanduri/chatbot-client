package org.test.chatbotclient.model;

public class WebhookMessage {
	
	public String id;
	public WebhookDataObject data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public WebhookDataObject getData() {
		return data;
	}
	public void setData(WebhookDataObject data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "WebhookMessage [id=" + id + ", data=" + data + "]";
	}
	
	/*
	 * { "id":
	 * "Y2lzY29zcGFyazovL3VzL1dFQkhPT0svZDE3MzU4YWQtZTAxNy00MDcwLWJkZGQtODY2NTM5YTk1MmNi",
	 * "name":"SPARK Webhook1","targetUrl":
	 * "https://f1b16f72175b.eu.ngrok.io/forwardwebhook",
	 * "resource":"messages","event":"created", "orgId":
	 * "Y2lzY29zcGFyazovL3VzL09SR0FOSVpBVElPTi9kODM4ZTZiMy1hOWQ4LTQ5YzMtYjQ5My0wOTE0OGVkNjM1Yjk",
	 * "createdBy":
	 * "Y2lzY29zcGFyazovL3VzL1BFT1BMRS9kZjQ3NGY4Mi05YmU0LTQ0NGEtYTYzYy1mNjdiNTU3MjEwZTA",
	 * "appId":
	 * "Y2lzY29zcGFyazovL3VzL0FQUExJQ0FUSU9OL0MzMmM4MDc3NDBjNmU3ZGYxMWRhZjE2ZjIyOGRmNjI4YmJjYTQ5YmE1MmZlY2JiMmM3ZDUxNWNiNGEwY2M5MWFh",
	 * "ownedBy":"creator","status":"active","created":"2021-06-10T19:22:28.270Z",
	 * "actorId":
	 * "Y2lzY29zcGFyazovL3VzL1BFT1BMRS9iY2M0ZWYxMC05YWRlLTQ2MGUtYWUzNS01YWY1ZTUxMTc3NTY",
	 * "data": {"id":
	 * "Y2lzY29zcGFyazovL3VzL01FU1NBR0UvNWFhNjAyYTAtY2EyMi0xMWViLWFmZGUtODlmNmQ5MjllMWY3",
	 * "roomId":
	 * "Y2lzY29zcGFyazovL3VzL1JPT00vYzIxOTVlMjAtYzU3NS0xMWViLWE1ZWMtZTM0MDM0NjY3N2Yz",
	 * "roomType":"direct","personId":
	 * "Y2lzY29zcGFyazovL3VzL1BFT1BMRS9iY2M0ZWYxMC05YWRlLTQ2MGUtYWUzNS01YWY1ZTUxMTc3NTY",
	 * "personEmail":"MALLESH.KANDURI@GMAIL.COM","created":
	 * "2021-06-10T19:30:46.346Z"} }
	 */
}
