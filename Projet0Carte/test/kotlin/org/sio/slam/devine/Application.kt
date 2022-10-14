val comparePrix = Comparator { o1: Produit, o2: Produit -> o1.prix.compareTo(o2.prix)
//// ou bien :
//    if (o1.prix == o2.prix) 0
//    if (o1.prix < o2.prix) -1
//    else 1
//
}


fun main(args: Array<String>) {
    var panier = Panier()

//    panier.listeProduits.sort() // compare sur le nom des produits
    panier.listeProduits.sortWith(comparePrix)
    for (produit in panier.listeProduits) {
        println(produit)
    }
}


