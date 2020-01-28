
public class FortuneHotel extends HotelDetails{
	
	final String hotelName = "Fortune";
	private final Double amount = 43d;
	private final int waiverDays = 4;
	private final float waiver = 0.148f;
	double totalAmount;

	@Override
	double calculateCost(double money, int days) {
		if (money < amount) {
			return 0;
		}

		else {
			totalAmount = amount * days;
			if (days > waiverDays) {
				totalAmount = totalAmount - (totalAmount * waiver);
			} 
			if (totalAmount > money) {
				return 0;
			}
		}

		return totalAmount;

	}


}
