<%@include file="setup.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Order Success</title>
        <link href="<c:url value='/static/css/styles.css' />" type="text/css" rel="stylesheet"></link>
        <link href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' />" rel="stylesheet"></link>
  <style>
   .btn{      float: right;
              margin-top: 10%;
              border: none;
              border-radius: 1.5rem;
              padding: 2%;
              background: #fed136;
              color: #fff;
              font-weight: 600;
              width: 50%;
              cursor: pointer;
          }
          </style> 
   </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="generic-container">
            <div class="alert alert-success lead">
                ${message}
            </div>
 <input type="submit" class="btn"<a href="<c:url value='/' />">Go to home page</a>
            

        </div>
            <%@include file="scripts.jsp" %>
    </body>

</html>
