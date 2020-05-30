<%-- 
    Document   : view_order_success
    Created on : Aug 6, 2019, 5:19:52 PM
    Author     : giorgos
--%>

<%@include file="z1JSP_setup.jsp" %>
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




        <!-- Our CSS -->
        <link href="<c:url value='/static/css/contact.css' />" type="text/css" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/style.css' />" type="text/css" rel="stylesheet"></link>
        <style>
            h1 {
                background-color: black;
                color: lightgoldenrodyellow;
            }


            body {
                background-color: lightgoldenrodyellow;
            }

            nav {
                background-color: lightgoldenrodyellow;
            }

            .color {
                background-color: lightgreen;
            }

            .gr {
                background-color: greenyellow;
            }

            .ran {
                flex-grow: unset;
                background-color: rgb(219, 219, 130);
                color: rgb(6, 8, 6);
            }
        </style>
    </head>
    <body>
        <%@include file="z5HTML_NavBar_Menu.jsp" %>
        <main>

            <div class="container">
                <div class="row ">

                    <div class="mx-auto d-block text-center" style="width:50%;">
                        <h2 class="text-danger">You are not authorised</h2>
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/static/img/access_denied.jpg" alt="access denied" class="card-img-top">
                        </div>
                    </div>
                </div>
        </main>
        <%@include file="z5HTML_Footer.jsp" %>
        <%@include file="z4scriptsBeforeBody.jsp" %>
    </body>
</html>
