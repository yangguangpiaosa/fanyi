<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>Admin</title>
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/reset.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/site.css">

  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/container.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/grid.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/menu.css">

  <%-- <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/form.css"> --%>
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/input.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/item.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/icon.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/button.css">
  
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/dropdown.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/step.css">

  <script src="${cxt_path }/js/comn/sea.js"></script>
  <script src="${cxt_path }/js/comn/config.js"></script>
  <script type="text/javascript">
  	seajs.use('system/signIn');
  </script>
</head>
<body>

<div class="ui attached stackable menu">
	<div class="ui container">
		<a class="item">
	      <i class="home icon"></i> Home
	    </a>
	    <a class="item">
	      <i class="grid layout icon"></i> Browse
	    </a>
	    <a class="item">
	      <i class="mail icon"></i> Messages
	    </a>
	    <div class="ui simple dropdown item">
	      More
	      <i class="dropdown icon"></i>
	      <div class="menu">
	        <a class="item"><i class="edit icon"></i> Edit Profile</a>
	        <a class="item"><i class="globe icon"></i> Choose Language</a>
	        <a class="item"><i class="settings icon"></i> Account Settings</a>
	      </div>
	    </div>
	    <div class="right item">
	      <!-- <div class="ui input"><input type="text" placeholder="Search..."></div> -->
	      <div class="ui action input">
			  <input type="text" placeholder="Search...">
			  <button class="ui icon button">
			    <i class="search icon"></i>
			  </button>
		  </div>
	    </div>
	</div>
</div>

<div class="ui four column doubling stackable grid container" style="margin-top:0px;">
  <div class="column">
  	<div class="ui two buttons">
  		<div class="ui teal button">确定</div>
  		<div class="ui button">取消</div>
  	</div>
    <p>a<a href="${cxt_path }/topic">Topic</a></p>
  </div>
  <div class="column">
    <div class="ui fluid green button">button</div>
    <p>b</p>
  </div>
  <div class="column">
    <div class="ui fluid yellow button">button</div>
    <p>c</p>
  </div>
  <div class="column">
    <div class="ui fluid blue button">button</div>
    <p>d</p>
  </div>
</div>

<div class="ui four column grid container">
<div class="column">
<div class="ui fluid blue button" onclick="window.location.href='${cxt_path }/sign/signOut'">退出</div>
</div>
<div class="ui ordered steps" style="padding: 0px;">
  <div class="completed step">
    <div class="content">
      <div class="title">Shipping</div>
      <div class="description">Choose your shipping options</div>
    </div>
  </div>
  <div class="completed step">
    <div class="content">
      <div class="title">Billing</div>
      <div class="description">Enter billing information</div>
    </div>
  </div>
  <div class="active step">
    <div class="content">
      <div class="title">Confirm Order</div>
      <div class="description">Verify order details</div>
    </div>
  </div>
</div>
</div>

</body>

</html>
