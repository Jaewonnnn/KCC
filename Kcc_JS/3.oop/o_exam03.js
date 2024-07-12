// Prototype

// __proto__ : 모든 객체에 존재하는 프로퍼티
// 내가 접근할 수 있는 부모 클래스를 결정
const testObj = {};
console.log(testObj.__proto__);

function IdolModel(name, year) {
  this.name = name;
  this.year = year;
}

// console.log(IdolModel.prototype);
// console.dir(IdolModel.prototype, {
//   showHidden: true,
// });
// 서로서로 참조중
console.log(IdolModel.prototype.constructor === IdolModel); // true
console.log(IdolModel.prototype.constructor === IdolModel.prototype); // false

const yuJin = new IdolModel("안유진", 2003);
console.log(yuJin.__proto__);
console.log(yuJin.__proto__ === IdolModel.prototype); // 생성자의 prototype과 생성자를 통해 생성된 객체의 __proto__와 같음

console.log(testObj.__proto__ === Object.prototype); // 모든 객체는 Object의 prototype을 가리킴

console.log(yuJin.toString()); // Object.prototype.toString()에 존재하기 때문에 가능
console.log(Object.prototype.toString());

console.log(IdolModel.__proto__ === Function.prototype);
console.log(Function.prototype.__proto__ === Object.prototype);
console.log(IdolModel.prototype.__proto__ === Object.prototype);

function IdolModel2(name, year) {
  this.name = name;
  this.year = year;

  this.sayHello = function () {
    return `${this.name}이 인사를 합니다.`;
  };
}
const yuJin2 = new IdolModel2("안유진", 2003);
const wonYoung2 = new IdolModel2("장원영", 2002);

console.log(yuJin2.sayHello());
console.log(wonYoung2.sayHello());
console.log(yuJin2.sayHello() === wonYoung2.sayHello()); // false 이 함수들의 메모리는 서로 다르다
console.log(yuJin2.hasOwnProperty("sayHello")); // true 메모리적으로 엄청 비효율적임

function IdolModel3(name, year) {
  this.name = name;
  this.year = year;
}
IdolModel3.prototype.sayHello = function () {
  return `${this.name}이 인사를 합니다.`;
};
const yuJin3 = new IdolModel3("안유진", 2003);
const wonYoung3 = new IdolModel3("장원영", 2002);

console.log(yuJin3.sayHello());
console.log(wonYoung3.sayHello());

console.log(yuJin3.sayHello === wonYoung3.sayHello); // true

console.log(yuJin3.hasOwnProperty("sayHello")); // false

function Student(name, korean, math, english, science) {
  this.name = name;
  this.korean = korean;
  this.math = math;
  this.english = english;
  this.science = science;
}
// Student.prototype.getSum = function () {
//   return this.korean + this.math + this.english + this.science;
// };
// Student.prototype.getAverage = function () {
//   return this.getSum() / 4;
// };
// Student.prototype.toString = function () {
//   return `${this.name}\t${this.korean}\t${this.math}\t${this.english}\t${
//     this.science
//   }\t${this.getSum()}\t${this.getAverage()}`;
// };
Student.prototype = {
  getSum: function () {
    return this.korean + this.math + this.english + this.science;
  },
  getAverage: function () {
    return this.getSum() / 4;
  },
  toString: function () {
    return `${this.name}\t${this.korean}\t${this.math}\t${this.english}\t${
      this.science
    }\t${this.getSum()}\t${this.getAverage()}`;
  },
};
let students = [];
students.push(new Student("홍길동", 95, 90, 80, 75));
students.push(new Student("임꺽정", 100, 95, 85, 80));
students.push(new Student("이순신", 85, 80, 70, 75));

for (let i in students) {
  console.log(students[i].toString());
}
