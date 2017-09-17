angular.module('myApp').controller('categoriesController', function($scope, $state) {

	var objCategories = {
    container: {
      '_id': 'p_categoriesTableContanner',
      '_isInit': true,
    },
    ajax: {
      '_url': '../categories',
      '_method': 'get',
    },
    columns: [{
      field: 'created_time',
      title: 'Created Time',
      align: 'left',
      valign: 'middle',
      sortable: true,
      searchable: true
    }, {
      field: 'updated_time',
      title: 'Update Time',
      align: 'left',
      valign: 'middle',
      sortable: true,
      searchable: true,
      visible: true
    }, {
      field: 'id',
      title: 'ID',
      align: 'left',
      valign: 'middle',
      sortable: true,
      searchable: true,
      visible: true
    }, {
      field: 'original_id',
      title: 'Original ID',
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
      field: 'merchant_id',
      title: 'Merchant ID',
      align: 'left',
      valign: 'middle',
      sortable: false,
      searchable: false,
      visible: true
    }, {
      field: 'category_ufo',
      title: 'Category ufo',
      align: 'left',
      valign: 'middle',
      sortable: false,
      searchable: false,
      visible: true
    }, {
      field: 'script',
      title: 'Script',
      align: 'left',
      valign: 'middle',
      sortable: false,
      searchable: false,
      visible: true
    }, {
      field: 'display_name',
      title: 'Display Name',
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
      sortName: 'name',
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