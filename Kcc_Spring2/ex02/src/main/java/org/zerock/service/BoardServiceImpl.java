package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper; //mapper을 통한 묵시적 객체주입 (스프링4.3이후)
	
	@Override
	public void register(BoardVO board) {
		log.info("register........");
		mapper.insertSelectKey(board);
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList..........");
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) { //페이징처리
		log.info("getList..........");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get.......................");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..................");
		return mapper.update(board) == 1; //int가 넘어오므로 1이면 true (boolean일경우)
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..................");
		return mapper.delete(bno) == 1; //int가 넘어오므로 1이면 true (boolean일경우)
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	
}
