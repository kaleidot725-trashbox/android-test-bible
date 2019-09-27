package kaleidot725.tests.mockito.list2_54

import kaleidot725.tests.mockito.list2_31_39.SunnySattelite
import kaleidot725.tests.mockito.list2_31_39.WeatherFormatter
import kaleidot725.tests.mockito.list2_31_39.WeatherRecorder
import org.mockito.Mock
import org.mockito.Spy

class MockitoJUnitRunner {
    @Mock
    lateinit var satellite: SunnySattelite

    @Mock
    lateinit var recorder: WeatherRecorder

    @Spy
    val formatter: WeatherFormatter = WeatherFormatter()
}