package org.mxn.architecture.tries.sm.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/18
 */
public class NetsManager <T> implements Nets<T>{
    @Override
    public T slogan(String json) throws ClassNotFoundException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Type[] genericInterfaces = this.getClass().getGenericInterfaces();
        Class aClass = null;
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type actualTypeArgument = actualTypeArguments[0];
                aClass = Class.forName(actualTypeArgument.getTypeName());
                System.out.println(actualTypeArgument);
            }
        }
        return (T) objectMapper.readValue(json,aClass);
    }
}
