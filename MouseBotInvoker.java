package Projects;

import java.awt.event.InputEvent;
import java.lang.Thread;
import java.util.Scanner;

public class MouseBotInvoker {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("----MouseBot----");
		
		System.out.println("Enter the desired number of clicks: ");
		int clicks = scanner.nextInt();
		
		System.out.println("Enter delay between clicks in milliseconds: ");
		int delay = scanner.nextInt();
		System.out.println();
		
		System.out.println("AutoClicker will start in 3 seconds.");
		
		try {
		Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		MouseBot MouseBot = new MouseBot();
		MouseBot.setDelay(delay);
		
		for (int i=0; i<clicks; i++) {
			MouseBot.click(InputEvent.BUTTON1_MASK);  //Can be exchanged for different button masks.
		}
		
		System.out.println("AutoClicker Finished.");
	}
	
}
