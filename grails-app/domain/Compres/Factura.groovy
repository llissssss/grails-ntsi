package Compres

class Factura {
    
    String usuari
    Date data
    String adreca
    String poblacio
    String cp
    BigDecimal preu_base_general
    BigDecimal preu_base_reduit
    BigDecimal preu_base_superreduit
    BigDecimal preu_total_general
    BigDecimal preu_total_reduit
    BigDecimal preu_total_superreduit

    static constraints = {
        usuari(blank: false)
        data(blank: false)
    }
}
