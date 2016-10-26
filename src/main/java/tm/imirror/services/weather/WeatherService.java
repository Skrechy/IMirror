package tm.imirror.services.weather;

import java.io.IOException;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.HourlyForecast;
import net.aksingh.owmjapis.HourlyForecast.Forecast;
import net.aksingh.owmjapis.OpenWeatherMap;

public class WeatherService extends Observable {

	/**
	 * DEFAULTS
	 */
	private final static int DEFAULT_REFRESH_DELAY_SEC = 1;
	private final static int DEFAULT_REFRESH_PERIOD_SEC = 60;
	private final static String DEFAULT_CITY = "Hamburg";
	private final static String DEFAULT_COUNTRY = "DE";

	/**
	 * TIMER
	 */
	private Timer timer; // timer object
	private int refreshDelay; // delay in milliseconds
	private int refreshPeriod; // period in milliseconds

	/**
	 * Weather Client
	 */
	private OpenWeatherMap owmClient; 	//client
	private final static String OWM_API_KEY = "d40cc0844ac7fb77991e6a2d92e7f4d2";
	private WeatherData weatherData;
	
	private String cityName;
	private String countryCode;

	/**
	 * This contructor will use the default settings for Location and timings.
	 */
	public WeatherService() {
		this(DEFAULT_CITY, DEFAULT_COUNTRY, DEFAULT_REFRESH_DELAY_SEC * 1000, DEFAULT_REFRESH_PERIOD_SEC * 1000);
	}

	/**
	 * This constructor will use city and country as location and default
	 * settings for timings.
	 * 
	 * @param cityName
	 *            City for weather updates.
	 * @param countryCode
	 *            Country of the city.
	 */
	public WeatherService(String cityName, String countryCode) {
		this(cityName, countryCode, DEFAULT_REFRESH_DELAY_SEC * 1000, DEFAULT_REFRESH_PERIOD_SEC * 1000);
	}

	/**
	 * This constructor will use city and country as location and refreshDelay
	 * and period for timings.
	 * 
	 * @param cityName
	 *            City for weather updates.
	 * @param countryCode
	 *            Country of the city.
	 * @param refreshDelayMSec
	 *            Refresh delay in milliseconds for weather information after startup.
	 * @param refreshPeriodMSec
	 *            Refresh period in milliseconds for weather information.
	 */
	public WeatherService(String cityName, String countryCode, int refreshDelayMSec, int refreshPeriodMSec) {
		weatherData = new WeatherData();
		
		owmClient = new OpenWeatherMap(OWM_API_KEY);
		
		this.refreshDelay = refreshDelayMSec;
		this.refreshPeriod = refreshPeriodMSec;
		
		this.cityName = cityName;
		this.countryCode = countryCode;

		timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				refresh();
			}
		}, this.refreshDelay, this.refreshPeriod);
	}

	
	
	/**
	 * This method will refresh the weather information.
	 * It will periodically be called by timer.
	 */
	public void refresh() {
		try {
			// getting current weather data for the "London" city
	        CurrentWeather currentWeather = owmClient.currentWeatherByCityName(cityName, countryCode);
	        //HourlyForecast hourlyForecast = owmClient.hourlyForecastByCityName(cityName, countryCode);
	        //DailyForecast dailyForecast = owmClient.dailyForecastByCityName(cityName, countryCode, count);
	        this.weatherData.setCurrentWeather(currentWeather);
	        
	        if(countObservers()>0){
	        	setChanged();
	        	notifyObservers();
	        }
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public IWeatherData getWeatherData(){
		return weatherData;
	}
	
	@Override
	public String toString() {
		String ret = "";
		if(weatherData != null){
			ret += "{WeatherService:";
			ret += weatherData.toString();
			ret += "}";
		}
		return ret;
	}

}
