class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"producte", action:"ofertes")
		"500"(view:'/error')
                "403"(view:'/403')
	}
}
