// 호이스팅
// 함수를 let변수에 넣었기 때문에 add2에서 Cannot access 'add2' before initialization 발생
// console.log(add(10, 20));
// console.log(add2(10, 20));

// 선언적 함수 (함수선언문)
function add(a, b) {
  return a + b;
}

// 익명 함수(함수 표현식) : 함수명 대신 변수에 함수를 할당하는 함수
// 변수 안에 함수를 넣을 수 있으며 변수를 함수처럼 사용 가능
let add2 = function (a, b) {
  return a + b;
};

// add2  VS  add2()
let plus = add2; // 함수의 주소값이 할당됨
let plus2 = add2(10, 20); // 함수의 실행 결과(리턴값)가 할당

console.log(plus(50, 100));
console.log(plus2);
console.log("===========================");

// 함수의 파라미터에 함수를 전달할 수 있다. (콜백 함수)
let foo = function (func) {
  if (typeof func === "function") {
    func();
  }
};
foo(function () {
  console.log("파라미터 함수");
});

// 함수가 함수를 리턴할 수 있다.
// 함수를 리턴하는 예제와 함께 리턴된 함수를 호출해 보자.
let foo2 = function () {
  return function () {
    console.log("함수를 리턴하는 예제");
  };
};
let box = foo2();
box();

// 함수의 파라미터에 (plus or minus) 호출
// plus => plus 기능을 하는 함수를 리턴
// minus => minus 기능을 하는 함수를 리턴
// let func2 = function(number){
//   if(number >= 0){
//     return function(b){
//       return number + b;
//     }
//   }else{
//     return function(b){
//       return number - b;
//     }
//   }
// }
// let plus3 = func2(10);
// let minus2 = func2(10);
// console.log(plus3(20));
// console.log(minus2(-20));
function call(mode) {
  let obj = {
    plus: function (left, right) {
      return left + right;
    },
    minus: function (left, right) {
      return left - right;
    },
  };
  return obj[mode];
}
let func2 = call("plus");
console.log(func2(10, 20));

// 콜백함수(함수의 파라미터에 전달되는 함수)
// function sortAscending(a, b) {
//   if(a > b) return 1;
//   else if(a < b) return -1;
//   else return 0;
// }
function sortAscending(a, b) {
  return a - b; // 오름차순
  // return b - a; // 내림차순
}
let arr = [10, 20, 30, 321, 2];
console.log(arr.sort(sortAscending));

// 즉시 실행 함수
(function (a, b) {
  console.log(a + b);
})(10, 5);
