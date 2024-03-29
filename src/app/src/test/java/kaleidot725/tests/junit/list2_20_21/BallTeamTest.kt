package kaleidot725.tests.junit.list2_20_21

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.Test

class BallTeamTest() {
    data class BallTeam(val name : String, val city : String, val stadium : String)

    @Test
    fun ballTeamAssert() {
        val target = listOf(
            BallTeam("Giants", "San Francisco", "AT&T Park"),
            BallTeam("Dodgers", "Los Angels", "Dodger Stadium"),
            BallTeam("Angels", "Los Angels", "Angel Stadium"),
            BallTeam("Athletics", "Oakland", "Oakland Coliseum"),
            BallTeam("Padres", "San Diego", "Petco Park")
        )

        assertThat(target)
            .filteredOn { team -> team.city.startsWith("San")}
            .filteredOn { team -> team.city.endsWith("Francisco")}
            .extracting("name", String::class.java)
            .containsExactly("Giants")

        assertThat(target)
            .filteredOn { team -> team.city == "Los Angels"}
            .extracting("name", "stadium")
            .containsExactly(
                tuple("Dodgers", "Dodger Stadium"),
                tuple("Angels", "Angel Stadium")
            )
    }
}