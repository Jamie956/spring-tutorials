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
  	.state('tab-category', {
  		url: '/category',
  		templateUrl: '/ngviews/category.html',
  		controller: 'categoryCtrl',
      resolve: {
        load: function($ocLazyLoad) {
          return $ocLazyLoad.load ({
              name: 'category',
              files: [
              	'/apps/controllers/category.ctrl.js'
              ]	
          });
        }
      }
  	})
  	.state('tab-transaction', {
  		url: '/transaction',
  		templateUrl: '/ngviews/transaction.html',
  		controller: 'transactionCtrl',
      resolve: {
        store: function($ocLazyLoad, $rootScope) {
          $rootScope.loading = true;
          return $ocLazyLoad.load({
            name: 'transaction',
            files: [
            	'/apps/controllers/transaction.ctrl.js'
            ]
          }).then(function() {
          });
        }
      }
  	})
  	.state('postData', {
  		url: '/postdata',
  		templateUrl: '/ngviews/postData.html',
  		controller: 'postDataCtrl',
      resolve: {
        store: function($ocLazyLoad, $rootScope) {
          $rootScope.loading = true;
          return $ocLazyLoad.load({
            name: 'postdata',
            files: [
            	'/apps/controllers/postData.ctrl.js'
            ]
          }).then(function() {
          });
        }
      }
  	})  	
  	.state('otherwise',{
  		url: "*path",
  		template: '<strong>Oh no, you out of this world...</strong>'
  	});
	$urlRouterProvider.otherwise('/');
}]);