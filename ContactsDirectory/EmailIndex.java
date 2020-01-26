import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmailIndex {

	public Map readContactFromEmail(Map map) throws Throwable {
		try {
			FileInputStream fileInputMap1 = new FileInputStream("C:\\Users\\user\\Desktop\\JavaLearn\\Java-Beginner\\ContactsDirectory\\Directory");																							// operation
			ObjectInputStream objInputMap1 = new ObjectInputStream(fileInputMap1);
			map = (HashMap) objInputMap1.readObject();
			objInputMap1.close(); // read operation ends
		} catch (EOFException e) {

			System.out.println("the contact list is empty.Please add contacts.");

		}
		return map;
	}

	public void writeContactFromEmail(Map map) throws Throwable {
		// for write
		File EmailIndex = new File("C:\\Users\\user\\Desktop\\JavaLearn\\Java-Beginner\\ContactsDirectory\\Directory");
		FileOutputStream fileMap = new FileOutputStream(EmailIndex);
		ObjectOutputStream outputMap = new ObjectOutputStream(fileMap);
		outputMap.writeObject(map);
		outputMap.flush();
		outputMap.close();// added to test
	}

}
