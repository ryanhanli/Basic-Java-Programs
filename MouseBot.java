package Projects;

import java.awt.Robot;

public class MouseBot {
		
		private Robot Robot;
		private int delay; // delay between clicks in ms
		
		public MouseBot() {
			try {
				Robot = new Robot();				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			delay = 300;
		}
		
		public void click(int button) {
			try {   //Most of Java's Robot Class throws exceptions so try catch must be implemented almost everywhere
				Robot.mousePress(button);
				Robot.delay(250);  //delay between press and release
				Robot.mouseRelease(button);
				Robot.delay(delay);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		public void setDelay(int ms) {
			this.delay = ms;
		}
	
}
