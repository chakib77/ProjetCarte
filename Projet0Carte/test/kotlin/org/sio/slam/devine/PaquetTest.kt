package org.sio.slam.devine

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.fail
import org.sio.slam.devine.core.Carte
import org.sio.slam.devine.core.Paquet
import org.sio.slam.devine.enum.CouleurCarte
import org.sio.slam.devine.enum.NomCarte
import org.sio.slam.devine.fabrique.createJeu32Cartes
import org.sio.slam.devine.fabrique.createJeu52Cartes
import java.util.*

internal class PaquetTest {

    @Test
    fun cardinal2Cartes() {
        val paquet2Cartes = Paquet(listOf(
            Carte(NomCarte.VALET, CouleurCarte.COEUR),
            Carte(NomCarte.DIX, CouleurCarte.TREFLE),
        ))
        assertEquals(2, paquet2Cartes.cardinal())
    }

    @Test
    fun testToString2Cartes() {
        val paquet2Cartes = Paquet(listOf(
            Carte(NomCarte.VALET, CouleurCarte.COEUR),
            Carte(NomCarte.DIX, CouleurCarte.TREFLE),
        ))
        assertEquals("Paquet de 2 cartes", paquet2Cartes.toString() )
    }

    @Test
    fun testGetCartes() {
        val paquet2Cartes = Paquet(listOf(
            Carte(NomCarte.VALET, CouleurCarte.COEUR),
            Carte(NomCarte.DIX, CouleurCarte.TREFLE),
        ))
        assertEquals(2,paquet2Cartes.cartes.size)
        assertEquals(NomCarte.VALET, paquet2Cartes.cartes[0].nom)
        assertEquals(CouleurCarte.COEUR, paquet2Cartes.cartes[0].couleur)
    }

    @Test
    fun fabriqueDe32Cartes() {
        val jeuDeTest32Cartes = createJeu32Cartes()
        assertEquals(32, jeuDeTest32Cartes.size)
    }

    @Test
    fun fabriqueDe52Cartes() {
        val jeuDeTest52Cartes = createJeu52Cartes()
        assertEquals(52, jeuDeTest52Cartes.size)
    }

    @Test
    fun batCartes() {
        val paquet2Cartes = Paquet(listOf(
            Carte(NomCarte.AS, CouleurCarte.PIQUE),
            Carte(NomCarte.ROI, CouleurCarte.PIQUE),
            Carte(NomCarte.DAME, CouleurCarte.PIQUE),
            Carte(NomCarte.VALET, CouleurCarte.PIQUE),
            Carte(NomCarte.DIX, CouleurCarte.PIQUE),
            Carte(NomCarte.NEUF, CouleurCarte.PIQUE),
            Carte(NomCarte.HUIT, CouleurCarte.PIQUE),
            Carte(NomCarte.SEPT, CouleurCarte.PIQUE),

            Carte(NomCarte.AS, CouleurCarte.CARREAU),
            Carte(NomCarte.ROI, CouleurCarte.CARREAU),
            Carte(NomCarte.DAME, CouleurCarte.CARREAU),
            Carte(NomCarte.VALET, CouleurCarte.CARREAU),
            Carte(NomCarte.DIX, CouleurCarte.CARREAU),
            Carte(NomCarte.NEUF, CouleurCarte.CARREAU),
            Carte(NomCarte.HUIT, CouleurCarte.CARREAU),
            Carte(NomCarte.SEPT, CouleurCarte.CARREAU),

            Carte(NomCarte.AS, CouleurCarte.COEUR),
            Carte(NomCarte.ROI, CouleurCarte.COEUR),
            Carte(NomCarte.DAME, CouleurCarte.COEUR),
            Carte(NomCarte.VALET, CouleurCarte.COEUR),
            Carte(NomCarte.DIX, CouleurCarte.COEUR),
            Carte(NomCarte.NEUF, CouleurCarte.COEUR),
            Carte(NomCarte.HUIT, CouleurCarte.COEUR),
            Carte(NomCarte.SEPT, CouleurCarte.COEUR),

            Carte(NomCarte.AS, CouleurCarte.TREFLE),
            Carte(NomCarte.ROI, CouleurCarte.TREFLE),
            Carte(NomCarte.DAME, CouleurCarte.TREFLE),
            Carte(NomCarte.VALET, CouleurCarte.TREFLE),
            Carte(NomCarte.DIX, CouleurCarte.TREFLE),
            Carte(NomCarte.NEUF, CouleurCarte.TREFLE),
            Carte(NomCarte.HUIT, CouleurCarte.TREFLE),
            Carte(NomCarte.SEPT, CouleurCarte.TREFLE),
        ))
        val rndsNom = (0..31).random()
        val rndsCouleur = (0..31).random()
        print(paquet2Cartes.cartes[rndsNom].nom)
        print(" de " + paquet2Cartes.cartes[rndsCouleur].couleur)
    }

    /* @Test
    fun <String> shuffle(list: MutableList<String>) {
        list.shuffle()
    }

    fun main() {
        val list: MutableList<Int?> = (0..10).toMutableList();

        shuffle(list)
        println(list)
    } */
}