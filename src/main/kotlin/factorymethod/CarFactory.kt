package factorymethod

interface CarFactory {

    fun orderCar(email: String): Car {
        val car = createCar()

        validation(email)
        prepareCar(car)
        setToEmail(car.name, email)

        return car
    }

    private fun validation(email: String) {
        if (email.isBlank()) throw IllegalArgumentException()
    }

    private fun prepareCar(car: Car) {
        println("$car.name 차가 준비중입니다.")
        println("$car.color 로 칠하는 중")
        println("$car.logo 입히는 중")
    }

    private fun setToEmail(name: String, email: String) {
        println("$email 님 $name 차가 완성되었습니다.")
    }

    fun createCar(): Car
}