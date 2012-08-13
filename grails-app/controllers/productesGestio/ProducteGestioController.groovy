package productes

import org.springframework.dao.DataIntegrityViolationException

class ProducteGestioController {
    
    static scaffold = true
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def saveUrl()
    {
        def url = request.getRequestURL()
        def querystring = request.getQueryString()
        url = url.toString().replaceAll("/grails/","/")
        url = url.toString().replaceAll(".dispatch","")
        if(params.id) url=url + '/'+ params.id
        if(querystring != null) url = url + '?' + querystring
       
        session.url =  url
    }
    
    def saveUrlTornarOferta()
    {
        def url = request.getRequestURL()
        def querystring = request.getQueryString()
        url = url.toString().replaceAll("/grails/","/")
        url = url.toString().replaceAll(".dispatch","")
        if(params.id) url=url + '/'+ params.id
        if(querystring != null) url = url + '?' + querystring
       
        session.urlTornarOferta =  url
    }
    
    def index() {
        redirect(action: "list", params: params)
    }

    def list()
    {
        this.saveUrl()
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [producteInstanceList: Producte.list(params), producteInstanceTotal: Producte.count()]
    }

    def create() {
        [producteInstance: new Producte(params)]
    }

    def save() {
        def producteInstance = new Producte(params)

        producteInstance.data_alta = new Date()
        /*
        def f = request.getFile('imatge')
        if (!f.empty) {
            def a = servletContext.getRealPath("images/productes/"+producteInstance.getFitxerUrlImatge())
            f.transferTo(new File(a))
        }
        */
        if (!producteInstance.save(flush: true)) {
            render(view: "create", model: [producteInstance: producteInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'producte.label', default: 'Producte'), producteInstance.id])
        redirect(action: "show", id: producteInstance.id)
    }

    def show() {
        def producteInstance = Producte.get(params.id)
        if (!producteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'producte.label', default: 'Producte'), params.id])
            redirect(action: "list")
            return
        }
        this.saveUrlTornarOferta()
        [producteInstance: producteInstance]
    }

    def edit() {
        def producteInstance = Producte.get(params.id)
        if (!producteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'producte.label', default: 'Producte'), params.id])
            redirect(action: "list")
            return
        }
        this.saveUrlTornarOferta()
        [producteInstance: producteInstance]
    }

    def update() {
        def producteInstance = Producte.get(params.id)
        def f = request.getFile('imatge')
        if (!f.empty) {
             def a = servletContext.getRealPath("images/productes/"+producteInstance.getFitxerUrlImatge())
            def arxiu=new File(a)
            if(arxiu.exists()){
                arxiu.delete()
            }
            f.transferTo(arxiu)
        }
       
        if (!producteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'producte.label', default: 'Producte'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (producteInstance.version > version) {
                producteInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                    [message(code: 'producte.label', default: 'Producte')] as Object[],
                          "Another user has updated this Producte while you were editing")
                render(view: "edit", model: [producteInstance: producteInstance])
                return
            }
        }

        producteInstance.properties = params

        if (!producteInstance.save(flush: true)) {
            render(view: "edit", model: [producteInstance: producteInstance])
            return
        }
        flash.message = message(code: 'default.updated.message', args: [message(code: 'producte.label', default: 'Producte'), producteInstance.id])
        redirect(action: "show", id: producteInstance.id)
    }

    def delete() {
        def producteInstance = Producte.get(params.id)
        if (!producteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'producte.label', default: 'Producte'), params.id])
            redirect(action: "list")
            return
        }

        try {
            producteInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'producte.label', default: 'Producte'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'producte.label', default: 'Producte'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
    
    def baixa()
    {
        def producteInstance = Producte.get(params.id)
        producteInstance.data_baixa = params.data_baixa
        producteInstance.save(flush: true);
        
        tornar()
    }
    
    def tornar()
    {
        if(session.url) redirect(url: session.url)
        else  redirect(controller:"producteGestio", action:"list");
    }
    
    def tornaroferta()
    {
        if(session.urlTornarOferta) redirect(url: session.urlTornarOferta)
        else  redirect(controller:"producteGestio", action:"list");
    }
    
    
}
