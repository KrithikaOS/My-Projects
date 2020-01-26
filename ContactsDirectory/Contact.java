import java.io.Serializable;
import java.util.*;

class Contact implements Serializable  {
	private long number;
	private String name, address;
	private String email;

	// public Contact()

	static Scanner in = new Scanner(System.in);
	public static void main(String args[]) {}

	public Contact(String name, String email, long number2, String address) {
		this.name = name;
		this.email = email;
		this.number = number2;
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public long getNumber() {
		return number;
	}

	public static int createContact(Map map, Map map2) {
		System.out.println("Enter your name");
		String name = in.nextLine();
		if (name.contains("@.") || name.length()>15 || map2.containsKey(name)) {
			System.out.println("Enter a valid name");
			return 0;
		}
		System.out.println("Enter your Email");
		String email = in.nextLine();
		if (!email.contains("@") || email.length()>40 || map.containsKey(email)) {
			System.out.println("Enter a valid email-valid email should have @ ");
			return 0;
		}
		System.out.println("Enter your address");
		String address = in.nextLine();
		if(address.length()>100)
		{
			System.out.println("Address length exceeded");
			return 0;	
		}
		System.out.println("Enter your Number");
		try {
		long number = Long.parseLong(in.nextLine());
		
		Contact c1 = new Contact(name, email, number, address);
		map.put(email, c1);
		map2.put(name, c1.email);
		return 1;
		}catch (Exception e) {
			System.out.println("Please enter a valid number");
			return 0;
		}

	}

	@Override
	public String toString() {
		return "name: " + name + "\t " + "number: " + number + "\t " + "address: " + address + "\t" + "email: " + email + "\n";
	}
}
