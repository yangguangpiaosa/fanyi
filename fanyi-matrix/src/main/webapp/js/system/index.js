define(function(require, exports, module){
	var $ = require('jquery');
	
	$(document).ready(function() {
		console.log('loading...');
		$("#toSignIn").click(function() {
			console.log('button click.');
			document.forms[0].submit();
		});
	});
	
});