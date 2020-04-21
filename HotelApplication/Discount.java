
public class Discount {
	private String id;
	private int waiverDays;
	private float discountPercent;
	
	
	public Discount(int waiverDays, float discountPercent) {
		super();
		this.waiverDays = waiverDays;
		this.discountPercent = discountPercent;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWaiverDays() {
		return waiverDays;
	}
	public void setWaiverDays(int waiverDays) {
		this.waiverDays = waiverDays;
	}
	public float getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}
	

	
}
