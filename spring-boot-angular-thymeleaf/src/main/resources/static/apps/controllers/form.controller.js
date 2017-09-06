angular.module('myApp').controller('formController', function($scope, $state, $http) {

	function getFormData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {};
		$.map(unindexed_array, function(n, i) {
			indexed_array[n['name']] = n['value'];
		});
		return indexed_array;
	}

	$(".save-Category").click(function() {
		/**
		 * ajax
		 * json -> string
		 */
		//  	var _url = "../add1";
		//  	var data = {
		//      "name": "rice",
		//      "display_name": "good rice"
		//  	};
		//		$.ajax({
		//			type : "POST",
		//			contentType : "application/json",
		//			url : _url,
		//			data : JSON.stringify(data),
		//			dataType : 'json',
		//			timeout : 100000,
		//			success : function(data) {
		//				console.log("SUCCESS: ", data);
		//			},
		//			error : function(e) {
		//				console.log("ERROR: ", e);
		//			},
		//			done : function(e) {
		//				console.log("DONE");
		//			}
		//		});

		/**
		 * ajax
		 * serialize data -> json -> string
		 */
		//		var _url = "../add1";
		//		var $form = $("#categoryForm");
		//		
		//		_data = {};
		//		var serialized = $form.serializeArray();
		//		var s = '';
		//		var data = {};
		//		for(s in serialized){
		//		    data[serialized[s]['name']] = serialized[s]['value']
		//		}
		//		var data_str = JSON.stringify(data);
		//		console.log( data_str );
		//		
		//		$.ajax(_url, {
		//		  type : 'POST',
		//		  contentType : "application/json",
		//		  dataType : "json",
		//		  data : data_str
		//		}).done(function(data) {
		//			alert('done');
		//		}).fail(function(data) {
		//			alert('fail');
		//		});


		/**
		 * ajax
		 * serialize data -> json -> string
		 */
		var _url = "../add1";
		var $form = $("#categoryForm");
		var _data = getFormData($form);

		console.log(_data);

		$.ajax(_url, {
			type : 'POST',
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify(_data)
		}).done(function(data) {
			alert('done');
		}).fail(function(data) {
			alert('fail');
		});
		
	});
	
	/**
	 * Angular http
	 * serialize data -> arr -> json
	 */
	$scope.AddCategory = function() {
		var _url = "../add2";
		var $form = $("#categoryForm");
		var _data = getFormData($form);

		$http.post(_url, _data).success(function(data, status, headers, config) {
			console.log(data);
			console.log(status);
			console.log(headers);
			console.log(config);
			
		}).error(function(data, status, headers, config) {
			alert("An error occurred during the AJAX request");
		});
	}




});