import kotlin.random.Random

class Produit constructor(val nom : String, val prix: Double) : Comparable<Produit> {

    override fun compareTo(other: Produit): Int {
        // p-12 : prendre le 12 (un entier) et comparer sur lui
        val suffixThis = this.nom.substring(2).toInt()
        val suffixOther = other.nom.substring(2).toInt()

        if (suffixThis == suffixOther) return 0
        if (suffixThis < suffixOther) return -1
        return 1
    }

    override fun toString(): String {
        return "Produit(nom='$nom', prix=$prix)"
    }
}

class Panier {
    var listeProduits = mutableListOf<Produit>()

    init {
    for (i in 1..15) {
            listeProduits.add(Produit(nom="p-${i}", prix=Random.nextInt(0, 100) * 1.0))
        }
    }
}
