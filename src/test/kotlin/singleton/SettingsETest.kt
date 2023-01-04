package singleton

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class SettingsETest {

    @Test
    //자바와 다르게 코틀린에서는 리플렉션으로 enum 객체를 생성 가능해 리플렉션은 대응 불가능
    internal fun `리플렉션을 사용해 별도의 인스턴스를 생성하면 싱글톤 인스턴스와 서로 다름`() {
        val instanceA = SettingsE.Instance
        val instanceB = SettingsE::class.objectInstance

        assertNotEquals(instanceA, instanceB)
    }
}