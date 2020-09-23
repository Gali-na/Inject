package lib;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import persondao.PersonDaoBase;
import persondao.PersonDaoBaseImpl;

public class InjectorForPeople {
    public static Object getInstance(Class clazz) throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if (f.getAnnotation(Inject.class) != null) {
                Class interfacesFild = f.getType();
                if (interfacesFild.equals(PersonDaoBase.class)) {
                    f.setAccessible(true);
                    f.set(instance, new PersonDaoBaseImpl());
                }
            }
        }
        return instance;
    }
}
