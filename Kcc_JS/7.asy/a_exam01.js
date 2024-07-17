// // 비동기식(async)
// function longWork() {
//   const now = new Date();
//   const milliseconds = now.getTime();
//   const afterTwoSeconds = milliseconds + 2 * 1000;

//   while (new Date().getTime() < afterTwoSeconds) {}

//   console.log("완료");
// }

// // 동기식 프로그램
// console.log("Hello");
// longWork();
// console.log("world");

// 비동기식 프로그램
// function longWork() {
//   setTimeout(() => {
//     console.log("완료");
//   }, 2000);
// }
// console.log("Hello");
// longWork();
// console.log("world");

function waitAndRun() {
  setTimeout(() => {
    console.log("1");
    setTimeout(() => {
      console.log("2");
      setTimeout(() => {
        console.log("3");
      }, 2000);
    }, 2000);
  }, 2000);
}

waitAndRun();
