<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>견적서작성</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
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
       #quotation-contents{
      text-align: center;

    }
    #quotation{
      position: relative;
    }
    form>h1{
      position: relative;
      right: 335px;
    }
    form>h2{
      position: relative;
      right: 350px
    }
    #image{
      position: relative;
      right: 280px;
      background-color: rgba(230, 221, 221, 0.959);
      border-radius: 5px 5px 5px 5px;
      width: 160px;
      height: 30px;
      top: 30px;
      border-color:  rgba(230, 221, 221, 0.959);
    }
    #category{
      position: relative;
      left: 255px;
      bottom: 50px;
      width: 230px;
      height: 30px;
    }
    #save,#cancel{
      width: 200px;
      height: 50px;
      background-color: rgba(230, 221, 221, 0.959);
      border-radius:5px 5px 5px 5px;
      border-color: rgba(230, 221, 221, 0.959);
    }
    textarea{
      width: 800px;
      height: 600px;
    }
    #subject{
      height: 30px;
    }
    #save{
      position: relative;
      right: 60px;
    }
    #cancel{
      position: relative;
      left: 0px;
    }
    </style>
  </head>
  <body>
    <nav class="navbar">
      <div class="navbar_logo"></div>

      <ul class="navbar_menu">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">메뉴</a></li>
        <li><a href="#">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
      </ul>

      <ul class="navbar_icons">
        <li><i class="fas fa-user"></i></li>
        <li><i class="fas fa-weight-hanging"></i></li>
        <li id="alarm_btn"><i class="fas fa-bell"></i></li>
        <li id="navbar_toogleBtn"><i class="fas fa-bars"></i></li>
      </ul>
    </nav>

    <navside class="navbar_side">
      <ul class="navbar_menu_side">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">메뉴</a></li>
        <li><a href="#">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
      </ul>
    </navside>
    <div id="quotation-contents">
    <form action="/quotation/insertQuotation" method="POST" id="quotation">
      <h1>견적서</h1>
      <br>
      <h2>제목</h2>
      <input type="text" name="subject" placeholder="제목을 입력해주세요" size="100px" id="subject" name="subject"><br><br><br>
      <input type="button" value="이미지 파일 업로드" id="image" name="image">
      <br><br>
      <select name="category" id="category">
        <option value="의류">의류</option>
        <option value="용품">용품</option>
      </select>
      <br>
      <textarea name="contents"></textarea><br><br><br><br>
       <input type="submit" value="저장" id="save"><input type="reset" value="취소" id="cancel">
    </form>
  </div>
  <footer class="">
    <div id="footer">
      <table id="footer_table">
        <tr>
          <td><label class="footer_table_title">고객센터</label></td>
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
  </body>
</html>
