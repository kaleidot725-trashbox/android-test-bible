package kaleidot725.tests.mockito.list2_40_41

class SunnySattelite : Satellite {
    override fun getWeather(latitude: Double, longitude: Double): Weather {
        return Weather.SUNNY
    }
}