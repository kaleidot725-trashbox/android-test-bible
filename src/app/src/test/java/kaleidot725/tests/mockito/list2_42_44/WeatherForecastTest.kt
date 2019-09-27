package kaleidot725.tests.mockito.list2_42_44

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito.mock

class WeatherForecastTest {
    @Test
    fun recordCurrentWeather_assertRecorderCalled() {
        val recorder = mock<WeatherRecorder>(WeatherRecorder::class.java)
        val satellite = SunnySattelite()
        val formatter = WeatherFormatter()
        val weatherForecast = WeatherForecast(satellite, recorder, formatter)

        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        argumentCaptor<Record>().apply {
            verify(recorder, times(1)).record(capture())
            assertThat(firstValue.description).isEqualTo("Weather is SUNNY")
        }
    }

    @Test
    fun recordCurrentWeather_assertFormatterCalled() {
        val recorder = WeatherRecorder()
        val satellite = SunnySattelite()
        val formatter = spy(WeatherFormatter())
        val weatherForecast = WeatherForecast(satellite, recorder, formatter)

        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        verify(formatter, times(1)).format(any())
    }
}
