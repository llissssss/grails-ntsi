package Compres
import Usuaris.*

class Comanda {
    
    Usuari usuari
    Date data
    String nom_env
    String cognom_env
    String adreca
    String poblacio_env
    String metodeEnviament
    String nom_fact
    String cognom_fact
    String nif_fact
    String adreca_fact
    String poblacio_fact
    String estat
    Date data_recepcio
    String lliure
    Date data_lliurament

    // estats possibles: en procés, servida, pendent de stock
    BigDecimal preu_total
    static hasMany = [linies_comanda:LiniesComanda]

    static constraints = {
        usuari(nullable:false)
        data()
        metodeEnviament(blank:false,maxSize:50)
        adreca(blank:false,maxSize:200)        
        estat(blank:false)
        lliure(nullable:true)
        data_recepcio(nullable:true)
        data_lliurament(nullable:true)
    }

}
