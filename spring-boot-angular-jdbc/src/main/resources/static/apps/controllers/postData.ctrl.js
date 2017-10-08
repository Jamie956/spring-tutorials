var app = angular.module('myApp');

app.controller('postDataCtrl', function($scope, $state, $http) {

	function getFormData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {};
		$.map(unindexed_array, function(n, i) {
			indexed_array[n['name']] = n['value'];
		});
		return indexed_array;
	}

	$scope.AddCategory = function() {
		var _url = "../add";
		var _data = getFormData($("#categoryForm"));

		$http.post(_url, _data).success(function(data, status, headers, config) {
			alert('success');
		}).error(function(data, status, headers, config) {
			alert("An error occurred during the AJAX request");
		})
	};

});