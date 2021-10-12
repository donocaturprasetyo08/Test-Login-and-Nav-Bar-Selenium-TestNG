package qaautomation.evermos.utils;
import com.twilio.Twilio;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageDeleter;

public class OtpTwilio {
	private static final String ACCOUNT_SID = "AC0a43424fdcacc0df308043b9e983dba4";
	private static final String AUTH_TOKEN = "2f8b08d41e6d916490c86f5597d5cdaa";
	private static final String PHONE_NUMBER = "+18783484721";
	
	public String getOTP() {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		 String smsBody = getMessage();
		 System.out.println(smsBody);
		 String otp = smsBody.replaceAll("[^-?0-9]+", " ");
		 return otp;
	}
	
	
	public String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals(PHONE_NUMBER)).map(Message::getBody).findFirst()
				.orElseThrow(() -> new IllegalStateException("Data not found"));
	}
	
	 public void deleteMessages(MessageDeleter messagedeleter1){
		 			getMessages()
	                .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
	                .filter(m -> m.getTo().equals(PHONE_NUMBER))
	                .map(Message::getSid)
	                .map(sid -> Message.deleter(ACCOUNT_SID, sid))
	                .forEach(MessageDeleter::delete);

	    }

	private static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
}
