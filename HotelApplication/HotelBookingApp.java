import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelBookingApp {

	public static List<Hotel> hotelsRepo = new ArrayList<>();

	public static void bookHotel(int money, int days, int rating) throws Exception {
		Preference preference = new Preference();
		preference.setTotalBudget(money);
		preference.setDays(days);
		preference.setRatingPreference(rating);
		HotelFinder app = new HotelFinder();
		Hotel answer = app.getHotels(hotelsRepo, preference);
		if (answer == null) {
			System.out.println("Sorry! you dont have sufficient amount to book any hotel");
		} else {
			Double cost = app.applyDiscount(answer, preference) * preference.getDays();
			System.out.println(
					" 'Hotel Booked for " + preference.getDays() + " days in " + preference.getRatingPreference()
							+ " star Hotel " + answer.getName() + " for the cost of " + cost + " for hotel");
		}

	}

	public static void main(String[] args) throws Exception {
		// hardcoded hotel details
		Hotel hyatt = new Hotel("Hotel Hyatt", 5, 82);
		hyatt.addDiscount(new Discount(3, 12));
		hotelsRepo.add(hyatt);
		Hotel rainTree = new Hotel("RainTree", 3, 58);
		rainTree.addDiscount(new Discount(2, 15));
		hotelsRepo.add(rainTree);
		Hotel raddisson = new Hotel("Raddisson", 3, 60);
		raddisson.addDiscount(new Discount(3, 18));
		hotelsRepo.add(raddisson);
		Hotel fortune = new Hotel("Fortune", 1, 43);
		fortune.addDiscount(new Discount(4, 14.8f));
		hotelsRepo.add(fortune);
		Hotel accord = new Hotel("Accord", 1, 41.55f);
		accord.addDiscount(new Discount(3, 11.8f));
		hotelsRepo.add(accord);
		Hotel thePark = new Hotel("The Park", 5, 90);
		thePark.addDiscount(new Discount(2, 20));
		// thePark.addDiscount(new Discount(8, 60));
		hotelsRepo.add(thePark);
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------HOTEL BOOKING APP---------------------------");
		int days, rating, money;
		System.out.println("Enter the details");
		System.out.println("Enter your budget");
		money = Integer.parseInt(scan.next());
		System.out.println("Enter the num of days of your stay");
		days = Integer.parseInt(scan.next());
		System.out.println("Enter the hotel rating you are looking for - \n available ratings - 1, 3, 5");
		rating = Integer.parseInt(scan.next());
		bookHotel(money, days, rating);

	}

}
