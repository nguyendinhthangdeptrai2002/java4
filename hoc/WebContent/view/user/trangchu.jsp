<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  .header{
  background-color:red;
    width:100%;
    height:200px;
    
  }
  .menu{
   
    width: 100%;
    height:50px;
  }
  
  .body{
    
    width:100%;
    min-height: 80vh;
    position: relative;
    
  }
  .footer{
   width:100%;
   height:100px;
   background-color: black;;
  }
  .menu{
     font-size: 30px;
     text-transform: uppercase;
     
     text-align: center;
     padding-left: 20px;
  }
  .menu a{
     padding-left: 20px;
     text-decoration: none;
     color: black;
     line-height: 50px;
  }
  .menu a:hover{
     color: yellow;
  }
  #index{
   font-size: 35px;
  }
  .no1{
  display: flex;
  position:relative;
 
  height: 50%;
  width:100%;
  
  }
 .no2{
 position:relative;
 display: flex;
 height: 50%;
 width:100%;
 
 }
  .box1{
   
   width:350px;
   height:250px;
   margin: 50px;
   margin-left: 130px;
   border: ridge;
   position: relative;
  }
    .box2{
   border: ridge;
   width:350px;
   height:250px;
  margin: 50px;
  position: relative;
   
  }
    .box3{
   border: ridge;
    width:350px;
   height:250px;
   margin: 50px;
   position: relative;
    
  }
    .box4{
  border: ridge;
   width:350px;
   height:250px;
   margin: 50px;
   margin-left: 130px;
    position: relative;
  }
    .box5{
   border: ridge;
   width:350px;
   height:250px;
  margin: 50px;
   position: relative;
  }
    .box6{
   border: ridge;
   width:350px;
   height:250px;
  margin: 50px;
   position: relative;
   
  }
  .dichuyen{
      line-height:100px;
text-align: center;
  }
  .dichuyen button{
  width: 70px;
  height: 30px;
  }
  .dichuyen button:hover{
    background-color: red;
    color: green;
  }
  .poster{
   border:solid 1px gray;
   width:330px;
   height:150px;
  margin: 10px;
  }
  .tt{
  border: solid 1px gray;

  width:100%;
  height:40px;
  position: absolute;
  bottom: 0px;
  }

</style>
<link href="">
</head>


<body>
<div class="tong">
<div class="header"> video </div>
  <div class="menu"> 
  <a href="index" id="index"> Online Entertainment</a>
   <a href="favorite"> My favorite</a>
   <a href="account">My account</a>
   
   </div>
<div class="body">
    <div class="no1">
    <div class="box1"> 
       <div class="poster"> </div>
       <div class="title"> Tây Du Ký </div>
       <div class="tt"> </div>
     </div>
        <div class="box2"> 
           <div class="poster"> </div>
       <div class="title"> Tây Du Ký </div>
       <div class="tt"> </div>
         </div>
            <div class="box3">
             <div class="poster"> </div>
       <div class="title"> Tây Du Ký </div>
         <div class="tt"></div>
              </div>
    </div>
    <div class="no2">
    <div class="box4"> 
       <div class="poster"> </div>
       <div class="title"> Tây Du Ký </div>
       <div class="tt"> </div>
     </div>
        <div class="box5">  
           <div class="poster"> </div>
       <div class="title"> Tây Du Ký </div>
         <div class="tt"> </div>
        </div>
            <div class="box6"> 
               <div class="poster"> </div>
               <div class="title"> Tây Du Ký </div>
               <div class="tt"></div>
             </div>
    </div>
    
    <div class="dichuyen">
    <button> |< </button>
    <button> << </button>
    <button> >> </button>
    <button> >| </button>
    </div>
 
</div>

<div class="footer"></div>
</div>
</body>
</html>