class Persona(var peso: Double, var altura: Double) {

    init {
        require(peso > 0 && altura > 0) { "El peso y la altura deben ser mayores que 0" }
    }

    var nombre: String = ""
    val imc: Double = peso / (altura * altura)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
        this.peso = peso
        this.altura = altura
    }

    override fun toString(): String {
        return "Persona(peso=$peso, altura=$altura, nombre='$nombre', imc=$imc)"
    }

    fun saludar(): String {
        return "Hola, soy $nombre"
    }

    fun alturaEncimaMedia(): Boolean {
        return altura >= 1.75
    }

    fun pesoEncimaMedia(): Boolean {
        return peso >= 70
    }

    fun obtenerDescImc(): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }

    fun obtenerDesc(): String {
        val descAltura = if (alturaEncimaMedia()) "Por encima de la media" else "Por debajo de la media"
        val descPeso = if (pesoEncimaMedia()) "Por encima de la media" else "Por debajo de la media"

        return "$nombre con una altura de ${"%.2f".format(altura)}m ($descAltura) " +
                "y un peso de ${"%.2f".format(peso)}kg ($descPeso) " +
                "tiene un IMC de ${"%.2f".format(imc)} (${obtenerDescImc()})."
    }
}

fun main() {
    val p1 = Persona("Julia", 75.0, 1.80)
    val p2 = Persona("Juan", 85.0, 1.75)
    val p3 = Persona("María", 67.30, 1.68)
    val p4 = Persona("Manuel", 100.30, 1.70)
    val p5 = Persona("Jose", 40.30, 1.78)

    println(p1.obtenerDesc())
    println(p2.obtenerDesc())
    println(p3.obtenerDesc())
    println(p4.obtenerDesc())
    println(p5.obtenerDesc())
}
