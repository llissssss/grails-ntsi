package Usuaris

class Usuari {

    String nom
    String cognom
    String nif
    String adreca
    String poblacio
    Date data_naixement
    String Sexe
    String email
    String login
    String password
    String password2
    String rol
    

    static constraints = {

        nom(blank:false,maxSize:15)
        cognom(blank:false,maxSize:25)
        nif(blank:false,maxSize:9)
        adreca(blank:false,maxSize:200)
        data_naixement()
        sexe(inList:['H','D'])
        email(blank:false,maxSize:50)
        login(blank:false,size:4..10,unique:true)
        password(blank:false,size:6..10)
        password2(blank:false,size:6..10)
        rol(inList:['client','comercial','magatzem','administracio'])

    }

    boolean equals(Usuari u)
    {
        return this.login == u.login
    }

}