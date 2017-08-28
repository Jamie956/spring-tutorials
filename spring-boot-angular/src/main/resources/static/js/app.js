angular.module("myApp",[]).controller("myCtrl",function($scope,$http){
	$scope.products=[];
	$http.get("/listProducts").then(function(response){
		$scope.products=response.data;
	});
});