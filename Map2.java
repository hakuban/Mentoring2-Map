package com.cybertek.Mentor2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Map2 {

		public static void main(String[] args) {
			
			System.out.println("gold:"+mostMedal("gold")); 
			System.out.println("silver:"+mostMedal("silver"));
			System.out.println("bronze:"+mostMedal("BRONZE"));
			System.out.println("total:"+mostMedal("toTal"));	
			
			
		}
		
		
		
		
		
		
		
		
		public static String mostMedal(String medal) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
			
			medal=medal.toLowerCase();
			int num=0;
			switch(medal) {
			case "gold": num=2;break;
			case "silver": num=3; break;
			case "bronze": num=4; break;
			case "total": num=5; break;
			default: num=5; break;
			
			}//switch end
			
			String path="//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td["+num+"]";
			List<WebElement> medalCounts=driver.findElements(By.xpath(path));
		
			List<WebElement> countries=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a"));
			Map<Integer,String> map=new HashMap<>();
			int max=0;
			for(int i=0; i<10; i++) {
				String medalStr=medalCounts.get(i).getText();//"46"
				Integer medalInt=Integer.parseInt(medalStr);
				if(max<medalInt) {
					max=medalInt;
				}
				String country=countries.get(i).getText();//"USA"
				map.put(medalInt, country);
				
			}
			System.out.println("Max value:"+max);
			
			
			return map.get(max);
		}
		


}
