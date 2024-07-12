// 함수를 호출할 때 함수의 파라미터 갯수가 일치하지 않아도오류가 발생하지 않는다.
function add(a, b, c) {
  console.log(a, b, c);
}
add(10, 20); // 10 20 undefined
add(10, 20, 30, 40); // 10 20 30

//argments
function sumAll() {
  let sum = 0;
  for (let i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  return sum;
}
console.log(sumAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

// 함수 파라미터에 기본값 설정
function calculate(total, tex = 0.1, tip = 0.2) {
  return total + total * tex + total * tip;
}

console.log(calculate(100, 0.1, 0.1)); // 파라미터로 값을 넣어줄 때는 기본값 무시
console.log(100); // 파라미터 값이 없을 때는 기본값

// 화살표 함수
var greeting = function (name) {
  return "Hello " + name;
};
console.log(greeting("홍길동"));

var greeting2 = (name) => {
  return "Hello " + name;
};
console.log(greeting2("홍길동"));

function multiply(x) {
  return function (y) {
    return function (z) {
      return `x:${x} y:${y} z:${z}`;
    };
  };
}

const multiply2 = (x) => (y) => (z) => `x:${x} y:${y} z:${z}`;
console.log(multiply(10)(20)(30));
console.log(multiply2(10)(20)(30));

// 1. 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 함수 작성
function solution(n) {
  let sum = 0;
  while (n > 0) {
    sum += n % 10;
    n = Math.floor(n / 10);
  }
  return sum;
}
console.log(solution(930211));

// 2. 문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수 작성
function solution2(my_string) {
  return my_string
    .split("")
    .filter((v) => !isNaN(v))
    .map((v) => +v)
    .sort((a, b) => a - b);
}
console.log(solution2("hi12392"));
/**
 * 3.년도 인자만 받을 경우 "1234년"과 같은 문자열을 리턴,
 * 년도, 월 인자를 받을 경우 "1234년 5월" 과 같은 문자열 리턴 ,
 * 년도, 월, 일 인자를 전부 받을 경우 "1234/5/6"과 같은 형식의 문자열을 리턴하는 solution함수 작성
 */
function solution3(...args) {
  if (args.length === 1) {
    return `${args[0]}년`;
  } else if (args.length === 2) {
    return `${args[0]}년 ${args[1]}월`;
  } else {
    return `${args[0]}/${args[1]}/${args[2]}`;
  }
}

console.log(solution3(1234));
console.log(solution3(1234, 5));
console.log(solution3(1234, 5, 6));
