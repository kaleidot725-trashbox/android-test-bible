package kaleidot725.tests.mockito.list2_40

class SunnySattelite : Satellite {
    override fun getWeather(latitude: Double, longitude: Double): Weather {
        return Weather.SUNNY
    }
}