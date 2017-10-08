var app = angular.module('myApp', ['ngTable'])
app.controller('transactionCtrl', function($scope, $filter, $q, NgTableParams) {
  var data = [{name: "Moroni", age: 51},
              {name: "Tiancum", age: 43},
              {name: "Jacob", age: 27},
              {name: "Nephi", age: 29},
              {name: "Enos", age: 34},
              {name: "Tiancum", age: 43},
              {name: "Jacob", age: 27},
              {name: "Nephi", age: 29},
              {name: "Enos", age: 34},
              {name: "Tiancum", age: 43},
              {name: "Jacob", age: 27},
              {name: "Nephi", age: 29},
              {name: "Enos", age: 34},
              {name: "Tiancum", age: 43},
              {name: "Jacob", age: 27},
              {name: "Nephi", age: 29},
              {name: "Enos", age: 34}
          ];
  $scope.names = [{id: "", title: ""}, {id: 'Moroni', title: 'Moroni'}, {id: 'Enos', title: 'Enos'}, {id: 'Nephi', title: 'Nephi'}];
  $scope.tableParams = new NgTableParams({page: 1, count: 10}, {data: data});
})	