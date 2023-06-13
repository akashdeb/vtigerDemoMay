package vitiger.POMRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingProductPage {
	
	public CreatingProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTextField;
	
	@FindBy (name = "sales_start_date")
	private WebElement productStartDate;
	
	@FindBy(name = "productcategory")
	private WebElement productCatagoryDropdown;
	
	@FindBy (name="sales_end_date")
	private WebElement productEndDate;
	
	

}
