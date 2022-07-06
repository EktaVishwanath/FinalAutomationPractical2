package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	WebDriver driver;

	public List<WebElement>  readFromDropdown(WebElement element) {
		
		Select sel = new Select(element);
		
		List<WebElement> options = sel.getOptions();
		return options;

	}

}
