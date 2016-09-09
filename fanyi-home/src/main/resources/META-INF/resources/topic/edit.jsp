<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<div class="ui container" style="margin-top:0px;">
	<form action="${cxt_path }/topic/editSave">
		<input type="hidden" name="topic.id" value="${topic.id }">
		<input type="text" name="topic.title" value="${topic.title }"><br/>
		<input type="text" name="topic.content" value="${topic.content }"><br/>
		<input type="submit" value="submit">
	</form>
</div>

</body>

</html>
