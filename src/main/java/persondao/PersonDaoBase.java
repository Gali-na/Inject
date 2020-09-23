package persondao;

import java.util.List;
import model.Person;

public interface PersonDaoBase {
    public List<Person> getAll();

    void add(Person person);
}

