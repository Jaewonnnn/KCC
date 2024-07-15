// Array
let kccMembers = ["진아", "수호", "한희", "채원", "주언", "연호"];
console.log(kccMembers);

// push() : 배열 마지막에 엘리먼트 추가 후 리스트 길이 반환
console.log(kccMembers.push("승언")); // 7
console.log(kccMembers);

// pop() : 배열 마지막 엘리먼트 제거 후 제거한 엘리먼트 반환
console.log(kccMembers.pop()); // 승언
console.log(kccMembers);

// shift() : 배열 첫 번째 엘리먼트 제거 후 제거한 엘리먼트 반환
console.log(kccMembers.shift());
console.log(kccMembers);

// unshift() : 배열 첫 번째에 엘리먼트 추가 후 리스트 길이 반환
console.log(kccMembers.unshift("현민"));
console.log(kccMembers);

// splice() : 0 ~ 3 까지 잘라서 반환
console.log(kccMembers.splice(0, 3));

// 불변성 함수
kccMembers = ["진아", "수호", "한희", "채원", "주언", "연호"];
console.log(kccMembers);

// concat() :
console.log(kccMembers.concat("승우")); // concat()한 결과를 리턴
console.log(kccMembers); // 원본은 그대로

// slice() : 0 ~ 3 까지지 잘라서 반환
console.log(kccMembers.slice(0, 3));
console.log(kccMembers); // 원본은 그대로

// spread()
let kccMembers2 = [...kccMembers];
console.log(kccMembers2);

let kccMembers3 = kccMembers;
console.log(kccMembers3);

// 서로 같은 값을 참조하고 있기 때문에 kccMembers의 값이 수정되면 kccMembers3의 값도 수정됨.
console.log(kccMembers === kccMembers3); // true
// spread는 서로 다른 주소를 참조하고 있기 때문에 연관이 없음.
console.log(kccMembers === kccMembers2); // false

let kccMembers4 = ["홍길동", "박길동", ...kccMembers, "조길동", "한길동"];
console.log(kccMembers4);

let arr1 = [100, 200, 300];

function sum(a, b, c) {
  return a + b + c;
}

console.log(sum(...arr1)); // 600

// join() : 배열의 모든 엘리먼트를 연결해 하나의 문자열로 변환
console.log(kccMembers.join()); // 진아,수호,한희,채원,주언,연호
console.log(kccMembers.join(" / ")); // 진아 / 수호 / 한희 / 채원 / 주언 / 연호

// sort() : 배열을 정렬
console.log(kccMembers.sort()); // 오름차순
console.log(kccMembers.reverse()); // 내림차순

let numbers = [1, 8, 3, 2, 6];
console.log(numbers.sort((a, b) => a - b)); // 오름차순
console.log(numbers.sort((a, b) => b - a)); // 내림차순

const book = [
  {
    name: "이것이 자바다",
    price: 30000,
    publisuer: "한빛미디어",
  },
  {
    name: "스프링 정석",
    price: 35000,
    publisuer: "길벗",
  },
  {
    name: "도커의 완성",
    price: 20000,
    publisuer: "이지스퍼블릭",
  },
];
// 이름을 기준으로 오름차순
book.sort((a, b) => (a.name > b.name ? 1 : -1));

// forEach
book.forEach((a) =>
  console.log(
    `책이름 : ${a.name}, 책가격 : ${a.price}, 출판사 : ${a.publisuer}`
  )
);
// for in
for (let i in book) {
  console.log(
    `책이름 : ${book[i].name}, 책가격 : ${book[i].price}, 출판사 : ${book[i].publisuer}`
  );
}
// for of
for (let i of book) {
  console.log(
    `책이름 : ${i.name}, 책가격 : ${i.price}, 출판사 : ${i.publisuer}`
  );
}

// filter : 조건에 만족하는 것 전부 출력
numbers = [1, 8, 7, 4, 9];
console.log(numbers.filter((x) => x % 2 === 0)); // 8,4

// find : 조건에 만족하는 것 중 하나만 출력(첫 번째)
console.log(numbers.find((x) => x % 2 === 0)); // 8

// findIndex : 조건에 만족하는 것의 인덱스(위치) 출력(? 번째)
console.log(numbers.findIndex((x) => x % 2 === 0)); // 1

// reduce() :
console.log(numbers.reduce((prev, curr) => prev + curr, 0));

// 퀴즈 > iveMembers 변수에 있는 모든 스트링 값들을 더해 보자.

let iveMembers = ["유진", "가을", "레이", "원영", "리즈", "이서"];
console.log(iveMembers.reduce((p, n) => p + n.length, 0));

console.log(iveMembers.join(" "));
