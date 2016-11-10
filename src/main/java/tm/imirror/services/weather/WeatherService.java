package tm.imirror.services.weather;

import java.io.IOException;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.HourlyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Language;
import net.aksingh.owmjapis.OpenWeatherMap.Units;

public class WeatherService extends Observable {

	/**
	 * DEFAULTS
	 */
	private final static int DEFAULT_REFRESH_DELAY_SEC = 1;
	private final static int DEFAULT_REFRESH_PERIOD_SEC = 60;
	private final static String DEFAULT_CITY = "Hamburg";
	private final static String DEFAULT_COUNTRY = "DE";
	private final static byte BYTE_COUNT_FORECAST = 5;

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
	private WeatherData currentWeatherData;
	private HourlyForecast hourlyForecastData;
	private DailyForecast dailyForecastData;
	
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
		currentWeatherData = new WeatherData();
		
		owmClient = new OpenWeatherMap(Units.METRIC, OWM_API_KEY);
		
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
			// update data from server.
	        CurrentWeather currentWeather = owmClient.currentWeatherByCityName(cityName, countryCode);
	        HourlyForecast hourlyForecast = owmClient.hourlyForecastByCityName(cityName, countryCode);
	        DailyForecast dailyForecast = owmClient.dailyForecastByCityName(cityName, countryCode, BYTE_COUNT_FORECAST);
	       
	        // update date interfaces.
	        this.currentWeatherData.setCurrentWeather(currentWeather);
	        
	        // notify observers.
	        if(countObservers()>0){
	        	setChanged();
	        	notifyObservers();
	        }
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public IWeatherData getCurrentWeatherData(){
		return currentWeatherData;
	}
	
	@Override
	public String toString() {
		String ret = "";
		if(currentWeatherData != null){
			ret += "{WeatherService:";
			ret += currentWeatherData.toString();
			ret += "}";
		}
		return ret;
	}

}
