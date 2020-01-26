import java.util.*;

public class ContactRemove {
	public void removeContact(Map map, Map map2, Scanner in) {
		System.out.println("Enter the email to remove the contact");
		String email = in.nextLine();

		if (map.containsKey(email)) {
			Contact c = (Contact) map.get(email);
			map2.remove(c.getName());
			map.remove(email);
			System.out.println("The contact has been removed");

		} else {
			System.out.println("Enter an existing email");
		}
	}
}