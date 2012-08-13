package Usuaris

import user.*
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UsuariController)
@Mock(Usuari)
class UsuariControllerTests {

    void setUp() {
        //Guardem un usuari per fer el test de
        //no login repetit
        Date d=new Date()
        d.setYear(80)
        def u=new Usuari(
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
        assert u.validate()
        //Preparem la classe de domini per poder
        //validar constraints
        mockForConstraintsTests(Usuari)
    }

    void testAnarRegistre() {
        //Per defecte anem a l'acció registre
        request.method = 'GET'
        controller.index()
        assert response.redirectUrl == '/usuari/registre'
        //Amb GET el registre no fa res
        //ens redirigeix a la vista per defecte
        def ret = controller.registre()
        assert ret == null
    }

    void testRegistreFormulariBuit() {
        //Si cridem l'acció registre amb POST
        //i el formulari és buit retornem l'usuari
        //amb errors
        Date d=new Date()
        d.setYear(80)
        request.method = 'POST'
        params.login = ''
        params.password = ''
        params.password2 = ''
        params.nom = ''
        params.cognom = ''
        params.nif = ''
        params.adreca = ''
        params.poblacio = ''
        params.data_naixement = d
        params.Sexe = ''
        params.email = ''
        params.rol = ''
        def model = controller.registre()
        def u = model.usuari
        assert u.hasErrors()
        assert u.errors.errorCount == 8
        assert u.errors.nom == 'blank'
        assert u.errors.cognom == 'blank'
        assert u.errors.login == 'blank'
    }

    void testRegistrePasswordNoconcorda() {
        //Si cridem l'acció registre amb POST
        //i el passwords entrats no concorden
        //retornem l'usuari amb l'error
        request.method = 'POST'
        params.login = 'maria'
        params.password = 'antonieta'
        params.password2 = 'antonieta2'
        params.nom = 'Maria'
        params.cognom = 'Antonieta'
        def model = controller.registre()
        def u = model.usuari
        assert u.hasErrors()
        assert u.errors.password == 'usuari.password.noconcorda'
    }

    void testRegistreLoginRepetit() {
        //Si cridem l'acció registre amb POST
        //i el login ja existeix
        //retornem l'usuari amb l'error
        Date d=new Date()
        d.setYear(80)
        request.method = 'POST'
        params.login = 'maria'
        params.password = 'antonieta'
        params.password2 = 'antonieta'
        params.nom = 'Maria'
        params.cognom = 'Antonieta'
        params.nif = 'prova'
        params.adreca = 'prova'
        params.poblacio = 'prova'
        //params.data_naixement = 'Thu Jun 17 00:00:00 CEST 1982'
        params.data_naixement = d
        params.Sexe = 'D'
        params.email = 'prova'
        def model = controller.registre()
        def u = model.usuari
        assert u.hasErrors()
        assert u.errors.login == 'unique'
    }

    void testRegistreTotCorrecte() {
        //Si cridem l'acció registre amb POST
        //i tot es correcte redirigim a la llista
        //de contactes amb l'usuari guardat a BDD
        //a sessió i donant un missatge de benvinguda
        Date d=new Date()
        d.setYear(80)
        request.method = 'POST'
        params.login = 'danis'
        params.password = 'capells'
        params.password2 = 'capells'
        params.nom = 'Dani'
        params.cognom = 'Capell'
        params.nif = '777111a'
        params.adreca = 'c/aprova 27'
        params.poblacio = 'Girona'
        params.data_naixement = d
        params.Sexe = 'H'
        params.email = 'aaa@bbb.com'
        params.rol = 'client'
        controller.registre()
        assert flash.message == 'usuari.missatge.benvingut'
        assert response.redirectUrl == '/producte/ofertes'
        assert session.usuari == Usuari.get(2)
        assert session.usuari.login == 'danis'
        assert flash.message == 'usuari.missatge.benvingut'
        assert flash.args[0] == 'Dani'
    }
    void testLoginUsuariNoTrobat() {
        //No pot fer login qui no
        //s'ha registrat
        request.method = 'POST'
        def cmd = mockCommandObject(LoginCommand)
        cmd.login = 'aapp'
        cmd.password = 'antonieta'
        cmd.validate()
        controller.login(cmd)
        assert cmd.hasErrors()
        assert cmd.errors['login'].code == "loginCommand.login.notrobat"
    }

    void testLoginPasswordIncorrecte() {
        //No pot fer login amb pwd incorrecte
        request.method = 'POST'
        def cmd = mockCommandObject(LoginCommand)
        cmd.login = 'maria'
        cmd.password = 'maria'
        cmd.validate()
        controller.login(cmd)
        assert cmd.hasErrors()
        assert cmd.errors['password'].code == "loginCommand.password.incorrecte"
    }

    void testLoginTotCorrecte() {
        //Quan es fa login es redirigeix a la
        //llista de contactes, donant un missatge de
        //benvinguda i quardant l'usuari a sessió
        request.method = 'POST'
        def cmd = mockCommandObject(LoginCommand)
        cmd.login = 'maria'
        cmd.password = 'antonieta'
        cmd.validate()
        controller.login(cmd)
        assert !cmd.hasErrors()
        assert response.redirectUrl == '/producte/ofertes'
        assert session.usuari == Usuari.get(1)
        assert session.usuari.login == 'maria'
        assert flash.message == 'usuari.missatge.benvingut'
        assert flash.args[0] == 'Maria'
    }
    void testLogout() {
        session.usuari = Usuari.get(1)
        controller.logout()
        assert session.usuari == null
        assert response.redirectUrl == '/'
    }
}
