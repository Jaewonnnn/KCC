// 과제1 > 1. Rectangle 생성자함수를 class 기반으로 수정하세요
// 2. 상속을 이용해서 Squere도 구현해 보세요.
class Ractangle {
  width;
  height;

  constructor(width, height) {
    this.width = width;
    this.height = height;
  }

  getArea = function () {
    return this.width * this.height;
  };
}
class Square extends Ractangle {
  constructor(width) {
    super(width, width);
  }
}
const newRectangle = new Ractangle(10, 20);
console.log(newRectangle.getArea()); // 200
const newSquare = new Square(10);
console.log(newSquare.getArea()); // 100

// map : 배열 내용을 가공하고 싶을 때
let iveMembers = ["유진", "가을", "레이", "원영", "리즈", "이서"];
console.log(iveMembers.map((x) => x));
console.log(iveMembers.map((x) => `아이브: ${x}`));

console.log(
  iveMembers.map((x) => {
    if (x === "유진") {
      return `아이브: ${x}`;
    } else {
      return x;
    }
  })
);
