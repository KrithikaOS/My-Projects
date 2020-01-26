import java.util.*;

public class ContactReplace {
	static Scanner in = new Scanner(System.in);
	String email, name;
	String emailNew, nameNew;

	public void replaceEmail(Map map, Map map2) {
		System.out.println("Enter the email to be replaced");
		email = in.nextLine();

		if (map.containsKey(email)) {
			System.out.println("Enter the new mail id");
			emailNew = in.nextLine();
			if (!map.containsKey(emailNew)) {
				Contact c = (Contact) map.get(email);
				c.setEmail(emailNew);
				map.put(emailNew, c);
				map2.replace(c.getName(), emailNew);
				map.remove(email);
				System.out.println("Email replaced successfully");
			} else {
				System.out.println("The email you are trying to replace with already exists");
			}
		} else {
			System.out.println("Enter an existing email");
		}

	}

	public void replaceName(Map map, Map map2) {
		System.out.println("Enter the name to be replaced");
		name = in.nextLine();

		if (map2.containsKey(name)) {
			System.out.println("Enter the new name");
			nameNew = in.nextLine();
			if (!map2.containsKey(nameNew)) {
				email = (String) map2.get(name);
				Contact c = (Contact) map.get(email);
				c.setName(nameNew);
				map2.put(nameNew, email);
				map.replace(email, c);
				map2.remove(name);
				System.out.println("Name replaced successfully");
			} else {
				System.out.println("The name you are trying to replace with already exists");
			}
		} else {
			System.out.println("Enter an existing name");
		}

	}

}
