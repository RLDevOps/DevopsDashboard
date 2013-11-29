package dto;

import javax.persistence.SequenceGenerator;

public class User {
	@SequenceGenerator(name = "ALBUMS_SEQ", sequenceName = "albums_seq", allocationSize = 1)
	private long seq;
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	

}