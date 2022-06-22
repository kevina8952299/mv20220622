package model;

public class MyProduct {
    String pid,pname,place;
    int price;
    public MyProduct() {}
	public MyProduct(String pid, String pname, String place, int price) {		
		this.pid = pid;
		this.pname = pname;
		this.place = place;
		this.price = price;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    public String toString() {
    	return "編號:"+pid+" 產品名稱:"+pname+" 產地:"+place+" 價格:"+price;
    }
}
