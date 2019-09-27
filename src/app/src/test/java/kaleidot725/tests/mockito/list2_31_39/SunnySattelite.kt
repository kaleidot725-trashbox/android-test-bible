package kaleidot725.tests.mockito.list2_31_39

class SunnySattelite : Satellite {
    override fun getWeather(latitude: Double, longitude: Double): Weather {
        return Weather.SUNNY
    }
}