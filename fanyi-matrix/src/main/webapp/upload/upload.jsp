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
  <title>Upload</title>
  
</head>
<body>
<form action="<%=request.getContextPath() %>/upload/upd" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
</body>

</html>
