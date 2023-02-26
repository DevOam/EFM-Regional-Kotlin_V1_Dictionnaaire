package EFM.EFM_V1

import java.lang.Exception

data class Ent(var français:String,var anglais:String) {
    init {
        if (français.isEmpty() || français.isBlank()) throw Exception("le mot français peut pas etre empty ou blank")
        if (anglais.isEmpty() || anglais.isBlank()) throw Exception("le mot anglais peut pas etre empty ou blank")
    }
    override fun toString(): String {
        return "$français : $anglais"
    }
     fun equals(other: Ent): Boolean {
        if (this.français==other.français)
            return true
        else return false
    }
}