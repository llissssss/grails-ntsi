package shop
import Compres.*
import Usuaris.*

class ComandesController {

    def index() { }
    
    def veure(){
        
        def query=Comanda.where{
            (usuari.id==session.usuari.id && (estat=="en proces" || estat=="pendent de stock") )
        }
        def comandes=query.list()
        def teComandes
        if(comandes){
           teComandes=true
        }else{
           teComandes=false
        }
        
        [comandes:comandes, teComandes:teComandes]
    }
    

    
}
