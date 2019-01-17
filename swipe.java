package CheapTicketApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class swipe {

	@SuppressWarnings({ "unused", "rawtypes" })
	AndroidDriver<WebElement> dvr;
	@SuppressWarnings("rawtypes")
	@Test
	public void testAppium() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("deviceName", "Coolpad 3600l");
		capability.setCapability("deviceVersion", "6.0.1");
		capability.setCapability("devicePlatForm", "Android"); 

		File file = new File("C:\\Users\\Akram\\eclipse-workspace\\Appium\\apk\\FarmRise.apk");
		capability.setCapability("app",file.getAbsolutePath());
		dvr = new AndroidDriver<WebElement>(new URL("http://192.168.1.8:4723/wd/hub"), capability);
		dvr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		Thread.sleep(4000);
		// Chose language
		dvr.findElementById("com.climate.farmrise:id/txt_alphabet").click();
		Thread.sleep(4000);
		// Click proceed
		dvr.findElementById("com.climate.farmrise:id/btn_Proceed").click();
		Thread.sleep(4000);
		// Click Agree and Continue
		dvr.findElementById("com.climate.farmrise:id/btn_agree").click();

		// Click login button
		for(int i=1; i<=5; i++){
			for(int j=1; j<=i; j++){
				dvr.findElementById("com.climate.farmrise:id/tv_dismiss").click();
			}
		}

		// Navigate to Home Screen
		// Tap on "Access weather Details" in Weather details section

		Thread.sleep(15000);
		dvr.findElementById("com.climate.farmrise:id/checkWeatherView").click();
		Thread.sleep(12000);

		// Get visible Text
		List<WebElement> button = dvr.findElementsByClassName("android.widget.TextView");
		System.out.println("Total Flights  On The Screen :" +button.size());
		for(int i1=1; i1<button.size(); i1++) {
			System.out.println(button.get(1).getAttribute("text"));
			Thread.sleep(9000);

			// Swipe Right to Left
			dvr.findElementByClassName("android.widget.LinearLayout").click();
			System.out.println(dvr.manage().window().getSize().getWidth());
			System.out.println(dvr.manage().window().getSize().getHeight());
			int screenWidth=dvr.manage().window().getSize().getWidth();
			int screenHeight=dvr.manage().window().getSize().getHeight();

			int startx=screenWidth*6/7;
			int endx=screenWidth/7;
			int starty=screenHeight/2;
			int endy=screenHeight/2;

			for(int i=1; i<=5; i++){
				for(int j=1; j<=i; j++){
					new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();
					Thread.sleep(10000);

					// Get All Visible Text With Swiping
					List<WebElement> bt = dvr.findElementsByClassName("android.widget.TextView");
					System.out.println("Total Flights  On The Screen :" +bt.size());
					for(int i2=1; i2<bt.size(); i2++) {
						System.out.println(bt.get(1).getAttribute("text"));
						Thread.sleep(8000);
					}

				}
			}


			// Click on More Tab, Navigate to More screen.
			Thread.sleep(15000);
			dvr.findElementById("com.climate.farmrise:id/action_more").click();
			Thread.sleep(12000);

			// Tap on "Government Schemes"
			dvr.findElementById("com.climate.farmrise:id/more_govtSchemes").click();
			Thread.sleep(10000);

			// Scroll 3 times to the bottom till "Load More schemes"Button displayed.
			System.out.println(dvr.manage().window().getSize().getWidth());
			System.out.println(dvr.manage().window().getSize().getHeight());
			int screenWidths=dvr.manage().window().getSize().getWidth();
			int screenHeights=dvr.manage().window().getSize().getHeight();

			startx=screenWidths/2;
			endx=screenWidths/2;
			starty=screenHeights*8/9;
			endy=screenHeights/9;
			// Swipe Down with 3 Times
			for(int i=1; i<=3; i++){
				for(int j=1; j<=i; j++){
					Thread.sleep(10000);
					new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();
				}
			}

			//Verify the same button.
			Thread.sleep(10000);
			dvr.findElementById("com.climate.farmrise:id/loadMore");
			if(dvr.getTitle().equalsIgnoreCase("Load more schemes")) {
				System.out.println("Load more schemes button is present");}
			else {
				System.out.println("Load more schemes button is not present");
			}
			Thread.sleep(10000);

			// In "Government schemes" screen tap on search and input word "scheme",
			dvr.findElementById("android:id/search_button").sendKeys("scheme");
			Thread.sleep(9000);
			dvr.findElementById("com.climate.farmrise:id/action_more").click();
			Thread.sleep(9000);

			// Verify the results displayed.
			// Swipe Down all results, and Get Text
			List<WebElement> btn = dvr.findElementsByClassName("com.climate.farmrise:id/govtSchemeStatus");
			System.out.println("Total Flights  On The Screen :" +btn.size());
			for(int i3=1; i3<btn.size(); i3++) {
				System.out.println(button.get(1).getAttribute("text"));
				Thread.sleep(8000);}

			System.out.println(dvr.manage().window().getSize().getWidth());
			System.out.println(dvr.manage().window().getSize().getHeight());
			dvr.manage().window().getSize().getWidth();
			dvr.manage().window().getSize().getHeight();
			startx=screenWidths/2;
			endx=screenWidths/2;
			starty=screenHeights*4/6;
			endy=screenHeights/6;

			for(int i=1; i<=3; i++){
				for(int j=1; j<=i; j++)
				{
					Thread.sleep(10000);
					new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();
					// Get Text With Swipe
					List<WebElement> btn1 = dvr.findElementsByClassName("com.climate.farmrise:id/govtSchemeStatus");
					System.out.println("Total Flights  On The Screen :" +btn1.size());
					for(int i3=1; i3<btn1.size(); i3++) {
						System.out.println(btn1.get(1).getAttribute("text"));
						Thread.sleep(8000);

						// Now Verify getting all Results
						String[] thisIsAStringArray = {
								"S.C.P. Scheme",
								"Jan Aushadhi scheme",
								"Sukanya Samriddhi Account Scheme",
								"Weather Based Crop Insurance Scheme",
								"Hathkarga Weaver Pension Scheme",
								"Barn Fire Accident Help Scheme",
								"Rural Backward Poultry Development Scheme",
								"Deep Boring Scheme",
								"Mini Kamdhenu Dairy Scheme",
								"Scholarship Scheme UP Mandi Parishad",
								"Kamdhenu Dairy Scheme",
								"Indira Gandhi National Widow Pension Scheme",
								"Employment generation through Dhaba/ Fast food/ Restaurant training scheme",
								"Monthly Income Scheme (MIS) account",
								"Public Personal Accident Help Scheme",
								"Handicap Pension Scheme",
								"Pension Scheme (BOCW)",
								"Maternity Benefit Scheme (BOCW)",
								"Disability Pension Scheme (BOCW)",
								"Mukhyamantri Kisan Ayam Sarvhit Bima Yojana– Bima Care Card",
								"Accident Assistance Scheme (BOCW)",
								"Micro Kamdhenu Dairy Scheme",
								"Critical Illness Scheme (BOCW)",
								"Solar energy assistance scheme(BOCW)",
								"Marriage of Daughter for Construction Worker Scheme (BOCW)",
								"Death and Cremation Assistance Scheme (BOCW)",
								"Term loan scheme of NSKFDC",
								"Indira Gandhi Old Age Pension Scheme",
								"Farmers Gift Scheme UP Mandi Parishad",
								"Scheme to promote quality betel production in state",
								"Coconut Palm Insurance Scheme (CPIS)",
								"Pradhan Mantri Kaushal Rin Yojna (Skill Loan Scheme)",
								"Modified National Agricultural Insurance Scheme (MNAIS)",
								"Self Employment Scheme (UP SC Finance and Development Corporation)",
								"Weather Based Crop Insurance Scheme (WBCIS) ",
								"Anganwadi Karyakartri Bima Yojana (Insurance)",
								"Pradhan Mantri Suraksha Bima Yojana",
								"Pradhan Mantri Matritva Vandana Yojana (PMMVY)",
								"Commercial Layers farm",
								"Farmer Training"
						};

						for( int i4 = 0; i4 < thisIsAStringArray.length; i4++)
						{
							String element = thisIsAStringArray[i];
							System.out.println( element );    
						}

					}

				}
			}
		}
	}
}


















