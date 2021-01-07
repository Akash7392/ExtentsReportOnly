package ecommain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common_base.CommonBaseClass;

public class HomePageMain extends CommonBaseClass{
	

	public	By signin=By.xpath("//a[contains(text(),'Sign in')]");
  public   By Contact_us_link= By.xpath("//div[@id='contact-link']/a[contains(text(),'Contact us')]");
  public  By search =By.xpath("//input[@id='search_query_top']");
  public By search_click =By.xpath("//button[@name='submit_search']");
    
  public  @FindBy(xpath="//button[@name='submit_search']") WebElement abc;
   public  @FindBy (id="name") WebElement bcd;
   
   
   
    
    public void click_on_sign()
    {
        d.findElement(signin).click();;

    }
    
    public void click_Contact_us_link()
    {
        d.findElement(Contact_us_link).click();;
         
    }
    
    public void enter_search()
    {
        d.findElement(search).sendKeys("women");
     
    }

    public void click_search_click()
    {
        d.findElement(search_click).click();
        
    }
    public String gettitle()
    {
             String dd=d.getTitle();
             return dd;

    }


}
