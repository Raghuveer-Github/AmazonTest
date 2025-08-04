package GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	//Method to Generate Random Number
		public int getRandomNumber()
		{
			Random ran=new Random();
			int random = ran.nextInt(1000);
			return random;
		}

		//Method to get the current System Date
		public  String getSystemDate()
		{
			Date date=new Date();
			String d1 = date.toString();
			return d1;
		}

		//Method to get the current System Date in Proper Format
		public String getSystemDateInFormate()
		{
			Date date=new Date();
			String d1 = date.toString();
	        String[] d2 = d1.split(" ");

			String mon = d2[1];
			String day = d2[2];
			String time= d2[3].replace(":","-");
			String year= d2[5];

			String Dateformate =day+" - "+mon+" - "+year+" - "+time;
			return Dateformate;

	 	}
}
