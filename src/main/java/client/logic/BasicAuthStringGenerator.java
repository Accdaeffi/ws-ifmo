package client.logic;

public class BasicAuthStringGenerator {

	private static String login = "login";
	private static String password = "pass";
	
	public static String generateString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Basic ");
		sb.append(new String(java.util.Base64.getEncoder().encode(new String(login+":"+password).getBytes())));

		return sb.toString();
		
	}

}
