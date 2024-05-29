package seleniumAutomationDemo.demoSelenium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello Code");
		WebDriver driver = new ChromeDriver();
		//driver.get("www.google.com");
		
		List<String> names2 =Arrays.asList("Tiger","Lion","Elephant","Fox");
		ArrayList<String> name1 = new ArrayList<String>();
		name1.add("Gouda");
		name1.add("Balaa");
		name1.add("Munna");
		name1.add("Veerendra");
		name1.add("Prasad");
		name1.add("Arya");
		name1.add("Akihel");
		int count=0; 
		for (int i = 0; i < name1.size(); i++) {
			System.out.println(name1.get(i));
			
			String actual = name1.get(i);
			if (actual.startsWith("A")) 
			{
				count++;
			}
		}
		System.out.println(count);	
		
		name1.stream().filter(s-> s.length()>5).forEach(s-> System.out.println(s));
		//System.out.println(c);
		//name1.stream().filter(s-> s.length()>5).forEach(s-> System.out.println(s) );
		Stream.of("Arun","Agith","Aadhi","Arya2","Swetha","Latha","Usha").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println());
		//ends with "a" change to upperCase
		name1.stream().filter(s-> s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		names2.stream().sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		//concact streams
		Stream<String> newStream= Stream.concat(name1.stream(), names2.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		//collectors
		List<String> ls= name1.stream().map(s-> s.toLowerCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> valuesIntegers = Arrays.asList(2,2,3,5,6,8,9,0);
		valuesIntegers.stream().distinct().sorted().forEach(s->System.out.println(s));
		List<Integer> li = valuesIntegers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));
	}
	
		
	public void stremFliter() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Goud");
		names.add("Bala");
		names.add("Munna");
		names.add("Veerendra");
		names.add("Prasad");
		names.add("Arya");
		names.add("Akihel");
		
		//long c = names.stream().filter(s-> s.startsWith("A")).count();
		//System.out.println(c);
		
		
		//names.stream().filter(s-> s.length()<4).limit(2).forEach(s-> System.out.println(s) );
		
		
/*	Stream.of("Arun","Agith","Aadhi","Arya2","Aeroplane").filter(a-> 
	{
		a.startsWith("A");
	}).count();
	} */
		
	}
}


