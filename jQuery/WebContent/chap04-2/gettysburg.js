$(function(){
	$('div.label').click(function(){
		// width는 패딩, 마진값이 빠져있음 -> outerWidth 사용
		const pWidth = $('div.speech p').outerWidth();
		const divWidth = $('#switcher').outerWidth();
		
		console.log(pWidth + ": " + divWidth);
		
		const num = parseInt(pWidth) - parseInt(divWidth);
		
		$('#switcher')
		.fadeTo('fast', 0.5)
		.animate({marginLeft: num}, 'slow')
		.fadeTo('fast', 0.5)
		.slideUp('slow', function(){
			$(this).css('background', 'red')
		})
		.slideDown('slow');
	});
});

$(function(){
	// 2번째 p태그를 화면에서 숨김 : hide()
	// <a>reade more => 클릭 : 사라진 p태크 화면 보임
	// slideUp() + slideDown() => slideToggle()
	// read more => 클릭 => read less / read less => 클릭 => read more
	// text(값) : 텍스트 값 변경, text() : 텍스트 값 추출

	$('.speech>p:eq(1)').hide();
	$('.more').click(function(){
		if($(this).text() === 'read more'){
			$('.speech>p:eq(1)').slideToggle('slow');
			$(this).text('read less');
		}else{
			$('.speech>p:eq(1)').slideToggle('slow');
			$(this).text('read more');
		}
	});
})

// Bigger => 기존 폰트 크기 1.2배 커지도록
// Smaller => 기존 폰트 크기 1.2배 작아지도록
// Default => 처음 글자 크기
// css('fontSize') => 기존 폰트 크기 리턴, css('fontSize('12px')) => 폰트 크기 수정
$(function(){
	const defaultSize = parseFloat($('p').css('fontSize'));
	
	$('#switcher #switcher-default').click(function(){
		$('p').animate({'fontSize': `${defaultSize}px`}, 'slow');
	});
	$('#switcher #switcher-large').click(function(){
		$('p').animate({'fontSize': `${defaultSize * 1.2}px`}, 'slow');
	});
	$('#switcher #switcher-small').click(function(){
		$('p').animate({'fontSize': `${defaultSize * 0.8}px`}, 'slow');
	});
});

