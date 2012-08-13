package user
import Usuaris.*

class LoginCommand {
    String login
    String password
    private u
    Usuari getUsuari() {
        if (!u && login)
        u = Usuari.findByLogin(login)
        return u
    }
    static constraints = {
        login (blank:false, validator: {val,cmd ->
                if (!cmd.usuari)
                return "loginCommand.login.notrobat"
            })
        password (blank:false, validator: {val,cmd ->
                if (cmd.usuari && cmd.usuari.password != val)
                return "loginCommand.password.incorrecte"
            })
    }
}

class UsuariController {

    def index() {
        redirect(action: 'registre')
    }

    def registre()
    {
        if(request.method=='POST') // el formulari per primer cop login + pass
        {
            Usuari u = new Usuari(params)
            u.rol="client";
            if(!params.password.equals(params.password2))
            {
                u.errors.rejectValue('password','usuari.password.noconcorda')
                [usuari: u]
            }
            else if(params.password ==null)
            {
                u.errors.rejectValue('password','usuari.password.esnul')
                [usuari: u]
            }
            else if(getEdat() < 18)
            {
                u.errors.rejectValue('data_naixement','usuari.edat.menor')
                [usuari: u]
            }
            // comprovacio edat
            else if(u.save()) // fa les validacions si tot esta ok fa el sessions
            {
                session.usuari=u
                flash.message = 'usuari.missatge.benvingut'
                flash.args=[u.getNom()]
                if(session.urlCistella=="/cistella/comprar"){
                    redirect(controller: 'cistella', action: 'comprar')
                }
                else redirect(controller: "producte", action: "ofertes") // redirecciona a contacte
            }
            else
            {
                //mostra els errors
                [usuari: u]
               
            }
        }
        else // si el formulari no esta per primer cop o sigui ja has fet el login i pass, mostras al formulari
        {
           
           
        }
        

    }

    def login(LoginCommand cmd) {
        if (request.method=='POST') {
            if (!cmd.hasErrors()) {
                session.usuari = cmd.usuari
                flash.message = 'usuari.missatge.benvingut'
                flash.args = [session.usuari.nom]
                if(session.urlCistella){
                    redirect(url:session.urlCistella)
                }
                else if(session.url){
                    redirect(url:session.url)
                }
                else redirect(controller: 'producte', action: 'ofertes')
            }
            else {
                [dades:cmd]
            }
        }
    }

    def logout()
    {
    
        session.invalidate()
        redirect(uri: "/")
    }





    int getEdat()
    {
        Date d=new Date()
        d.setYear(80) 
        def edat=d.toString()
        def p=params
        Calendar actual = Calendar.instance        
        Calendar naixament = Calendar.instance
        naixament.time = params.data_naixement
        int rest_any = actual.get(Calendar.YEAR) - naixament.get(Calendar.YEAR)
        int rest_mes = actual.get(Calendar.MONTH) - naixament.get(Calendar.MONTH)
        int rest_dia = actual.get(Calendar.DAY_OF_MONTH) - naixament.get(Calendar.DAY_OF_MONTH)

        if(rest_mes<0 || (rest_mes==0 && rest_dia<0))
        {
            rest_any = rest_any - 1
        }

        return rest_any
    }
    



}

