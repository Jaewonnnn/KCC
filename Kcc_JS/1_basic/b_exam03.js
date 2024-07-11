/**
 * 타입변환(형변환)
 * 1) 명시적
 * 2) 암묵적
 */

// 명시적
let age = 20;
let stringAge = age.toString();

console.log(typeof stringAge); // string

// 암묵적
let test = age + '';
console.log(typeof test); // string

// + 는 문자열로 변환이 되는데 나머지는 알아서 정수형으로 변환이됨
// 권장하지 않음
console.log('100' + '2'); // 1002
console.log('100' * '2'); // 200
console.log('100' - '2'); // 98

// 문자열(string) -> 숫자형(number)
// eval(), Number(), parseInt(), parseFloat()
// parseInt 권장
let num = '100안녕';
// num = eval(num); // '100안녕'을 eval, Number를 통해 변환하면 오류발생(NaN)
num = parseInt(num); // parseInt는 변환할 수 있는 값만 변환함(number타입 이외의 값 제거)
let result = num + 100;
console.log(result); // 200

/**
 * 호이스팅(Hoisting)
 * 모든 변수 선언문이 코드 최상단으로 이동되는 것 같은 현상
 */
// var name;
// console.log(name); // undefined
// name = "홍길동";
// console.log(name); // 홍길동

// console.log(kim); // undefined
// var kim = '김씨';

// 초기화가 되어있지 않을 뿐 호이스팅 발생
// let, const또한 호이스팅이 발생하지만 에러를 발생시킴으로써 차단
console.log(kim); // Cannot access 'kim' before initialization
let kim = '김씨';