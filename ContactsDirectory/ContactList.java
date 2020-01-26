import java.util.*;

public class ContactList {

	public static void listContact(Map map, Map map2) {
		System.out.println(map.values().toString().replaceAll("\\[|\\]|,| ", ""));
	}

}
