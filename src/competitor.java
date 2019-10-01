
public class competitor {

	//Competitor address
	private String address;
	//Competitor number
	private int comp_num;
	//Competitor Name
	private String name;
	//Competitor Age
	private int age;
	//Number of coins collected
	private int tot_coins;
	//Score achieved
	private int score;
	//Distance reached
	private double distance;
	
	//get and set the Competitor Number
	public int getcomp_num(){
		return comp_num;
	}
	public void setcomp_num(int comp_num){
		this.comp_num = comp_num;
	}
	
	//get and set the Competitor Number
	public String getname() {
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	
	//get and set the Competitor Age
	public int getage() {
		return age;
	}
	public void setage(int age){
		this.age = age;
	}
	
	//get and set the Coins collected
	public int gettot_coins(){
		return tot_coins;
	}
	public void settot_coins(int tot_coins){
		this.tot_coins = tot_coins;
	}
	
	//get and set the Score achieved
	public int getscore(){
		return score;
	}
	public void setscore(int score){
		this.score = score;
	}
	
	//get and set the Distance reached
	public double getdistance() {
		return distance;
	}
	public void setdistance(double distance){
		this.distance = distance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "competitor{" +
				"address='" + address + '\'' +
				", comp_num=" + comp_num +
				", name='" + name + '\'' +
				", age=" + age +
				", tot_coins=" + tot_coins +
				", score=" + score +
				", distance=" + distance +
				'}';
	}
}
