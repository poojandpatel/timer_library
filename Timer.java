/**
 * This Timer class implements an interface to create, initialize, and maintain a clock; both military and standard time
 * @author Poojan Patel
 * @since 03.20.2019
 */
package maxeta;

public class Timer {
	private int hour = 0; 
	private int minutes = 0;
	private int seconds = 0;
	private boolean isMilitary; // to know if the timer is military time or not
	
	/*
	 * @param isMilitary is a boolean: true if the timer uses 24 hr format, false elsewise
	 */
	public Timer(boolean isMilitary) {
		this.isMilitary = isMilitary;
		if(isMilitary)
			hour = 0;
		else
			hour = 12;
	};
	
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
	
	public int getSeconds()
	{
		return this.seconds;
	}
	
	public int getMinutes()
	{
		return this.minutes;
	}
	
	/*
	 * @hour is the hour value passed in by the user
	 * if military time is set, and hour value passed in is 24 it is changed to 0
	 * else if hour is 
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
		else if((!isMilitary) && hour >= 1 && hour <= 12)
			this.hour = hour;
		else
			throw new IllegalArgumentException("Invalid Hour Value");
	}

	public void setMinutes(int minutes)
	{
		if(minutes >= 0 && minutes < 60)
			this.minutes = minutes;
		else if(minutes == 60)
		{
			minutes = 0;
			incrementHour();
		}
		else
			throw new IllegalArgumentException("Invalid Minute Value");
	}

	public void setSeconds(int seconds)
	{
		if(seconds >= 0 && seconds < 60)
			this.seconds = seconds;
		else if(seconds == 60)
		{
			this.seconds = 0;
			incrementMinutes();
		}
		else
			throw new IllegalArgumentException("Invalid Second Value");
	}
	
	/**
	 * increments hour by 1, and if timer is military time and hour is 24, it is changed to 0. 
	 * and if it is standard time, and hour is at 12, incrementing it will change it to 1.
	 */
	public void incrementHour() {
		if(isMilitary && hour < 24)
			hour++;
		else if(!isMilitary && hour < 12)
			hour++;
		else if(isMilitary && hour == 24)
			hour = 0;
		else if (!isMilitary && hour == 12)
			hour = 1;
			
	}
	
	/**
	 * This method increments minutes by 1 and if minutes is already at 59, the method calls increment Hour and sets minutes to 0
	 */
	public void incrementMinutes() {
		if(minutes >= 0 && minutes <= 58)
			minutes++;
		else if(minutes == 59)
		{
			minutes = 0;
			incrementHour();
		}	
	}
	
	/**
	 * This method increments second by 1 and if second is already at 59, the method calls increment minutes and sets second to 0
	 */
    public void incrementSeconds() {
    	if(seconds >= 0 && seconds <= 58)
    		seconds++;
    	else if(seconds == 59)
    	{
    		seconds = 0;
    		incrementMinutes();
    	}
	}
    
}
