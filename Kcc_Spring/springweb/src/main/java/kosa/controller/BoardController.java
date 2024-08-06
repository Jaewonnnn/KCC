package kosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosa.model.Board;
import kosa.model.BoardDao;

@Controller
public class BoardController {

	@Autowired
	private BoardDao dao;

//	@RequestMapping("/board_insert")
//	public ModelAndView boardInsert() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("insert_form");
//		
//		return mav;
//	}

//	String 형식으로도 사용 가능
	@GetMapping("/board_insert")
	public String board_form() {
		return "insert_form";
	}

	// 직접 JSP를 호출하는 것은 바람직하지 않다.
	// 일반적으로 JSP는 DispatcherServlet을 통해 호출되어야 JSP가 정상적으로 작동한다.
	@PostMapping("/board_insert")
	public String board_insert(Board board) {
		// form에서 input태그의 name과 객체의 변수명이 동일해야 한다!!
		System.out.println(board);
		dao.insertBoard(board);
		// insert, update, delete는 데이터를 전달받아야 하기 때문에 forward가 아니라 redirect 해야 한다.
		return "redirect:board_list";
	}

	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list);
		return "list";
	}
	
//	@GetMapping("/board_detail")
//	public String board_datail(@RequestParam("seq") int seq, Model model) {
//		Board board = dao.detailBoard(seq);
//		model.addAttribute("board", board);
//		
//		return "detail";
//	}
	@GetMapping("/board_detail{seq}")
	public String board_datail(@PathVariable int seq, Model model) {
		Board board = dao.detailBoard(seq);
		model.addAttribute("board", board);
		
		return "detail";
	}
}
