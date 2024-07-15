// 상속
class IdolModel {
  name;
  year;

  constructor(name, year) {
    this.name = name;
    this.year = year;
  }

  sayHello() {
    return `안녕하세요 ${this.name}입니다.`;
  }
}

class FemaleIdolModel extends IdolModel {
  part;
  constructor(name, year, part) {
    super(name, year);
    this.part = part;
  }

  dance() {
    return `여자 아이돌이 춤을 춥니다.`;
  }
  sayHello() {
    return `${super.sayHello()} 저는 ${this.part}을 맡고 있습니다.`;
  }
}

const yujin = new FemaleIdolModel("안유진", 2003, "보컬");
console.log(yujin);
console.log(yujin.dance());

// 부모타입
console.log(yujin instanceof FemaleIdolModel);
console.log(yujin instanceof IdolModel);

console.log(yujin.sayHello());
