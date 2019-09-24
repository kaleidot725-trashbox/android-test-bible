package kaleidot725.tests.list2_23_30

class SpyWeatherFormatter : WeatherFormatter() {
    var weather : Weather? = null
    var isCalled = false

    override fun format(weather: Weather): String {
        this.weather = weather
        isCalled = true
        return super.format(weather)
    }
}