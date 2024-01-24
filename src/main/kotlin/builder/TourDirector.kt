package builder

import java.time.LocalDate

class TourDirector(
    val tourPlanBuilder: TourPlanBuilder
) {

    fun cancunTrip(): TourPlan {
        return this.tourPlanBuilder.title("칸쿤 여행")
            .nightsAndDays(2, 3)
            .startDate(LocalDate.now())
            .whereToStay("리조트")
            .addPlan(0, "체크인 하고 짐풀기")
            .addPlan(1, "저녁 식사")
            .getPlan()
    }
}