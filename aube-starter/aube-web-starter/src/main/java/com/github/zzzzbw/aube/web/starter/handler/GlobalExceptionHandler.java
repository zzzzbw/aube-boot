package com.github.zzzzbw.aube.web.starter.handler;


import com.github.zzzzbw.aube.common.constants.Consts;
import com.github.zzzzbw.aube.common.constants.Response;
import com.github.zzzzbw.aube.common.constants.ResponseCodes;
import com.github.zzzzbw.aube.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/*
  常见异常处理并返回相应错误码
  SpringMVC自定义异常对应的status code
  Exception                               HTTP Status Code
  ConversionNotSupportedException         500 (Internal Server Error)
  HttpMessageNotWritableException         500 (Internal Server Error)
  HttpMediaTypeNotSupportedException      415 (Unsupported Media Type)
  HttpMediaTypeNotAcceptableException     406 (Not Acceptable)
  HttpRequestMethodNotSupportedException  405 (Method Not Allowed)
  NoHandlerFoundException                 404 (Not Found)
  TypeMismatchException                   400 (Bad Request)
  HttpMessageNotReadableException         400 (Bad Request)
  MissingServletRequestParameterException 400 (Bad Request)
 */

/**
 * 全局异常处理
 *
 * @author by zzzzbw
 * @since 2020/4/1 22:50
 */
@Slf4j
@RestControllerAdvice(Consts.PACKAGE.BASE)
public class GlobalExceptionHandler {

    /**
     * 参数绑定对象时候抛出的异常
     */
    @ExceptionHandler(value = BindException.class)
    public Response<Response.EmptyData> handleBindException(BindException ex) {
        log.error(ex.getMessage());
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return Response.fail(ResponseCodes.BAD_REQUEST.getCode(), defaultMsg.get(0));
    }

    /**
     * 单个参数校验
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response<Response.EmptyData> handleBindGetException(ConstraintViolationException ex) {
        log.error(ex.getMessage());
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return Response.fail(ResponseCodes.BAD_REQUEST.getCode(), defaultMsg.get(0));
    }


    @ExceptionHandler(BaseException.class)
    public Response<Response.EmptyData> baseException(BaseException e) {
        log.error(e.getMsg(), e);
        return Response.fail(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Response<Response.EmptyData> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR.getCode(), ResponseCodes.INTERNAL_SERVER_ERROR.getMsg());
    }


    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Response<Response.EmptyData> runtimeExceptionHandler(HttpServletRequest req, HttpServletResponse rep, RuntimeException re) {
        log.error("---RuntimeException Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), re.getMessage(), re);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Response<Response.EmptyData> nullPointerExceptionHandler(HttpServletRequest req, HttpServletResponse rep, NullPointerException ex) {
        log.error("---NullPointerException Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public Response<Response.EmptyData> classCastExceptionHandler(HttpServletRequest req, HttpServletResponse rep, ClassCastException ex) {
        log.error("---classCastException Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    /**
     * IO异常
     */
    @ExceptionHandler(IOException.class)
    public Response<Response.EmptyData> classCastExceptionHandler(HttpServletRequest req, HttpServletResponse rep, IOException ex) {
        log.error("---classCastException Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    /**
     * 未知方法异常
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public Response<Response.EmptyData> noSuchMethodExceptionHandler(HttpServletRequest req, HttpServletResponse rep, NoSuchMethodException ex) {
        log.error("---noSuchMethodException Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    /**
     * 数组越界异常
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Response<Response.EmptyData> indexOutOfBoundsExceptionHandler(HttpServletRequest req, HttpServletResponse rep, IndexOutOfBoundsException ex) {
        log.error("---indexOutOfBoundsException Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    /**
     * 400相关异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class, TypeMismatchException.class, MissingServletRequestParameterException.class})
    public Response<Response.EmptyData> request400(HttpServletRequest req, HttpServletResponse rep, Exception ex) {
        log.error("---request400 Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    /**
     * 404异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Response<Response.EmptyData> request404(HttpServletRequest req, HttpServletResponse rep, Exception ex) {
        log.error("---request404 Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    /**
     * 405相关异常
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Response<Response.EmptyData> request405(HttpServletRequest req, HttpServletResponse rep, Exception ex) {
        log.error("---request405 Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage());
    }

    /**
     * 406相关异常
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public Response<Response.EmptyData> request406(HttpServletRequest req, HttpServletResponse rep, Exception ex) {
        log.error("---request406 Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
    }

    /**
     * 500相关异常
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public Response<Response.EmptyData> server500(HttpServletRequest req, HttpServletResponse rep, Exception ex) {
        log.error("---server500 Handler---Host {}, invokes url {},  ERROR: {}", req.getRemoteHost(), req.getRequestURL(), ex.getMessage(), ex);
        return Response.fail(ResponseCodes.INTERNAL_SERVER_ERROR);
    }
}
