package kaleidot725.tests.list2_23_30

class MockWeatherRecorder : WeatherRecorder() {
    var weather : String? = null
    var isCalled = false

    override fun record(weather: String) {
        this.weather = weather
        isCalled = true
    }
}