package sintaxis

class Nulabilidad {
    fun main(){
        var name:String? = "AristiDevs SUSCRIBE"

        println(name?.get(3) ?:  "Es nulo wey")
    }
}