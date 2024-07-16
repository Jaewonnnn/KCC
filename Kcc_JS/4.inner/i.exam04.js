// 정규표현식(regex : regular expression)

// 1. 문자열.match(정규표현식) => 매칭된 결과(문자열) 리턴
// 정규식 조건에 부합하는 문자열을 배열 형태로 반환. 없으면 null
// const result = "sports".match(/s/);
// console.log(result); // [ 's', index: 0, input: 'sports', groups: undefined ]

// 2.ReqExp.exec => 조건에 부합하는 문자열을 배열 형태로 반환. 결과가 1개 이상이라도 첫 번째 값을 반환
// const str = "sfsjsaslkfsdf fsdafafejoi fsdflakdfj";
// const re = /fS/gi; // i:대소문자 구분 X, g:전역검사
// let result = re.exec(str);

// while (result) {
//   console.log(result);
//   result = re.exec(str);
// }

// 퀴즈 > 원하는 문자열만 뽑기 => July 16 2024
// const str = "This is a data : July 16 2024";
// const re = /\w*\s\d+\s\d+/gi;
// const result = str.match(re);
// console.log(result);

// 퀴즈 > 문자열.replace() 사용해서 sw => 소프트웨어로 변경
// const str =
//   "오늘 우리는 SW 세상에서 살고 있다. sw가 매우 중요한 시기이다. 그래서 SW 열심히 공부하자.";
// const re = /sw/gi;
// const result = str.replace(re, "소프트웨어");
// console.log(result);

// const str = "Java--JavaScript";
// const re = /(\w+)-*(\w+)/;
// const result = str.replace(re, "$2 $1");
// console.log(result);

// 이메일 체크
// 정규표현식.test(문자열) => 해당 문자열이 정규표현식에 매칭되는지 유무
// 정상 : dolsam77@nate.com
// 비정상 : 33dolam77.nate.com

const email = /^\w+(\w+)*@\w+(\w+)*(\.\w{2,3})+$/;

console.log(email.test("hello5@email.com")); // true
