package productes

class ProducteController
{

    def index()
    {
        redirect(action: "list", params: params)
    }
    def ara = new Date()
    
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
    /*
    def ofertesCerca = Producte.where
    {
        ofertes { data_fi_oferta >= ara && actiu == true  }
    }
    */
   
    //def productesOfertesActives = Producte.executeQuery("from Producte as p join p.ofertes as offer where offer.actiu = true and data_fi_oferta >= ?",[ara]);
    def productesOfertesActives = Producte.executeQuery("from Producte as p join p.ofertes as offer where (data_fi_oferta = null or data_fi_oferta >= ?) and data_inici_oferta <= ?",[ara, ara]);

    def list()
    {
        params.max = Math.min(params.max ? params.int('max') : 6, 1000)
        def resultats = new ArrayList();
        def resultats_total;
        def totalPaginacio;
        if(params.subcat) // si tria categoria del menu
        {
            def sc = Subcategoria.get(params.subcat);
            if(session.usuari?.rol!='comercial')
            {
                resultats = Producte.findAll("from Producte as p where p.subcategoria=:subcat and (data_baixa is null or :datab < data_baixa) order by nom asc",[subcat: sc, datab:ara],params);
                resultats_total = Producte.findAll("from Producte as p where p.subcategoria=:subcat and (data_baixa is null or :datab < data_baixa)",[subcat: sc, datab:ara]);
            }
            else
            {
                resultats = Producte.findAll("from Producte as p where p.subcategoria=:subcat order by nom asc",[subcat: sc],params);
                resultats_total = Producte.findAll("from Producte as p where p.subcategoria=:subcat",[subcat: sc]);
            }
            totalPaginacio = resultats_total.size();
        }
        else //cercador
        {
            // tractar parametres
            String[] nom_producte_arr;
            def preu_minn = null;
            def preu_maxx = null;
            def categories = null;
            def subcategories = null;
            def subcategoriesObj = new ArrayList();
            def categoriesObj = new ArrayList();
            def offset;
            def max;
           
            int comptador = 0;
            if(params.nom_producte) nom_producte_arr = params.nom_producte.split(" ");
            if(params.categoria) categories = params.categoria
            if(params.subcategoria) subcategories = params.subcategoria
            
            if(params.offset) offset = params.offset.toInteger() else offset = 0
            if(params.max) max = params.max.toInteger() else max = 6
            
            
            
            // array de subcategories
            comptador = 0;
            if(subcategories.getClass().isArray()) for(comptador = 0; comptador < subcategories.length; comptador++) subcategoriesObj.add(Subcategoria.get(subcategories[comptador].toInteger()));
            else if(subcategories) subcategoriesObj.add(Subcategoria.get(subcategories.toInteger()));
            
            // array de categories
            comptador = 0;
            if(categories.getClass().isArray()) for(comptador = 0; comptador < categories.length; comptador++) categoriesObj.add(Categoria.get(categories[comptador].toInteger()));
            else if(categories) categoriesObj.add(Subcategoria.get(categories.toInteger()));
            
            if(params.preu_min) preu_minn = params.preu_min;
            if(params.preu_max) preu_maxx = params.preu_max;
            if(preu_minn != null && !preu_minn.isNumber() || preu_maxx != null && !preu_maxx.isNumber())
            {
                flash.message='cercador.valorsnumerics'
                redirect(action: 'list')
            }
            // fi tractar parametres
            

            resultats_total = Producte.list();

            def crit_prod = Producte.createCriteria()
            def crit_oferta = Producte.createCriteria()
            
            def resultats_ofertes = crit_oferta.list
            {
                    createAlias("ofertes", "o")
                    createAlias("subcategoria", "sc")
                    if(session.usuari?.rol!='comercial') or {isNull("data_baixa") gt("data_baixa",ara)}

                    //eq("o.actiu",true)
                    //ge("o.data_fi_oferta",ara)
                    le("o.data_inici_oferta",ara)
                    or
                    {
                        ge("o.data_fi_oferta",ara)
                        isNull("o.data_fi_oferta")
                    }

                    for(def i = 0; i < nom_producte_arr?.length; i++) ilike("nom", "%" + nom_producte_arr[i] + "%")

                    if(preu_minn && preu_maxx && preu_maxx >= preu_minn) between("o.preu_oferta", preu_minn.toBigDecimal(), preu_maxx.toBigDecimal())
                    else if(preu_maxx) le("o.preu_oferta", preu_maxx.toBigDecimal())
                    else if(preu_minn) ge("o.preu_oferta", preu_minn.toBigDecimal())

                    if(subcategoriesObj) 'in'("subcategoria",subcategoriesObj)
                    if(categoriesObj)'in'("sc.categoria",categoriesObj)
                    
                    order("o.descompte","desc")
                    order("o.data_fi_oferta","asc")
                    order("nom","asc")
            }
            def resultats_normal = crit_prod.list
            {
                    createAlias("subcategoria", "sc")
                    if(session.usuari?.rol!='comercial') or {isNull("data_baixa") gt("data_baixa",ara)}

                    for(def i = 0; i < nom_producte_arr?.length; i++) ilike("nom", "%" + nom_producte_arr[i] + "%")

                    if(preu_minn && preu_maxx && preu_maxx >= preu_minn) between("preu_cataleg", preu_minn.toBigDecimal(), preu_maxx.toBigDecimal())
                    else if(preu_maxx) le("preu_cataleg", preu_maxx.toBigDecimal())
                    else if(preu_minn) ge("preu_cataleg", preu_minn.toBigDecimal())

                    if(subcategoriesObj) 'in'("subcategoria",subcategoriesObj)
                    if(categoriesObj)'in'("sc.categoria",categoriesObj)
                                        
                    order("nom","asc")
            }
            // afegim evitant repetits!!
            for(comptador = 0; comptador < resultats_normal.size(); comptador++)
                if(!resultats_ofertes.contains(resultats_normal[comptador])) resultats_ofertes.add(resultats_normal[comptador]);
            
            
            comptador = offset;
            while(comptador < (offset+max) && comptador < resultats_ofertes.size())
            {
                resultats.add(resultats_ofertes[comptador]);
                comptador++;
            }
            
               
            totalPaginacio = resultats_ofertes.size();
        }
        this.saveUrl()
        [productesInstance: resultats, producteInstanceTotal: totalPaginacio, categoria: Categoria.getAll(params.list('categoria')), subcategoria: Subcategoria.getAll(params.list('subcategoria'))]
    }

    def ofertes()
    {
        params.max = Math.min(params.max ? params.int('max') : 6, 1000)
        //def resultats = Producte.executeQuery("select p from Producte as p join p.ofertes as offer where offer.actiu = true and data_fi_oferta >= ? order by descompte desc, data_fi_oferta asc, nom asc",[ara],params);
        def resultats = Producte.executeQuery("select p from Producte as p join p.ofertes as offer where (data_fi_oferta = null or data_fi_oferta >= ?) and data_inici_oferta <= ? order by descompte desc, data_fi_oferta asc, nom asc",[ara, ara], params);

        def resultats_total = productesOfertesActives;
        this.saveUrl()
        [productesInstance: resultats, producteInstanceTotal: resultats_total.size()]
        /*
        params.max = Math.min(params.max ? params.int('max') : 6, 1000)
        params.sort="nom";
        def resultats = ofertesCerca.list(params)
        [productesInstance: resultats, producteInstanceTotal: ofertesCerca.list().size()]
        */
    }
    def detall =
    {
        if (params.id)
        {
            def p = Producte.get(params.id)
            if (p && (p.data_baixa == null || ara < p.data_baixa ))
            {
              [producte: p]
            }
            else
            {
                response.sendError(404)
            }
        }
        else {
            response.sendError(404)
        }
    }

    def tornar()
    {
        if(session.url) redirect(url: session.url)
        else redirect(controller:"producte", action:"ofertes");
    }
    

    
}
