
public class AccordHotel extends HotelDetails{
	final String hotelName = "Accord";
	private final Double amount = 41.55d;
	private final int waiverDays = 3;
	private final float waiver = 0.118f;
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
