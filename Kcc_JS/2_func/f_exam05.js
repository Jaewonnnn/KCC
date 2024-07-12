// 디자인패턴
let replyService = (function () {
  function create() {
    console.log("create");
  }
  function update() {
    console.log("update");
  }
  function getList(param, callback) {
    let data = "결과값" + param;
    callback(data);
  }

  return {
    create: create,
    update: update,
    getList: getList,
  };
})();

function show() {
  // replyService.create();
  // replyService.update();
  replyService.getList(" KOSA", function (result) {
    console.log("내가 원하는 형태의 출력 : " + result);
  });
}

show();

// ==============================================

function orderService(item, price, quantity, callback) {
  console.log("커피 주문");
  // 주문 관련 서비스 구현
  let result = price * quantity;
  callback(result);
}

function order() {
  orderService("아메리카노", 1500, 2, function (result) {
    console.log("최종가격: " + result);
  });
}

order();
