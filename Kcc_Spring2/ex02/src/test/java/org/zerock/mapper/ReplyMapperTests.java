package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //스프링 컨테이너 생성
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	private Long[] bnoArr = {5L, 6L, 7L, 8L, 9L};

	@Test
	@Ignore
	public void test() {
		log.info(mapper);
	}
	
	@Test
	@Ignore
	public void testCreate() {
		IntStream.range(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("reply " + i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	@Ignore
	public void testRead() {
		Long targetRno = 2L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	
	@Test
	@Ignore
	public void testDelete() {
		Long tergetRno = 2L;
		mapper.delete(tergetRno);
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Long targetRno = 3L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply........");

		int count = mapper.update(vo);
		log.info("update count : " + count);	
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}

}
