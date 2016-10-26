package tm.imirror.services.weather;

import java.util.Date;

public interface IWeatherData {

	/**
	 * Check if the weather information is set.
	 * @return true if weather information available otherwise false.
	 */
	public boolean hasWeatherInformation();
	
	/**
	 * Getter for the date time of the currently stored weather information.
	 * @return Date if available the date, otherwise null.
	 */
	public Date getDateTime();
	
	/**
	 * Getter for the city name of the currently stored weather information.
	 * @return String if available the city name, otherwise null.
	 */
	public String getCityName();
	
	/**
	 * Getter for the temperature of the currently stored weather information.
	 * @return float if available the temperature, otherwise NaN.
	 */
	public float getTemperature();
	
	/**
	 * Getter for the humidity of the currently stored weather information.
	 * @return float if available the humidity, otherwise NaN.
	 */
	public float getHumidity();
	
}
