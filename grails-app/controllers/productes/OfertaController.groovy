package productes

import org.springframework.dao.DataIntegrityViolationException

class OfertaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ofertaInstanceList: Oferta.list(params), ofertaInstanceTotal: Oferta.count()]
    }

    def create()
    {

        [ofertaInstance: new Oferta(params)]
    }

    def save()
    {
        def ofertaInstance = new Oferta(params)

        // comprovem q data inici mes petita q data fi
        Producte prodPertan = Producte.get(ofertaInstance.producte.id);
        if(ofertaInstance.data_fi_oferta && ofertaInstance.data_inici_oferta > ofertaInstance.data_fi_oferta)
        {
            ofertaInstance.errors.reject('La data de finalització és inferior a la inicial.')
            ofertaInstance.data_inici_oferta = null;
            ofertaInstance.data_fi_oferta = null;
            render(view: "create", model: [ofertaInstance: ofertaInstance])
            return
        }
        
        // comprovem q no es solapin dates
        Boolean rangocupat = false;
        prodPertan.ofertes.each
        {
            if(it.data_fi_oferta == null && (ofertaInstance.data_fi_oferta > it.data_inici_oferta || ofertaInstance.data_inici_oferta > it.data_fi_oferta  )) rangocupat = true;
            if(ofertaInstance.data_fi_oferta > it.data_inici_oferta) rangocupat = true;
            if(ofertaInstance.data_inici_oferta < it.data_fi_oferta) rangocupat = true;
        }
        // si es solapen, errorrororororo
        if(rangocupat)
        {
            ofertaInstance.errors.reject('Hi ha una oferta ja activa en aquestes dates.')
            ofertaInstance.data_inici_oferta = null;
            ofertaInstance.data_fi_oferta = null;
            render(view: "create", model: [ofertaInstance: ofertaInstance])
            return
        }


        if (!ofertaInstance.save(flush: true))
        {
            ofertaInstance.data_inici_oferta = null;
            ofertaInstance.data_fi_oferta = null;
            render(view: "create", model: [ofertaInstance: ofertaInstance])
            return
        }
        else
        {
            def dteapp = ((100 - params.descompte.toInteger()) * ofertaInstance.producte.preu_cataleg) / 100;
            ofertaInstance.preu_oferta = dteapp;
            println dteapp;
            ofertaInstance.save(flush: true);
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'oferta.label', default: 'Oferta'), ofertaInstance.id])
        redirect(action: "show", id: ofertaInstance.id)
    }
    
    

    def show()
    {
        def ofertaInstance = Oferta.get(params.id)
        if (!ofertaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'oferta.label', default: 'Oferta'), params.id])
            redirect(action: "list")
            return
        }

        [ofertaInstance: ofertaInstance]
    }

    def edit()
    {
        def ofertaInstance = Oferta.get(params.id)
        if (!ofertaInstance)
        {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'oferta.label', default: 'Oferta'), params.id])
            redirect(action: "list")
            return
        }

        [ofertaInstance: ofertaInstance]
    }

    def update()
    {
        def ofertaInstance = Oferta.get(params.id)
        if (!ofertaInstance)
        {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'oferta.label', default: 'Oferta'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (ofertaInstance.version > version) {
                ofertaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'oferta.label', default: 'Oferta')] as Object[],
                          "Another user has updated this Oferta while you were editing")
                render(view: "edit", model: [ofertaInstance: ofertaInstance])
                return
            }
        }
        
        ofertaInstance.properties = params

        // comprovem q data inici mes petita q data fi
        Producte prodPertan = Producte.get(ofertaInstance.producte.id);
        if(ofertaInstance.data_fi_oferta && ofertaInstance.data_inici_oferta > ofertaInstance.data_fi_oferta)
        {
            ofertaInstance.errors.reject('La data de finalització és inferior a la inicial.')
            ofertaInstance.data_fi_oferta = null;
            render(view: "edit", model: [ofertaInstance: ofertaInstance])
            return
        }

        // comprovem q no es solapin dates
        Boolean rangocupat = false;
        prodPertan.ofertes.each
        {
            if(it.id != ofertaInstance.id)
            {
                if(it.data_fi_oferta == null && (ofertaInstance.data_fi_oferta > it.data_inici_oferta || ofertaInstance.data_inici_oferta > it.data_fi_oferta  )) rangocupat = true;
                if(ofertaInstance.data_fi_oferta > it.data_inici_oferta) rangocupat = true;
                if(ofertaInstance.data_inici_oferta < it.data_fi_oferta) rangocupat = true;
            }
        }
        // si es solapen, errorrororororo
        if(rangocupat)
        {
            ofertaInstance.errors.reject('Hi ha una oferta ja activa en aquestes dates.')
            ofertaInstance.data_fi_oferta = null;
            render(view: "edit", model: [ofertaInstance: ofertaInstance])
            return
        }

        if (!ofertaInstance.save(flush: true))
        {
            
            render(view: "edit", model: [ofertaInstance: ofertaInstance])
            return
        }
        else
        {
            // actualitzem preu!!
            
            
            def dteapp = ((100 - params.descompte.toInteger()) * ofertaInstance.producte.preu_cataleg) / 100;
            ofertaInstance.preu_oferta = dteapp;
            println dteapp;
            ofertaInstance.save(flush: true);
        }

	flash.message = message(code: 'default.updated.message', args: [message(code: 'oferta.label', default: 'Oferta'), ofertaInstance.id])
        redirect(action: "show", id: ofertaInstance.id)
    }

    def delete() {
        def ofertaInstance = Oferta.get(params.id)
        if (!ofertaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'oferta.label', default: 'Oferta'), params.id])
            redirect(controller:"producteGestio", action: "tornaroferta")
            return
        }

        try {
            def producte = ofertaInstance.producte;
            ofertaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'oferta.label', default: 'Oferta'), params.id])
            redirect(controller:"producteGestio", action: "tornaroferta")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'oferta.label', default: 'Oferta'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
    
   
}
