package ru.kupchenkov;


import java.lang.reflect.Field;

public class LoginProcessor {

    private LoginProcessor(){}

    public static void startProcess(LoginExample exampleObject) throws NoSuchFieldException, IllegalAccessException {
        if (exampleObject == null) throw new IllegalArgumentException();
        Class classOfObject = exampleObject.getClass();
        Field login = null;
        Field name = null;
        final Field[] fields = classOfObject.getDeclaredFields();
        for(Field field : fields){
            if (field.getName().equals("name")) name = field;
            final Login annotation = field.getAnnotation(Login.class);
            if (annotation != null){
                login = field;
            }
        }
        if (login == null || name == null) throw new NoSuchFieldException();
        login.setAccessible(true);
        name.setAccessible(true);
        login.set(exampleObject, new StringBuffer(name.get(exampleObject).toString()).reverse().toString());
    }

}
