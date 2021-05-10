package org.mxn.architecture.tries.sm.model;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/18
 */
public interface Nets <T>{
    T slogan(String json) throws ClassNotFoundException, JsonProcessingException;
}
