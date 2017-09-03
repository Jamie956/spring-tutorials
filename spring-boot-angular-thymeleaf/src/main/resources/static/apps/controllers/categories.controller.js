angular.module('myApp').controller('categoriesController', function($scope, $state) {

	var objCategories = {
    container: {
      '_id': 'p_categoriesTableContanner',
      '_isInit': true,
    },
    ajax: {
      '_url': '../json/categories.json',
      '_method': 'get',
    },
    columns: [{
      field: 'created_time',
      title: 'Date',
      align: 'left',
      valign: 'middle',
      sortable: true,
      searchable: true
    }, {
      field: 'id',
      title: 'Categories ID',
      align: 'left',
      valign: 'middle',
      sortable: true,
      searchable: true,
      visible: true
    }, {
      field: 'name',
      title: 'Name',
      align: 'left',
      valign: 'middle',
      sortable: false,
      searchable: false,
      visible: true
    }, {
      field: 'alcohol',
      title: 'Alcohol',
      align: 'left',
      valign: 'middle',
      sortable: true,
      searchable: true,
      visible: true
    }],
    options: {
      sortName: 'order_ids',
      sortOrder: 'desc',
      search: false,
      showToggle: false,
      showRefresh: true,
      showColumns: true,
    }
  }

	function initCategoriesTable() {
	  var _container = objCategories.container;
	  var _ajax = objCategories.ajax;
	  var _columns = objCategories.columns;
	  var _options = objCategories.options;
	  var initTransactionsTable = new baseTableView(_container, _ajax, _columns, _options);
	}

	initCategoriesTable();
	
});