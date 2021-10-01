<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="../../menu/menu.css" />
    <script src="../../menu/menu.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="../../footer/footer.css" />
    <style>
      table{
      width: 400px;
      height: 200px;
      margin: 0px;
      position: relative;

    }
      #shop_img{
      width: auto;
      heiht: auto;
      }
      #shoppingBag_list{
      	text-align: center;
      	float: left;
      	position: relative;
      	left:500px;
      }
      #shoppingBag_body>h2{
      	position: relative;
      	left: 1050px;
      }
      #buy{
      	align-content:center;
      	float:left;
      	position: relative;
      	left: 800px;
      }
      #buy>button,h3{
      	position: fixed;
      }
      #buy>button{
      width: 200px;
      height: 40px;
      background-color:#a5dfd3;
      border-radius:5px 5px 5px 5px;
      border-color:#a5dfd3;
      color : white;
      margin-bottom: 20px;
      }
      body,html{
      align-content: center;
      }
      
      
    </style>
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
        <li><i class="fas fa-weight-hanging"></i></li>
        <a href = "/alarm/selectAlarm"> 
        <li id="alarm_btn" id="alarm"><i class="fas fa-bell"></i></li>
         </a>
        <li id="navbar_toogleBtn"><i class="fas fa-bars"></i></li>
      </ul>
    </nav>

    <navside class="navbar_side">
      <ul class="navbar_menu_side">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">메뉴</a></li>
        <li><a href="/quotation/userCheck">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
      </ul>
    </navside>
    <div id="shoppingBag_body">
    <h2>장바구니</h2>
    <div id="shoppingBag_list">
   <c:forEach items="${requestScope.sList}" var="sOne" varStatus="index">
      <table border="1">
    <tr>
      <td rowspan="3" style="width: 200px;"><img src="${sOne.shoppingBagProductImageName}" alt="이미지없음" id="shop_img"></td>
      <td colspan="3" style="height: 40px;">${sOne.shoppingBagProductName}</td>
    </tr>
    <tr>
      <td colspan="3" style="height: 140px;">${sOne.shoppingBagProductContents}</td>
    </tr>
    <tr>
      <td colspan="2">${sOne.shoppingBagProductPrice}</td>
      <td></td>
      <td><a href="/shoppingBag/deleteShoppingBag?shoppingBagCode=${sOne.shoppingBagCode}">
      <button>삭제</button>
      </a>
      </td>      
    </tr>
  </table>
    <br><br>
    </c:forEach>
    </div>
	<div id="buy">
		<h3>합계:${requestScope.shoppingBagTotalPrice}</h3>
		<br><br><br>
		<button>결제하기</button>
	</div>
	</div>
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
        src="../../public/image/footer.png"
        alt=""
      />
    </div>
  </footer>
    <script>
//     document.querySelector("#alarm").addEventListener("click", function(){
// 		alert("test");
//     	$.ajax({
// 			type:"GET",
// 			url: "/alarm/selectAlarm",
// 			data: {"userId" : userId},
// 			error:function(xhr, status, err){
// 				alert(err);
// 			}
// 			success:function(data){
// 				if(data == "Y"){
// 					alert("성공");													
					
// 				}else{
// 					alert("실패");
// 				}
// 			}
			
// 		});

    	
//     })
  </script>
  </body>
</html>
