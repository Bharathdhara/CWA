package CWM_pack;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import Basic.Driver_Launch;

public class Snippet extends Driver_Launch{

	
	@Test
		public void test() throws Exception {
			
	      Launch_browser();
			try {
				driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
	
				WebElement tableDataButton = driver.findElement(By.xpath("//summary[contains(text(),'Table Data')]"));
				tableDataButton.click();
	
				String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, "
						+ "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, "
						+ "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, "
						+ "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, "
						+ "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
				
				
				WebElement dataInput = driver.findElement(By.xpath("//input[@id='caption']"));
				dataInput.clear();
				dataInput.sendKeys(jsonData);
				
				WebElement refreshTableButton = driver.findElement(By.xpath("//button[@id='refreshtable']"));
				refreshTableButton.click();
	
				String tableContent = driver.findElement(By.xpath("//input[@id='caption']")).getAttribute("value");
				
				System.out.println(tableContent);
				Thread.sleep(3000);
				if (tableContent.equals(jsonData)) {
					System.out.println("Data matches the UI table.");
				} else {
					System.out.println("Data does not match the UI table.");
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.quit();
			}
			
			Close_window();
		}
}

