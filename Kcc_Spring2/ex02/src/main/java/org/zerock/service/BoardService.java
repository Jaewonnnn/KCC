package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService { //�븯�굹�쓽 �꽕怨꾨룄 �뿭�븷�쓣 �빐以��떎. (硫붾돱�뼹) -> �씪愿��꽦怨� �룆由쎌꽦 �쑀吏�
	public void register(BoardVO board);
	
//	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);//�럹�씠吏뺤쿂由�
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public int getTotal(Criteria cri);
}
