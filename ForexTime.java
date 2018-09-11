import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class ForexTime {

	public static void main(String[] args) {

//		boolean Sydney = false;
//		boolean Tokyo = false;
//		boolean London = false;
//		boolean NewYork= false;
		
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm:ss MM/dd/yyyy");
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(dateTime.format(currentDateTime));

//		Sun Sep 09 21:28:42 EDT 2018 Format
//		Date date=java.util.Calendar.getInstance().getTime();  
//		System.out.println(date);  
		
		String s = dateTime.format(currentDateTime);
		double k= Integer.parseInt(s.substring(0,2));
		double i= (Integer.parseInt(s.substring(3,5)))/(double) 60;
		int y = 0;
		i=round(i,2);
		k = k+i;
//		System.out.println(k);
		
		if(k>=3 && k<=11) {
//			London = true;
			System.out.println("You are currently in the English Session(GBP).");
			y++;
		}
		if((k>=8 && k<=16)) {
//			NewYork = true;
			System.out.println("You are currently in the American Session(USD).");
			y++;
		}
		if((k>=18 || k<=2)) {
//			Sydney = true;
			System.out.println("You are currently in the Australian Session(AUD).");
			y++;
		}
		if((k>=19 || k<=3)) {
//			Tokyo = true;
			System.out.println("You are currently in the Asian Session(JPY).");
			y++;
		}
		if(y==0) {
			System.out.println("All sessions are currently closed.");
		}
	}
	
	public static double round(double value, int decimalPlaces) {
	    
		if (decimalPlaces < 0) throw new IllegalArgumentException("Not a valid decimal place value");

	    BigDecimal decimal = new BigDecimal(value);
	    decimal = decimal.setScale(decimalPlaces, RoundingMode.HALF_UP);
	    return decimal.doubleValue();
	}

}
