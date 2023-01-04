package singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

internal class SettingsDTest {

    @Test
    internal fun `싱글톤 패턴을 사용한 두개의 인스턴스는 같음`() {
        val instanceA = SettingsD.getInstance()
        val instanceB = SettingsD.getInstance()

        assertEquals(instanceA, instanceB)
    }

    @Test
    internal fun `리플렉션을 사용해 별도의 인스턴스를 생성하면 싱글톤 인스턴스와 서로 다름`() {
        val instanceA = SettingsD.getInstance()
        val instanceB = SettingsD::class.objectInstance

        assertNotEquals(instanceA, instanceB)
    }

    @Test
    // readResolve() 함수에 싱글톤을 인스턴스를 리턴 시키면 역질렬화 시 싱글톤 보장 가능
    internal fun `역직렬화를 통해 인스턴스를 생성하면 싱글톤 인스턴스와 서로 같음`() {
        val instanceA = SettingsD.getInstance()
        var instanceB: SettingsD? = null;

        ObjectOutputStream(FileOutputStream("settings.obj")).use {
            it.writeObject(instanceA)
        }

        ObjectInputStream(FileInputStream("settings.obj")).use {
            instanceB = it.readObject() as SettingsD
        }

        assertEquals(instanceA, instanceB)
    }
}
