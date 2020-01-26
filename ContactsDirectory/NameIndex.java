import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class NameIndex {

	public Map readEmailFromName(Map map2) throws Throwable {
		try {
			FileInputStream fileInputMap2 = new FileInputStream("C:\\Users\\user\\Desktop\\JavaLearn\\Java-Beginner\\ContactsDirectory\\Name_EmailStorage");																										
			ObjectInputStream objInputMap2 = new ObjectInputStream(fileInputMap2);
			map2 = (HashMap) objInputMap2.readObject();
			objInputMap2.close(); // read operation ends

		} catch (EOFException e) {

			System.out.println("the contact list is empty.Please add contacts.");

		}
		return map2;
	}

	public void writeEmailFromName(Map map2) throws Throwable {
		// for write
		File NameIndex = new File("C:\\Users\\user\\Desktop\\JavaLearn\\Java-Beginner\\ContactsDirectory\\Name_EmailStorage");																										
		FileOutputStream fileMap2 = new FileOutputStream(NameIndex);// first map
		ObjectOutputStream outputMap2 = new ObjectOutputStream(fileMap2);// first map
		outputMap2.writeObject(map2);
		outputMap2.flush();
		outputMap2.close();// added to test
	}

}
