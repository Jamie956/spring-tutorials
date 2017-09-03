var myApp = angular.module('myApp', ['ui.router', 'oc.lazyLoad']);

myApp.run(
  ['$rootScope', '$state', '$stateParams',
    function($rootScope, $state, $stateParams) {
	    $rootScope.$on('$stateChangeStart', function(e, toState, toParams, fromState, fromParams) {
	    });
    }
  ]
);

myApp.config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider){
	$stateProvider
  	.state('home', {
  		url: '/',
  		template: '<strong>Oh yeah, You coming home...</strong>'
  	})
  	.state('categories', {
  		url: '/categories?tabs',
  		templateUrl: '/ngviews/categories.html',
  		controller: 'categoriesController',
      resolve: {
        load: function($ocLazyLoad) {
          return $ocLazyLoad.load ({
              name: 'categories',
              files: [
              	'/apps/controllers/categories.controller.js'
              ]	
          });
        }
      }
  	})  	
  	.state('transactions', {
  		url: '/transactions?tabs',
  		templateUrl: '/ngviews/transactions.html',
  		controller: 'transactionsController',
      resolve: {
        store: function($ocLazyLoad, $rootScope) {
          $rootScope.loading = true;
          return $ocLazyLoad.load({
            name: 'transactions',
            files: [
            	'/apps/controllers/transactions.controller.js'
            ]
          }).then(function() {
          });
        }
      }
  	})
  	.state('otherwise',{
  		url: "*path",
  		template: '<strong>Oh no, you out of this world...</strong'
  	});
	$urlRouterProvider.otherwise('/');
}]);