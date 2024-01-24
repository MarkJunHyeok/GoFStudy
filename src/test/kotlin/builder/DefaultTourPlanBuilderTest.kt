package builder

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DefaultTourPlanBuilderTest {

    @Test
    fun `칸쿤 여행 생성`() {
        val builder = DefaultTourPlanBuilder()

        val tourDirector = TourDirector(builder)

        val plan = tourDirector.cancunTrip()

        assertEquals(plan.title, "칸쿤 여행")
        assertEquals(plan.nights, 2)
        assertEquals(plan.days, 3)
        assertNotNull(plan.startDate)
        assertEquals(plan.plans.get(0).day, 0)
        assertEquals(plan.plans.get(0).plan, "체크인 하고 짐풀기")
        assertEquals(plan.plans.get(1).day, 1)
        assertEquals(plan.plans.get(1).plan, "저녁 식사")
    }
}