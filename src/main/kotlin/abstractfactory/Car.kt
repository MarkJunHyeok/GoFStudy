package abstractfactory

import java.awt.Color

open class Car(
    val name: String,
    val color: Color,
    val logo: String,
    var engine: Engine? = null,
    var wheel: Wheel? = null,
)