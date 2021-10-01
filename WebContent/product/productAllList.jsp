<%@page import="java.util.List"%>
<%@page import="pufit.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>상품페이지</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://kit.fontawesome.com/0ac2e127d2.js"
      crossorigin="anonymous"
    ></script>

    <link rel="stylesheet" type="text/css" href="../menu/menu.css" />
    <script src="./menu/menu.js"></script>
    <link rel="stylesheet" type="text/css" href="../footer/footer.css" />
    <link rel="stylesheet" type="text/css" href="./productAllList.css" />
  </head>
  <body>
    <nav class="navbar">
      <div class="navbar_logo"></div>

      <ul class="navbar_menu">
        <li><a href="#">SHOP</a></li>
        <li><a href="#">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
        <li><a href="#">고객센터</a></li>
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
        <li><a href="#">견적서</a></li>
        <li><a href="#">디자이너</a></li>
        <li><a href="#">리뷰게시판</a></li>
        <li><a href="#">고객센터</a></li>
      </ul>
    </navside>

    <main>
        <div class="product-page">
            <div class="product product-ad">
                <img id="product-ad-img"
                src="./test.png" alt="">
                <h1>SHOP</h1>
            </div>
            <form action="/product/search" method="get">
	            <input type="search" id="searchProduct">
	            <input type="submit" value="검색">
            </form>

            <div class = "product category">
                <article style="margin: 10px;">
                    <p style="font-size: 35px;">리스트</p><hr>
                    <section>
                        <p class="list-font">의류</p>
                        <ul>
                            <li><a href="javascript:void(0);" onclick="callListFunction('민소매');">민소매</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('셔츠');">셔츠</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('후드티');">후드티</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('맨투맨');">맨투맨</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('잠옷');">잠옷</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('원피스');">원피스</a></li><br>
                        </ul>
                    </section>
                    <section>
                        <p class="list-font">용품</p>
                        <ul>
                            <li><a href="javascript:void(0);" onclick="callListFunction('목줄');">목줄</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('밥그릇');">밥그릇</a></li><br>
                            <li><a href="javascript:void(0);" onclick="callListFunction('하우스');">하우스</a></li><br>
                        </ul>
                    </section>
                </article>
            </div>

            <div id="list" class = "product list" style="background-color: antiquewhite;">
              
                <div class="list-bar">
                    <div class="select-layer">
                        <p style="position: relative; right:210px; top: 10px; font-size: 30px;">목록</p>              
                    </div>
                    <div class="select-layer">
                       <!--  <div class="select-sort" id="TopSort">
                            <a href="#" style="text-decoration: none; color: black;">
                                <span>최신순</span>&nbsp;&nbsp;
                                <button id="select-button" style="border: 0; outline: 0; background-color: transparent;
                                font-size: 20px; color: rgb(64, 177, 162); cursor: pointer;">V</button>
                            </a>
                        </div>
                        <div class="select-sort" id="divTopSortLayer">
                            <ul>
                                <li>
                                    <a href="#">인기순</a>
                                </li>
                                <li>
                                    <a href="#">최신순</a>
                                </li>
                            </ul>
                        </div> -->
                        <select style="width: 100px; height: 30px; font-size: 20px;" name="productOption">
                        	<option value="최신순">최신순</option>
                        	<option value="인기순">인기순</option>
                        </select>
                    </div>
                    <button id="onDisplay">click</button>
                </div>
                <hr>
                
                <div class="container">
	                <c:forEach items="${requestScope.pList }" var="product" varStatus="index">
		                <div class="container-item" onclick="location.href='/product/detail?productCode=${product.productCode}'">
		                        <div class="productImg">
		                            <img src="../productImgFolder/${product.productImgName}" alt="test">
		                            <%-- <p><%=p.getProductImage()%></p> --%>
		                        </div>
		                        <div class="price">
		                            <!-- <strong>16,000</strong>원 -->
		                            <strong>${product.productPrice}</strong>원
		                        </div>
		                    </div>
	                </c:forEach>
                  </div>
                <div class="product-page" style="float: left; background-color: thistle; height: 50px; width: 100%;">
                    <!-- 페이징 코드 자리 -->
                </div>
                
            </div>
            <div class = "product" id="bag">
                  <div class="sideBanner">
                      <button id ="insertProduct">insert</button>
                      <span class="product-Img">adfaf</span>
                  </div>
            </div>
           	<input type="hidden" id="category" value="${category }">
           	<input type="hidden" id="select" value="${select }">
        </div>
    </main>
  </body>
  <footer>
    <div id="footer" style="width: 100%; height: 200px; float: left;">
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
      <img class="footer_img" src="../public/img/footer.png" alt="">
    </div>
  </footer>

  <script>
    $(function(){
        $("#onDisplay").click(function(){
            if($("#bag").css("display")=="none"){
                $("#bag").show();
            } else{
                $("#bag").hide();
            }
            // $(".bag").toggle();
        })
        //기본 위치(top) 값
        var floatPosition=parseInt($(".sideBanner").css("top"))
        // scorll 인식
        $(window).scroll(function(){
            //현재 스크롤 위치
            var currentTop =$(window).scrollTop();
            var bannerTop = currentTop+floatPosition+"px";

        //이동 애니메이션
        $(".sideBanner").stop().animate({
                "top":bannerTop
                }, 300);
        }).scroll();

        var i = 1;
        $("#insertProduct").click(function(){
            $(".sideBanner").append("<span class='product-Img'>adfaf"+i+"</span>");
            i++
        });

/*         $(".select-sort").click(function(){
            $("#divTopSortLayer").toggle();
        }); */
        
        
      $("select[name=productOption]").change(function() {
			//var selectOne=$("select[name=productOption] option:selected").text();
			var item = $("#category").val();
			var selectOne = $(this).val();
			//ajax는 url 안 바뀜
			$.ajax({
				async:false,
				cache:false,
				type:'get',
				url:'/product/allList?item='+item+'&selectOne='+selectOne,
				data:{selectOne:selectOne},
				success:function(data){
				},
				error:function(){
					alert("정렬 오류!");
				}
			});
		});  
    });
    

    function callListFunction(f) {
    	var item = f;
		var selectOne = $("#select").val();
		location.href="/product/allList?item="+item+"&selectOne=최신순";
    }


  </script>
</html>