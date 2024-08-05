// $(function () {
//   //리스트안의 모든 댓글 목록 보여지게 하기
//   // $(window).on("load", function () {});
// });

$(function() {
	// 댓글 작성
	$("form").submit(function(event) {
		event.preventDefault(); // 기본 제출 동작 방지
		const title = $("input[name=title]").val();
		const writer = $("input[name=writer]").val();
		const contents = $("input[name=contents]").val();

		// AJAX POST 요청
		$.ajax({
			type : "POST",
			url : "server.jsp",
			data : {title, writer, contents}, // data를 객체로 직접 전달
			success : function(response) {
				console.log(response);

				// JSON 응답 처리
				$.each(response, function(index, item) {
					
					$('#list').empty();
					let html = "<div class='container'>";
					html += "<p>title : " + item.title + "</p>";
					html += "<p>writer : " + item.writer + "</p>";
					html += "<p>contents : " + item.contents + "</p>";
					html += "<button class='delete'>delete</button>";
					html += "</div>";
					
					$('#list').append(html);
				});

				// 삭제 버튼 클릭 시 이벤트 처리
				$(".delete").off("click").on("click", function() {
					$(this).parent().remove(); // 해당 댓글 삭제
				});
			},
		});
	});

	// 입력 값 변화 시 로그 출력
	$("input").change(function() {
		const title = $("input[name=title]").val();
		const writer = $("input[name=writer]").val();
		const contents = $("input[name=contents]").val();

		console.log(title);
		console.log(writer);
		console.log(contents);
	});
});
