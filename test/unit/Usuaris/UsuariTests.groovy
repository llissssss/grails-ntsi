package Usuaris



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Usuari)
class UsuariTests {

    void testValidacio() {
        Date d=new Date(1980,10,2)
        def ue = new Usuari(
            nom:'Andreu',
            cognom:'Amarimon',
            nif: '777333p',
            adreca: 'C/Ribes 45, 17200',
            poblacio: 'Girona',
            data_naixement: d,
            Sexe: 'H',
            email: 'aam@aam.com',
            login: 'amarimon',
            password: 'secret',
            password2: 'secret',
            rol:'client').save()
        mockForConstraintsTests(Usuari, [ue])
        
        def u = new Usuari(
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
            rol:'comercial')
        assert u.validate()

        //El nom no pot ser buit ni superior als 15 caràcters
        /*u.nom = ''
        assert !u.validate()
        assert u.errors.nom == 'blank'
        u.nom = '1234567890123456'
        assert !u.validate()
        assert u.errors.nom == 'maxSize'
        u.nom = 'Maria'*/

        //Els cognoms no pot ser buits ni superior als 25 caràcters
        u.cognom = ''
        assert !u.validate()
        assert u.errors.cognom == 'blank'
        u.cognom = '12345678901234567890123456'
        assert !u.validate()
        assert u.errors.cognom == 'maxSize'
        u.cognom = 'Antonieta Deulofeu'
        
        //El nif no pot ser buit ni superior als 9 caràcters
        
        u.nif = ''
        assert !u.validate()
        assert u.errors.nif == 'blank'
        u.nif = '1234567890'
        assert !u.validate()
        assert u.errors.nif == 'maxSize'
        u.nif= '777111p'
        
        //La adreca no pot ser buit
        
        u.adreca = ''
        assert !u.validate()
        assert u.errors.adreca == 'blank'
        u.nif= 'C/Ribes 27, 17200'
        
        //El email no pot ser buit
        
        u.email = ''
        assert !u.validate()
        assert u.errors.email == 'blank'
        u.nif= 'mad@mad.com'
        

        //El login ha de ser diferent per cada usuari,
        //no pot ser buit i ha de tenir de 4 a 10 caràcters
        u.login = ''
        assert !u.validate()
        assert u.errors.login == 'blank'
        u.login = '123'
        assert !u.validate()
        assert u.errors.login == 'size'
        u.login = '12345678901'
        assert !u.validate()
        assert u.errors.login == 'size'
        u.login = 'amarimon'
        assert !u.validate()
        assert u.errors.login == 'unique'
        u.login = 'maria'
    }
    void testRolUsuari() {
        mockForConstraintsTests(Usuari)
    
        Date d=new Date(1980,10,2)
        def u = new Usuari(
            nom:'Maria',
            cognom:'Antonieta Deulofeu',
            nif: '777111p',
            adreca: 'C/Ribes 27, 17200',
            poblacio: 'Girona',
            data_naixement: d,
            Sexe: 'D',
            email: 'mad@mad.com',
            login: 'maria',
            password: 'antonieta',
            password2: 'antonieta',
            rol: 'client')
        assert u.validate()    
        //La validació es correcte
        assert u.validate() == true
        assert u.rol == 'client'
        //Tenim quatre tipus de rol: 'client', 'comercial', 'magatzem', 'administracio'
        [client:true,comercial:true,magatzem:true,administracio:true,patata:false,rol23:false].each {
            u.rol = it.key
            assert u.validate() == it.value
            if (u.hasErrors()) {
                assert u.errors.rol == 'inList'
            }
        }
    }
}
