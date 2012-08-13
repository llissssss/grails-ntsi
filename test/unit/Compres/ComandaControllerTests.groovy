package Compres

import Usuaris.*
import org.junit.*
import grails.test.mixin.*

@TestFor(ComandaController)
@Mock([Comanda,Usuari])
class ComandaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/comanda/escullOpcio" == response.redirectedUrl
    }
    
    void testServir(){
        Date d=new Date(1980,10,2)
        def u= new Usuari(
            nom:'Maria',
            cognom:'Antonieta',
            nif: '777111p',
            adreca: 'C/Ribes 27, 17200',
            poblacio: 'Girona',
            data_naixement: d,
            Sexe: 'D',
            email: 'mad@mad.com',
            login: 'maria',
            password: 'antonieta',
            password2: 'antonieta',
            rol:'comercial').save()
        
        def avui=new Date()        
        def com=new Comanda()
        com.usuari=u
        com.data= avui
        com.nom_env= "jordi"
        com.cognom_env= "sabria"
        com.adreca= "c/torroella 25"
        com.poblacio_env="Torroella de Montgri"
        com.nom_fact= "jordi"
        com.cognom_fact= "sabria"
        com.nif_fact= "777323f"
        com.adreca_fact= "c/torroella 25"
        com.poblacio_fact="Torroella de Montgri"
        com.metodeEnviament= "UPS"
        com.preu_total=(BigDecimal) 20
        com.estat='en proces'
        com.save()
         
        assert com.validate()
        
        /*params.id=1
        
        def c=controller.servir()
        assert c.id==1
        assert session.idComandaPerServir==c.id*/

        // no es pot fer per que no soporta el find()
    }
    
    void testFinalitzarServirServida(){
        Date d=new Date(1980,10,2)
        def u= new Usuari(
            nom:'Maria',
            cognom:'Antonieta',
            nif: '777111p',
            adreca: 'C/Ribes 27, 17200',
            poblacio: 'Girona',
            data_naixement: d,
            Sexe: 'D',
            email: 'mad@mad.com',
            login: 'maria',
            password: 'antonieta',
            password2: 'antonieta',
            rol:'comercial').save()

        def avui=new Date()
        def com=new Comanda()
        com.usuari=u
        com.data= avui
        com.nom_env= "jordi"
        com.cognom_env= "sabria"
        com.adreca= "c/torroella 25"
        com.poblacio_env="Torroella de Montgri"
        com.nom_fact= "jordi"
        com.cognom_fact= "sabria"
        com.nif_fact= "777323f"
        com.adreca_fact= "c/torroella 25"
        com.poblacio_fact="Torroella de Montgri"
        com.metodeEnviament= "UPS"
        com.preu_total=(BigDecimal) 20
        com.estat='en proces'
        com.save()
        
        // servida
        session.idComandaPerServir=com.id
        params.estat="servida"
        controller.finalitzarServir()
        assert com.estat=="servida"
    }
    void testFinalitzarServirPendentStock(){
        Date d=new Date(1980,10,2)
        def u= new Usuari(
            nom:'Maria',
            cognom:'Antonieta',
            nif: '777111p',
            adreca: 'C/Ribes 27, 17200',
            poblacio: 'Girona',
            data_naixement: d,
            Sexe: 'D',
            email: 'mad@mad.com',
            login: 'maria',
            password: 'antonieta',
            password2: 'antonieta',
            rol:'comercial').save()

        def avui=new Date()
        def com=new Comanda()
        com.usuari=u
        com.data= avui
        com.nom_env= "jordi"
        com.cognom_env= "sabria"
        com.adreca= "c/torroella 25"
        com.poblacio_env="Torroella de Montgri"
        com.nom_fact= "jordi"
        com.cognom_fact= "sabria"
        com.nif_fact= "777323f"
        com.adreca_fact= "c/torroella 25"
        com.poblacio_fact="Torroella de Montgri"
        com.metodeEnviament= "UPS"
        com.preu_total=(BigDecimal) 20
        com.estat='en proces'
        com.save()

         // pendet de stock
        session.idComandaPerServir=com.id
        params.estat="pendent de stock"
        params.data_recepcio=avui
        params.lliure="Producte 2"
        controller.finalitzarServir()
        assert com.estat=="pendent de stock"
    }

    void testLliurada(){
        Date d=new Date(1980,10,2)
        def u= new Usuari(
            nom:'Maria',
            cognom:'Antonieta',
            nif: '777111p',
            adreca: 'C/Ribes 27, 17200',
            poblacio: 'Girona',
            data_naixement: d,
            Sexe: 'D',
            email: 'mad@mad.com',
            login: 'maria',
            password: 'antonieta',
            password2: 'antonieta',
            rol:'comercial').save()

        def avui=new Date()
        def com=new Comanda()
        com.usuari=u
        com.data= avui
        com.nom_env= "jordi"
        com.cognom_env= "sabria"
        com.adreca= "c/torroella 25"
        com.poblacio_env="Torroella de Montgri"
        com.nom_fact= "jordi"
        com.cognom_fact= "sabria"
        com.nif_fact= "777323f"
        com.adreca_fact= "c/torroella 25"
        com.poblacio_fact="Torroella de Montgri"
        com.metodeEnviament= "UPS"
        com.preu_total=(BigDecimal) 20
        com.estat='en proces'
        com.save()

        assert com.validate()

        // servida
        params.id=com.id
        controller.lliurada()
        assert com.estat=="lliurada"
    }
}
