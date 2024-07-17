// promise

// const timeoutPromise = new Promise((resolve, reject) => {
//   setTimeout(() => {
//     resolve("완료");
//   }, 2000);
// });

// timeoutPromise.then((res) => {
//   console.log("----then----");
//   console.log(res);
// });

// ---------------resolve---------------
const getPromise = (seconds) =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("완료");
    }, seconds * 1000);
  });

Promise.all([getPromise(1), getPromise(4), getPromise(1)]).then((res) =>
  console.log(res)
);
// getPromise(3)
//   .then((res) => {
//     console.log("---------then--------");
//     console.log(res);
//     return getPromise(3);
//   })
//   .then((res) => {
//     console.log("---------then--------");
//     console.log(res);
//   });

// -------------------reject---------------------
// const getPromise = (seconds) =>
//   new Promise((resolve, reject) => {
//     setTimeout(() => {
//       reject("에러");
//     }, seconds * 1000);
//   });
// getPromise(3)
//   .then((res) => {
//     console.log("---------then--------");
//     console.log(res);
//   })
//   .catch((err) => {
//     console.log("---------catch--------");
//     console.log(err);
//   })
//   .finally(() => {
//     console.log("finally");
//   });

// 과제> 빌린 돈에 대해 원금 + 이자(10%)에 대한 상환금액을 비동기식으로 구현하시오
// const borrow = 20;
// const payWith10perc = (seconds) =>
//   new Promise((resolve, reject) => {
//     setTimeout(() => {
//       const total = borrow * 1.1;
//       resolve(total);
//     }, seconds * 1000);
//   });

// payWith10perc(1).then((res) => console.log(res));

// console.log("완료");
