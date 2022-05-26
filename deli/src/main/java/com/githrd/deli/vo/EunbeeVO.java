package com.githrd.deli.vo;

public class EunbeeVO {
	private String id, mail, pw;

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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "EunbeeVO [id=" + id + ", mail=" + mail + ", pw=" + pw + "]";
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
