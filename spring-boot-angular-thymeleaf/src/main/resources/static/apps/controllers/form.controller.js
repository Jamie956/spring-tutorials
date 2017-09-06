angular.module('myApp').controller('formController', function($scope, $state) {
	
  function postData(url, formData) {
    $.ajax(url, {
      type : 'POST',
      dataType : "json",
      data : formData
    }).done(function(data) {
      if (data.status == 200) {
        alert('200');
      } else {
      	alert('not 200');
      }
    }).fail(function(data) {
    	alert('fail');
    });
  }
  
  $(".save-Category").click(function() {
  	var url = "../add";
  	var formData = $("#categoryForm").serialize();
  	postData(url, formData);
  });
	
});