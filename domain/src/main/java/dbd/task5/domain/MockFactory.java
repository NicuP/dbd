package dbd.task5.domain;

import org.apache.commons.lang.RandomStringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/3/13
 * Time: 11:11 AM
 * User: nicu
 */
/*Currently works only for class having String and int fields or recursively to classes that decompose to such classes*/
public class MockFactory {
    private static Random random = new Random();
    private static long id;

    public static <T> List<T> mockMany(Class<T> tClass, int count) {
        List<T> list = new ArrayList<T>(count);
        for (int i = 0; i < count; i++) {
            list.add(mock(tClass));
        }
        return list;
    }

    public static <T> T mock(Class<T> aClass) {
        T t = null;
        try {
            if (aClass.isInterface()) {
                return t;
            }
            t = aClass.newInstance();
            for (Method method : aClass.getMethods()) {
                handleMethod(t, method);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    private static <T> void handleMethod(T t, Method method) throws IllegalAccessException, InvocationTargetException {
        if (isValidMethod(method)) {
            Class<?> classParameter = method.getParameterTypes()[0];
            Object value;
            if ("setId".equals(method.getName())) {
                value = id++;
            } else if (String.class.equals(classParameter)) {
                value = randomString();
            } else if (int.class.equals(classParameter) || Integer.class.equals((classParameter))) {
                value = randomInteger();
            } else if (boolean.class.equals(classParameter) || Boolean.class.equals((classParameter))) {
                value = random.nextBoolean();
            } else if (Date.class.equals(classParameter)) {
                value = random.nextBoolean();
            } else if (List.class.equals(classParameter)) {
                value = Collections.emptyList();
            }else {
                value = mock(classParameter);
            }
            if (t != null) {
                method.invoke(t, value);
            }
        }
    }

    private static boolean isValidMethod(Method method) {
        return method.getName().startsWith("set") &&
                method.getParameterTypes().length == 1 &&
                !method.isSynthetic();
    }

    private static String randomString() {
        return RandomStringUtils.randomAlphanumeric(7);
    }

    private static Integer randomInteger() {
        return random.nextInt(12345678);
    }
}
