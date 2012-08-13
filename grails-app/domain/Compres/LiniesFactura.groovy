package Compres

class LiniesFactura {
    
    String producte
    Integer quantitat
    Integer tipus_iva
    BigDecimal preu

    static constraints = {
        producte(blank: false)
        quantitat(blank: false)
        tipus_iva(blank: false)
        preu(blank: false)
    }
}
