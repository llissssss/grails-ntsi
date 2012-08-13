package productes



import org.junit.*
import grails.test.mixin.*

@TestFor(ProducteController)
@Mock(Producte)
class ProducteControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/producte/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.producteInstanceList.size() == 0
        assert model.producteInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.producteInstance != null
    }

    void testSave() {
        controller.save()

        assert model.producteInstance != null
        assert view == '/producte/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/producte/show/1'
        assert controller.flash.message != null
        assert Producte.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/producte/list'


        populateValidParams(params)
        def producte = new Producte(params)

        assert producte.save() != null

        params.id = producte.id

        def model = controller.show()

        assert model.producteInstance == producte
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/producte/list'


        populateValidParams(params)
        def producte = new Producte(params)

        assert producte.save() != null

        params.id = producte.id

        def model = controller.edit()

        assert model.producteInstance == producte
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/producte/list'

        response.reset()


        populateValidParams(params)
        def producte = new Producte(params)

        assert producte.save() != null

        // test invalid parameters in update
        params.id = producte.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/producte/edit"
        assert model.producteInstance != null

        producte.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/producte/show/$producte.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        producte.clearErrors()

        populateValidParams(params)
        params.id = producte.id
        params.version = -1
        controller.update()

        assert view == "/producte/edit"
        assert model.producteInstance != null
        assert model.producteInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/producte/list'

        response.reset()

        populateValidParams(params)
        def producte = new Producte(params)

        assert producte.save() != null
        assert Producte.count() == 1

        params.id = producte.id

        controller.delete()

        assert Producte.count() == 0
        assert Producte.get(producte.id) == null
        assert response.redirectedUrl == '/producte/list'
    }
}
