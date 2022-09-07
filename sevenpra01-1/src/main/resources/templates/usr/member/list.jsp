<!DOCTYPE html>
<html lang="ko">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>게시물 목록</title>
</head>
<body>
    <hr>
    <div>
        안녕!
        <br>
        내 나이는 <span th:text="${age}"></span>살이고,
        <br>
        내 이름은 <span th:text="${name}"></span> (이)라고 해.
    </div>
    <hr>

    <h1>게시물 목록</h1>
    <ul>
        <li>내용 1</li>
        <li>내용 2</li>
        <li>내용 3</li>
    </ul>
</body>
</html>