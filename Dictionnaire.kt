package EFM.EFM_V1

class Dictionnaire {
     var entrées:MutableList<Ent> = mutableListOf()
    //return the number of entrées
    fun nombresEntrées():Int{
        return entrées.size
    }
    //add a entree
    fun ajouter(e:Ent){
        if (entrées.contains(e)){
            throw Exception("already exist")
        }else entrées.add(e)
    }
    //remove one entre from the list of entrees
    fun supprimer(e:Ent):Boolean{
        if(entrées.contains(e)) {
            entrées.remove(e)
            return true
        }else {
            throw Exception("doesn't exist")
            return false
        }
    }
    //remove one entre from the list of entrées by englishWord
    fun supprimer(motEnglish:String):Boolean{
        var etat:Boolean=false
        for (entre in entrées){
            if (entre.anglais==motEnglish){
                entrées.remove(entre)
                 etat=true
            }else {
                throw Exception("doesn't exist")
                etat=false
            } }
        return etat
    }
    // retourne une liste contenant les mots anglais équivalents au mot français
    fun frAn(motFrench:String): MutableList<String> {
        val motsAnglais = mutableListOf<String>()
        for (entree in entrées) {
            if (entree.français == motFrench) {
                motsAnglais.add(entree.anglais)
            }
        }
        return motsAnglais
    }
    //qui retourne tous les mots français (sans doublons) stockés dans le dictionnaire.
    fun motsFrançais(): Set<String> {
        return entrées.map { it.français }.toSet()
    }
    fun dictionnaireFrAn():HashMap<String,ArrayList<String>>{
        val dictionnaire = HashMap<String, ArrayList<String>>()
        for (entree in entrées) {
            val motsAnglais = dictionnaire.getOrDefault(entree.français, ArrayList())
            motsAnglais.add(entree.anglais)
            dictionnaire[entree.français] = motsAnglais
        }
        return dictionnaire
    }
   override fun toString():String{
        val str = StringBuilder()
        for (entree in entrées) {
            str.append(entree.toString())
            str.append("\n")
        }
        return str.toString()
    }
}
