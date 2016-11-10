package tm.imirror.services.weather;

public enum EWeatherCondition {
	ERROR,
	
	// Thunderstorm
	Thunderstorm__thunderstorm_with_light_rain, Thunderstorm__thunderstorm_with_rain, Thunderstorm__thunderstorm_with_heavy_rain, Thunderstorm__light_thunderstorm, Thunderstorm__thunderstorm,
	Thunderstorm__heavy_thunderstorm, Thunderstorm__ragged_thunderstorm, Thunderstorm__thunderstorm_with_light_drizzle,
	Thunderstorm__thunderstorm_with_drizzle, Thunderstorm__thunderstorm_with_heavy_drizzle,
	
	// Drizzle
	Drizzle__light_intensity_drizzle, Drizzle__drizzle, Drizzle__heavy_intensity_drizzle, Drizzle__light_intensity_drizzle_rain,
	Drizzle__drizzle_rain, Drizzle__heavy_intensity_drizzle_rain, Drizzle__shower_rain_and_drizzle,
	Drizzle__heavy_shower_rain_and_drizzle, Drizzle__shower_drizzle,
	
	// Rain
	Rain__light_rain, Rain__moderate_rain, Rain__heavy_intensity_rain, Rain__very_heavy_rain, Rain__extreme_rain, Rain__freezing_rain,
	Rain__light_intensity_shower_rain, Rain__shower_rain, Rain__heavy_intensity_shower_rain, Rain__ragged_shower_rain,
	
	// Snow
	Snow__light_snow, Snow__snow, Snow__heavy_snow, Snow__sleet, Snow__shower_sleet, Snow__light_rain_and_snow, Snow__rain_and_snow,
	Snow__light_shower_snow, Snow__shower_snow, Snow__heavy_shower_snow,
	
	// Atmosphere
	Atmosphere__mist, Atmosphere__smoke, Atmosphere__haze, Atmosphere__sand_or_dust_whirls, Atmosphere__fog, Atmosphere__sand, Atmosphere__dust, Atmosphere__volcanic_ash, Atmosphere__squalls, Atmosphere__tornado,
	
	// Clouds
	Clouds__clear_sky, Clouds__few_clouds, Clouds__scattered_clouds, Clouds__broken_clouds, Clouds__overcast_clouds,
	
	// Extreme
	Extreme__tornado, Extreme__tropical_storm, Extreme__hurricane, Extreme__cold, Extreme__hot, Extreme__windy, Extreme__hail,
	
	// Additional
	Additional__calm, Additional__light_breeze, Additional__gentle_breeze, Additional__moderate_breeze, Additional__fresh_breeze, Additional__strong_breeze, 
	Additional__high_wind_or_near_gale, Additional__gale, Additional__severe_gale, Additional__storm, Additional__violent_storm, Additional__hurricane
}