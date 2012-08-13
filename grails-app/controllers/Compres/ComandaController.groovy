package Compres

import org.springframework.dao.DataIntegrityViolationException

class ComandaController {

    static scaffold = true
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "escullOpcio", params: params)
    }
    def escullOpcio(){
        
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        /*if(!params.sort){
            params.sort="data"
        }*/
        def p=params
        if(!session.ordreBy1)  session.ordreBy1="data"
        if(!session.order1) session.order1="asc"

        if(p.action) p.remove('action')
        if(p.controller) p.remove('controller')
        if(p.offset){
            def off=Integer.parseInt(p.get('offset'))
            p.put('offset',off)
        }
        if(p.sort){
            session.ordreBy1=p.sort
            p.remove('sort')
        }
        if(p.order){
            session.order1=p.order
            p.remove('order')
        }
        def llista=Comanda.findAll("from Comanda as c where c.estat='en proces' OR c.estat='pendent de stock'")
        def llistaComandes=Comanda.findAll("from Comanda as c where c.estat='en proces' OR c.estat='pendent de stock' ORDER BY "+session.ordreBy1+" "+session.order1, p)
        def total=llistaComandes.size()
        def totalComandes=Comanda.count()
        this.guardaUrl()
        [comandaInstanceList: llistaComandes, comandaInstanceTotal: llista.size()]
    }

    
    def servir(){
        def com=Comanda.find("from Comanda as c where c.id="+params.id)
        session.idComandaPerServir=com.id
        [comandaSelection: com]
    }
    
    def finalitzarServir(){
        def com=Comanda.get(session.idComandaPerServir)
        def estat=params.estat
        def p=params
        if(com){
            params.estatservida="ok"
            if(params.estat=="pendent de stock"){
                com.estat="pendent de stock"
                com.data_recepcio=params.data_recepcio
                com.lliure=params.lliure
                com.save(failOnError:true)
            }
            if(params.estat=="servida"){
                com.estat="servida"
                com.save(failOnError:true)
            }
            if(session.url) redirect(url: session.url)
            else redirect(controller: "producte", action: "index")
        }
        else{
            flash.message='comanda.id_inexistent'
            response.sendError(404)
        }
        
    }

    def llistaServides(){
                params.max = Math.min(params.max ? params.int('max') : 10, 100)
        /*if(!params.sort){
            params.sort="data"
        }*/
        def p=params
        if(!session.ordreBy)  session.ordreBy="data"
        if(!session.order) session.order="asc"

        if(p.action) p.remove('action')
        if(p.controller) p.remove('controller')
        if(p.offset){
            def off=Integer.parseInt(p.get('offset'))
            p.put('offset',off)
        }
        if(p.sort){
            session.ordreBy=p.sort
            p.remove('sort')
        }
        if(p.order){
            session.order=p.order
            p.remove('order')
        }

        def llista=Comanda.findAll("from Comanda as c where c.estat='servida'")
        def llistaComandes=Comanda.findAll("from Comanda as c where c.estat='servida' ORDER BY "+session.ordreBy+" "+session.order, p)
        [comandaInstanceList: llistaComandes, comandaInstanceTotal: llista.size()]
    }
    def lliurada(){
        def com=Comanda.get(params.id)
        def d=new Date()
        if(com){
            com.estat="lliurada"
            com.data_lliurament=d
            com.save(failOnError:true)
        }
        redirect(action:"llistaServides")
    }
    def guardaUrl()
    {
        def url = request.getRequestURL()
        def querystring = request.getQueryString()
        url = url.toString().replaceAll("/grails/","/")
        url = url.toString().replaceAll(".dispatch","")
        if(params.id) url=url + '/'+ params.id
        if(querystring != null) url = url + '?' + querystring
       
        session.url =  url
    }
}
