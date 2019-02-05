//authors: Tyler Zudans and Brooks Walls
public class Burner {

	//created temperature enum in burner class
	public enum Temperature {BLAZING("VERY HOT! DON'T TOUCH"), HOT("CAREFUL"), WARM("warm"), COLD("cooool");
		private String value;
	
	Temperature (String aValue){
		value = aValue;
		
	}
	public String toString() {
		return value;
		
	}
	
	};
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public final int TIME_DURATION= 2;
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		
	}
	public String getMyTemperature() {
		return myTemperature.toString();
		
	}
	public void plusButton() {
		
		switch(mySetting) {
			case OFF:
				//only when bumping up to low timer is set to 2
				mySetting=Setting.LOW;
				timer=TIME_DURATION;
				break;
				
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
				
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
				
		}
		
	}
	public void minusButton() {
		switch(mySetting) {
			case HIGH:
				mySetting=Setting.MEDIUM;
				break;
				
			case LOW:
				mySetting = Setting.OFF;
				myTemperature = Temperature.COLD;
				break;
				
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
				
		}
		
	}
	public void updateTemperature() {
		//subtracts from timer because one minute has passed
		timer -= 1;
		//checks if its been two minutes
		if(timer==0) {
			
			switch(myTemperature) {
			
			case COLD:
				if(mySetting!=Setting.OFF) {
					myTemperature=Temperature.WARM;
					
				}
				//ensures no wrong temperatures
				else if (mySetting == Setting.OFF){
					myTemperature=Temperature.COLD;
					
				}
				break;
				
			case WARM:
				if(mySetting!=Setting.LOW) {
					myTemperature=Temperature.HOT;
					
				}
				//ensures no wrong temperatures
				else if (mySetting == Setting.MEDIUM) {
					myTemperature=Temperature.HOT;
					
					
				}
				else if (mySetting == Setting.LOW){
					myTemperature=Temperature.WARM;
					
					
				}
				else if (mySetting == Setting.OFF){
					myTemperature=Temperature.COLD;
					
				}
				
				break;
				
			case HOT:
				if(mySetting!=Setting.MEDIUM&&mySetting!=Setting.LOW && mySetting!= Setting.OFF) {
					myTemperature=Temperature.BLAZING;
					
				}
				break;
				
			}
			timer = TIME_DURATION;
				
		}
		
	}
	public void display() {
		System.out.println(mySetting.toString()+"...."+myTemperature.toString());
		
	}
	
	

}
