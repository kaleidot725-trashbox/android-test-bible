package kaleidot725.tests.mockito.list2_31_39

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.lang.RuntimeException

fun <T> any(): T = Mockito.any<T>()

class WeatherForecastTest {
    lateinit var weatherForecast : WeatherForecast
    lateinit var recorder : WeatherRecorder
    lateinit var formatter : WeatherFormatter

    @Before
    fun setUp() {
        val satellite = mock<Satellite>(Satellite::class.java)
//      Mockito.`when`(satellite.getWeather(any(), any())).thenReturn(Weather.CLOUDY)
//      Mockito.`when`(satellite.getWeather(eq(37.580006), eq(-122.345106))).thenReturn(Weather.SUNNY)
//      Mockito.`when`(satellite.getWeather(eq(37.792872), eq(-122.393615))).thenReturn(Weather.RAINY)

        Mockito.`when`(satellite.getWeather(any(), any())).thenAnswer { invocation ->
            val latitude = invocation.arguments[0] as Double
            val longitude = invocation.arguments[1] as Double

            if (latitude in 20.424086..45.55099 &&
                longitude in 122.033872..153.980789) {
                return@thenAnswer Weather.SUNNY
            } else {
                return@thenAnswer Weather.RAINY
            }
        }

        recorder = mock<WeatherRecorder>(WeatherRecorder::class.java)
        formatter = mock<WeatherFormatter>(WeatherFormatter::class.java)
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun shouldBringUmbrella_givenSunny_returnsFalse() {
        val actual = weatherForecast.shouldBringUmbrella(35.669784, 139.817728)
        assertThat(actual).isFalse()
    }

    @Test
    fun shouldBringUmbrella_givenBurlingame_returnsTrue() {
        val actual = weatherForecast.shouldBringUmbrella(37.580006, -122.345106)
        assertThat(actual).isTrue()
    }

    @Test
    fun exception() {
        val satellite = mock<Satellite>(Satellite::class.java)
        Mockito.`when`(satellite.getWeather(any(), any())).thenThrow(RuntimeException("ERROR"))

        val recorder = mock<WeatherRecorder>(WeatherRecorder::class.java)
        val formatter = mock<WeatherFormatter>(WeatherFormatter::class.java)
        val weatherForecast = WeatherForecast(satellite, recorder, formatter)

        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            weatherForecast.shouldBringUmbrella(37.580006, -122.345106)
        }
        .withMessage("ERROR")
        .withNoCause()
    }
}