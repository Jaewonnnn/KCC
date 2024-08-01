package kosa.mapper;

import java.util.List;
import java.util.Map;

import kosa.model.Board;

public interface BoardMapper {
	List<Board> listBoard(Map search);
	Board detailBoard(int seq);
	int insertBoard(Board board);
	int updateBoard(Board board);
}
