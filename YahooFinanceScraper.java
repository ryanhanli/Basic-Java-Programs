import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class YahooFinanceScraper {

	public static void main(String args[]) throws IOException { //avoids try and catch
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the stock quote abbreviation you wish to check"
				+ "(for ex. Apple is AAPL): ");
		String stockAbbreviation = scanner.nextLine();
		String SA = "https://finance.yahoo.com/quote/" + stockAbbreviation + "?p=" + stockAbbreviation;
		//System.out.println(SA);

		//Used for when running without scanner
		//final String stockName = "REGN";
		
		
		URL url = new URL(SA);
		URLConnection urlConnectionObject = url.openConnection();
		
		InputStreamReader streamInput = new InputStreamReader(urlConnectionObject.getInputStream());
		BufferedReader onlineReader = new BufferedReader(streamInput);
		
		String currentPrice = "Price not found";
		String HTMLline = onlineReader.readLine();
		
		
//		 Rewrite the Web Scraper parameters
//		 Gets all of the website information in a different language
//		 while(HTMLline != null){
//		 System.out.println(HTMLline);
//		 HTMLline = onlineReader.readLine();
//		 }
		
//		Loop to fetch information
//		while(HTMLline != null) {
//		if(HTMLline.contains("\"StreamDataStore\"")) {
//			int indexTarget = HTMLline.indexOf("\"StreamDataStore\"");
//			int deciIndex = HTMLline.indexOf(".",indexTarget);
//			int startIndex = deciIndex;
//			while(HTMLline.charAt(startIndex) != ':') {
//				startIndex--;
//			}
//			currentPrice = HTMLline.substring(startIndex+1, deciIndex+3);
//		}
//		HTMLline = onlineReader.readLine();
//	}
	//System.out.println("Current price of " + stockName + "(rounded to nearest cent): " + currentPrice);
		
			while(HTMLline != null) {
			if(HTMLline.contains("\"regularMarketVolume\"")) {
				int indexTarget = HTMLline.indexOf("\"regularMarketVolume\"");
		  indexTarget -= 73;
				int deciIndex = HTMLline.indexOf(".",indexTarget);
				int startIndex = deciIndex;
//				Attempts to make the decimals more automated
//				if(HTMLline.charAt(deciIndex)!= ',') {
//					deciIndex++;
//				}
//				int deciTwo = HTMLline.indexOf(".",indexTarget);
				while(HTMLline.charAt(startIndex) != ':') {
					startIndex--;
				}
//				while(HTMLline.charAt(startIndex) != ',') {
//					deciTwo++;
//				}
				currentPrice = HTMLline.substring(startIndex+1, deciIndex+4);
			}
			HTMLline = onlineReader.readLine();
		}
		if(currentPrice.contains(","))	{
			int k= currentPrice.indexOf(",");
			currentPrice = currentPrice.substring(0,k);
		}
		System.out.println("Current price of " + stockAbbreviation + ": " + currentPrice);

	}
	
}
