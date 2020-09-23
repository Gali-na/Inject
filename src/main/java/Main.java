import controller.ConsoleHendler;
import controller.ConsoleHendlerForPerson;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;
import lib.InjectorForPeople;

public class Main {
    public static void main(String[] args) throws
            NoSuchMethodException,
            SecurityException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        ConsoleHendler handler = (ConsoleHendler) Injector.getInstance(ConsoleHendler.class);
        System.out.println("Введiть value та risk для вашої ставки ");
        handler.handle();
        System.out.println("Введiть name та surname для реєстрації вашої ставки ");
        ConsoleHendlerForPerson consoleHendlerForPerson =
                (ConsoleHendlerForPerson) InjectorForPeople
                .getInstance(ConsoleHendlerForPerson.class);
        consoleHendlerForPerson.handle();
    }
}
