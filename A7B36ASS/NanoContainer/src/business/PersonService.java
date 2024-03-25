package business;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Person;

import org.exolab.castor.xml.Unmarshaller;

public class PersonService implements IPersonService {

	private static final String PERSON_XML = "person.xml";

	@SuppressWarnings("unchecked")
	public List<Person> getPersonList() {
		try {
			FileReader reader = new FileReader(PERSON_XML);
			return (List<Person>) Unmarshaller.unmarshal(ArrayList.class,
					reader);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
		return null;
	}

}
