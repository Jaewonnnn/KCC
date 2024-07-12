/**
 * 함수 클로저
 * => 함수 호출 이후에도 함수의 실행 컨텍스트 영역을 유지
 */

// 원래 outerFunc()이 완료되면 x는 사라져야 하지만, innerFunc에서 계속 사용중이기 때문에 x가 유지됨.
function outerFunc() {
  let x = 10;
  var innerFunc = function () {
    console.log(x);
  };
  return innerFunc;
}

let inner = outerFunc();
inner(); // 10

// 데이터 캐싱
function cashFunction(newNumb) {
  // 아주 오래 소요하는 작업이 있다고 가정
  var number = 10 * 10;
  return number * newNumb;
}
console.log(cashFunction(10));
console.log(cashFunction(20));
// 문제점 : 이 함수를 호출할 때 마다 오래된 작업을 계속해서 수행해야 함.

function cashFunction2() {
  var number = 10 * 10;

  function innerCashFunction(newNumb) {
    // number가 이미 저장되어 있으므로 1번만 오래걸리는 작업을 수행하면 됨.
    return number * newNumb;
  }
  return innerCashFunction;
}

const runner = cashFunction2(); // 1번만 수행
console.log(runner(30));
console.log(runner(40));

function outer(arg1, arg2) {
  function inner(innerArg) {
    console.log((arg1 + arg2) / innerArg);
  }
  return inner;
}
// var innerFn = outer(10, 20);
// innerFn(2);
// 위의 2줄을 1줄로 사용 가능
outer(10, 20)(2);
