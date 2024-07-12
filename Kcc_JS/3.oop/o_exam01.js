/**
 * 자바스크립트 객체
 * 1) 사용자 정의 객체
 *  1. Object 2. 객체 리터럴 3. 생성자 함수(프로토타입)
 * 2) 내장 객체(빌트인 객체)
 *  1. 코어객체 : string, number, math, array
 *  2. 브라우저객체 : document, window, navigator, history
 *  3. DOM 객체 : 문서 내 모든 요소 : div, form, p, a, table, li ...
 */

// 1) 사용자 정의 객체
// 1. object 객체
// 1-1 자바스크립트 객체는 동적으로 프로퍼티를 추가/삭제할 수 있다.
let obj = new Object();
console.log(obj);

obj.name = "홍길동";
obj.age = 20;

console.log(`이름: ${obj.name}`);
console.log(`나이: ${obj.age}`);

// 함수도 1급 객체이다.
function add(a, b) {
  let sum = a + b;
  return sum;
}

console.log(typeof add);
console.log(add instanceof Object);

add.result = add(10, 20);
console.log(`결과: ${add.result}`);

// 2. 리터럴 형식 => 1개의 객체를 생성해서 사용하는 경우(일회용)
let obj2 = {
  name: "홍길동",
  age: 20,
  getInfo: function () {
    console.log(this.name); // this -> obj2
  },
};
obj2.getInfo();
console.log(`나이: ${obj2.age}`);
console.log(`나이: ${obj2["age"]}`);

// 퀴즈> 리터럴 형식으로 빈 객체를 생성 후 동적 프로퍼티와 함수를 추가 후 호출하는 예제를 구현하시오
let obj3 = {};
obj3.name = "김길동";
obj3.age = 29;
obj3.getInfo = function () {
  console.log(`이름 : ${this.name} 나이 : ${this.age} `);
};
obj3.getInfo();

// 객체 디스트럭처링 : 객체의 프로퍼티를 풀어서 별개의 변수에 저장하는 방식
let person = {
  first: "홍",
  last: "길동",
};

let { first, last } = person;
console.log(first);
console.log(last);

// const 객체 생성
// 1) const로 선언할 경우 객체 자체를 변경할 수는 없다.
// 2) 객체 내부의 프로퍼티나 메서드는 변경이 가능하다.
const obj4 = {
  name: "김길동",
  age: 20,
  display: function () {
    console.log(this.name);
  },
};
obj4.name = "홍길동";
console.log(obj.name); // 홍길동
