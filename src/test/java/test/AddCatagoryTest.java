package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCatagoryPage;
import util.BrowserFactory;


public class AddCatagoryTest {
	
	WebDriver driver;
		
	@Test
	public void userShouldBeAbleToAddACatagory() throws InterruptedException {
		driver = BrowserFactory.init();
		
		AddCatagoryPage addCatagoryPage = PageFactory.initElements(driver, AddCatagoryPage.class);
		addCatagoryPage.insertDataElement("Jogging");
		Assert.assertEquals(addCatagoryPage.getDataElement(), "Jogging", "Unable to add a new category");
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void userShouldNotBeAbleToAddADuplicatedCatagory() throws InterruptedException {
        try
        {
		driver = BrowserFactory.init();
		
		AddCatagoryPage addCatagoryPage = PageFactory.initElements(driver, AddCatagoryPage.class);
		addCatagoryPage.insertDataElement("Jogging2");
		addCatagoryPage.insertDataElement("Jogging2");
        }
        catch(NoSuchElementException ex)
        {
        	Assert.assertNotNull(ex.getStackTrace(), "Able to add a duplicate element");
        }
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void userShouldBeAbleToValidateAllMonthsInDropdown() throws InterruptedException {
    driver = BrowserFactory.init();
		
		AddCatagoryPage addCatagoryPage = PageFactory.initElements(driver, AddCatagoryPage.class);
		List<String> actualResultList = addCatagoryPage.readDropdown(); 
		List<String> expectedResultList = new ArrayList<String>(); 
		String[] arr = {"None","Jan","Feb","Mar", "Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

		for(String stringelement: arr)
			 expectedResultList.add(stringelement);
		Assert.assertEquals(actualResultList, expectedResultList, "They don't match");
		System.out.println(expectedResultList);
		Thread.sleep(2000);
		driver.close();
	}

}





























