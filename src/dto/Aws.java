package dto;

public class Aws {
	private String key;
	private String secret;
	private String endpoint;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	@Override
	public String toString() {
		return "Aws [key=" + key + ", secret=" + secret + ", endpoint="
				+ endpoint + "]";
	}
	
	
	

}
