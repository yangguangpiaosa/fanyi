<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>Login Example - Semantic</title>
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/reset.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/site.css">

  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/container.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/grid.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/header.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/image.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/menu.css">

  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/divider.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/segment.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/form.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/input.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/button.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/list.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/message.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/icon.css">

  <script src="${cxt_path }/js/comn/sea.js"></script>
  <script src="${cxt_path }/js/comn/config.js"></script>
  <script type="text/javascript">
  	seajs.use(['jquery', 'comn/semantic-ui/sea/form', 'comn/semantic-ui/sea/transition'], function($) {
  		$(document).ready(function() {
  			$('.ui.form')
	  	        .form({
	  	          fields: {
	  	            email: {
	  	              identifier  : 'email',
	  	              rules: [
	  	                {
	  	                  type   : 'empty',
	  	                  prompt : 'Please enter your e-mail'
	  	                },
	  	                {
	  	                  type   : 'email',
	  	                  prompt : 'Please enter a valid e-mail'
	  	                }
	  	              ]
	  	            },
	  	            password: {
	  	              identifier  : 'password',
	  	              rules: [
	  	                {
	  	                  type   : 'empty',
	  	                  prompt : 'Please enter your password'
	  	                },
	  	                {
	  	                  type   : 'length[6]',
	  	                  prompt : 'Your password must be at least 6 characters'
	  	                }
	  	              ]
	  	            }
	  	          }
	  	        })
	  	      ;
	  	  	});
  		});
  		
  </script>

  <style type="text/css">
    body {
      background-color: #DADADA;
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
  </style>
</head>
<body>

<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <img src="${cxt_path }/img/logo.png" class="image">
      <div class="content">
        Log-in to your account
      </div>
    </h2>
    <form class="ui large form">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="email" placeholder="E-mail address">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder="Password">
          </div>
        </div>
        <div class="ui fluid large teal submit button">Login</div>
      </div>

      <div class="ui error message"></div>

    </form>

    <div class="ui message">
      New to us? <a href="#">Sign Up</a>
    </div>
  </div>
</div>

</body>

</html>
