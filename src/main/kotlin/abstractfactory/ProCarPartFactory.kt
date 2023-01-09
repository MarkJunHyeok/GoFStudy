package abstractfactory

class ProCarPartFactory : CarPartFactory {
    override fun createEngine(): Engine {
        return ProEngine()
    }

    override fun createWheel(): Wheel {
        return ProWheel()
    }
}