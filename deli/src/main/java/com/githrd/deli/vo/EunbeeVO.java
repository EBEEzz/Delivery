package com.githrd.deli.vo;

public class EunbeeVO {
	private int bno, ano;
	private double esti;
	private String id, mail, pw, savename;
	
	public int getBno() {
		return bno;
	}
	
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getEsti() {
		return esti;
	}
	
	public void setEsti(double esti) {
		this.esti = esti;
	}
	
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
	
	public String getSavename() {
		return savename;
	}
	
	public void setSavename(String savename) {
		this.savename = savename;
	}
	
	@Override
	public String toString() {
		return "EunbeeVO [bno=" + bno + ", ano=" + ano + ", esti=" + esti + ", id=" + id + ", mail=" + mail + ", pw="
				+ pw + ", savename=" + savename + "]";
	}

}
