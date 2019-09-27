package kaleidot725.tests.junit.list2_23_30

class StubSatellite(private val anyWeather : Weather) : Satelite {
    override fun getWeather(): Weather {
        return anyWeather
    }
}