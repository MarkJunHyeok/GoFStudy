package builder

import java.time.LocalDate

class TourPlan(
    val title: String? = null,
    val nights: Int? = null,
    val days: Int? = null,
    val startDate: LocalDate? = null,
    val whereToStay: String? = null,
    val plans: MutableList<DetailPlan>
) {
}