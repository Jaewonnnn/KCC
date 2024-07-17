// Async / Await
const getPromise = (seconds) =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("완료");
    }, seconds * 1000);
  });

// async function runner() {
//   const result = await getPromise(3);
//   console.log(result);
// }

// runner();
// console.log("실행 끝");

// async function runner() {
//   const result1 = await getPromise(1);
//   console.log(result1);
//   const result2 = await getPromise(2);
//   console.log(result2);
//   const result3 = await getPromise(1);
//   console.log(result3);
// }
// runner();
// console.log("실행 끝");

function moneyLend(borrow) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (Math.random() < 0.1) {
        reject("채무자 파산");
      }
      resolve(borrow * 1.1);
    }, 1000);
  });
}

async function lend() {
  try {
    const lend1 = await moneyLend(10);
    const lend2 = await moneyLend(lend1);
    const lend3 = await moneyLend(lend2);
    const lend4 = await moneyLend(lend3);
    const lend5 = await moneyLend(lend4);

    console.log("대출 금액: " + lend5);
  } catch (e) {
    console.log(e);
  } finally {
    console.log("대금 종료");
  }
}
lend();
