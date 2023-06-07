package vitiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLead {
	
	public CreatingNewLead(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "salutationtype")
	private WebElement leadSalutation;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "company")
	private WebElement companyTextField;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "assigntype")
	private WebElement groupByRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToDropdown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getLeadSalutation() {
		return leadSalutation;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getGroupByRadioButton() {
		return groupByRadioButton;
	}

	public WebElement getAssignedToDropdown() {
		return assignedToDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void selectFromLeadsSalutationDropdown(String option) {
		 Select select=new Select(leadSalutation);
		 select.selectByVisibleText(option);
	}
	
	public void enterFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	
	public void enterCompanytName(String company) {
		companyTextField.sendKeys(company);
	}
	
	public void selectFromIndustrDropdown(String option) {
		Select select=new Select(industryDropdown);
		 select.selectByVisibleText(option);
	}
	
	public void clickOnGroupRadioButton() {
		groupByRadioButton.click();
	}
	
	public void selectFromAssigntoDropdown(String option) {
		Select select=new Select(assignedToDropdown);
		 select.selectByVisibleText(option);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
}
