
public class HyattHotel extends HotelDetails{
	final String hotelName = "Hotel Hyatt";
	private final Double amount = 82d;
	private final int waiverDays = 3;
	private final float waiver = 0.12f;
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
