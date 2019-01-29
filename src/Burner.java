
public class Burner {

	
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
		// TODO Auto-generated constructor stub
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		
	}
	public void plusButton() {
		switch(mySetting) {
			case OFF:
				mySetting=Setting.LOW;
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
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
		}
	}
	public void updateTemperature() {
		if(timer==0) {
			switch(myTemperature) {
			case COLD:
				if(mySetting!=Setting.OFF) {
					myTemperature=Temperature.WARM;
				}
				if(mySetting!=Setting.LOW) {
					timer = TIME_DURATION;
				}
				break;
			case WARM:
				if(mySetting!=Setting.LOW)myTemperature=Temperature.HOT;
				if(mySetting!=Setting.MEDIUM) {
					timer = TIME_DURATION;
				}
				break;
			case HOT:
				if(mySetting!=Setting.MEDIUM)myTemperature=Temperature.BLAZING;
				break;
			}
			
				
		}
	}
	public void display() {
		
		System.out.println(mySetting.toString()+"...."+myTemperature.toString());
	}
	
	

}
