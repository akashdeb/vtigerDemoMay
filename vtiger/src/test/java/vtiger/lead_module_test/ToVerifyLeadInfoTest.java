package vtiger.lead_module_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vitiger.POMRepository.CreatingNewLead;
import vitiger.POMRepository.HomePage;
import vitiger.POMRepository.LeadInformationPage;
import vitiger.POMRepository.LeadsPage;
import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPathConstant;

public class ToVerifyLeadInfoTest extends BaseClass {

	@Test
	public void toCreateALeadAndToVerifyLeadInfoTest() throws EncryptedDocumentException, IOException {
		//Here we are fetching data from excel sheets
		String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.SHEETNAME, 17, 2);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.SHEETNAME, 18, 2);
		String expectedleadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.SHEETNAME, 19, 2);
		String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.SHEETNAME, 20, 2);
		String leadIndustryName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.SHEETNAME, 21, 2);
		String leadAssignedToDetails = eUtils.fetchStringDataFromExcelSheet(IPathConstant.SHEETNAME, 23, 2);
		
		//All the object creation statements
		HomePage home = new HomePage(driver);
		LeadsPage leads = new LeadsPage(driver);
		CreatingNewLead createLead = new CreatingNewLead(driver);
		LeadInformationPage leadInfo = new LeadInformationPage(driver);

		//Clicking lead module
		home.clickOnLeadsModule();
		
		//Clicking on lead plus button
		leads.clickOnLeadsPlusButton();
		
		//Creating a lead
		createLead.selectFromLeadsSalutationDropdown(leadSalutation);
		createLead.enterFirstName(leadFirstName);
		createLead.enterLastName(expectedleadLastName);
		createLead.enterCompanytName(leadCompanyName);
		createLead.selectFromIndustrDropdown(leadIndustryName);
		createLead.clickOnGroupRadioButton();
		createLead.selectFromAssigntoDropdown(leadAssignedToDetails);
		createLead.clickOnSaveButton();
		
		System.out.println("The Lead has been created");
		
		//Verifying the lead
		String actualLeadsLastName = leadInfo.verfiyLeadsName(expectedleadLastName);
		
		Assert.assertEquals(actualLeadsLastName, expectedleadLastName);
		System.out.println("Pass: the Lead has been verified");
		
		
	}

}
