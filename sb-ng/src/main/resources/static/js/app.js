angular.module("myApp",[]).controller("myCtrl",function($scope, $http){
	
	$scope.products=[];
	$http.get("/product").then(function(response){
		$scope.products=response.data;
	});
	
	function getSeletedIndex(id){
		for(var i=0;i < $scope.products.length ;i++){
			if($scope.products[i].id == id){
				return i;
			}
		}
		return -1;
	};
	
	$scope.del = function(id){
		var index = getSeletedIndex(id);
		$scope.products.splice(index, 1);
	};
	
	$scope.edit = function(id){
		var index = getSeletedIndex(id);
		var product = $scope.products[index];
		$scope.id = product.id;
		$scope.name = product.name;
		$scope.price = product.price;
	};
	
	$scope.add = function(){
		var _data = {id:$scope.id, name:$scope.name, price:$scope.price};
		$scope.products.push(_data);
		
		$scope.id = '';
		$scope.name = '';
		$scope.price = '';
	};
	
	$scope.save = function(){
		var index = getSeletedIndex($scope.id);
		$scope.products[index].id = $scope.id;
		$scope.products[index].name = $scope.name;
		$scope.products[index].price = $scope.price;
		
		$scope.id = '';
		$scope.name = '';
		$scope.price = '';
	};
	
});