package com.github.zzzzbw.aube.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.zzzzbw.aube.model.dto.UserDTO;
import com.github.zzzzbw.aube.model.dto.req.UserCreateReq;
import com.github.zzzzbw.aube.model.dto.req.UserPageReq;
import com.github.zzzzbw.aube.model.dto.req.UserUpdateReq;
import com.github.zzzzbw.aube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author by zzzzbw
 * @since 2020/08/07 9:48
 */
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public UserDTO get(@PathVariable long id) {
        return userService.getDto(id);
    }

    @GetMapping
    public IPage<UserDTO> page(UserPageReq req) {
        return userService.pageDto(req);
    }

    @PostMapping
    public void create(@RequestBody UserCreateReq req) {
        userService.createByReq(req);
    }

    @PutMapping("{id:\\d+}")
    public void update(@PathVariable("id") Long id, @RequestBody UserUpdateReq req) {
        userService.updateByReq(id, req);
    }

    @DeleteMapping("{id:\\d+}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
