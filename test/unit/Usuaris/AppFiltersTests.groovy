package Usuaris
import Usuaris.*

@Mock(AppFilters)
class AppFiltersTests {

    @Test
    void "Cal usuari magatzem per accedir a comanda"() {
        session.usuari = new Usuari(rol:'magatzem')
        def filtreSuperat = false
        withFilters(controller: 'comanda', action:'escullOpcio'){
            filtreSuperat = true
        }
        assert filtreSuperat
    }
    @Test
    void "Cal usuari comercial per accedir a producteGestio"() {
        session.usuari = new Usuari(rol:'comercial')
        def filtreSuperat = false
        withFilters(controller: 'producteGestio', action:'index'){
            filtreSuperat = true
        }
        assert filtreSuperat
    }
 
    @Test
    void "Cal usuari administracio per accedir a administracio"() {
        session.usuari = new Usuari(rol:'administracio')
        def filtreSuperat = false
        withFilters(controller: 'administracio', action:'index'){
            filtreSuperat = true
        }
        assert filtreSuperat
    }

    @Test
    void "Un usuari no registrat no pot accedir a producteGestio, comanda i administracio "() {
    
        ['producteGestio','comanda','administracio'].each {
            def filtreSuperat = false
            withFilters(controller: it, action:'index'){
                filtreSuperat = true
            }
            assert !filtreSuperat
            assert response.status == 403
            response.reset()
        }
    }
    @Test
    void "Un usuari registrat com a comercial no pot accedir a administracio i comanda "() {
        session.usuari = new Usuari(rol:'comercial')
        ['comanda','administracio'].each {
            def filtreSuperat = false
            withFilters(controller: it, action:'index'){
                filtreSuperat = true
            }
            assert !filtreSuperat
            assert response.status == 403
            response.reset()
        }
    }
    @Test
    void "Un usuari registrat com a magatzem no pot accedir a producteGestio i administracio "() {
        session.usuari = new Usuari(rol:'magatzem')
        ['producteGestio','administracio'].each {
            def filtreSuperat = false
            withFilters(controller: it, action:'index'){
                filtreSuperat = true
            }
            assert !filtreSuperat
            assert response.status == 403
            response.reset()
        }
    }
    @Test
    void "Un usuari registrat com a administracio no pot accedir a producteGestio i comanda "() {
        session.usuari = new Usuari(rol:'administracio')
        ['producteGestio','comanda'].each {
            def filtreSuperat = false
            withFilters(controller: it, action:'index'){
                filtreSuperat = true
            }
            assert !filtreSuperat
            assert response.status == 403
            response.reset()
        }
    }

}
