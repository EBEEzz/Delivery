package com.githrd.deli.vo;

public class EunbeeVO {
	private String id, mail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "EunbeeVO [id=" + id + ", mail=" + mail + "]";
	}

	public String getJson() {
		StringBuffer buff = new StringBuffer();
		buff.append("{\r\n");
		buff.append("\"id\": \"" + id + "\",\r\n");
		buff.append("\"mail\": \"" + mail + "\",\r\n");
		buff.append("}");
		return buff.toString();
	}
}
