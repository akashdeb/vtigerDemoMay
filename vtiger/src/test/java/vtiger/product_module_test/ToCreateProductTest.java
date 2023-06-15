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
import vtiger.genericUtility.IPathConstant;
@Listeners (vtiger.genericUtility.ListenersImplementationClass.class)

public class ToCreateProductTest extends BaseClass {
	
	@Test(retryAnalyzer = vtiger.genericUtility.RetryAnalyzerImplementationClass.class)
	public void toCreateProductAndToVerifyProductName() throws EncryptedDocumentException, IOException, InterruptedException {
		//Fetch Product related datas from excel sheet
		String vendorName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 18, 2);
		String productName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 22, 2);
		
		//Creating all the  objects
		HomePage home = new HomePage(driver);
		VendorPage vendor=new VendorPage(driver);
		CreatingNewVendorPage createVendor=new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInfo=new VendorInformationPage(driver);
		ProductPage product=new ProductPage(driver);
		CreatingProductPage createProduct=new CreatingProductPage(driver);
		ProductInformationPage productInfo=new ProductInformationPage(driver);
		
		//Creating vendor to avoid data dependency
		home.clickOnVendorsModule();
		vendor.clickOnvendorPlusButton();
		createVendor.enterVendorName(vendorName);
		createVendor.clickOnSaveButton();
		System.out.println("The vendor has been created");
		
		//verifying the vendor
		String actualVendorName = vendorInfo.verifyVendorInfo(vendorName);
		Assert.assertTrue(actualVendorName.contains(vendorName));
		System.out.println("Pass: the vendor name has been verified");
		
		//Creating a product
		home.clickOnProductsModule();
		product.clickOnProductPlusButton();
		createProduct.enterProductName(productName);
		createProduct.selectVendorNameFromVendorLookUpPage(IPathConstant.VENDOR_LOOKUP_PAGE_TITLE, vendorName, IPathConstant.CREATING_PRODUCT_PAGE_TITLE);
		createProduct.uploadProductImage(IPathConstant.PRODUCT_IMAGE_PATH);
		createProduct.clickOnSaveButton();
		System.out.println("The product has been created");
	
		//Verifying the product
		String actualProductName = productInfo.verifyProductInfo(productName);
		Assert.assertTrue(actualProductName.contains(productName));
		System.out.println("Pass: the product name has been verified");
	
	}

}
