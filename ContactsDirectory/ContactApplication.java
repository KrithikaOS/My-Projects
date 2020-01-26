
//contain main class 
import java.io.*;
import java.lang.*;
import java.util.*;

public class ContactApplication {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws Throwable {
		
		// To create objects for index to retrieve, store the data and to create objects of the type Map to perform operations on the map.
		Map map = new HashMap();// creates 1st hash map
		Map map2 = new HashMap();// creates 2nd hash map
		NameIndex nameIndex = new NameIndex(); // for file operation in map2
		EmailIndex emailIndex = new EmailIndex(); // for file operation in map1
		//To de-serialize the objects and store it in map.
		map = emailIndex.readContactFromEmail(map);
		map2 = nameIndex.readEmailFromName(map2);
		int choice;
		System.out.println("---------TELEPHONE DIRECTORY------------");
		while (true) {
			try {

				System.out.println(
						" 1. Enter 1 to add a contact\n 2. Enter 2 to display contacts\n 3. Enter 3 to search a contact\n"
								+ " 4. Enter 4 to update a contact\n 5. Enter 5 to delete a contact\n 6. Enter 6 to quit");

				choice = in.nextInt();
				in.nextLine();
				switch (choice) {
				case 1:
					int ch1 = Contact.createContact(map, map2);
					if (ch1 == 1) {
						System.out.println("Contact added\n");
					} else if (ch1 == 0) {
						System.out.println("Failed to add contact\n");
					}
					break;
				case 2:
					System.out.println("-------------Displaying contacts------------");
					ContactList.listContact(map, map2);
					break;
				case 3:
					ContactSearch search = new ContactSearch();
					System.out.println("Do you want to search by name or by email?");
					String ch = in.next();
					if (ch.equalsIgnoreCase("email")) {
						search.searchByEmail(map);
					} else if (ch.equalsIgnoreCase("name")) {
						search.searchByName(map2, map);
					} else {
						System.out.println("Invalid input. Please try again \n");
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
					} else {
						System.out.println("Invalid input. Please try again \n");
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
						emailIndex.writeContactFromEmail(map);
						nameIndex.writeEmailFromName(map2);
						System.exit(0);
					} else
						break;
				default:
					System.out.println("Enter a number from 1 to 6\n");
				}
			} catch (Exception e) {
				System.out.println("Please enter a number from 1-6. Displaying options again\n");
			}
		}
	}
}