package org.mxn.architecture.tries.sm.model;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/9
 */
public class PlaysOff<T> {
    T clazz;
    public String getTypeName(){
        return clazz.getClass().getTypeName();
    }

    public T getClazz() {
        return clazz;
    }

    public void setClazz(T clazz) {
        this.clazz = clazz;
    }
}
