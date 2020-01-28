import java.util.ArrayList;
import java.util.*;

public class HotelBookingApplication {

	public ArrayList<HotelDetails> createHotelDataBase() {
		HotelDetails thePark = new TheParkHotel();
		HotelDetails hyatt = new HyattHotel();
		HotelDetails raddisson = new RaddissonHotel();
		HotelDetails rainTree = new RainTreeHotel();
		HotelDetails accord = new AccordHotel();
		HotelDetails fortune = new FortuneHotel();
		ArrayList<HotelDetails> hotelList = new ArrayList<HotelDetails>();
		hotelList.add(accord);
		hotelList.add(fortune);
		hotelList.add(rainTree);
		hotelList.add(raddisson);
		hotelList.add(hyatt);
		hotelList.add(thePark);
		return hotelList;
	}

	public String bookHotel(double money, int days, int rating, ArrayList<HotelDetails> hotelList) {

		switch (rating) {
		case 1:Double totalAmount1 = ((AccordHotel) hotelList.get(0)).calculateCost(money, days);
				Double totalAmount2 = ((FortuneHotel) hotelList.get(1)).calculateCost(money, days);
			if (totalAmount1 == 0 && totalAmount2 == 0) {
				return "Sorry! you dont have sufficient amount to book any hotel";
			}
			else if (totalAmount1 < totalAmount2) {
					return "Hotel Booked for " + days + " days in " + rating + " star Hotel "
							+ ((AccordHotel) hotelList.get(0)).hotelName + " for the cost of " + totalAmount1;
				} else {
					return "Hotel Booked for " + days + "days in " + rating + "star Hotel "
							+ ((FortuneHotel) hotelList.get(1)).hotelName + " for the cost of " + totalAmount2;
				}
		
		case 3:
			Double totalAmount3 = ((RainTreeHotel) hotelList.get(2)).calculateCost(money, days);
			Double totalAmount4 = ((RaddissonHotel) hotelList.get(3)).calculateCost(money, days);
			if (totalAmount3 == 0 && totalAmount4 == 0) {
				return "Sorry! you dont have sufficient amount to book any hotel";
			}

			else {
				if (totalAmount3 < totalAmount4) {
					return "Hotel Booked for " + days + " days in " + rating + " star Hotel "
							+ ((RainTreeHotel) hotelList.get(2)).hotelName + " for the cost of " + totalAmount3;
				}

				else {
					return "Hotel Booked for " + days + " days in " + rating + " star Hotel "
							+ ((RaddissonHotel) hotelList.get(3)).hotelName + " for the cost of " + totalAmount4;
				}
			}
			

		case 5:
			Double totalAmount5 = ((HyattHotel) hotelList.get(4)).calculateCost(money, days);
			Double totalAmount6 = ((TheParkHotel) hotelList.get(5)).calculateCost(money, days);
			if (totalAmount5 == 0 && totalAmount6 == 0) {
				return "Sorry! you dont have sufficient amount to book any hotel";
			}

			else {
				if (totalAmount5 < totalAmount6) {
					return "Hotel Booked for " + days + " days in " + rating + " star Hotel "
							+ ((HyattHotel) hotelList.get(4)).hotelName + " for the cost of " + totalAmount5;
				}

				else {
					return "Hotel Booked for " + days + " days in " + rating + " star Hotel "
							+ ((TheParkHotel) hotelList.get(5)).hotelName + " for the cost of " + totalAmount6;
				}
			}
		
		default:
			System.out.println("Ratings of only 1, 3 and 5 are only available");

		}// end of switch
      return "sorry ...try again";
	}

	public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
		System.out.println("-------------------------HOTEL BOOKING APP---------------------------");
		HotelBookingApplication hotelBook = new HotelBookingApplication();
		ArrayList<HotelDetails> hotelList=hotelBook.createHotelDataBase();
		double money;
		int days,rating;
		try {
		System.out.println("Enter the details");
		System.out.println("Enter your budget");
		money= Double.parseDouble(scan.nextLine());
		System.out.println("Enter the num of days of your stay");
		days= Integer.parseInt(scan.nextLine());
		if(days<1 || days>31)
		{ 
			System.out.println("Enter days from 1 to 31");
			throw new ArithmeticException();
		}
		System.out.println("Enter the hotel rating you are looking for - \n available ratings - 1, 3, 5");
		rating= Integer.parseInt(scan.nextLine());
	    String bookStatus= hotelBook.bookHotel(money, days, rating, hotelList);	
	    System.out.println(bookStatus);
		}
		catch(Exception e) {
			System.out.println("Enter valid data");
		}

	}

}
