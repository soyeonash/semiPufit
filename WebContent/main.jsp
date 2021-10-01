<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userCheck = (String)request.getAttribute("userYN");
	String quotationCheck = (String)request.getAttribute("quotationYN");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>pufit</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<!--     <script src="http://code.jquery.com/jquery-latest.js"></script> -->
    <script
      src="https://kit.fontawesome.com/0ac2e127d2.js"
      crossorigin="anonymous"
    ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./menu/menu.css" />
    <script src="./menu/menu.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="./footer/footer.css" />
  </head>
  <body>
    <nav class="navbar fiexd-top">
      <div class="navbar_logo"></div>

      <ul class="navbar_menu">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">메뉴</a></li>
        <li><a href="/quotation/userCheck" type="onclick" id="quotation">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
      </ul>

      <ul class="navbar_icons">
        <li><i class="fas fa-user"></i></li>
        <a href="/shoppingBag/selectShoppingBag">
        <li><i class="fas fa-weight-hanging"></i></li>
        </a>
<!--         <a href = "/alarm/selectAlarm">  -->
        <li id="alarm_btn" onclick="alarm_btn_click"><i class="fas fa-bell"></i></li>
<!--          </a> -->
        <li id="navbar_toogleBtn"><i class="fas fa-bars"></i></li>
      </ul>
    </nav>
         <div id="Alarm_Area"></div>

    <navside class="navbar_side">
      <ul class="navbar_menu_side">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">메뉴</a></li>
        <li><a href="/quotation/userCheck">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
      </ul>
    </navside>
    <a href="/shoppingBag/insertShoppingBag"><button>장바구니 담기</button></a>
  <footer class="fixed-bottom">
    <div id="footer">
      <table id="footer_table">
        <tr>
          <td><label class="footer_table_title">고객센터</label></td>
        </tr>

        <tr>
          <td>
            <label></label>
          </td>
        </tr>
        <tr>
          <td>
            <label> </label>
          </td>
        </tr>
        <tr>
          <td>
            <label> </label>
          </td>
        </tr>
        <tr>
          <td>
            <label></label>
          </td>
        </tr>
      </table>
      <img
        class="footer_img"
        src="public/image/footer.png"
        alt=""
      />
    </div>
    <div id="Alarm_Area"></div>
  </footer>
    <script>
//    $(document).ready(function(){    	
//         $.ajax({
//             type : "GET", //전송방식을 지정한다 (POST,GET)
//             url : "/alarm/selectAlarm?currentPage=1",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
//             dataType : "html",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
//             error : function(){
//                 alert("통신실패!!!!");
//             },
//             success : function(Parse_data){
//                 $("#Alarm_Area").html(Parse_data); //div에 받아온 값을 넣는다.
//                 //alert("통신 데이터 값 : " + Parse_data);
//             }
             
//         });
//     });

   var alarm = document.querySelector("#alarm_btn");
   function alarm_btn_click(){
	   $.ajax({
           type : "GET", //전송방식을 지정한다 (POST,GET)
           url : "/alarm/selectAlarm?currentPage=1",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
           dataType : "html",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
           error : function(){
               alert("통신실패!!!!");
           },
           success : function(Parse_data){
               $("#Alarm_Area").html(Parse_data); //div에 받아온 값을 넣는다.
               //alert("통신 데이터 값 : " + Parse_data);
           }
            
       });
   }
//    $(alarm).addEventListener('click', function(){    	
//         $.ajax({
//             type : "GET", //전송방식을 지정한다 (POST,GET)
//             url : "/alarm/selectAlarm?currentPage=1",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
//             dataType : "html",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
//             error : function(){
//                 alert("통신실패!!!!");
//             },
//             success : function(Parse_data){
//                 $("#Alarm_Area").html(Parse_data); //div에 받아온 값을 넣는다.
//                 //alert("통신 데이터 값 : " + Parse_data);
//             }
             
//         });
//     });
  </script>
  </body>
</html>
