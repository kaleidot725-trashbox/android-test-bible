package kaleidot725.tests.jetpack

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import kaleidot725.tests.R
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JetPackTest {
    @Test
    fun gettingContextTest() {
        val context = InstrumentationRegistry.getTargetContext()
        val appName = context.getString(R.string.app_name)
        assertThat(appName).isEqualTo("AndroidTestingBible")
    }
}