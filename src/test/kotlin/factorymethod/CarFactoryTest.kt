package factorymethod

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CarFactoryTest {

    @Test
    fun `블랙 차 생성`() {
        val blackCar = BlackCar()

        val orderCar = BlackCarFactory().orderCar("test@mail")

        assertEquals(orderCar.name, blackCar.name)
        assertEquals(orderCar.color, blackCar.color)
        assertEquals(orderCar.logo, blackCar.logo)
    }

    @Test
    fun `레드 차 생성`() {
        val redCar = RedCar()

        val orderCar = RedCarFactory().orderCar("test@mail")

        assertEquals(orderCar.name, redCar.name)
        assertEquals(orderCar.color, redCar.color)
        assertEquals(orderCar.logo, redCar.logo)
    }

    @Test
    fun `이메일이 공백이면 에러`() {
        assertThrows(IllegalArgumentException::class.java) { RedCarFactory().orderCar("") }
    }
}
