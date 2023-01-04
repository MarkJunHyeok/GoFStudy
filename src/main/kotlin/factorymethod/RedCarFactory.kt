package factorymethod

class RedCarFactory : CarFactory {

    override fun createCar(): Car {
        return RedCar()
    }
}