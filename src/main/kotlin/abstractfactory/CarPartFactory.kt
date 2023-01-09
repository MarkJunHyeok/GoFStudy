package abstractfactory

interface CarPartFactory {

    fun createEngine(): Engine

    fun createWheel(): Wheel
}