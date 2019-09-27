package kaleidot725.tests.mockito.list2_51_52

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kaleidot725.tests.mockito.list2_40_41.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class MockSpyAnottation() {
    @Mock
    lateinit var satellite: Satellite

    @Mock
    lateinit var recorder: WeatherRecorder

    @Spy
    val formatter: WeatherFormatter = WeatherFormatter()

    lateinit var wetaherForecast: WeatherForecast

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(satellite.getWeather(any(), any())).thenReturn(Weather.SUNNY)
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }
}