$(document).ready(function () {
  $(".quantity").on("input change", function () {
    const quantityInput = $(this);
    const cartItem = quantityInput.closest(".cart-item");

    if (quantityInput.val() <= 0) {
      cartItem.find('input[type="checkbox"]').prop("checked", false);
    } else {
      cartItem.find('input[type="checkbox"]').prop("checked", true);
    }

    calculateTotalPrice();
  });

  $(".remove").click(function () {
    $(this).closest(".cart-item").remove();
    calculateTotalPrice();
  });

  $('input[type="checkbox"]').change(function () {
    calculateTotalPrice();
  });

  function calculateTotalPrice() {
    let total = 0;
    $(".cart-item").each(function () {
      if ($(this).find('input[type="checkbox"]').is(":checked")) {
        const price = parseInt(
          $(this)
            .find(".price")
            .text()
            .replace(/,/g, "")
            .replace("원", "")
            .trim()
        );
        const quantity = parseInt($(this).find(".quantity").val());
        total += price * quantity;
      }
    });
    $("#total-price").text(total.toLocaleString());
    $(".checkout").text(
      `구매하기 (${$('.cart-item:has(input[type="checkbox"]:checked)').length})`
    );
  }

  calculateTotalPrice();
});
