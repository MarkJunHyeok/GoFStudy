package abstractfactory

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProCarFactoryTest {

    @Test
    fun `프로카 생성 성공`() {
        val proPartFactory = ProCarPartFactory()
        val proPartProCarFactory = ProCarFactory(proPartFactory)

        val proPartCar = proPartProCarFactory.createCar()

        assertEquals(proPartCar.engine!!.javaClass, ProEngine::class.java)
        assertEquals(proPartCar.wheel!!.javaClass, ProWheel::class.java)

        val defaultPartFactory = DefaultCarPartFactory()
        val defaultPartProCarFactory = ProCarFactory(defaultPartFactory)

        val defaultPartCar = defaultPartProCarFactory.createCar()

        assertEquals(defaultPartCar.engine!!.javaClass, DefaultEngine::class.java)
        assertEquals(defaultPartCar.wheel!!.javaClass, DefaultWheel::class.java)
    }
}
