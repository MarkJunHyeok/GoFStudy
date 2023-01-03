package singleton

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

fun main() {
    A()
    B()
    C()
    notSameInstanceC()
    D()
    E()
    notSameInstanceE()
}

fun A() {
    val instanceA = SettingsA.getInstance()
    val instanceB = SettingsA.getInstance()

    val result = instanceA == instanceB

    println("A : $result")
}

fun B() {
    val instanceA = SettingsB.getInstance()
    val instanceB = SettingsB.getInstance()

    val result = instanceA == instanceB

    println("B : $result")
}

fun C() {
    val instanceA = SettingsC.getInstance()
    val instanceB = SettingsC.getInstance()

    val result = instanceA == instanceB

    println("C : $result")
}

//리플렉션은 대응 불가능
fun notSameInstanceC() {
    val instanceA = SettingsC.getInstance()
    val instanceB = SettingsC::class.objectInstance

    val result = instanceA == instanceB

    println("notSameInstanceC : $result")
}

fun D() {
    val instanceA = SettingsD.getInstance()
    var instanceB: SettingsD? = null;

    ObjectOutputStream(FileOutputStream("settings.obj")).use {
        it.writeObject(instanceA)
    }

    ObjectInputStream(FileInputStream("settings.obj")).use {
        instanceB = it.readObject() as SettingsD
    }

    val result = instanceA == instanceB

    println("D : $result")
}

//enum은 자체적으로 역지렬화를 했을때 동일한 인스턴스를 반환한다.
fun E() {
    val instanceA = SettingsE.Instance
    var instanceB: SettingsE? = null;

    ObjectOutputStream(FileOutputStream("settings.obj")).use {
        it.writeObject(instanceA)
    }

    ObjectInputStream(FileInputStream("settings.obj")).use {
        instanceB = it.readObject() as SettingsE
    }

    val result = instanceA == instanceB

    println("E : $result")
}

//자바와 다르게 코틀린에서는 리플렉션으로 enum 객체를 생성 가능해 리플렉션은 대응 불가능
fun notSameInstanceE() {
    val instanceA = SettingsE.Instance
    val instanceB = SettingsE::class.objectInstance

    val result = instanceA == instanceB

    println("notSameInstanceE : $result")
}
