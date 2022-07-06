package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCatagoryPage extends BasePage{
	
	WebDriver driver;
	
	public AddCatagoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using = "categorydata") WebElement CATAGORY_DATA_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value= 'Add category']") WebElement ADD_CATAGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Jogging')]") WebElement CATAGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//body]") WebElement BODY_ELEMENT;
	
	@FindBy(how = How.NAME, using = "due_month") WebElement MONTH_DROPDOWN_ELEMENT;
	 
	public void insertDataElement(String catagoryData)
	{
		CATAGORY_DATA_ELEMENT.sendKeys(catagoryData);
		ADD_CATAGORY_ELEMENT.click();
	}
	
	public String getDataElement() {
		return CATAGORY_ELEMENT.getText();
		
	}
	public String getBodyText() {
		return BODY_ELEMENT.getText();
		
	}
	public void addCatagoryElement() 
	{
		ADD_CATAGORY_ELEMENT.click();
	}
	 
	 	 
	 public List<String> readDropdown() {

		 List<String> optionsList =  new ArrayList<String>();
		 List<WebElement> options = readFromDropdown(MONTH_DROPDOWN_ELEMENT);

		 for(WebElement we:options)
			 optionsList.add(we.getText());
		 
		return optionsList;
	 }
}
