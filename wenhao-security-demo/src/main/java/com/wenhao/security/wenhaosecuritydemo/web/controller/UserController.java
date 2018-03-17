package com.wenhao.security.wenhaosecuritydemo.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wenhao.security.wenhaosecuritydemo.dto.User;
import com.wenhao.security.wenhaosecuritydemo.dto.UserQueryCondition;
import com.wenhao.security.wenhaosecuritydemo.exception.UserNotExistException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /*@RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam(value = "username", required = true, defaultValue = "wenhao") String username) {
        System.out.println(username);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }*/

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() + "    " + error.getDefaultMessage();
                System.out.println(message);
            });
        }
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @JsonView(User.userSimplView.class)
    @GetMapping
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 1, size = 10, sort = "age ,desc") Pageable pageable) {
        System.out.println(condition);
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }


    @JsonView(User.userDetailsView.class)
    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable(name = "id", required = false) String id) {

        //throw new UserNotExistException(id);
        //throw new RuntimeException(id);
        System.out.println(id);
        System.out.println("调用服务");
        User user = new User();
        user.setUsername("tom");
        return user;

    }
}
