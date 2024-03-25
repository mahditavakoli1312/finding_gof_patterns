package business;

import java.util.List;

import model.Person;

public class MarriedReportCommand implements IReportCommand {

	@Override
	public Object execute(List<Person> list) {
		Long total = (long) list.size();
		Long married = 0l;
		for (Person person : list) {
			if (person.getMarried()) {
				married += 1;
			}
		}
		return married + "/" + total;
	}

}
