package GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromPropertyFile(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties plib = new Properties();
		plib.load(fis);
		String value = plib.getProperty(Key);
		return value;
	}

}
