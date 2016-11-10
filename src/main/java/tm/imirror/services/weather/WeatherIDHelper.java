package tm.imirror.services.weather;

public class WeatherIDHelper {

	public static EWeatherCondition mapIDToWeatherCondition(int id) {
		EWeatherCondition ret = EWeatherCondition.ERROR;
		
		switch (id) {
		//thunderstorm
		case 200: ret = EWeatherCondition.Thunderstorm__thunderstorm_with_light_rain; break;
		case 201: ret = EWeatherCondition.Thunderstorm__thunderstorm_with_rain; break;
		case 202: ret = EWeatherCondition.Thunderstorm__thunderstorm_with_heavy_rain; break;
		case 210: ret = EWeatherCondition.Thunderstorm__light_thunderstorm; break;
		case 211: ret = EWeatherCondition.Thunderstorm__thunderstorm; break;
		case 212: ret = EWeatherCondition.Thunderstorm__heavy_thunderstorm; break;
		case 221: ret = EWeatherCondition.Thunderstorm__ragged_thunderstorm; break;
		case 230: ret = EWeatherCondition.Thunderstorm__thunderstorm_with_light_drizzle; break;
		case 231: ret = EWeatherCondition.Thunderstorm__thunderstorm_with_drizzle; break;
		case 232: ret = EWeatherCondition.Thunderstorm__thunderstorm_with_heavy_drizzle; break;
		//drizzle
		//rain
		//snow
		//atmosphere
		//clouds
		//extreme
		//additional
		}
		
		return ret;
	}

}
