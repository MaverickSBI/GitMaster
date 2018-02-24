package pack;

public class RoutBean {
	
	String city1;
	 String city2;
	 int time;
	 float cost;
	 int busnumber;
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getBusnumber() {
		return busnumber;
	}
	public void setBusNo(int busnumber ) {
		this.busnumber = busnumber;
	}
	@Override
	public String toString() {
		return "RoutBean [city1=" + city1 + ", city2=" + city2 + ", time="
				+ time + ", cost=" + cost + ", busnumber=" + busnumber+ "]";
	}
	 

}
