package kaleidot725.tests.mockito.list2_40_41

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

lateinit var weatherForecast: WeatherForecast
lateinit var recorder: WeatherRecorder

class WeatherForecastTest {
    @Before
    fun setUp() {
        recorder = mock<WeatherRecorder>(WeatherRecorder::class.java)
        val satellite = SunnySattelite()
        val formatter = WeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun recordCurrentWeather_assertRecorderCalled() {
        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        verify(recorder, times(1)).record(any())
        verify(recorder, times(1)).record(eq("Weather is SUNNY"))
    }
}
