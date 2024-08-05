package kosa.mapper;

import java.util.List;
import java.util.Map;

import kosa.model.Board;
import kosa.model.Search;

public interface BoardMapper {
	List<Board> listBoard(Search search); //이 메소드명은 id명과 일치해야만 한다.
	/* List<Board> listBoard(Map map); */
	
	Board detailBoard(int seq); //상세보기 -> 글번호 전달을 위한 파라미터 값
	int insertBoard(Board board); //글쓰기
		
	int updateBoard(Board board); //글 수정
}
