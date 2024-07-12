// 인스턴스 __proto__ 변경
function IdolModel(name, year) {
  this.name = name;
  this.year = year;
}
IdolModel.prototype.sayHello = function () {
  return `${this.name}이 인사를 합니다.`;
};

function FemaleIdolModel(name, year) {
  this.name = name;
  this.year = year;

  this.dance = function () {
    return `${this.name}이 춤을 춥니다.`;
  };
}

const gaEul = new IdolModel("가을", 2004);
const ray = new FemaleIdolModel("레이", 2004);

console.log(gaEul.__proto__);
console.log(gaEul.__proto__ === IdolModel.prototype);

console.log(gaEul.sayHello());
console.log(ray.dance());

// console.log(ray.sayHello()); // sayHello() 메서드가 없기 때문에 에러 발생
Object.setPrototypeOf(ray, IdolModel.prototype);
console.log(ray.sayHello());

console.log(ray.__proto__.constructor === IdolModel); // true

console.log(gaEul.constructor === IdolModel); // true
console.log(FemaleIdolModel.prototype === IdolModel.prototype); // false

// 함수의 prototype 변경
FemaleIdolModel.prototype = IdolModel.prototype;

const eSeo = new FemaleIdolModel("이서", 2007);
console.log(Object.getPrototypeOf(eSeo) === FemaleIdolModel.prototype); // true
console.log(Object.getPrototypeOf(eSeo) === IdolModel.prototype); // true
console.log(FemaleIdolModel.prototype === IdolModel.prototype); // true
