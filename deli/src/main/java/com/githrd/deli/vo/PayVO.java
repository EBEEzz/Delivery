package com.githrd.deli.vo;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayVO {
	private int mno, rno, mimg, mprice, mino, olno, ono, oprice, omprice, quantity, esti, cname;
	private String mname, mintro, miname, sname, dir, omenu, rname, addr, tel, stime, sdate;
	private Time rtime;
	private Date rdate;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getMimg() {
		return mimg;
	}
	public void setMimg(int mimg) {
		this.mimg = mimg;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	public int getMino() {
		return mino;
	}
	public void setMino(int mino) {
		this.mino = mino;
	}
	public int getOlno() {
		return olno;
	}
	public void setOlno(int olno) {
		this.olno = olno;
	}
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	public int getOmprice() {
		return omprice;
	}
	public void setOmprice(int omprice) {
		this.omprice = omprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getEsti() {
		return esti;
	}
	public void setEsti(int esti) {
		this.esti = esti;
	}
	public int getCname() {
		return cname;
	}
	public void setCname(int cname) {
		this.cname = cname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMintro() {
		return mintro;
	}
	public void setMintro(String mintro) {
		this.mintro = mintro;
	}
	public String getMiname() {
		return miname;
	}
	public void setMiname(String miname) {
		this.miname = miname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getOmenu() {
		return omenu;
	}
	public void setOmenu(String omenu) {
		this.omenu = omenu;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Time getRtime() {
		return rtime;
	}
	public void setRtime(Time rtime) {
		this.rtime = rtime;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public void setStime() {
		SimpleDateFormat form = new SimpleDateFormat("HH24:mm:ss");
		stime = form.format(rtime);
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년 MM월 dd일");
		sdate = form.format(rdate);
	}
	public String getSdate() {
		return stime;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "PayVO [mno=" + mno + ", rno=" + rno + ", mimg=" + mimg + ", mprice=" + mprice + ", mino=" + mino
				+ ", olno=" + olno + ", ono=" + ono + ", oprice=" + oprice + ", omprice=" + omprice + ", quantity="
				+ quantity + ", esti=" + esti + ", cname=" + cname + ", mname=" + mname + ", mintro=" + mintro
				+ ", miname=" + miname + ", sname=" + sname + ", dir=" + dir + ", omenu=" + omenu + ", rname=" + rname
				+ ", addr=" + addr + ", tel=" + tel + ", stime=" + stime + ", sdate=" + sdate + ", rtime=" + rtime
				+ ", rdate=" + rdate + ", getMno()=" + getMno() + ", getRno()=" + getRno() + ", getMimg()=" + getMimg()
				+ ", getMprice()=" + getMprice() + ", getMino()=" + getMino() + ", getOlno()=" + getOlno()
				+ ", getOno()=" + getOno() + ", getOprice()=" + getOprice() + ", getOmprice()=" + getOmprice()
				+ ", getQuantity()=" + getQuantity() + ", getEsti()=" + getEsti() + ", getCname()=" + getCname()
				+ ", getMname()=" + getMname() + ", getMintro()=" + getMintro() + ", getMiname()=" + getMiname()
				+ ", getSname()=" + getSname() + ", getDir()=" + getDir() + ", getOmenu()=" + getOmenu()
				+ ", getRname()=" + getRname() + ", getAddr()=" + getAddr() + ", getTel()=" + getTel() + ", getRtime()="
				+ getRtime() + ", getStime()=" + getStime() + ", getSdate()=" + getSdate() + ", getRdate()="
				+ getRdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
