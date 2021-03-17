package org.mxn.architecture.tries.sm.model;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/9
 */
public class PlaysOffFactoryBean<T> {
    public PlaysOff<T> getPlaysOff(){
        return new PlaysOff<T>();
    }
}
