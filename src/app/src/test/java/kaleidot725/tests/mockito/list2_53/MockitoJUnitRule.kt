package kaleidot725.tests.mockito.list2_53

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kaleidot725.tests.mockito.list2_31_39.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit
import org.mockito.quality.Strictness

class MockitoJUnitRule {
    @get:Rule
    val rule = MockitoJUnit.rule().strictness(Strictness.WARN)

    @Mock
    lateinit var satellite: Satellite

    @Mock
    lateinit var recorder: WeatherRecorder

    @Spy
    val formatter: WeatherFormatter = WeatherFormatter()

    lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        whenever(satellite.getWeather(any(), any())).thenReturn(Weather.SUNNY)
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

}