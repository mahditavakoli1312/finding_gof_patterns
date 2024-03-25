package business;

import java.util.List;

import model.Person;

public class SallaryReportCommand implements IReportCommand {

	@Override
	public Object execute(List<Person> list) {
		Long total = 0l;
		for (Person person : list) {
			total += person.getSalary();
		}
		return total;
	}

}
