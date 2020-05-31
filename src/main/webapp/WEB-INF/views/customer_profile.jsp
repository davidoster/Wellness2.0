
 <link rel="icon" type="image/x-icon" href="assets/img/wellness.png" />
 <!-- Font Awesome icons (free version)-->
 <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
 <!-- Google fonts-->
 <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
 <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
 <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
 <!-- Core theme CSS (includes Bootstrap)-->
<!---  <link href="css/styles.css" rel="stylesheet" /> --> 
 <link href="css/styles.css" rel="stylesheet" />
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



<style>
    .profile{
      background: -webkit-linear-gradient(left, #e9d179, #ff1e00);
      margin-top: 3%;
      padding: 3%;
  }
  .profile-left{
      text-align: center;
      color: #fff;
     
  }
  .profile-left input{
      border: none;
      border-radius: 1.5rem;
      padding: 2%;
      width: 60%;
      background: #f8f9fa;
      font-weight: bold;
      color: #383d41;
      margin-top: 30%;
      margin-bottom: 3%;
      cursor: pointer;
  }
  .profile-right{
      background: #f8f9fa;
      border-top-left-radius: 10% 50%;
      border-bottom-left-radius: 10% 50%;
  }
 
 
  .profile-left img{
      margin-top: 15%;
      margin-bottom: 5%;
      width: 25%;
      -webkit-animation: mover 2s infinite  alternate;
      animation: mover 1s infinite  alternate;
  }
  @-webkit-keyframes mover {
      0% { transform: translateY(0); }
      100% { transform: translateY(-20px); }
  }
  @keyframes mover {
      0% { transform: translateY(0); }
      100% { transform: translateY(-20px); }
  }
  .profile-left p{
      font-weight: lighter;
     
  }
  .profile .profile-form{
      padding: 10%;
      margin-top: 10%;
  }
  .btnUpdate{
      float: right;
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
  .profile .nav-tabs{
      margin-top: 3%;
      border: none;
      background: #fed136;
      border-radius: 1.5rem;
      width: 28%;
      float: right;
  }
  .profile .nav-tabs .nav-link{
      padding: 2%;
      height: 34px;
      font-weight: 600;
      color: #fff;
      border-top-right-radius: 1.5rem;
      border-bottom-right-radius: 1.5rem;
  }
  .profile .nav-tabs .nav-link:hover{
      border: none;
  }
  .profile .nav-tabs .nav-link.active{
      width: 100px;
      color: #fed136;
      border: 2px solid #fed136;
      border-top-left-radius: 1.5rem;
      border-bottom-left-radius: 1.5rem;
  }
  .profile-heading{
      text-align: center;
      margin-top: 8%;
      margin-bottom: -15%;
      color: #495057;
  }
  </style>
  
  

</head>






<div class="container profile">
<div class="row">
<div class="col-md-3 profile-left">
    <img src="assets/img/wellness.png" alt=""/>
    <h3>${success} </h3>
    <p>Check your stats!</p>
    <input type="submit" name="" value="Homepage"/><br/>
   <a href="/Wellness/user/profile/myorders" class="btnUpDate ">My orders</a>
   <!-- <a href="/Wellness/products/" class="btnUpdate">Shop now</a>-->
    <a href="/Chat/chat" class="btnUpdate ">Chat</a>
</div>
<div class="col-md-9 profile-right">
    <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
      
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
        <!--    <h3 class="profile-heading">My profile</h3>-->
        <div class='profile-heading'>

       <!--    <sec:authorize access="hasRole('ADMIN')">
                <c:if test="${adminForAdmin}">
                    <div class="row"><h2>My Profile</h2></div>
                </c:if>
                <c:if test="${!adminForAdmin}">
                    <div class="row"><h2>Customer Profile</h2></div>
                </c:if>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <div class="row"><h2>My Profile </h2></div>
            </sec:authorize> 
        </div>-->
            <div class="row profile-form">
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="text-warning font-weight-bold" for="fname">First Name</label>
                        <input disabled="true" type="text" class="form-control" id="fname" value="${customer.fname}">
                    </div>
                    <div class="form-group">
                        <label class="text-warning font-weight-bold" for="lname">Last Name</label>
                        <input disabled="true" type="text" class="form-control" id="lname" value="${customer.lname}">
                    </div>
                    <div class="form-group">
                        <label class="text-warning font-weight-bold" for="email">Email</label>
                        <input disabled="true" type="email" class="form-control" id="email" value="${customer.email}">
                    </div>


                 <!--   <div class="form-group">
                        
                    </div>
                   <div class="form-group">
                        <div class="maxl">
                            <label class="radio inline"> 
                                <input type="radio" name="gender" value="male" checked>
                                <span> Male </span> 
                            </label>
                            <label class="radio inline"> 
                                <input type="radio" name="gender" value="female">
                                <span>Female </span> 
                            </label>
                        </div>
                    </div>-->
                    
                <!---  <div class="form-group">
                        <div class="maxl">
                            <label class="radio inline"> 
                                <input type="radio" name="gender" value="male" checked>
                                <span> Male </span> 
                            </label>
                            <label class="radio inline"> 
                                <input type="radio" name="gender" value="female">
                                <span>Female </span> 
                            </label>
                        </div>
                    </div>
                </div>-->  
                <div class="col-md-12">
                 
               
                    <div class="form-group">
                        <label class="text-warning font-weight-bold" for="address">Address</label>
                        <input disabled="true" type="text" class="form-control" id="address" value="${customer.address}">
                  </div>
                  <div class="form-group">
                    <label class="text-warning font-weight-bold" for="number">Phone Number</label>
                    <input disabled="true" type="text" class="form-control" id="number" value="${customer.phoneNumber}">
                </div>
         <!--   <div class="form-group">
                <input type="number" class="form-control" step = 0.01 min = 10.0 placeholder="BMI *" value="${userprofile.BMI}" />
            </div>
            <div class="form-group">
              <input type="text" class="form-control" required maxlength =10 placeholder="Known allergies *" value="${userprofile.knownAllergies}" />
          </div>


                 <input type="submit" class="btnUpdate" <a href="<c:url value='${editurl}/${user.id}' />" value="Update"/>
                </div>
            </div>
        </div>
        

    </body>
    </html>  

-->
    <sec:authorize access="hasRole('ADMIN')">
        <c:if test="${adminForAdmin}">
            <div><a href="<c:url value='/admin/profile/update'/>" class="btnUpdate">Edit</a></div>
        </c:if>
        <c:if test="${!adminForAdmin}">
            <div><a href="<c:url value='/admin/customers/update/${customer.customerId}' />" class="btnUpdate">Edit</a></div>
        </c:if>

    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
        <div><a href="<c:url value='/user/profile/update'/>" class="btnUpdate">Edit</a></div>
    </sec:authorize>
</form>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>

<%@include file="scripts.jsp" %>
</body>
</html>
