package com.github.zzzzbw.aube;

import com.github.zzzzbw.aube.model.dto.UserDTO;
import com.github.zzzzbw.aube.model.dto.req.UserCreateReq;
import com.github.zzzzbw.aube.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/10 14:03
 */
@Slf4j
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void getDto() {
        UserDTO user = userService.getDto(1);
        log.info("{}", user);
    }

    @Test
    public void updateByDto() {
        UserCreateReq build = UserCreateReq.builder()
                .birthday(new Date())
                .name("13")
                .build();
        userService.createByReq(build);
    }
}
