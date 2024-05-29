package seleniumAutomationDemo.demoSelenium;
import java.util.ArrayList;

import org.junit.Test;



public class javaStreams {
	
	public void main(String[] args) {
		// TODO Auto-generated method stub
		//Count the number of names starting with alphabet "A" in list.
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Goud");
		names.add("Bala");
		names.add("Munna");
		names.add("Veerendra");
		names.add("Prasad");
		names.add("Arya");
		names.add("Akihel");
		
		int count = 0;
		
		for (int i = 0; i < names.size(); i++) 
		{
			String actual = names.get(i);
			if (actual.startsWith("A")) 
			{
				count++;
			}
		}
		System.out.println(count);
	}

}
