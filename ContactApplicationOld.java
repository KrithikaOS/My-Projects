import java.io.*;
import java.util.*;
import java.io.Serializable;

//to add a contact
class ContactAddition implements Serializable  {
	private long number;
	private String name, address;
	private String email;

	// public ContactAddition()

	static Scanner in = new Scanner(System.in);

	public ContactAddition(String name, String email, long number2, String address) {
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
		if (name.contains("@.")&&name.length()<15) {
			System.out.println("Enter a valid name");
			return 0;
		}
		System.out.println("Enter your Email");
		String email = in.nextLine();
		if (!email.contains("@")&&email.length()>40) {
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
		long number = in.nextLong();
		in.nextLine();
		ContactAddition c1 = new ContactAddition(name, email, number, address);
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

//to display contacts

public class ContactList {
	
	public static void listContact(Map map)
	{
		 System.out.println(map.values().toString().replaceAll("\\[|\\]|,| ",""));//.replaceAll(",", ""));
	}

}

//to search a contact
public class ContactSearch {
	static Scanner in = new Scanner(System.in);
	 static String email;
	 public void searchByEmail(Map map)
	 {
		System.out.println("Enter the email") ;
	    email= in.nextLine();
		if (map.containsKey(email))
		{ 
			
			System.out.println("Contact Details:"+map.get(email));
		}
	 }
	 public void searchByName(Map map2,Map map)
	 {
		 System.out.println("Enter the name") ; 
		 String name= in.nextLine();
		
		 if(map2.containsKey(name))	 
		 {
			email=map2.get(name).toString(); 
			System.out.println("Contact details:"+map.get(email));
			
		 }
		 
		 
	 }

}


//to replace contact

public class ContactReplace {
	static Scanner in = new Scanner(System.in);
	 static String email,name;
	 static String emailNew,nameNew; 
	 public void replaceEmail(Map map,Map map2)
	 {
		System.out.println("Enter the email to be replaced");
	    email= in.nextLine();
	   
		if (map.containsKey(email))
		{ 
			System.out.println("Enter the new mail id");
		    emailNew=in.nextLine();
			ContactAddition c=(ContactAddition) map.get(email);	
			c.setEmail(emailNew);
			map.put(emailNew,c);
			map2.replace(c.getName(),emailNew);
			map.remove(email);
		
	    }
		else
		{
			System.out.println("Enter an existing email");
		}
		
	 }
	 
	 public void replaceName(Map map,Map map2)
	 {
		System.out.println("Enter the name to be replaced");
	    name= in.nextLine();
	   
		if (map.containsKey(name))
		{ 
			System.out.println("Enter the new name");
		    name=in.nextLine();
			ContactAddition c=(ContactAddition) map.get(name);	
			c.setName(nameNew);
			map2.put(nameNew,c.getEmail());
			map.replace(c.getEmail(),c);
			map.remove(name);
		
	    }
		else
		{
			System.out.println("Enter an existing name");
		}
		
	 }


}


//to remove a contact

public class ContactRemove 
{
	public void removeContact(Map map,Map map2,Scanner in)
	{
		System.out.println("Enter the email to remove the contact");
		String email=in.nextLine();
		 
		if (map.containsKey(email))
		{ 
			ContactAddition c=(ContactAddition) map.get(email);	
			map2.remove(c.getName());
			map.remove(email);
			System.out.println("The contact has been removed");
		
	    }
		else
		{
			System.out.println("Enter an existing email");
		}
	}
}

// main class Contact Application

public class ContactApplication implements Serializable {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws Throwable {
		Map map = new HashMap();// = new HashMap();// creates 1st hash map
		Map map2 = new HashMap();// creates 2nd hash map
		File myFileRead = new File("C:\\Users\\user\\Desktop\\JavaLearn\\Java-Beginner\\ContactsDirectory\\Directory");
		FileInputStream inp = new FileInputStream(myFileRead);
		ObjectInputStream input = new ObjectInputStream(inp);
		Object obj = input.readObject();
		map = (HashMap) obj;
		input.close();
		File myFileWrite = new File("C:\\Users\\user\\Desktop\\JavaLearn\\Java-Beginner\\ContactsDirectory\\Directory");
		FileOutputStream out = new FileOutputStream(myFileWrite);
		ObjectOutputStream output = new ObjectOutputStream(out);
		int choice;
		System.out.println("---------TELEPHONE DIRECTORY------------");
		while (true) {
			try {

				System.out.println(
						" 1. Enter 1 to add a contact\t 2. Enter 2 to display contacts\t 3. Enter 3 to search a contact\n"
								+ " 4. Enter 4 to update a contact\t 5. Enter 5 to delete a contact\t 6. Enter 6 to quit");

				choice = in.nextInt();
				in.nextLine();
				switch (choice) {
				case 1:
					int ch1 = ContactAddition.createContact(map, map2);
					if (ch1 == 1) {
						System.out.println("Contact added");
						output.writeObject(map);
						output.flush();
						System.out.println(map.values().toString().replaceAll("\\[|\\]|,| ", ""));
					} else if (ch1 == 0) {
						System.out.println("Failed to add contact");
					}
					break;
				case 2:
					System.out.println("-------------Displaying contacts------------");
					ContactList.listContact(map);
					break;
				case 3:
					ContactSearch search = new ContactSearch();
					System.out.println("Do you want to search by name or by email?");
					String ch = in.next();
					if (ch.equalsIgnoreCase("email")) {
						search.searchByEmail(map);
					} else if (ch.equalsIgnoreCase("name")) {
						search.searchByName(map2, map);
					}
					break;
				case 4:
					ContactReplace replace = new ContactReplace();
					System.out.println("Do you want to replace name or email?");
					String ch4 = in.next();
					if (ch4.equalsIgnoreCase("email")) {
						replace.replaceEmail(map, map2);
					} else if (ch4.equalsIgnoreCase("name")) {
						replace.replaceName(map, map2);
					}
					break;
				case 5:
					ContactRemove remove = new ContactRemove();
					remove.removeContact(map, map2, in);
					break;
				case 6:
					System.out.println("Do you want to close?Press yes to quit");
					String ch6 = in.nextLine();
					if (ch6.equalsIgnoreCase("yes")) {
						System.out.println("Program Exiting. Bye");
						System.exit(0);
					} else 
						break;
				default:
					System.out.println("Enter a number from 1 to 6");
				}
			} catch (Exception e) {
				System.out.println("Please enter a number from 1-6. Displaying options again");
			}
		}
	}
}
