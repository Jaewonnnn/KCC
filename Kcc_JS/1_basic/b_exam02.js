/*컴파일 언어: 데이터형, 문법이 매우 엄격함
컴파일이 되어야만 실행 파일이 만들어지고, 실행되어야 하기 때문
기계어로 변환하는데에 오류가 발생하면 안 됨.
인터프리터 언어 : 문법적으로 느슨함
*/

// var : 여러 큰 스코프에서 공유하기 위한 최상위 변수 사용(전역)

// let a = 10;
// a = '안녕';
// console.log(a);

// const : 상수값으로 사용

// 데이터타입(자료형)
// 숫자형(number)
// let intNum = 10;
// let floatNum = 3.14;
// console.log(typeof intNum);
// console.log(typeof floatNum);

//문자형(string)
// let sinS = 'single';
// let doubleS = "double";

// console.log(typeof sinS);
// console.log(typeof doubleS);

/**
 * template literal
 * 1. newline -> \n
 * 2. tap -> \t
 * 3. \ -> \\
 */

// const kcc = '김진아\t\\\t이수호'
// console.log(kcc);

// ``를 통해 특수문자 출력
// const kcc = `김지안 \
//                   ^^ㅍ "" `
// console.log(kcc);

// const groupName = 'kcc';
// console.log(groupName + '이수호');

// const groupName = 'kcc';
// console.log(`${groupName} 이한희`);

// 논리형(boolean)
/**
 * false
 * => string : 빈 문자열
 * => 값이 없는 경우
 * => 0
 */
// let booVar = true;
// console.log(typeof booVar);

console.log(!!false); // false
// 문자열도 논리연산자로 변환할 수 있음
// 빈 문자열이라면 false
// 문자열이 있으면 true
console.log(!!""); // false
// 숫자 0은 false
// 1 이상은 true
console.log(!!0); // false
// undefined도 false
console.log(!!undefined); // false
// null도 false
console.log(!!null); // false
console.log(!!"0"); // true
// 객체
console.log(!!{}); // true
// 배열
console.log(!![]); // true

//undefiend
let emptyVar;
console.log(typeof emptyVar);

// null : 아무것도 참조하지 않는다
let nullVar = null;
console.log(typeof nullVar); // object

// function / 함수는 1급 객체이기도 함.
let fun = function () {};
console.log(typeof fun); // function

// object / 중괄호 -> 객체
let person = {
  name: "홍길동",
  age: 20,
};
console.log(typeof person); // object
console.log(person.name);
console.log(person["age"]);

const kccMember = ["김현민", "윤채원", "김연호", "원승언"];
console.log(typeof kccMember); // object
console.log(kccMember);

/**
 * symbol 타입
 * 유일무이한 값을 생성할 때 사용
 */

const test1 = "1";
const test2 = "1";

console.log(test1 === test2); // true

const symbol1 = Symbol("1");
const symbol2 = Symbol("1");

console.log(symbol1 === symbol2); // false

console.log("==============================");
