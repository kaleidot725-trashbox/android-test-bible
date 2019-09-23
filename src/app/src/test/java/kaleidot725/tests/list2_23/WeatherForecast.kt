package kaleidot725.tests.list2_23

class WeatherForecast(private val satellite : Satelite) {
    fun shouldBringUmbrella() : Boolean {
        val weather = satellite.getWeather()
        return when(weather) {
            Weather.SUNNY, Weather.CLOUDY -> false
            Weather.RAINY -> true
        }
    }
}