package tm.imirror.services.weather;

import static org.junit.Assert.*;

import org.junit.Test;

import tm.imirror.services.weather.WeatherService;

public class WeatherServiceTest {

	@Test
	public void test() throws InterruptedException {
		WeatherService weather = new WeatherService();
		Thread.sleep(6000);
		System.out.println(weather.toString());
		assertFalse("Weather not set.", weather.toString().equals(""));
	}

}
