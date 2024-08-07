<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기본정보 입력</h1>
   <form action="insert_membership.jsp" method="post">
      <fieldset>
      <table width="600" border="1">
         <tbody>
            <tr>
               <td for="name">이름</td>
               <td>
                  <input type="text" name="userName" id="name" autofocus="autofocus"
                  placeholder="ex)고길동">
               </td>
            <tr>
               <td for="name">아이디</td>
               <td>
                  <input type="text" name="userID" id="id"
                  placeholder="ex)duden5000">
                  <button type="button">중복 확인</button>
               </td>
            </tr>
            <tr>
               <td for="password">비밀번호</td>
               <td>
                  <input type="password" name="userPass">
               </td>
            </tr>
            <tr>
               <td for="name">비밀번호 확인</td>
               <td>
                  <input type="password" name="userPassCheck">
               </td>
            </tr>
            <tr>
               <td for="name">이메일</td>
               <td>
                  <input type="text" id="emailPrefix" placeholder="이메일">
                <select id="emailDomain">
                   <option value="선택하세요">선택하세요</option>
                    <option value="gmail.com">gmail.com</option>
                    <option value="naver.com">naver.com</option>
                    <option value="daum.net">daum.net</option>
                    <option value="custom">직접 입력</option>
                </select>
               <input type="text" id="emailPrefix">
               </td>
            </tr>
            <tr>
               <td for="name">연락처</td>
               <td>
                  <input type="tel" placeholder="010-xxxx-xxxx" required="required">
               </td>
            </tr>
            <tr>
               <td for="name">메일수신여부</td>
               <td>
                  <input type="radio" name="subscribe" value="yes"> 받음
                 <input type="radio" name="subscribeNo" value="no"> 받지않음
               </td>
            </tr>
            <tr>
               <td for="name">관심분야</td>
               <td>
                  <label><input type="checkbox" name="language" value="java"> 자바</label>
                  <label><input type="checkbox" name="language" value="cpp"> C++</label>
                  <label><input type="checkbox" name="language" value="python"> 파이썬</label>
                  <label><input type="checkbox" name="language" value="android"> 안드로이드</label>
               </td>
            </tr>
         </tbody>
      </table>
      </fieldset>
      <fieldset>
         <input type="reset" value="취소">
         <input type="submit" value="전송">
      </fieldset>
      
      
   </form>
</body>
</html>