package com.cybertek.Mentor2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Map1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
		
		List<WebElement> countries=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/a"));
		List<WebElement> goldCounts=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]"));
		
//		Map<Integer,String> map=new HashMap<>();
//		
//		for(int i=0; i<10; i++ ) {
//			String countryName=countries.get(i).getText();//"USA"
//			String goldStr=goldCounts.get(i).getText(); //"46"
//			Integer goldInt=Integer.parseInt(goldStr);//46
//			map.put(goldInt, countryName);
//		
//		}//for end
//		
//		System.out.println(map);
//		System.out.println(map.size());
		
//		
		
		Map<String,Integer> map=new HashMap<>();
		int max=0;
		int min=Integer.parseInt(goldCounts.get(0).getText());
		for(int i=0; i<10; i++ ) {
			String countryName=countries.get(i).getText();//"USA"
			String goldStr=goldCounts.get(i).getText(); //"46"
			Integer goldInt=Integer.parseInt(goldStr);//46
			if(max<goldInt) {
				max=goldInt;
			}
			
			if(goldInt<min) {
				min=goldInt;
			}
			map.put( countryName,goldInt);
		
		}//for end
		
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(max);
		System.out.println(min);
		String mostGold="";
		String leastGold="";
		for(Entry<String,Integer> each:map.entrySet()) {
			if(max==each.getValue()) {
				mostGold=each.getKey();
			}//if ends
			if(min==each.getValue()) {
				leastGold=each.getKey();
			}
			
		}//for end
		
		System.out.println(mostGold);
		System.out.println(leastGold);
		
	
	
	
	
	}
}