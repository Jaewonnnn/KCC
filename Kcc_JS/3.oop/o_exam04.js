// class 기반의 객체지향 프로그래밍.
class IdolModel {
  name;
  year;

  constructor(name, year) {
    this.name = name;
    this.year = year;
  }
}

console.log(new IdolModel("안유진", 2003));

// # : private
class IdolModel2 {
  #name;
  #year;

  constructor(name, year) {
    this.#name = name;
    this.#year = year;
  }

  set name(name) {
    this.#name = name;
  }
  get name() {
    return this.#name;
  }
  set year(year) {
    this.#year = year;
  }
  get year() {
    return this.#year;
  }

  static returnGroupName() {
    return "아이브";
  }
}

let yujin = new IdolModel2("안유진", 2003);
console.log(yujin.name);
yujin.name = "장원영";
console.log(yujin.name);
console.log(IdolModel2.returnGroupName()); // static이기 때문에 class 이름으로 호출

// factory constructor
class IdolModel3 {
  name;
  year;

  constructor(name, year) {
    this.name = name;
    this.year = year;
  }

  static fromObject(obj) {
    return new IdolModel3(obj.name, obj.year);
  }

  static fromList(list) {
    return new IdolModel3(list[0], list[1]);
  }
}

const yujin2 = IdolModel3.fromObject({ name: "안유진", year: 2003 });
console.log(yujin2);
const wonYoung = IdolModel3.fromList(["장원영", 2002]);
