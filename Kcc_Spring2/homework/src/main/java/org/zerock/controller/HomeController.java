package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.CartItem;
import org.zerock.domain.Users;
import org.zerock.service.CartService;
import org.zerock.service.HomeService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/home")
@Log4j
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String mainPage() {
        log.info("login page called");
        return "login";
    }

    @PostMapping("/login")
    public String login(Users loginUser, HttpSession session, Model model) {
        log.info("id: " + loginUser.getUserId() + " / password: " + loginUser.getPassword());

        Users user = homeService.getUser(loginUser);
        if (user != null && user.getUserId().equals(loginUser.getUserId()) && user.getPassword().equals(loginUser.getPassword())) {
            session.setAttribute("username", loginUser.getUserId()); // 세션에 사용자 ID 저장
            return "redirect:/home/add";
        } else {
            log.info("로그인 실패");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(Users signupUser) {
        homeService.signUp(signupUser);
        return "redirect:/home/";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
    }

    @PostMapping("/addToCart")
    public String addToCart(String product, HttpSession session, Model model) {
        String userId = (String) session.getAttribute("username");
        log.info("cart: " + product + " user: " + userId);
        if (userId != null) {
            CartItem cart = new CartItem();
            cart.setUserId(userId);
            cart.setProductName(product);
            cartService.addToCart(cart);
        }
        model.addAttribute("cartItems", cartService.getCartItems(userId));
        return "viewCart";
    }

    @GetMapping("/viewCart")
    public String viewCart(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("username");
        if (userId != null) {
            model.addAttribute("cartItems", cartService.getCartItems(userId));
        }
        return "viewCart";
    }
}
