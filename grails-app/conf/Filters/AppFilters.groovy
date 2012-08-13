package Usuaris

class AppFilters {

    def filters = {
        
        comprovarCistella(controller:'*', action:'*') {
           before = {
                if (!session.cistella) {
                    session.cistellaTotal=0
                    session.cistella=[:]
                }
                if(!session.usuari && (controllerName=='producteGestio' || controllerName=='comanda' || controllerName=='administracio')){
                    response.sendError(403)
                    return false
                }
                if(session.usuari?.rol!='comercial' && controllerName=='producteGestio'){
                    response.sendError(403)
                    return false
                }
                if(session.usuari?.rol!='magatzem' && controllerName=='comanda'){
                    response.sendError(403)
                    return false
                }
                if(session.usuari?.rol!='administracio' && controllerName=='administracio'){
                    response.sendError(403)
                    return false
                }
            }
        }
        /*comprovarLoginComercial(controller:'comercial',action: '*'){
            before = {
                if(session.usuari?.roll!='comercial'){
                    response.sendError(404)
                    return false
                }
            }
        }
        comprovarLoginMagatzem(controller:'magatzem',action: '*'){
            before = {
                if(session.usuari?.roll!='magatzem'){
                    response.sendError(403)
                    return false
                }
            }
        }
        comprovarLoginAdministracio(controller:'administracio',action: '*'){
            before = {
                if(session.usuari?.roll!='administracio'){
                    response.sendError(403)
                    return false
                }
            }
        }*/
        
        
    }

}
