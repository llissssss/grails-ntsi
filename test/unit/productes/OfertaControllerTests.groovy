package productes



import org.junit.*
import grails.test.mixin.*

@TestFor(OfertaController)
@Mock(Oferta)
class OfertaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/oferta/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ofertaInstanceList.size() == 0
        assert model.ofertaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.ofertaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ofertaInstance != null
        assert view == '/oferta/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/oferta/show/1'
        assert controller.flash.message != null
        assert Oferta.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/oferta/list'


        populateValidParams(params)
        def oferta = new Oferta(params)

        assert oferta.save() != null

        params.id = oferta.id

        def model = controller.show()

        assert model.ofertaInstance == oferta
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/oferta/list'


        populateValidParams(params)
        def oferta = new Oferta(params)

        assert oferta.save() != null

        params.id = oferta.id

        def model = controller.edit()

        assert model.ofertaInstance == oferta
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/oferta/list'

        response.reset()


        populateValidParams(params)
        def oferta = new Oferta(params)

        assert oferta.save() != null

        // test invalid parameters in update
        params.id = oferta.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/oferta/edit"
        assert model.ofertaInstance != null

        oferta.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/oferta/show/$oferta.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        oferta.clearErrors()

        populateValidParams(params)
        params.id = oferta.id
        params.version = -1
        controller.update()

        assert view == "/oferta/edit"
        assert model.ofertaInstance != null
        assert model.ofertaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/oferta/list'

        response.reset()

        populateValidParams(params)
        def oferta = new Oferta(params)

        assert oferta.save() != null
        assert Oferta.count() == 1

        params.id = oferta.id

        controller.delete()

        assert Oferta.count() == 0
        assert Oferta.get(oferta.id) == null
        assert response.redirectedUrl == '/oferta/list'
    }
}
