import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
	
    private String name;
    private int stars;
    private float standardCostPerRoomPerDay;
    private List<Discount> discount = new ArrayList<>();
   
 Hotel(String name, int stars, float standardCostPerRoom) {
	 this.name = name;
	 this.stars = stars;
	 this.standardCostPerRoomPerDay = standardCostPerRoom;
		
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
	public float getStandardCostPerRoom() {
		return standardCostPerRoomPerDay;
	}
	public void setStandardCostPerRoom(float standardCostPerRoom) {
		this.standardCostPerRoomPerDay = standardCostPerRoom;
	}
	public List<Discount> getDiscount() {
		return discount;
	}
	public void addDiscount(Discount discount) {
		this.discount.add(discount);
	}
	
	
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", stars=" + stars + ", standardCostPerRoomPerDay=" + standardCostPerRoomPerDay
				+ ", discount=" + discount + "]";
	}

    

}
