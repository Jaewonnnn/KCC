$(function() {
	$('#selected-plays > li').addClass('horizontal');

	// $('#selected-plays > li li').addClass('sub-level');
	$('li:not(.horizontal)').addClass('sub-level');

	$('a[href^=mailto]').addClass('mailto');
	$('a[href$=pdf]').addClass('pdflink');
//	$('a[href*=henry]:not(.mailto)').addClass('henrylink');
	$('a[href*=henry]').not('.mailto').addClass('henrylink');
	
//	$('table tr:odd').addClass('alt'); // 짝수번째
//	$('tr:nth-child(odd').addClass('alt');
	$('tr').filter(':odd').addClass('alt');
	
//	$('td:contains(Henry)').addClass('highlight');
//	$('td:contains(사극), td:contains(1596), td:contains(1599)').addClass('highlight');
//	$('td:contains(Henry)').nextAll().addClass('highlight');
//	$('td:contains(Henry)').nextAll().andSelf.addClass('highlight'); // 이전 집합 포함
//	$('td:contains(Henry)').parent().find('td').addClass('highlight');
	$('td:contains(Henry)').parent().find('td:first').addClass('highlight')
	.end().find('td:eq(1)').addClass('highlight');
	
	
	//each() => 배열을 받아서 각각의 작업을 수행
	// $.each(배열, function(index, item){ 배열의 각 요소 작업 수행 })
	// $('선택자').each(function(index,item){ 각 요소들의 작업 수행})
	
	
});