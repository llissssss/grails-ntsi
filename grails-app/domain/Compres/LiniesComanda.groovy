package Compres

class LiniesComanda {
    
    String idProducte
    String producte
    Integer quantitat
    BigDecimal preu

    static constraints = {
        idProducte()
        producte(blank: false)
        quantitat(blank: false)
        preu(blank: false)   
    }

}
