package org.sio.slam.devine

import org.sio.slam.devine.core.Carte
import org.sio.slam.devine.core.Jeu
import org.sio.slam.devine.core.Paquet
import org.sio.slam.devine.enum.CouleurCarte
import org.sio.slam.devine.enum.NomCarte
import org.sio.slam.devine.enum.getCouleurCarteFromString
import org.sio.slam.devine.enum.getNomCarteFromString
import org.sio.slam.devine.fabrique.createJeu32Cartes
import org.sio.slam.devine.fabrique.createJeu52Cartes

fun main(args: Array<String>) {

    // TODO (A) demander au joueur s'il souhaite avoir de l'aide pour sa partie
    var aide = false
    println("Souhaitez vous avoir de l'aide ?")
    val demandeaide: String = (readLine() + "").uppercase()
    if (demandeaide == "OUI") {
        aide = true
    }

    // TODO (A) demander au joueur avec quel jeu de cartes 32 ou 52 il souhaite jouer
    var paqueDeCartes = Paquet()
    do {
    println("Avec quel jeu de cartes souhaitez vous jouer ? 32 ou 52 ?")
        val demandeCarte: String = readLine() + ""
        if (demandeCarte == "32") {
            paqueDeCartes = Paquet(createJeu32Cartes())
            println("Création du paquet de 32 cartes")
        } else if (demandeCarte == "52") {
            paqueDeCartes = Paquet(createJeu52Cartes())
            println("Création du paquet de 52 cartes")
        } else {
            println("Nous n'avons pas de paquet $demandeCarte carte")
        }
    } while (demandeCarte != "32" && demandeCarte != "52")


    println(" ==== Instanciation du jeu, début de la partie. ====")
    val jeu = Jeu(aide, paqueDeCartes)
    var nbEssai = 0
    do{
        nbEssai++
        println("Entrez un nom de carte dans le jeu (exemples : Roi, sept, six, As...) :")
        // TODO (optionnel) permettre de saisir un chiffre au lieu d'une chaine : 7 au lieu de Sept...

        val nomCarteUserStr: String = readLine() + ""
        val nomCarteUser: NomCarte? = getNomCarteFromString(nomCarteUserStr.trim().uppercase())

        println("Entrez un nom de \"couleur\" de carte parmi : Pique, Trefle, Coeur, Carreau : ")
        val couleurCarteUserStr: String = readLine() + ""
        val couleurCarteUser: CouleurCarte? = getCouleurCarteFromString(couleurCarteUserStr.trim().uppercase())

        if (nomCarteUser != null && couleurCarteUser != null) {
            // prise en compte de la carte du joueur
            val carteDuJoueur: Carte = Carte(nomCarteUser, couleurCarteUser)

            if (jeu.isMatch(carteDuJoueur)) {
                println("Bravo, vous avez trouvé la bonne carte !")
                break
            } else {
                println("Ce n'est pas la bonne carte !")
                println("votre proposition  : $carteDuJoueur")
                if (aide) {
                    if (carteDuJoueur < jeu.carteADeviner) {
                        println("Votre carte est inférieur à la carte à trouver")
                    } else if (carteDuJoueur > jeu.carteADeviner) {
                        println("Votre carte est supérieur à la carte à trouver")
                    } else {
                        println("Vous êtes sur la bonne piste")
                    }
                    println("Souhaitez vous connaitre la carte a deviner ?")
                    val laCarte = (readLine() + "").uppercase()
                    if (laCarte == "OUI") {
                        println("la carte à deviner était ${jeu.carteADeviner}")
                        break
                    }
                    // TODO: (A) si l'aide est activée, alors dire si la carte proposée est
                    //  plus petite ou plus grande que la carte à deviner
                }
            }
        } else {
            // utilisateur a mal renseigné sa carte
            val nomCarte = if (nomCarteUserStr == "") "?" else nomCarteUserStr
            val couleurCarte = if (couleurCarteUserStr == "") "?" else couleurCarteUserStr

            println("Désolé, mauvaise définition de carte ! (${nomCarte} de ${couleurCarte})")
        }

        // TODO (A) permettre au joueur de retenter une autre carte (sans relancer le jeu) ou d'abandonner la partie
        println("Souhaitez vous réessayer")
        var retenter = false
        val reponseChance = (readLine() + "").uppercase()
        if (reponseChance == "OUI") {
            retenter = true
        }
        // TODO (challenge-4) la stratégie de jeu est à implémenter... à faire lorsque les autres TODOs auront été réalisés
        println("Votre stratégie de jeu : ${jeu.strategiePartie(retenter,nbEssai)} ")
    } while(retenter)


    println(" ==== Fin de la partie. ====")
}