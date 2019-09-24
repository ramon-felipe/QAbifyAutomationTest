package screens;

import static driverFactory.MobileDriver.getDriver;

import org.openqa.selenium.By;

import base.BaseScreen;

public class JourneysHistoryScreen extends BaseScreen {
	String journeysListXPath;

	public JourneysHistoryScreen() {
		journeysListXPath = "(//android.support.v7.widget.RecyclerView/android.widget.LinearLayout)";
		this.waitJourneyListLoad();
	}
	
	public JourneysHistoryScreen waitJourneyListLoad() {
		//WaitHelper.waitUntilElementVisible(By.xpath(journeysListXPath), 15);
		
		return this;
	}
	
	public int getQtyJourneys() {		
		return getDriver().findElements(By.xpath(journeysListXPath)).size();
	}
	
	public String getLastJourneyTitle() {
		String journeyTitleXPath = null;
		String journeyTitle = null;
		
		try {
			journeyTitleXPath = journeysListXPath + "[last()]/android.widget.TextView[@resource-id='com.cabify.qabify:id/journeyTitle']";
			journeyTitle = mobileDSL.getText(By.xpath(journeyTitleXPath));
		} catch (Exception e) {
			System.out.println("Error obtaining journay title");
			e.printStackTrace();
		}
		
		return journeyTitle;
	}
	
	public String getLastJourneyPrice(){
		String journeyPriceXPath = null;
		String journeyPrice = null;
		
		try {
			journeyPriceXPath = journeysListXPath + "[last()]/android.widget.TextView[@resource-id='com.cabify.qabify:id/journeyPrice']";
			journeyPrice = mobileDSL.getText(By.xpath(journeyPriceXPath));
		} catch (Exception e) {
			System.out.println("Error obtaining journay price.");
			e.printStackTrace();
		}
		
		return journeyPrice;
	}	
}
