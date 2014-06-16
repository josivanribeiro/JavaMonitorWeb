package com.javamonitorweb.vo;

/**
 * Server Value Object class.
 * 
 * @author Ribeiro_Josivan
 *
 */
public class ServerVO {

	private int id;
	private String hostname;
	private int port;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override 
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append (" id: " + id);
	    result.append (" hostname: " + hostname);
	    result.append (" port: " + port );
	    result.append (" type: " + type);
	    return result.toString();
	  }
	
}
