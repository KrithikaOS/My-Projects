import java.util.ArrayList;
import java.util.List;

public class HotelBookingApp {

    public static List<Hotel> hotelsRepo = new ArrayList<>();
	public static void main(String[] args) {
	   
		Hotel hyatt = new Hotel("Hyatt", 5 , 82);
        hotelsRepo.add(hyatt);
        Hotel rainTree = new Hotel("Rain Tree", 5 , 82);
        hotelsRepo.add(rainTree);
        Hotel raddisson = new Hotel("Raddisson", 5 , 82);
        hotelsRepo.add(raddisson);
        Hotel fortune = new Hotel("Fortune", 5 , 82);
        hotelsRepo.add(fortune);
        Hotel accord= new Hotel("Accord", 5 , 82);
        hotelsRepo.add(accord);
        Hotel thePark = new Hotel("The Park", 5 , 82);
        hotelsRepo.add(thePark);
        Customer customer = new Customer();
        
	

	}

}
