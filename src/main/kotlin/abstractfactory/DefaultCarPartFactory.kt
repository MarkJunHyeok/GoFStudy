package abstractfactory

class DefaultCarPartFactory : CarPartFactory {
    override fun createEngine(): Engine {
        return DefaultEngine()
    }

    override fun createWheel(): Wheel {
        return DefaultWheel()
    }
}