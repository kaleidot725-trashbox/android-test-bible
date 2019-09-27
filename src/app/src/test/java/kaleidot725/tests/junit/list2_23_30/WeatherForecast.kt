package kaleidot725.tests.junit.list2_23_30

class WeatherForecast(
    private val satellite : Satelite,
    private val recorder : WeatherRecorder,
    private val formatter : WeatherFormatter
) {
    fun shouldBringUmbrella() : Boolean {
        val weather = satellite.getWeather()
        return when(weather) {
            Weather.SUNNY, Weather.CLOUDY -> false
            Weather.RAINY -> true
        }
    }

    fun recordCurrentWeather() {
        val weather = satellite.getWeather()
        val formatted = formatter.format(weather)
        return recorder.record(formatted)
    }
}