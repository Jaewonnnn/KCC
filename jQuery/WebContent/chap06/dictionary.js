// step1 : HTML
$(function () {
  $("#letter-a a").click(function () {
    $("#dictionary")
      .hide()
      .load("a.html", function () {
        $(this).fadeIn(1000);
      });
    // a태그 기본 이벤트 해제
    return false;
  });
});

//step 2_1
$(function () {
  $("#letter-b a").click(function () {
    $.ajax({
      url: "b.json",
      dataType: "json",
      success: function (data) {
        $("#dictionary").empty();
        data.sort(function (a, b) {
          if (a.term < b.term) return 1;
          else if (a.term > b.term) return -1;
          else return 0;
        });
        $.each(data, function (index, item) {
          let html = '<div class = "entry">';
          html += '<h3 class = "term">' + item.term + "</h3>";
          html += '<div class = "part">' + item.part + "</div>";
          html += '<div class = "definition">' + item.definition + "</div>";
          html += "</div>";
          $("#dictionary").append(html);
        });
      },
    });
    return false;
  });
});

// step2 : JSON
// $(function () {
//   $("#letter-b a").click(function () {
//     // 반드시 json은 HTML으로 파싱해야 하기 때문에 콜백함수가 필요
//     $.getJSON("b.json", function (data) {
//       // data는 json파일의 내용
//       $("#dictionary").empty();
//       // 결과값 : 배열 => [{},{},{}] => HTML
//       $.each(data, function (index, item) {
//         // 객체 하나하나가 item에 담는다.
//         let html = '<div class = "entry">';
//         html += '<h3 class = "term">' + item.term + "</h3>";
//         html += '<div class = "part">' + item.part + "</div>";
//         html += '<div class = "definition">' + item.definition + "</div>";
//         html += "</div>";
//         $("#dictionary").append(html);
//       });
//     });
//     return false;
//   });
// });

// step3 : javascript
$(function () {
  $("#letter-c a").click(function () {
    $.getScript("c.js");
    return false;
  });
});

// step4 : XML
$(function () {
  $("#letter-d a").click(function () {
    $.get("d.xml", function (data) {
      $("#dictionary").empty();
      $(data)
        .find("entry")
        .each(function (index) {
          $entry = $(this);
          let html = '<div class = "entry">';
          html += '<h3 class = "term">' + $entry.attr("term") + "</h3>";
          html += '<div class = "part">' + $entry.attr("part") + "</div>";
          html +=
            '<div class = "definition">' +
            $entry.find("definition").text() +
            "</div>";
          html += "</div>";
          $("#dictionary").append(html);
        });
    });
    return false;
  });
});

// step5 : jsp
$(function () {
  $("#letter-e a").click(function () {
    $.get("server3.jsp", { term: $(this).text() }, function () {
      $("#dictionary").text(data);
    });
    return false;
  });
});

// step6 : jsp
$(function () {
  $("#letter-f a").click(function () {
    $.ajax({
      url: "server3.jsp",
      type: "POST",
      data: $(this).serialize(),
      dataType: "text",
      success: function (data) {
        $("#dictionary").text(data);
      },
    });
    return false;
  });
});
