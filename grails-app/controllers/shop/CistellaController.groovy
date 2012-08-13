package shop
import Compres.*
import productes.*
import Usuaris.*
import java.util.Date

class CistellaController {

    def index() { }

    def afegirProducte(){
        // rebrem amb parametres: idProducte i quantitat
        def prod= Producte.get(params.idProducte)
        if(!prod){
            // el producte no existeix
            flash.message='producte.message.noexisteix'

        }else{
            if(!session.cistella){
                session.cistellaTotal=0
                session.cistella=[:] // crea un map en memoria
            }
            if(!session.cistella[Long.parseLong(params.idProducte)]){
                session.cistella[Long.parseLong(params.idProducte)]=Integer.parseInt(params.quantitat)
            }else{
                session.cistella[Long.parseLong(params.idProducte)]++
            }
            session.cistellaTotal=session.cistellaTotal+prod.getPreu()
            def total=session.cistellaTotal
            def to=0
        }
        redirect(controller:"cistella", action:"veure")
    }

    def treureProducte(){
        // rebrem amb parametres: id
        def ppp=params.id
        def idp=Long.parseLong(params.id)
        def prod= Producte.get(params.id)
        if(session.cistella[idp]==0){
            session.cistella.remove(idp)
        }else{
            def totalProduct=session.cistella[]
            session.cistellaTotal=session.cistellaTotal-(prod.getPreu()*session.cistella[idp])
            def dte=0
            if(prod.GetOferta()){
                dte=(prod.getPreuCataleg()-prod.GetOferta().CalcularPreuOferta())*session.cistella[idp]
            }
            session.totalDescompte=session.totalDescompte - dte
            session.cistella.remove(idp)
            def td=session.totalDescompte
            def llistaProductes=obtenirLListaProductes()
            def totalCistella=session.cistellaTotal
            def totalDte=round(td, 2, BigDecimal.ROUND_HALF_UP)
            session.totalDescompte=td
            if(!session.cistella.isEmpty()){
                render(template:'llista', model: [cistellaProductes:llistaProductes, totalCistella:totalCistella, totalDescompte:totalDte])
            }else{
                // ha de tornar a la llista des de la que ha entrat a la cistella.
                redirect(controller:"producte", action:"ofertes")
            }

        }
    }
    public static BigDecimal round(double unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded;
    }

    def veure(){
        // Em de preparar una llista amb tots el productes de la cistella després
        // ha de obrir la web de modificar la cistella
        // Aquests espectes els fem aquí per no haver de que la web demani la informació de cada
        // producte que te la cistella.
        
        // creem la llista amb tot el que hi ha a la cistella
        //def llistaProductes=Producte.list()
      
        /*def llistaProductes=[]
        session.cistellaTotal=0
        session.cistella.each{
        def prod= Producte.get(it.key)
        def mapProdQuant=['producte':prod,'quantitat':it.value]
        llistaProductes.add(mapProdQuant)
        def totalProd=prod.getPreu() * it.value
        session.cistellaTotal=session.cistellaTotal + totalProd
        }
        def totalCistella=session.cistellaTotal*/
        def llistaProductes=obtenirLListaProductes()
        def totalCistella=session.cistellaTotal
        

        def totalDte=round(session.totalDescompte, 2, BigDecimal.ROUND_HALF_UP)
        
        [cistellaProductes:llistaProductes, totalCistella:totalCistella, totalDescompte:totalDte]
    }
    
    private ArrayList obtenirLListaProductes(){
        // Em de preparar una llista amb tots el productes de la cistella
        session.totalDescompte=0
        def cist=session.cistella
        def llistaProductes=[]
        session.cistella.each{
            def prod= Producte.get(it.key)
            if(prod!=null){
                def mapProdQuant=['producte':prod,'quantitat':it.value]
                llistaProductes.add(mapProdQuant)
                def totalProd=prod.getPreu() * it.value
                def dte=0
                if(prod.GetOferta()){
                    dte=prod.getPreuCataleg()-prod.GetOferta().CalcularPreuOferta()
                }
                if(dte!=0){
                    session.totalDescompte=session.totalDescompte + dte * mapProdQuant['quantitat']
                }
                
            }
        }
        // la guardem a sessio
        session.llistaProductes=llistaProductes
        return llistaProductes
    }     

    def eliminar(){
        // eliminem la cistella i tornem d'on veniem
        
        if(session.cistella){            
            // ha de tornar a la llista des de la que ha entrat a la cistella.
            session.cistella=[:]
            def llista=session.cistella
            def total=0
            // ha de tornar a la llista des de la que ha entrat a la cistella.
            this.continuarComprant()
            
        }else{
            // no hi ha cistella creada
            flash.message='cistella.message.noexisteix'
        }
    }

    def modificar(){
        // ha de obrir la web per modificar la comanda (gestio comanda)

    }

    def estat(){}

    def calcularCistella(){
        //haig de recorre el map i per cada producte multiplicar la quantitat per el que val i guardar-ho
        //a session.cistellaTotal
        
        session.cistella.each{
            def prod= Producte.get(it.key)
            def totalProd=prod.getPreu() * it.value
            session.cistellaTotal=session.cistellaTotal + totalProd
        }
        return session.cistellaTotal
    }

    BigDecimal preuProducte(int idProd){
        def prod= Producte.get(idProd)
        if(prod){
            return prod.getPreu()
        }else{
            // no existeix el producte
            flash.message='producte.message.noexisteix'
        }
    }
    def upQuantitat(){
        if(params.id){
            def idp=Long.parseLong(params.id)
            def prod= Producte.get(params.id)
            session.cistella[idp]++
            session.cistellaTotal=session.cistellaTotal+prod.getPreu()
            def dte=0
            def of=prod.GetOferta()
            
            if(prod.GetOferta()){
                dte=prod.getPreuCataleg()-prod.GetOferta().CalcularPreuOferta()
            }
            session.totalDescompte=session.totalDescompte + dte
        }
        def td=session.totalDescompte
        def llistaProductes=obtenirLListaProductes()
        def totalCistella=session.cistellaTotal
        def totalDte=round(td, 2, BigDecimal.ROUND_HALF_UP)
        session.totalDescompte=td
        
        render(template:'llista', model: [cistellaProductes:llistaProductes, totalCistella:totalCistella, totalDescompte:totalDte])
    }
    def downQuantitat(){
        
        if(params.id){
            def idp=Long.parseLong(params.id)
            def prod= Producte.get(params.id)
            session.cistella[idp]--
            session.cistellaTotal=session.cistellaTotal-prod.getPreu()
            def quanProd=session.cistella[idp]
            if(session.cistella[idp]==0){
                session.cistella.remove(idp)
            }
            def dte=0
            if(prod.GetOferta()){
                dte=prod.getPreuCataleg()-prod.GetOferta().CalcularPreuOferta()
            }
            session.totalDescompte=session.totalDescompte - dte
        }
        if(session.cistellaTotal==0){
            // ha de tornar a la llista des de la que ha entrat a la cistella.
            this.continuarComprant()
        }
        def td=session.totalDescompte
        def llistaProductes=obtenirLListaProductes()
        def totalCistella=session.cistellaTotal
        def totalDte=round(td, 2, BigDecimal.ROUND_HALF_UP)
        session.totalDescompte=td

        render(template:'llista', model: [cistellaProductes:llistaProductes, totalCistella:totalCistella, totalDescompte:totalDte])
    }
    def veureComandesPendens(){
        
    }
    
    // AQUI POSEM EL REFERENT AL WEBFLOW COMPRAR

    def comprarFlow={
        
        ident{
            action{
                //temporalment
                /*def u = new Usuari()
                u.nom="Jordi"
                u.cognom="Sabria"
                u.nif="7737279a"
                u.adreca="c/novadelli, 27 Girona 17200"
                Date d=new Date(1980,10,02)
                u.data_naixement=d
                u.Sexe="H"
                u.email="jsp@jsp.com"
                u.login="jordi"
                u.password="sabria"
                u.password="sabria"
                u.rol="client"
                
                session.usuari=u*/
                //succes()
                if(session.usuari){
                    session.dadesEnvia=new DadesEnviament()
                    session.dadesEnvia.nom=session.usuari.nom
                    session.dadesEnvia.cognom=session.usuari.cognom
                    session.dadesEnvia.adreca=session.usuari.adreca
                    session.dadesEnvia.poblacio=session.usuari.poblacio
                    session.dadesEnvia.metodeEnviament="UPS"
                    succes()
                }
                else{ 
                    noident()
                }
            }
            on("succes").to "dadesEnviament"
            on("noident"){session.urlCistella="/cistella/comprar"}.to "identificarUser" 
        }
        dadesEnviament{

            on("seguirComanda"){
                session.dadesEnvia.nom=params.nom
                session.dadesEnvia.cognom=params.cognom
                session.dadesEnvia.adreca=params.adreca
                session.dadesEnvia.poblacio=params.poblacio
                session.dadesEnvia.metodeEnviament=params.metodeEnviament
                session.urlCistella=null
            }.to "mostrarDadesFacturacio"
            on("back"){session.urlCistella=null}.to "tornarCistella"
        }
        mostrarDadesFacturacio{
            on("seguirComanda"){
                session.usuari.nom=params.nom
                session.usuari.cognom=params.cognom
                session.usuari.nif=params.nif
                session.usuari.adreca=params.adreca
                session.usuari.poblacio=params.poblacio
                
            }.to "mostrarComanda"
            on("back").to "dadesEnviament"
        }
        mostrarComanda{
            on("comprar").to "finalitzar"
            on("back").to "mostrarDadesFacturacio"
        }
        tornarCistella{
            redirect(controller:"cistella", action:"veure")
        }
        identificarUser{
            redirect(controller:"usuari")
        }
        finalitzar {
            action{
                this.crearComanda()
                session.cistella=[:]
                session.dadesEnvia=null
                session.llistaProductes=null
                session.cistellaTotal=null
                fi()
            }
            on("fi").to "fi"
        }
        fi{
            redirect(controller:"cistella", action:"veureComandesPendens")
        }
    }
    
    // fem un metode per crear la comanda a partir d'uns parametres
    private void crearComanda(){
        // crea la comanda  a partir de: 
        // session.usuari
        // session.dadesEnviament
        // session.llistaProductes
        // session.cistellaTotal
        def avui=new Date()
        def com=new Comanda()
        com.usuari=session.usuari
        com.data= avui
        com.nom_env= session.dadesEnvia.nom
        com.cognom_env= session.dadesEnvia.cognom
        com.adreca= session.dadesEnvia.adreca
        com.poblacio_env= session.dadesEnvia.poblacio
        com.nom_fact= session.usuari.nom
        com.cognom_fact= session.usuari.cognom
        com.nif_fact= session.usuari.nif
        com.adreca_fact= session.usuari.adreca
        com.poblacio_fact= session.usuari.poblacio
        com.metodeEnviament= session.dadesEnvia.metodeEnviament
        com.preu_total=session.cistellaTotal
        com.estat='en proces'
            
        session.llistaProductes.each{
            def mapProdQuan=it
            def prod=mapProdQuan.get('producte')
            def lc=new LiniesComanda(
                idProducte: prod.id,
                producte: prod.nom,
                quantitat: mapProdQuan.get('quantitat'),
                preu: prod.getPreu()
            ).save()
            def l=lc
            com.addToLinies_comanda(lc)
        }
        com.save()
        // comanda realitzada i guardada
    }
    def continuarComprant(){
        def prova=0
        if(session.url) redirect(url: session.url)
        else redirect(controller:"producte", action:"ofertes")
    }
}


class DadesEnviament {
  
    String nom
    String cognom
    String adreca
    String poblacio
    String metodeEnviament
  
  
    static constraints = {
        nom(blank:false,maxSize:30)
        cognom(blank:false,maxSize:30)
        adreca(blank:false,maxSize:200)
        poblacio(blank:false,maxSize:200)
        metodeEnviament(blank:false,maxSize:50)
    }
 
}