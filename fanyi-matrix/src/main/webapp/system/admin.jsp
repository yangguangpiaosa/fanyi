<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>SignIn Example - Semantic</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/reset.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/site.css">

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/container.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/grid.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/header.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/image.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/menu.css">

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/divider.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/segment.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/form.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/input.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/button.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/list.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/message.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/comn/semantic-ui/components/icon.css">

  <script src="<%=request.getContextPath() %>/js/comn/sea.js"></script>
  <script src="<%=request.getContextPath() %>/js/comn/config.js"></script>
  <script type="text/javascript">
  	seajs.use('system/signIn');
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
      <img src="<%=request.getContextPath() %>/img/logo.png" class="image">
      <div class="content">
        Admin
      </div>
    </h2>
    <div class="ui message">
      New to us? <a href="#">Sign Up</a>
    </div>
  </div>
</div>

</body>

</html>
