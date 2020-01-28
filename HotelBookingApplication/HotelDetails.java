
abstract public class HotelDetails {
	String hotelName;
	Double amount;
	int waiverDays;
	float waiver;
	abstract double calculateCost(double money,int days);
	
}
