// 생성자 함수를 이용한 객체 생성 -> 다수의 객체를 생성하기 위해서
// 생성자 함수라는 것을 식별하기 위해 앞글자를 대문자로
function Student(name, korean, math, english, science) {
  this.name = name;
  this.korean = korean;
  this.math = math;
  this.english = english;
  this.science = science;

  this.getSum = function () {
    return this.korean + this.math + this.english + this.science;
  };
  this.getAverage = function () {
    return this.getSum() / 4;
  };
  this.toString = function () {
    return `${this.name}\t${this.korean}\t${this.math}\t${this.english}\t${
      this.science
    }\t${this.getSum()}\t${this.getAverage()}`;
  };
}
// Student 객체 생성
let students = [];
students.push(new Student("홍길동", 95, 90, 80, 75));
students.push(new Student("임꺽정", 100, 95, 85, 80));
students.push(new Student("이순신", 85, 80, 70, 75));

for (let i in students) {
  console.log(students[i].toString());
}

// 퀴즈> Ractangle 생성자 함수를 만들고 사각형 넓이를 구해보자.
// (width, height, getArea())
function Rectangle(width, height) {
  this.width = width;
  this.height = height;
  this.getArea = function () {
    return this.width * this.height;
  };
}
let rectangle = new Rectangle(10, 20);
console.log(rectangle.getArea());
