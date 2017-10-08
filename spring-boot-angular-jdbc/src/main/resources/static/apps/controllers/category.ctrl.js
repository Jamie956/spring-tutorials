angular.module('myApp').controller('categoryCtrl', function($scope, $state) {

	var objCategory = {
    container: {
      '_id': 'p_categoryTableContanner',
      '_isInit': true,
    },
    ajax: {
      '_url': '../category',
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

	function initCategoryTable() {
	  var _container = objCategory.container;
	  var _ajax = objCategory.ajax;
	  var _columns = objCategory.columns;
	  var _options = objCategory.options;
	  new baseTableView(_container, _ajax, _columns, _options);
	}

	initCategoryTable();
	
});