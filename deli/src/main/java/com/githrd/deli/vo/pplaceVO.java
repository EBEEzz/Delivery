package vo;

public class pplaceVO {
	private String cusname, cusid;
	private double pickuplat, pickuplon, cus_lat,cus_lon,distance;
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public double getPickuplat() {
		return pickuplat;
	}
	public void setPickuplat(double pickuplat) {
		this.pickuplat = pickuplat;
	}
	public double getPickuplon() {
		return pickuplon;
	}
	public void setPickuplon(double pickuplon) {
		this.pickuplon = pickuplon;
	}
	public double getCus_lat() {
		return cus_lat;
	}
	public void setCus_lat(double cus_lat) {
		this.cus_lat = cus_lat;
	}
	public double getCus_lon() {
		return cus_lon;
	}
	public void setCus_lon(double cus_lon) {
		this.cus_lon = cus_lon;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "pplaceVO [cusname=" + cusname + ", cusid=" + cusid + ", pickuplat=" + pickuplat + ", pickuplon="
				+ pickuplon + ", cus_lat=" + cus_lat + ", cus_lon=" + cus_lon + ", distance=" + distance + "]";
	}
	
	
	
}
