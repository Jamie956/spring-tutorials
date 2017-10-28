method:get => localhost:8080/product
method:post => localhost:8080/product/01
method:post, application/json => localhost:8080/product
	{
	    "id": "05",
	    "name": "product05",
	    "price": "2.00"
	}
method:put => localhost:8080/product/01