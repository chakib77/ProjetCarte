package org.sio.slam.devine.core

import org.sio.slam.devine.fabrique.createJeu32Cartes

class Paquet constructor(var cartes: List<Carte> = ArrayList<Carte>()) {
    init {
        if (this.cartes.isEmpty()) {
            this.cartes = createJeu32Cartes()
        }
    }

    /**
     * Donne le nombre de cartes dans le paquet
     */
    fun cardinal(): Int = cartes.size

    /**
     * Représentation textuelle de l'état du paquet
     */
    override fun toString(): String {
        return "Paquet de ${cardinal()} cartes"
    }

    /**
     * C'est le paquet qui décide quelle sera la carte à deviner
     * @see [org.sio.slam.Jeu]
     */
    fun getCarteADeviner(): Carte {
        return this.cartes.random()
    }

    fun batLesCartes(list: List<Carte>): List<Carte> {
        return list.shuffled()
    }
}