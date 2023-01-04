package singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SettingsBTest {

    @Test
    internal fun `싱글톤 패턴을 사용한 두개의 인스턴스는 같음`() {
        val instanceA = SettingsB.getInstance()
        val instanceB = SettingsB.getInstance()

        assertEquals(instanceA, instanceB)
    }
}