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
		
		if(hasWeatherInformation()){
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
		if(hasWeatherInformation()){
			if (currentWeather.hasDateTime()) {
				ret += currentWeather.getDateTime();
			}
			
			ret += ",";
			if (currentWeather.hasCityName()) {
				ret += currentWeather.getCityName();
			}
			
			ret += ",";
			if (currentWeather.getMainInstance().hasTemperature()) {
				ret += currentWeather.getMainInstance().getTemperature() + "'F";
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
	public boolean hasWeatherInformation() {
		return (currentWeather != null);
	}

	@Override
	public Date getDateTime() {
		if(hasWeatherInformation()){
			return currentWeather.getDateTime();
		} else {
			return null;
		}
	}

	@Override
	public String getCityName() {
		if(hasWeatherInformation()){
			return currentWeather.getCityName();
		} else {
			return null;
		}
	}

	@Override
	public float getTemperature() {
		if(hasWeatherInformation()){
			return currentWeather.getMainInstance().getTemperature();
		} else {
			return Float.NaN;
		}
	}

	@Override
	public float getHumidity() {
		if(hasWeatherInformation()){
			return currentWeather.getMainInstance().getHumidity();
		} else {
			return Float.NaN;
		}
	}
}
