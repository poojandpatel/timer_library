public class Timer {
	private int hour = 0; 
	private int minutes = 0;
	private int seconds = 0;
	private boolean isMilitary; // to know if the timer is military time or not
	
	//Default Constructor
	public Timer() {};
	
	// this constructor allows to create an instance and preset value
	public Timer(int hour, int min, int seconds, boolean isMilitary)
	{
		this.isMilitary = isMilitary;
		setHour(hour);
		setMinutes(min);
		setSeconds(seconds);
	}
	
	public int getHour()
	{
		return hour;
	}
	
	/*
	 * @hour is the hour value passed in by the user
	 * if military time is set, and hour value passed in is 24 it is changed to 0
	 * 
	 */
	public void setHour(int hour)
	{
		if(isMilitary && (hour >= 0 && hour <= 24))
		{
			if(hour == 24) {
				this.hour = hour;
				incrementHour();
			}
			else
				this.hour = hour;
		}
		else if((!isMilitary) && hour >= 0 && hour <= 12)
			this.hour = hour;
		else
			throw new IllegalArgumentException("Invalid Hour Value");
	}

	public int getMinutes()
	{
		return this.minutes;
	}

	public void setMinutes(int minutes)
	{
		if(minutes >= 0 && minutes < 60)
			this.minutes = minutes;
		else if(minutes == 60)
			incrementHour();
		else
			throw new IllegalArgumentException("Invalid Minute Value");
	}
	
	public int getSeconds()
	{
		return this.seconds;
	}
	
	public void setSeconds(int seconds)
	{
		if(seconds >= 0 && seconds < 60)
			this.seconds = seconds;
		else if(seconds == 60)
			incrementMinutes();
		else
			throw new IllegalArgumentException("Invalid Second Value");
	}
	
	public void incrementHour() {
		if(isMilitary && hour < 24)
			hour++;
		else if(!isMilitary && hour < 12)
			hour++;
		if((isMilitary && hour == 24) || (!isMilitary && hour == 12)) {
			hour = 0;
		}
			
	}
	
	public void incrementMinutes() {
		if(minutes >= 0 && minutes < 58)
			minutes++;
		else if(minutes == 59)
		{
			minutes = 0;
			incrementHour();
		}	
	}
	
    public void incrementSeconds() {
    	if(seconds >= 0 && seconds < 58)
    		seconds++;
    	else if(seconds == 59)
    	{
    		seconds = 0;
    		incrementMinutes();
    	}
	}
}
