define(function(require, exports, module) {
	var $ = require('jquery');
	var form = require('comn/semantic-ui/sea/form');
	var trans = require('comn/semantic-ui/sea/transition');
	$(document).ready(function() {console.log('ready...');
		$('.ui.form').form({
			fields : {
				email : {
					identifier : 'email',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your e-mail'
					}, {
						type : 'email',
						prompt : 'Please enter a valid e-mail'
					} ]
				},
				password : {
					identifier : 'password',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your password'
					}, {
						type : 'length[6]',
						prompt : 'Your password must be at least 6 characters'
					} ]
				}
			}
		});
		$("#signIn").click(function() {
			if($('.ui.form').form('is valid')) {
				$('.ui.form').form('submit');
			}
		});
	});
});