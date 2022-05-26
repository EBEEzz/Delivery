package vo;

public class delipVO {
   private int no;
   private String name;
   private double lat, lon, dist, here_lat, here_lon;
   
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public double getLat() {
      return lat;
   }
   public void setLat(double lat) {
      this.lat = lat;
   }
   public double getLon() {
      return lon;
   }
   public void setLon(double lon) {
      this.lon = lon;
   }
   public double getDist() {
      return dist;
   }
   public void setDist(double dist) {
      this.dist = dist;
   }
   public double getHere_lat() {
      return here_lat;
   }
   public void setHere_lat(double here_lat) {
      this.here_lat = here_lat;
   }
   public double getHere_lon() {
      return here_lon;
   }
   public void setHere_lon(double here_lon) {
      this.here_lon = here_lon;
   }
   @Override
   public String toString() {
      return "delipVO [no=" + no + ", name=" + name + ", lat=" + lat + ", lon=" + lon + ", dist=" + dist
            + ", here_lat=" + here_lat + ", here_lon=" + here_lon + "]";
   }


}