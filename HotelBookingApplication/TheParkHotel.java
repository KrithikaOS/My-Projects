
public class TheParkHotel extends HotelDetails {
    final String hotelName= "The Park";
    private final Double amount= 90d;
	private final int waiverDays = 2;
	private final float waiver= 0.2f;
	double totalAmount;
	@Override
	double calculateCost(double money, int days) { 
		if(money<amount)
		{
			return 0;
		}
		
		else {  
		    totalAmount= amount * days;
			if(days> waiverDays) {
			    totalAmount= totalAmount - (totalAmount * waiver);
		          }
		
			if(totalAmount>money) {
				return 0;
			}
		}
		
		
		
		return totalAmount;
	}
	 

}
