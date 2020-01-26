import java.util.*;
import java.util.stream.Stream;

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
		else
		{
			System.out.println("Sorry.The email doesn't exist.");
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
		 else
			{
				System.out.println("Sorry.The name doesn't exist.");
			}
		 
		 
	 }

}




























//List<ContactAddition> list=new ArrayList<ContactAddition>(map.values());
//Set<ContactAddition> set=new HashSet<ContactAddition>(map.values());
//Stream<ContactAddition> result=set.stream().filter(e -> name.equals(e.name));
//result.peek(e -> System.out.println(e)).count();
