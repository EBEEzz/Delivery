package com.githrd.deli.vo;

public class EunbeeVO {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EunbeeVO [id=" + id + "]";
	}
	
	public String getJson() {
		StringBuffer buff = new StringBuffer();
		buff.append("{\r\n");
		buff.append("\"id\": \"" + id + "\",\r\n");
		buff.append("}");
		return buff.toString();
	}
}
