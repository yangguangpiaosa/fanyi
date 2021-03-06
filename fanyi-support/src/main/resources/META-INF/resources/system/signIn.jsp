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
  <title>SignIn Example - Semantic</title>
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/reset.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/site.css">

  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/container.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/grid.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/header.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/image.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/menu.css">

  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/divider.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/form.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/input.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/button.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/list.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/message.css">
  <link rel="stylesheet" type="text/css" href="${cxt_path }/js/comn/semantic-ui/components/icon.css">

  <script src="${cxt_path }/js/comn/sea.js"></script>
  <script src="${cxt_path }/js/comn/config.js"></script>
  <script type="text/javascript">
  	seajs.use('system/signIn');
  </script>

  <style type="text/css">
    body {
      //background-color: #DADADA;
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
    <h2 class="ui teal header">登录
      <%-- <img src="${cxt_path }/img/logo.png" class="image"/>
      <div class="content">登录</div> --%>
    </h2>
    <form class="ui large form" action="${cxt_path }/sign/signIn" method="POST">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="user.email" placeholder="E-mail address">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="user.userPass" placeholder="Password">
          </div>
        </div>
        <!-- <div id="signIn" class="ui fluid large teal submit button">Sign In</div> -->
        <div class="ui two column doubling stackable grid container">
		  <div class="column">
		  	<div id="signIn" class="ui fluid large teal submit button">登录</div>
		  </div>
		  <div class="column">
		    <div class="ui fluid large gray button">注册</div>
		  </div>
		</div>
        <div class="ui error message"></div>

    </form>

  </div>
</div>

</body>

</html>
