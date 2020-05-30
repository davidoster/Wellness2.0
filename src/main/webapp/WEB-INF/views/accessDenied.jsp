

<%@include file="setup.jsp" %>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap 4 -->
        <link href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' />" rel="stylesheet"></link>

        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
              integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

        <!-- Google Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,700&display=swap" rel="stylesheet">


        <!-- AngularJS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.8/angular.min.js"></script>

        <title>Access Denied</title>

        <link href="<c:url value='/static/css/styles.css' />" type="text/css" rel="stylesheet"></link>
        
      
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <main>
  <header class="masthead">
    <div class="container"> 
        <section class="page-section bg-light" id="accessDenied">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Access denied</h2>
                    <h3 class="section-subheading text-warning"> Sorry you are not authorised.</h3>
                </div> <!---class-->
                
            </div> <!--container-->
            </section>
            </div>
</header>            
        </main>
        <%@include file="footer.jsp" %>
        <%@include file="scripts.jsp" %>
    </body>
</html>
