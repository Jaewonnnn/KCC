package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor //보드컨트롤러에는 service가 필요 (autowire가 있다면 필요없음)
public class BoardController {// 기본페이지
	private BoardService service;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register") //post방식은 데이터값이 넘어온다.
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno()); //글번호 가져오기
		
		return "redirect:/board/list"; //그냥 list가 아니라 controller를 거쳐야한다. -> 그러므로 redirect를 해야한다. 
	}
	
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list................");
//		model.addAttribute("list", service.getList()); //DB에서 데이터가져오기
//		
//	}
	
	@GetMapping("/list") //페이징 처리 매핑
	public void list(Criteria cri, Model model) {
		log.info("list................");
		model.addAttribute("list", service.getList(cri)); 
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
		
	}
	
	@GetMapping({"/get","/modify"}) //글번호에 대한 board객체를 필요로한다. /get과 /modify둘 모두 동일하게 가능하기 때문에 같이 작성
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri")  Criteria cri, Model model) { //void -> url이 곧 view의 이름이다. 
		//ModelAttribute로 cri로 만들어서 get.jsp로 받을 수 있게 바꿔주기
		log.info("/get or /modify..........");
		model.addAttribute("board", service.get(bno)); //
		//BoardController에서 데이터값을 받아서 그대로 보내준다.
	}
	//@ModelAttribute("cri")  Criteria cri -> 이걸 이용해서 다른페이지로 넘어가도 데이터를 유지시킨다.
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri")  Criteria cri, RedirectAttributes rttr) { //return 받아야하니 String
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum()); //데이터값 유지
		rttr.addAttribute("amout", cri.getAmount());
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri")  Criteria cri, RedirectAttributes rttr) { //글번호 가져와서 삭제하기
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum()); //데이터값 유지
		rttr.addAttribute("amout", cri.getAmount());
		return "redirect:/board/list";
	}
	
}
