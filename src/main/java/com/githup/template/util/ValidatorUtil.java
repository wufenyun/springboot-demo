package com.githup.template.util;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @description: 参数校验工具类
 * @author: wufenyun
 * @date: 2018-06-13 13
 **/
public class ValidatorUtil {
    /**
     * 使用hibernate的注解来进行验证
     *
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 〈注解验证参数〉
     *
     * @param obj
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            throw new IllegalArgumentException(String.format("参数校验未通过:%s", constraintViolations.iterator().next().getMessage()));
        }
    }
}