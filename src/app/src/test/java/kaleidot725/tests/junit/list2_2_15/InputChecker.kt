package kaleidot725.tests.junit.list2_2_15

class InputChecker {
    fun isValid(text : String?) : Boolean {
        if (text == null)  return throw IllegalArgumentException("Cannot be null")
        return text.length >= 3 && text.matches(Regex("[a-zA-Z0-9]+"))
    }
}
