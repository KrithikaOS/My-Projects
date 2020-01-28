
public class RainTreeHotel extends HotelDetails {
	final String hotelName = "RainTree";
	private final Double amount = 58d;
	private final int waiverDays = 2;
	private final float waiver = 0.15f;
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
