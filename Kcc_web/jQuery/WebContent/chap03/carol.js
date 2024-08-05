// step1
//$(function(){
//	$("#switcher-large").on('click', function(){
//		$('body').addClass('large');
//	})
//});

// step2 => Large Print를 누르면 스타일이 large가 적용되도록
// narrow Column버튼을 누르면 스타일이 naroow가 적용되도록
// Default 버튼을 누르면 처음 스타일이 적용되도록
// addClass('클래스명') / removeClass('클래스명')
//$(function(){
//	$('#switcher-default').on('click', function(){
//		$('body').removeClass();
//	})
//	$('#switcher-narrow').on('click', function(){
//		$('body').removeClass().addClass('narrow');
//	})
//	$("#switcher-large").on('click', function(){
//		$('body').removeClass().addClass('large');
//	})
//});

// step3 : 클릭한 버튼만 selected 스타일이 적용되도록 수정 
//$(function(){
//	$('#switcher-default').on('click', function(){
//		$('body').removeClass();
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	})
//	$('#switcher-narrow').on('click', function(){
//		$('body').removeClass().addClass('narrow');
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	})
//	$("#switcher-large").on('click', function(){
//		$('body').removeClass().addClass('large');
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	})
//});

// step4 : selected 관련된 중복 코드를 최적화 하자
//$(function(){
//	$('#switcher-default').on('click', function(){
//		$('body').removeClass();
//	});
//	$('#switcher-narrow').on('click', function(){
//		$('body').removeClass().addClass('narrow');
//	});
//	$("#switcher-large").on('click', function(){
//		$('body').removeClass().addClass('large');
//	});
//	
//	$('#switcher .button').on('click', function(){
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//	});
//});

// step5 : 전체 최적화
//$(function(){	
//	$('#switcher .button').on('click', function(){
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//		$('body').removeClass();
//		
//		if(this.id === 'switcher-large'){
//			$('body').addClass('large');
//		}else if(this.id === 'switcher-narrow'){
//			$('body').addClass('narrow');
//		}
//	});
//});

// step6 : 이벤트 통합 함수 사용(on) => 개별 이벤트 함수(click)
//$(function(){	
//	$('#switcher .button').click(function(){
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//		$('body').removeClass();
//		
//		if(this.id === 'switcher-large'){
//			$('body').addClass('large');
//		}else if(this.id === 'switcher-narrow'){
//			$('body').addClass('narrow');
//		}
//	});
//});

// step7
$(function(){
	$('#switcher .button').hover(function(){
		$(this).addClass('hover');
	}, function(){
		$(this).removeClass('hover');
	})
});

// step8 : <h3>스타일 변환기</h3>를 클릭했을 때 모든 버튼을 화면에서 사라지게 하자
//$(function(){
//	$('#switcher>h3').click(function(){
//		$('#switcher .button').toggleClass('hidden');
////		$('#switcher .button').toggle();
//	})
//	
//	$('#switcher .button').click(function(){
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//		$('body').removeClass();
//		
//		if(this.id === 'switcher-large'){
//			$('body').addClass('large');
//		}else if(this.id === 'switcher-narrow'){
//			$('body').addClass('narrow');
//		}
//	});
//});

// step9 : 이벤트 버블링 차단
//$(function(){
//	$('#switcher').click(function(){
//		$('#switcher .button').toggleClass('hidden');
////		$('#switcher .button').toggle();
//	})
//	
//	$('#switcher .button').click(function(event){
//		$('.button').removeClass('selected');
//		$(this).addClass('selected');
//		$('body').removeClass();
//		
//		if(this.id === 'switcher-large'){
//			$('body').addClass('large');
//		}else if(this.id === 'switcher-narrow'){
//			$('body').addClass('narrow');
//		}
//		event.stopPropagation();
//	});
//});

// step10 : 통합 함수 on 함수로 변경 -> off('click') -> 이벤트 해제
// large, narrow 버튼을 클릭 후에는 버튼이 사라지게 하는 이벤트를 해제
$(function(){
	$('#switcher').on('click.kcc', function(){
		$('#switcher .button').toggleClass('hidden');
//		$('#switcher .button').toggle();
	})
	
	$('#switcher .button').on('click', function(event){
		$('.button').removeClass('selected');
		$(this).addClass('selected');
		$('body').removeClass();
		
		if(this.id === 'switcher-large'){
			$('body').addClass('large');
		}else if(this.id === 'switcher-narrow'){
			$('body').addClass('narrow');
		}
		event.stopPropagation();
		
//		$('#switcher').off('click');
	});
	
	$('#switcher').on('click.kosa', function(){
		alert('다른 이벤트 발생');
	});
	
	$('#switcher-large, #switcher-narrow').click(function(){
		$('#switcher').off('click.kcc');
	});
	
	$('#switcher').trigger('click.kcc');
});

