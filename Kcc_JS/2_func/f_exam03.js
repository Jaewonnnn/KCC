// 함수의 실행 컨텍스트
// Lexical Scope : 선언된 위치가 상위 스코프를 결정한다. => JavaScript
// Dynamic Scope : 실행한 위치가 상위 스코프를 결정한다.
// let var1 = 10;

// // 상위 스코프에 있는 변수를 쓸 수 있음
// function func() {
//   let var2 = 20;
//   console.log(var1);
// }
// func();

// 함수가 선언된 스코프의 변수가 우선순위를 가짐
// let value = "value1";
// function printFunction() {
//   let value = "value2";
//   function printValue() {
//     return value;
//   }
//   console.log(printValue()); // value2
// }
// printFunction();

let value = "value1";

function printValue() {
  return value;
}

function printFunction(func) {
  let value = "value2";
  console.log(func());
}
printFunction(printValue); // value1

console.log("=========================");

var numberThree = 3;

function functionOne() {
  var numberThree = 100;
  functionTwo();
}

function functionTwo() {
  console.log(numberThree);
}

functionOne(); // 3

console.log("=========================");

// var i = 999;

// for (var i = 0; i < 10; i++) {
//   console.log(i);
// }

// console.log(i);

let i = 999;

for (let i = 0; i < 10; i++) {
  console.log(i);
}

console.log(i);

console.log("=========================");

var var3 = 100;

function func3() {
  var var3 = 200;
  console.log(var3);
}

func3();
console.log(var3);
