package kaleidot725.tests.mockito.list2_51_52

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import kaleidot725.tests.mockito.list2_31_39.Satellite
import kaleidot725.tests.mockito.list2_31_39.Weather
import org.junit.Test

class InteractiveStub {
    @Test
    fun interactivestub() {
        val satellite = mock<Satellite>(name = "MockSatellite") {
            on { getWeather(any(), any()) } doReturn Weather.CLOUDY
            on { getWeather(eq(37.58006), eq(-122.345106)) } doReturn Weather.SUNNY
            on { getWeather(eq(37.792872), eq(-122.396915)) } doReturn Weather.RAINY
        }
    }
}