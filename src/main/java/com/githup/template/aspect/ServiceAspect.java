package com.githup.template.aspect;

import com.alibaba.dubbo.common.json.JSON;
import com.githup.template.common.ResultCode;
import com.githup.template.common.ServiceException;
import com.githup.template.util.ValidatorUtil;
import com.zhubajie.common.dto.BaseResult;
import com.zhubajie.common.dto.Request;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 服务调用切面,主要功能：参数校验、异常结果封装
 * @author: wufenyun
 * @date: 2018-06-13 11
 **/
@Aspect
@Component
public class ServiceAspect {

    private final static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    @Pointcut("execution(* com.github.template.module.*.*ServiceImpl.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            //参数校验
            paramValidate(pjp.getArgs(),((MethodSignature) pjp.getSignature()).getParameterTypes());
            //调用服务
            Object result = pjp.proceed();
            return result;
        } catch (Throwable t) {
            logger.error("入参{}", JSON.json(pjp.getArgs()));
            logger.error(t.getMessage(),t);

            Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
            Object obj = returnType.newInstance();
            //粗暴一点，如果返回类型not instanceof BaseResult,则直接抛出原始错误
            if(!(obj instanceof BaseResult)) {
                return t;
            }

            if(t instanceof IllegalArgumentException) {
                return returnErrorResult((BaseResult)obj,t.getMessage());
            } else if(t instanceof ServiceException) {
                return returnErrorResult((BaseResult)obj,((ServiceException) t).getCode(),t.getMessage());
            } else {
                return returnErrorResult((BaseResult)obj, ResultCode.SERVER_ERROR.getCode(),ResultCode.SERVER_ERROR.getDescription());
            }
        }
    }

    /*
    * 参数校验，强制要求是参数instanceof Request
     */
    private void paramValidate(Object[] args,Class[] paramTypes) throws IllegalArgumentException {
        if((null == args) || (args.length!=1) || (args[0]==null)) {
            throw new IllegalArgumentException("请求参数对象为空");
        }

        if(!(args[0] instanceof Request)) {
            throw new IllegalArgumentException("请求参数对象类型不对");
        }

        Request request = (Request)args[0];

        if(request.getData() == null) {
            throw new IllegalArgumentException("请求参数对象data不能为空");
        }

        ValidatorUtil.validate(request.getData());
    }


    private BaseResult returnErrorResult(BaseResult result,String message) {
        return returnErrorResult(result,null,message);
    }

    private BaseResult returnErrorResult(BaseResult result,String code,String message) {
        result.setDescription(message);
        result.setSuccess(false);
        result.setCode(code);
        return result;
    }
}