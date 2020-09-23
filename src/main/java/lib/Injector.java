package lib;

import dao.BetDao;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import org.reflections.Reflections;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();

        Reflections reflections = new Reflections("dao");
        Set<Class<?>> subtypes = reflections.getTypesAnnotatedWith(Dao.class);
        Class newClazz = subtypes.iterator().next();

        Constructor constructor1 = newClazz.getDeclaredConstructor();
        Object instance1 = constructor1.newInstance();

        for (Field f : fields) {
            if (f.getAnnotation(Inject.class) != null) {
                Class interfacesFild = f.getType();
                if (interfacesFild.equals(BetDao.class)) {
                    f.setAccessible(true);
                    f.set(instance, constructor1.newInstance());
                }
            }
        }
        return instance;
    }
}

