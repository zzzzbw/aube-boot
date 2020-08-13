package com.github.zzzzbw.aube.service.impl;

import com.github.zzzzbw.aube.common.exception.BaseException;
import com.github.zzzzbw.aube.common.exception.NotFoundException;
import com.github.zzzzbw.aube.common.service.impl.CrudService;
import com.github.zzzzbw.aube.dao.UserMapper;
import com.github.zzzzbw.aube.model.dto.UserDTO;
import com.github.zzzzbw.aube.model.dto.req.UserCreateReq;
import com.github.zzzzbw.aube.model.dto.req.UserUpdateReq;
import com.github.zzzzbw.aube.model.entity.User;
import com.github.zzzzbw.aube.service.UserService;
import com.github.zzzzbw.aube.web.starter.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by zzzzbw
 * @since 2020/08/10 10:56
 */
@Slf4j
@Service
public class UserServiceImpl extends CrudService<UserMapper, User> implements UserService {

    @Override
    public UserDTO getDto(long id) {
        User user = getById(id);
        if (null == user) {
            throw new NotFoundException(String.format("不存在id为[%s]的用户", id));
        }
        return new UserDTO().convertFrom(user);
    }

    @Log
    @Transactional
    @Override
    public void createByReq(UserCreateReq req) {
        User user = req.convertTo();
        save(user);
    }

    @Log
    @Transactional
    @Override
    public void updateByReq(Long id, UserUpdateReq req) {
        User user = getById(id);
        if (null == user) {
            throw new NotFoundException(String.format("不存在id为[%s]的用户", id));
        }
        req.updateTo(user);
        updateById(user);
    }

    @Log
    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!removeById(id)) {
            throw new BaseException(String.format("删除id为[%s]的用户失败", id));
        }
    }
}
