<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>pufit</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://kit.fontawesome.com/0ac2e127d2.js"
      crossorigin="anonymous"
    ></script>

    <link rel="stylesheet" type="text/css" href="../menu/menu.css" />
    <script src="./menu/menu.js"></script>
    <link rel="stylesheet" type="text/css" href="../footer/footer.css" />
  </head>
  <body>
    <nav class="navbar">
      <div class="navbar_logo"></div>
      <ul class="navbar_menu">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="/user/practice?userId=${userId }">결제하기</a></li>
        <li><a href="/user/logout">로그아웃</a></li>
      </ul>

      <ul class="navbar_icons">
        <a href="/user/mypage?userId=${userId }"><li><i class="fas fa-user"></i></li></a>
        <li><i class="fas fa-weight-hanging"></i></li>
        <li id="alarm_btn"><i class="fas fa-bell"></i></li>
        <li id="navbar_toogleBtn"><i class="fas fa-bars"></i></li>
      </ul>
    </nav>

    <navside class="navbar_side">
      <ul class="navbar_menu_side">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
        <li><a href="#">고객센터</a></li>
      </ul>
    </navside>

    <main>
		<a href="/wishlist/insert?productCode=D1&userId=${userId }">
	      <div style="width:300px; height:300px;">
		      <img src="/productImage/양초.jpg" style="width:100%; height:100%;">
	      </div>
		</a>
      
      
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
    </main>
  </body>
  <footer>
    <div id="footer">
      <table id="footer_table">
        <tr>
          <td><label class="footer_table_title">(주)퍼핏</label></td>
        </tr>

        <tr>
          <td>
            <label>위치 : 서울 중구 남대문로 120 대일빌딩 2층, 3층</label>
          </td>
        </tr>
        <tr>
          <td>
            <label>사업자 등록번호 : 569-14-00530 </label>
          </td>
        </tr>
        <tr>
          <td>
            <label>대표자 : 강소연 </label>
          </td>
        </tr>
        <tr>
          <td>
            <label>대표 메일 : pufit@gmail.com </label>
          </td>
        </tr>
      </table>
      <img
        class="footer_img"
        src="../public/image/footer.png"
        alt=""
      />
    </div>
  </footer>
</html>
