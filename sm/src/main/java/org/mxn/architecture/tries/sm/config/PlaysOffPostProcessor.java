package org.mxn.architecture.tries.sm.config;

import cn.hutool.core.util.StrUtil;
import org.mxn.architecture.tries.sm.model.PlaysOff;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/3/9
 */
//@Configuration
//@Order
public class PlaysOffPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);

//            ScannedGenericBeanDefinition scannedGenericBeanDefinition = (ScannedGenericBeanDefinition) beanDefinition;
//            String beanClassName = scannedGenericBeanDefinition.getBeanClassName();
            String beanClassName = beanDefinition.getBeanClassName();
            if (StrUtil.isBlank(beanClassName)) {
                System.out.println(beanDefinition.toString());
            }else {
                try {
                    Class<?> beanClass = Class.forName(beanClassName);
                    Field[] declaredFields = beanClass.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
                        if (declaredField.getDeclaredAnnotation(Autowired.class) != null) {
                            if (declaredField.getType() == PlaysOff.class) {
                                Type genericType = declaredField.getGenericType();
                                if (genericType instanceof ParameterizedType) {
                                    ParameterizedType pType = (ParameterizedType) genericType;
                                    Type[] actualTypeArguments = pType.getActualTypeArguments();
                                    Type actualTypeArgument = actualTypeArguments[0];

                                    RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(PlaysOff.class, () -> {
                                        PlaysOff championPlaysOff = new PlaysOff();
                                        if (actualTypeArgument instanceof ParameterizedTypeImpl){
                                            ParameterizedTypeImpl argImpl = (ParameterizedTypeImpl) actualTypeArgument;
                                            if (argImpl.getRawType().equals(List.class)) {
                                                championPlaysOff.setClazz(new ArrayList<>());
                                            }
                                        }else {
                                            Class<?> aClass = null;
                                            try {
                                                aClass = Class.forName(actualTypeArgument.getTypeName());
                                            } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            Object o = null;
                                            try {
                                                o = aClass.newInstance();
                                            } catch (InstantiationException e) {
                                                e.printStackTrace();
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                            championPlaysOff.setClazz(o);
                                        }
                                        return championPlaysOff;
                                    });
//                                    RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(PlaysOff.class);
                                    ResolvableType resolvableType = ResolvableType.forField(declaredField);
                                    rootBeanDefinition.setTargetType(resolvableType);
                                    registry.registerBeanDefinition(PlaysOff.class.getName() + "$" +actualTypeArgument.getTypeName(),rootBeanDefinition);
                                }
                            }
                        }
    //                    for (Annotation declaredAnnotation : declaredAnnotations) {
    //                        if (declaredAnnotation.annotationType() == Autowired.class) {
    //                        }
    //                    }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
//            if (beanDefinition instanceof ScannedGenericBeanDefinition) {
//            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
