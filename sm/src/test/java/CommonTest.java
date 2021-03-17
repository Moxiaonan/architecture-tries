import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mxn.architecture.tries.sm.biz.HelloBiz;
import org.mxn.architecture.tries.sm.controller.HelloController;
import org.mxn.architecture.tries.sm.entity.StarResume;
import org.mxn.architecture.tries.sm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.SharedSecrets;
import sun.reflect.ConstantPool;
import sun.reflect.annotation.AnnotationParser;
import sun.reflect.annotation.AnnotationType;

import javax.annotation.security.PermitAll;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationFormatError;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2020/11/25
 */
public class CommonTest {
    @Autowired
    HelloBiz helloBiz;
    @Test
    public void split(){
        String str = "get one  billion   dollar";
        String[] split = StringUtils.split(str,StringUtils.SPACE);
        for (String s : split) {
            System.out.println(String.format("{%s}",s));
        }
    }
    @Test
    public void optional(){
        List<User> a = Arrays.asList(new User(1, "a"));
        User a1 = Optional.ofNullable(a).map(lu -> lu.get(1)).orElseGet(() -> new User(0, "default"));
        System.out.println(a1);
    }
    @Test
    public void endBeginDay(){
        DateUtil.endOfDay(new Date());
    }

    @Test
    public void testOpt(){
        User u = new User();
        u.setName("f");
        User u2 = null;
        String nb = Optional.ofNullable(u).map(User::getName).orElse("nb");
        String nb2 = Optional.ofNullable(u2).map(User::getName).orElse("nb");
        System.out.println(nb);
        System.out.println(nb2);
    }

    @Test
    public void cia(){
        ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();
        map.put("a",new User(2,"b"));
        User a = map.computeIfAbsent("a", key -> {
            return new User(1, key);
        });
        System.out.println(a);
    }

    @Test
    public void getAno(){
        Class<HelloController> controllerClass = HelloController.class;
        Method[] declaredMethods = controllerClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            try {
                declaredMethod.setAccessible(true);
                Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations();
                Field annotations = declaredMethod.getClass().getDeclaredField("annotations");
                Object anoBytes = null;
                byte[] bytes = null;
                annotations.setAccessible(true);
                anoBytes = annotations.get(declaredMethod);
                bytes = (byte[]) anoBytes;
                ConstantPool constantPool = SharedSecrets.getJavaLangAccess().
                        getConstantPool(declaredMethod.getDeclaringClass());

                LinkedHashMap anoMap = new LinkedHashMap();
                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
                int var6 = byteBuffer.getShort() & '\uffff';
                int anoStartPos = 0;
                int anoEndPos = 0;
                for(int var7 = 0; var7 < var6; ++var7) {
                    Method[] apMethods = AnnotationParser.class.getDeclaredMethods();
                    Method parseAnnotation2Method = null;
                    for (Method apMethod : apMethods) {
                        if (apMethod.getName().equals("parseAnnotation2")) {
                            parseAnnotation2Method = apMethod;
                        }
                    }
                    int positionBefore = byteBuffer.position();
                    parseAnnotation2Method.setAccessible(true);
                    Annotation ano = (Annotation) parseAnnotation2Method.invoke(null, byteBuffer, constantPool, declaredMethod.getDeclaringClass(), false, null);
                    if (ano != null) {
                        Class anoType = ano.annotationType();
                        if (AnnotationType.getInstance(anoType).retention() == RetentionPolicy.RUNTIME && anoMap.put(anoType, ano) != null) {
                            throw new AnnotationFormatError("Duplicate annotation for class: " + anoType + ": " + ano);
                        }
                    }
                    int positionAfter = byteBuffer.position();
                    if (ano.annotationType().equals(PermitAll.class)) {
                        anoStartPos = positionBefore;
                        anoEndPos = positionAfter;
                        if (positionAfter == bytes.length) {
                            anoEndPos = bytes.length + 1;
                        }
                    }
                    System.out.println("dda");
                }
                if (anoStartPos > 0 && anoEndPos > anoStartPos) {
                    int newLength = bytes.length - anoEndPos + anoStartPos;
                    byte[] newArr = new byte[newLength];
                    int newArrPos = 0;
                    for (int i = 0; i < bytes.length; i++) {
                        if ((i < anoStartPos || i >= anoEndPos) && newArrPos < newLength) {
                            newArr[newArrPos] = bytes[i];
                            newArrPos++;
                        }

                    }
                    System.out.println(newArr);
                    annotations.set(declaredMethod,newArr);

                    Field declaredAnnotationsField = declaredMethod.getClass().getSuperclass().getDeclaredField("declaredAnnotations");
                    declaredAnnotationsField.setAccessible(true);
                    Map<Class<? extends Annotation>, Annotation> annotationMap = (Map<Class<? extends Annotation>, Annotation>) declaredAnnotationsField.get(declaredMethod);
                    annotationMap.remove(PermitAll.class);

                    Annotation[] afterAno = declaredMethod.getAnnotations();
                    System.out.println(afterAno);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void getShort(){
        byte[] bytes = {2, 1,1,2,1,3,1,4};
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        short aShort = wrap.getShort();
        int i = aShort & '\uffff';
        System.out.println(aShort + "----" + i);
    }

    @Test
    public void testT(){
        try {
            Field declaredFields = StarResume.class.getDeclaredField("champions");
            Type genericType = declaredFields.getGenericType();
            if (genericType instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) genericType;
                Type[] actualTypeArguments = pType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testZero(){
        System.out.println(String.format("%06d",22));
    }

    @Test
    public void testClassT(){

    }
}
