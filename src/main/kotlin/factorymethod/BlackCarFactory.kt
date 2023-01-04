package factorymethod

class BlackCarFactory : CarFactory {

    override fun createCar(): Car {
        return BlackCar()
    }
}