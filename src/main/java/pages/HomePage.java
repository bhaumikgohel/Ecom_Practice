package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


import Utilities.Utils;
import base.TestBase;

public class HomePage extends TestBase{
	
	String ProductName;
	ArrayList<String> ab;
	SoftAssert sa = new SoftAssert();
	
	@FindBy(xpath = "(//img[@class='default-logo'])[1]")
	WebElement logo;
	
	@FindBy(xpath = "(//div//a//span[@class='ct-icon-container'])[3]")
	WebElement Social_Header_icon;
	
	@FindBy(xpath = "//nav[@id='header-menu-1']//li[contains(@class,'menu-item menu-item-type-post_type')]")
	WebElement Menu;
	
	@FindBy(xpath = "(//h2[@class='woocommerce-loop-product__title']//a)[1]")
	WebElement First_Product_Name;
	
	@FindBy(xpath = "//button[@data-id='search']")
	WebElement Home_Searchbutton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement SearchTextBox;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement Search_Button_Detail;
	
	//input[@class="modal-field"]/following-sibling::div[@class="ct-search-form-controls"]
	
	@FindBy(xpath = "(//h2[@class=\"elementor-heading-title elementor-size-default\"])[2]")
	WebElement bannertext;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public String Validate_HomePage_title() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean Validate_HomePage_Logo() {
		boolean sitelogo = logo.isDisplayed();
		return sitelogo;
	}
	
	public boolean Validate_HomePage_Social_Media() {
		boolean Social_icon = Social_Header_icon.isDisplayed();
		return Social_icon;
	}
	
	public void Validate_HomePage_Menu(){
		
		int j=1;
		
		while(j <=3) {
			WebElement ele = driver.findElement(By.xpath(("(//nav[@id='header-menu-1']//li[contains(@class,'menu-item menu-item-type-post_type')])["+j+"]")));
			
			String w1 = ele.getText();
			System.out.println(w1);
			j++;
		}
		
	}
	public String Get_FirstProduct_Name() throws InterruptedException {
		
		Utils.ScrollUntil(First_Product_Name);
		
		 ProductName = First_Product_Name.getText();
		 
		 Thread.sleep(3000);
		 
		 System.out.println(ProductName);
		 
		 Thread.sleep(3000);
		 
		 return ProductName;
		 
		//ArrayList<ProductData> test = new ArrayList<>();
		
		//ProductData.ProductName1 = First_Product_Name.getText();
		//		ProductData.ProductName2 = First_Product_Name.getText();

		//	test.add(ProductData);
		
		// ab = new ArrayList<String>();
		
		
		
	}
	public void Search_Functionality(String ProductName) throws InterruptedException {
		
		Thread.sleep(3000);
		Utils.ScrollUntil(bannertext);
		Utils.FluentWaitforElement(bannertext,30);
		
		Thread.sleep(3000);
		System.out.println(bannertext.getText());
		
		Thread.sleep(3000);
		Utils.ScrollUntil(logo);
		Utils.Full_Page_Scroll_Up();
		Utils.FluentWaitforElement(logo,20);
		
		Utils.Waitfor(Home_Searchbutton, 10);
		Home_Searchbutton.click();
		
		Utils.Waitfor(SearchTextBox, 10);
		SearchTextBox.sendKeys(ProductName);
		
		Utils.Waitfor(Search_Button_Detail, 10);
		Search_Button_Detail.click();
		
		sa.assertEquals(ProductName, "Large Capacity Travel Cosmetic Bag,Multifunctional Storage Travel Makeup Bags,Compartment Cosmetic Toiletries Bag Travel Cosmetic Cases Waterproof Portable Makeup Pouch for Women Girls Men (Pack of 1pc)");
		sa.assertAll();
		
	}
}
