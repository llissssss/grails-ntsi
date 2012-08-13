package Compres

import Usuaris.*
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Comanda)
@Mock(Usuari)
class ComandaTests {

    void testValidacio(){
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
         
        assert com.validate()
        
        // Hi ha d'haver un usuari
        
        com.usuari=null
        assert !com.validate()
        
        // Hi ha d'haver una adreca
        com.adreca=''
        assert !com.validate()
        //assert com.errors.adreca=='blank'
        
        // Hi ha d'haver un metodeEnviament
        com.metodeEnviament=''
        assert !com.validate()
        //assert com.errors.metodeEnviament=='blank'
        
        // Hi ha d'haver un estat
        com.estat=''
        assert !com.validate()
        //assert com.errors.estat=='blank'
        
    }
   
}
