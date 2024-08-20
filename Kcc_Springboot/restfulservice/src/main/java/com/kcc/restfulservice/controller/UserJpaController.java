//package com.kcc.restfulservice.controller;
//
//import com.kcc.restfulservice.service.UserDaoService;
//import com.kcc.restfulservice.bean.Post;
//import com.kcc.restfulservice.bean.User;
//import com.kcc.restfulservice.exception.UserNotFoundException;
//import com.kcc.restfulservice.repository.PostRepository;
//import com.kcc.restfulservice.repository.UserRepository;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/jpa")
//public class UserJpaController {
//
//    private final UserDaoService userDaoService;
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
//
//    @GetMapping("/users")
//    public List<User> retrieveAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user == null) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        } //user가 없을경우 예외발생
//
//        //===============spring HATEOUS================
//        EntityModel entityModel = EntityModel.of(user);
//
//        WebMvcLinkBuilder LinkTo =
//                linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        entityModel.add(LinkTo.withRel("all-users"));
//
//        return entityModel;
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
//        User savedUser = userRepository.save(user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id) {
//        userRepository.deleteById(id);
//    }
//
//    @GetMapping("/users/{id}/posts")
//    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.isEmpty()) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        return user.get().getPosts();
//    }
//
//    @PostMapping("/users/{id}/posts")
//    public ResponseEntity<String> createPostForUser(@PathVariable int id, @RequestBody Post post) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (!user.isPresent()) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//        //post.setUser(user.get());
//
//        postRepository.save(post);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @GetMapping("/users/{id}/posts/{postId}")
//    public ResponseEntity<Post> retrievePostForUser(@PathVariable int id, @PathVariable int postId) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (!user.isPresent()) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        Optional<Post> post = postRepository.findById(postId);
//
//        if (!post.isPresent()) {
//            throw new UserNotFoundException(String.format("Post ID[%s] not found", postId));
//        }
//
//        return new ResponseEntity<>(post.get(), HttpStatus.OK);
//    }
//}
