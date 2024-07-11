// console.log(5 == 5); // true
// console.log(5 == '5'); // true
// console.log(5 === '5'); // false
// console.log(0 == ''); // true
// console.log(true == 1); // true

// for ~ in VS for ~ of
const gildong = {
  name : '홍길동',
  year : 2000,
  company : 'kcc'
}
// for ~ in : key값을 가짐
for(let key in gildong){
  console.log(key);
  console.log(gildong[key]);
}
const kccMember = ['노승우', '김상학', '황철원', '송예림'];
for(let key in kccMember){
  // console.log(key);
  console.log(`${key} : ${kccMember[key]}`);
}
console.log("==================================");
// for ~ of : value값을 가짐
for(let value of kccMember){
  console.log(value);
}

console.log('Cat' || 'Dog'); // Cat
// 'Cat'자체가 true이기 때문

let event = '';

event = event || '영화보기';
console.log(event); // 영화보기
// event가 false이기 때문

if(event){
  console.log("놀기");
}else{
  console.log("일하기");
}


