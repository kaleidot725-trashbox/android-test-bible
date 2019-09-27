package kaleidot725.tests.junit.list2_23_30

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherForecastTest {
    lateinit var weatherForecast : WeatherForecast
    lateinit var recorder : MockWeatherRecorder
    lateinit var formatter : SpyWeatherFormatter

    @Before
    fun setUp() {
        val satellite = StubSatellite(Weather.SUNNY)
        recorder = MockWeatherRecorder()
        formatter = SpyWeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun shouldBringUmbrella_givenSunny_returnsFalse() {
        val actual = weatherForecast.shouldBringUmbrella()
        assertThat(actual).isFalse()
    }

    @Test
    fun recordCurrentWeather_assertCalled() {
        weatherForecast.recordCurrentWeather()

        val formatterIsCalled = formatter.isCalled
        assertThat(formatterIsCalled).isTrue()

        val weather = formatter.weather
        assertThat(weather).isIn(Weather.SUNNY, Weather.CLOUDY, Weather.RAINY)

        val isCalled = recorder.isCalled
        assertThat(isCalled).isTrue()

        val recorded = recorder.weather
        assertThat(recorded).isEqualTo("Weather is ${weather}")
    }
}