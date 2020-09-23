package persondao;

import db.StorageForPerson;
import java.util.List;
import model.Person;

public class PersonDaoBaseImpl implements PersonDaoBase {
    @Override
    public List<Person> getAll() {

        return StorageForPerson.people;
    }

    @Override
    public void add(Person person) {

        StorageForPerson.people.add(person);
    }
}
