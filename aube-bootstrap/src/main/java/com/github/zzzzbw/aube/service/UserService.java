package com.github.zzzzbw.aube.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.zzzzbw.aube.common.service.ICrudService;
import com.github.zzzzbw.aube.model.dto.UserDTO;
import com.github.zzzzbw.aube.model.dto.req.UserCreateReq;
import com.github.zzzzbw.aube.model.dto.req.UserPageReq;
import com.github.zzzzbw.aube.model.dto.req.UserUpdateReq;
import com.github.zzzzbw.aube.model.entity.User;

/**
 * @author by zzzzbw
 * @since 2020/08/10 10:55
 */
public interface UserService extends ICrudService<User> {
    UserDTO getDto(long id);

    IPage<UserDTO> pageDto(UserPageReq req);

    void createByReq(UserCreateReq req);

    void updateByReq(Long id, UserUpdateReq req);

    void deleteById(Long id);
}
