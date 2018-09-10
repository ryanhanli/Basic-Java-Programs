import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ForexTime {

	public static void main(String[] args) {

		boolean Sydney = false;
		boolean Tokyo = false;
		boolean London = false;
		boolean NewYork= false;
		
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm:ss MM/dd/yyyy");
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(dateTime.format(currentDateTime));

//		Sun Sep 09 21:28:42 EDT 2018 Format
//		Date date=java.util.Calendar.getInstance().getTime();  
//		System.out.println(date);  
		
		String s = dateTime.format(currentDateTime);
		int k= Integer.parseInt(s.substring(0,2));
		
		if(k>=3 && k<=11) {
			London = true;
			System.out.println("You are currently in the English Session");
		}
		if((k>=8 && k<=16)) {
			NewYork = true;
			System.out.println("You are currently in the American Session");
		}
		if((k>=18 || k>=2)) {
			Sydney = true;
			System.out.println("You are currently in the Australian Session");
		}
		if((k>=19 || k>=3)) {
			Tokyo = true;
			System.out.println("You are currently in the Asian Session");
		}
		
	}

}
