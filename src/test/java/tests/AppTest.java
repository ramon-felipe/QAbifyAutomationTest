package tests;

import org.junit.Test;

import Enums.CarTypes;
import base.BaseJunitTest;
import screens.JourneySettingsScreen;
import screens.JourneysHistoryScreen;
import screens.LoginScreen;
import screens.RequestingCodeScreen;

public class AppTest extends BaseJunitTest
{
	@Test
	public void testMobile1() {
		String requestCode = new LoginScreen()
								.login("user@qabify.com", "1234Abc")
								.getRequestingCode();			

		System.out.println("Request Code: " + requestCode);
	}
	
	@Test
	public void testMobile2() {
		String requestCode = new LoginScreen()
								.login("user@qabify.com", "1234Abc")
								.getRequestingCode();			
		
		System.out.println("Request Code: " + requestCode);
		
		String estimatedPrice = new RequestingCodeScreen()
									.clickNextButton()
									.getEstimatedPrice("Calle Pradillo, 42", "Calle Mejía Lequerica, 14", CarTypes.LITE.getCarType(), requestCode)
									;
		
		System.out.println(estimatedPrice);
		
		new JourneySettingsScreen().requestCar();
		System.out.println(new JourneysHistoryScreen().getQtyJourneys());
		System.out.println(new JourneysHistoryScreen().getLastJourneyTitle());
		System.out.println(new JourneysHistoryScreen().getLastJourneyPrice());
	}
}
