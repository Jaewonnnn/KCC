$(function () {
  $(".quantity>input").change(function () {
    let totalCost = 0;
    let totalQuantity = 0;

    $("table tbody tr").each(function (index) {
      let price = parseFloat(
        $(this)
          .find(".price")
          .text()
          .replace(/^[^\d.]/, "")
      );
      price = isNaN(price) ? 0 : price;

      let quantity = parseInt($(this).find(".quantity>input").val());
      quantity = isNaN(quantity) ? 0 : quantity;

      let cost = price * quantity;

      $(this)
        .find(".cost")
        .text("$" + cost.toFixed(2)); // toFixed() : 소숫점 자르기

      totalCost += cost;
      totalQuantity += quantity;
      $(".subtotal .cost").text("$" + totalCost.toFixed(2));
      $(".shipping .quantity").text(totalQuantity);

      // tax, 배송료, 총금액 수정
      let tax = totalCost * 0.6;
      $(".tax .cost").text("$" + tax.toFixed(2));

      let shipping = totalQuantity * 2;
      $(".shipping .cost").text("$" + shipping.toFixed(2));

      let total = totalCost + tax + shipping;
      $(".total .cost").text("$" + total.toFixed(2));
    });
  });
});
