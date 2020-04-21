import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelFinder {
	
	class HotelCostComparator implements Comparator<Hotel>{
		
		public int compare(Hotel one, Hotel two) {
			float hotel1 = one.getStandardCostPerRoom();
			float hotel2= two.getStandardCostPerRoom();
			if(hotel1 > hotel2) return 1;
			if(hotel1 < hotel2) return -1;
			return 0;
		}
		
	}
class DiscountComparator implements Comparator<Discount>{
		
		public int compare(Discount one, Discount two) {
			float disc1 = one.getDiscountPercent();
			float disc2= two.getDiscountPercent();
			if(disc1 > disc2) return -1;
			if(disc1 < disc2) return 1;
			return 0;
		}
		
}

	public Hotel getHotels(List<Hotel> hotels, Preference pref) {
		int costPref = pref.getTotalBudget()/pref.getDays(); // perdaycost requirement 
    	int ratingPref = pref.getRatingPreference();
    	List<Hotel> result = new ArrayList<>();
    	double minCostSoFar = Double.MAX_VALUE;
    	for(Hotel hotel: hotels)
    	{
    		double costPerRoom = hotel.getStandardCostPerRoom();
    		if(hotel.getDiscount() != null && !hotel.getDiscount().isEmpty()) {
    			costPerRoom = this.applyDiscount(hotel, pref); //if discount is available, get it 
    		}
    	   if(costPerRoom <= costPref && hotel.getStars() >= ratingPref && costPerRoom < minCostSoFar) {
    		   minCostSoFar = costPerRoom;
    		   result.add(hotel);
    	   }
    		
    	}
    	
    	
    	if(result.isEmpty())
    	{
    		return null;
    	}
    	else
    	{
    		return result.get(result.size()-1);
    	}
    		
    		
    
    	
	}
	

	
	public double applyDiscount(Hotel hotel, Preference pref) {
		if(hotel.getDiscount() == null || hotel.getDiscount().isEmpty()) return hotel.getStandardCostPerRoom();
		hotel.getDiscount().sort(new DiscountComparator());
		int totalDaysRequested = pref.getDays();
		
		for(Discount discount: hotel.getDiscount())
    	{
    		if(totalDaysRequested >= discount.getWaiverDays())
    		{
    			double maxDiscountPerDayPerRoom = discount.getDiscountPercent()/100f;
    			return hotel.getStandardCostPerRoom() - (hotel.getStandardCostPerRoom() * (maxDiscountPerDayPerRoom));
    		}
    		
    	}
		return hotel.getStandardCostPerRoom();
		
	}
	
}
