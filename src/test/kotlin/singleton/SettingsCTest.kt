package singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

internal class SettingsCTest {


    @Test
    internal fun `싱글톤 패턴을 사용한 두개의 인스턴스는 같음`() {
        val instanceA = SettingsC.getInstance()
        val instanceB = SettingsC.getInstance()

        assertEquals(instanceA, instanceB)
    }

    @Test
    internal fun `리플렉션을 사용해 별도의 인스턴스를 생성하면 싱글톤 인스턴스와 서로 다름`() {
        val instanceA = SettingsC.getInstance()
        val instanceB = SettingsC::class.objectInstance

        assertNotEquals(instanceA, instanceB)
    }

    @Test
    internal fun `역직렬화를 통해 인스턴스를 생성하면 싱글톤 인스턴스와 서로 다름`() {
        val instanceA = SettingsC.getInstance()
        var instanceB: SettingsC? = null;

        ObjectOutputStream(FileOutputStream("settings.obj")).use {
            it.writeObject(instanceA)
        }

        ObjectInputStream(FileInputStream("settings.obj")).use {
            instanceB = it.readObject() as SettingsC
        }

        assertNotEquals(instanceA, instanceB)
    }
}