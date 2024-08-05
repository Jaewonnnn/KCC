$(function(){
	// 1. <ol id = "note"></ol> => 생성해서 <div id = 'footer'> 앞에 위치하도록
//	$('#footer').before('<ol id = "note"></ol>');
	$('<ol id = "note"></ol>').insertBefore('#footer');
	
	// 2. <span class = "footnote"> 앞에 <a id=""> [1] ....
	// 3. <ol>태그 자식으로 <span> 이동
	
	//부모가 앞에 오면 append / 자식이 앞에 오면 appendTo
	$('.footnote').each(function(index){
		$(this).before('<a id="context-'+ (index+1) +'">['+(index+1)+']</a>')
		.appendTo($('#note')).append(`&nbsp;<a href="#context-${index+1}">gogo</a>`)
		.wrap('<li></li>')
	})
});