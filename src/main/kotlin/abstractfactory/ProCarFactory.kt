package abstractfactory

class ProCarFactory(
    private val carPartFactory: CarPartFactory,
) : CarFactory {

    override fun createCar(): Car {
        val car = ProCar()
        car.engine = carPartFactory.createEngine()
        car.wheel = carPartFactory.createWheel()

        return car
    }
}