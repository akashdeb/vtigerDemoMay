package vtiger.product_module_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vitiger.POMRepository.CreatingNewVendorPage;
import vitiger.POMRepository.CreatingProductPage;
import vitiger.POMRepository.HomePage;
import vitiger.POMRepository.ProductInformationPage;
import vitiger.POMRepository.ProductPage;
import vitiger.POMRepository.VendorInformationPage;
import vitiger.POMRepository.VendorPage;
import vtiger.genericUtility.BaseClass;
@Listeners (vtiger.genericUtility.ListenersImplementationClass.class)

public class ToCreateProductTest extends BaseClass {
	
	@Test(retryAnalyzer = vtiger.genericUtility.RetryAnalyzerImplementationClass.class)
	public void toCreateProductAndToVerifyProductName() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String vendorName = eUtils.fetchStringDataFromExcelSheet("Product_001", 18, 2);
		String productName = eUtils.fetchStringDataFromExcelSheet("Product_001", 22, 2);
		
		HomePage home = new HomePage(driver);
		VendorPage vendor=new VendorPage(driver);
		CreatingNewVendorPage createVendor=new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInfo=new VendorInformationPage(driver);
		ProductPage product=new ProductPage(driver);
		CreatingProductPage createProduct=new CreatingProductPage(driver);
		ProductInformationPage productInfo=new ProductInformationPage(driver);
		
		
		home.clickOnVendorsModule();
		vendor.clickOnvendorPlusButton();
		createVendor.enterVendorName(vendorName);
		createVendor.clickOnSaveButton();
		
		String actualVendorName = vendorInfo.verifyVendorInfo(vendorName);
		Assert.assertTrue(actualVendorName.contains(vendorName));
		System.out.println("Pass: the vendor name has been verified");
		
		home.clickOnProductsModule();
		product.clickOnProductPlusButton();
		createProduct.enterProductName(productName);
		createProduct.selectVendorNameFromVendorLookUpPage("Vendors&action", vendorName, "Products&action");
		createProduct.uploadProductImage("/src/test/resources/002.jpg");
		createProduct.clickOnSaveButton();
		
		String actualProductName = productInfo.verifyProductInfo(productName);
		Assert.assertTrue(actualProductName.contains(productName));
		System.out.println("Pass: the product name has been verified");

		
		
	}

}
