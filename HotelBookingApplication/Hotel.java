
public class Hotel {
	
    private String name;
    private int stars;
    private int standardCostPerRoom;
    private Discount discount;
   
 Hotel(String name, int stars, int standardCostPerRoom) {
	 this.name = name;
	 this.stars = stars;
	 this.standardCostPerRoom = standardCostPerRoom;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getStandardCostPerRoom() {
		return standardCostPerRoom;
	}
	public void setStandardCostPerRoom(int standardCostPerRoom) {
		this.standardCostPerRoom = standardCostPerRoom;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

    

}
