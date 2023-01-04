package singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SettingsATest {

    @Test
    internal fun `싱글톤 패턴을 사용한 두개의 인스턴스는 같음`() {
        val instanceA = SettingsA.getInstance()
        val instanceB = SettingsA.getInstance()

        assertEquals(instanceA, instanceB)
    }
}