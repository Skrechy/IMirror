package tm.imirror.services.weather;

import java.util.Date;

import net.aksingh.owmjapis.CurrentWeather;

public class WeatherData implements IWeatherData {

	private CurrentWeather currentWeather = null;

	/**
	 * This method will return the currentWeather data if set.
	 * @return	The weatherData if set, else null
	 */
	public CurrentWeather getCurrentWeather() {
		return currentWeather;
	}

	/**
	 * This method will set the currentWeather information if the given has a
	 * newer timestamp.
	 * 
	 * @param currentWeather
	 */
	public void setCurrentWeather(CurrentWeather currentWeather) {
		boolean set = false;
		
		if(hasCurrentWeatherData()){
			if (currentWeather != null) {
				if (currentWeather.getDateTime() != null) {
					if (getDateTime() != null) {
						if (currentWeather.getDateTime().after(getDateTime())) {
							set = true;
						}
					} else {
						set = true;
					}
				}
			}
		} else {
			set = true;
		}

		if(set){
			this.currentWeather = currentWeather;
		}
	}

	@Override
	public String toString() {
		String ret = "{";
		ret += "WeatherData:{";
		if(hasCurrentWeatherData()){
			if (currentWeather.hasDateTime()) {
				ret += currentWeather.getDateTime();
			}
			
			ret += ",";
			if (currentWeather.hasCityName()) {
				ret += currentWeather.getCityName();
			}
			
			ret += ",";
			if (currentWeather.getMainInstance().hasTemperature()) {
				ret += currentWeather.getMainInstance().getTemperature() + "°C";
			}
			
			ret += ",";
			if (currentWeather.getMainInstance().hasHumidity()) {
				ret += currentWeather.getMainInstance().getHumidity() + "%";
			}
		} else {
			ret += "nodata";
		}

		ret += "}}";
		return ret;
	}

	@Override
	public boolean hasCurrentWeatherData() {
		return (currentWeather != null);
	}

	@Override
	public Date getDateTime() {
		if(hasCurrentWeatherData()){
			return currentWeather.getDateTime();
		} else {
			return null;
		}
	}

	@Override
	public String getCityName() {
		if(hasCurrentWeatherData()){
			return currentWeather.getCityName();
		} else {
			return null;
		}
	}

	@Override
	public float getTemperature() {
		if(hasCurrentWeatherData()){
			return currentWeather.getMainInstance().getTemperature();
		} else {
			return Float.NaN;
		}
	}

	@Override
	public float getHumidity() {
		if(hasCurrentWeatherData()){
			return currentWeather.getMainInstance().getHumidity();
		} else {
			return Float.NaN;
		}
	}
}
