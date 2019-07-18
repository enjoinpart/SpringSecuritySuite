package com.github.edu.base.utils;

import java.lang.reflect.Method;

/**
 * @author ：liming
 * @date ：2019/7/16 13:07
 * @description：
 */
public class EnumCodeOf {

    @SuppressWarnings("unchecked")
    public static <T> T codeOf(int code, Class<? extends Enum<?>> clazz){
        Method valuesMethod = getValuesMethod(clazz);
        Enum<?>[] values = invokeValues(clazz, valuesMethod);
        Method codeMethod = getCodeMethod(clazz);
        for(Enum<?> value: values){
            int codeNow = invokeCode(value, codeMethod);
            if(code == codeNow){
                return (T) value;
            }
        }
        throw new IllegalArgumentException("Invalid status code " + code + " in enum " + clazz);
    }


    private static Enum<?>[] invokeValues(Class<? extends Enum<?>> clazz, Method valuesMethod){
        try {
            return (Enum<?>[]) valuesMethod.invoke(null);
        } catch (Exception e) {
            //never happens...
            throw new RuntimeException("invoke " + clazz.getName() + "#values() error!!");
        }
    }

    private static int invokeCode(Enum<?> enums, Method codeMethod){
        try {
            return (Integer) codeMethod.invoke(enums);
        } catch (Exception e) {
            throw new RuntimeException("invoke " + enums.getClass().getName() + "#code():int error!");
        }
    }

    private static Method getValuesMethod(Class<? extends Enum<?>> clazz){
        try {
            return clazz.getDeclaredMethod("values");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("method " + clazz.getName() + "#values() required!! ");
        } catch (SecurityException e) {
            throw new RuntimeException("get method " + clazz.getName() + "#values() secrity exception!!");
        }
    }


    private static Method getCodeMethod(Class<? extends Enum<?>> clazz){
        Method codeMethod = null;
        NoSuchMethodException ex = null;
        try {
            codeMethod = clazz.getDeclaredMethod("code");
        } catch (NoSuchMethodException e) {
            ex = e;    //recovery next..
        } catch (SecurityException e) {
            throw new RuntimeException("getDeclaredMethod " + clazz.getName() + "#code() secrity exception!!");
        }

        if(codeMethod == null){
            try {
                codeMethod = clazz.getDeclaredMethod("getCode");
            } catch (NoSuchMethodException e) {
                ex = e;     //throw  next..
            } catch (SecurityException e) {
                throw new RuntimeException("getDeclaredMethod " + clazz.getName() + "#getCode() secrity exception!!");
            }

            if(codeMethod == null){
                throw new RuntimeException(clazz.getName() + "#getCode() or " + clazz.getName() + "#getCode() is required!!!" , ex);
            }
        }

        return codeMethod;
    }
}
