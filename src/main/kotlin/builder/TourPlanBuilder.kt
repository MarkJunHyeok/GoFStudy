package builder

import java.time.LocalDate

interface TourPlanBuilder {

    fun title(title: String): TourPlanBuilder
    fun nightsAndDays(nights: Int, days: Int): TourPlanBuilder
    fun startDate(localDate: LocalDate): TourPlanBuilder
    fun whereToStay(whereToStay: String): TourPlanBuilder
    fun addPlan(day: Int, plan: String): TourPlanBuilder
    fun getPlan(): TourPlan
}

class DefaultTourPlanBuilder(
    private var title: String? = null,
    private var nights: Int? = null,
    private var days: Int? = null,
    private var startDate: LocalDate? = null,
    private var whereToStay: String? = null,
    private val plans: MutableList<DetailPlan> = mutableListOf(),
) : TourPlanBuilder {


    override fun title(title: String): TourPlanBuilder {
        this.title = title

        return this
    }

    override fun nightsAndDays(nights: Int, days: Int): TourPlanBuilder {
        this.nights = nights
        this.days = days

        return this
    }

    override fun startDate(localDate: LocalDate): TourPlanBuilder {
        this.startDate = localDate

        return this
    }

    override fun whereToStay(whereToStay: String): TourPlanBuilder {
        this.whereToStay = whereToStay

        return this
    }

    override fun addPlan(day: Int, plan: String): TourPlanBuilder {
        this.plans.add(DetailPlan(day, plan))

        return this
    }

    override fun getPlan(): TourPlan {
        return TourPlan(title, nights, days, startDate, whereToStay, plans)
    }
}