<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>문의사항 작성</title>
        <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
        <style>
            #imgUploadLabel {
                border: 1px solid #000;
                background-color: #cbcbcb;
                padding: 5px;
                font-size: 10px;
                width: 100px;
            }
            #imgUploadLabel:hover {
                background-color: red;
                color: #fff;
            }
            h1 {
                text-align: center;
            }
            main {
                padding: 20px;
            }
            main form {
                max-width: 700px;
                display: flex;
                margin: 10px auto;
                flex-direction: column;
            }

            .imgDiv {
            }
            .imgDiv img {
                width: 100px;
                height: 100px;
                object-fit: cover;
            }
            .category {
                width: 100px;
                margin-left: auto;
                margin-bottom: 15px;
                height: 30px;
            }
            .title {
                margin-bottom: 20px;
                height: 30px;
            }

            .password {
                margin-bottom: 20px;
                height: 30px;
            }
            .displayNone {
                display: none;
            }

            .inputDiv input[type='submit'] {
                margin-left: auto;
            }
            .inputDiv input[type='reset'] {
                margin-left: 10px;
            }
            .inputDiv {
                display: flex;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../common/top_include.jsp" flush="false" />
        <main>
            <h1>QNA 작성</h1>
            <form action="/qna/insert" method="post" enctype="multipart/form-data">
                <select class="category" name="qna-category">
                    <option value="교환/환불문의" selected>교환/환불문의</option>
                    <option value="결제문의">결제문의</option>
                    <option value="배송문의">배송문의</option>
                    <option value="기타">기타</option>
                </select>

                <input class="title" type="text" size="70" placeholder="제목" name="qna-title" />
                <input class="password" type="text" size="70" placeholder="비밀번호" name="qna-pwd" />
                <textarea rows="30" cols="70" name="qna-comments" placeholder="내용을 입력해 주세요."></textarea><br />

                <input
                    id="imageSelector"
                    type="file"
                    name="upFile"
                    accept="image/jpeg, image/jpg, image/png"
                    multiple
                    style="display: none"
                />
                <div class="inputDiv">
                    <label for="imageSelector" id="imgUploadLabel">이미지 파일 올리기</label>
                    <input type="submit" value="등록" />
                    <input type="reset" value="취소" />
                </div>
                <div class="imgDiv">
                    <img src="" class="thumb1 displayNone" />
                    <img src="" class="thumb2 displayNone" />
                    <img src="" class="thumb3 displayNone" />
                    <img src="" class="thumb4 displayNone" />
                    <img src="" class="thumb5 displayNone" />
                </div>
            </form>
        </main>
        <jsp:include page="../common/bottom_include.jsp" flush="false" />
    </body>
    <script>
        var validateType = function (img) {
            return ['image/jpeg', 'image/jpg', 'image/png'].indexOf(img.type) > -1;
        };

        document.getElementById('imageSelector').addEventListener('change', function (e) {
            let elem = e.target;
            if (elem.files.length > 5) {
                alert('최대 5개까지만 업로드 가능합니다.');
            } else {
                for (let i = 0; i < elem.files.length; i++) {
                    if (validateType(elem.files[i])) {
                        let preview = document.querySelector('.thumb' + (i + 1));

                        preview.src = URL.createObjectURL(elem.files[i]); //파일 객체에서 이미지 데이터 가져옴.
                        $('.thumb' + (i + 1)).removeClass('displayNone');
                        preview.onload = function () {
                            URL.revokeObjectURL(preview.src); //URL 객체 해제
                        };
                        for (let i = elem.files.length + 1; i <= 5; i++) {
                            $('.thumb' + i).addClass('displayNone');
                        }
                    } else {
                        alert('이미지 파일이 아닙니다.');
                    }
                }
            }
        });
    </script>
</html>
