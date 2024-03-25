package business;

import model.Person;
import java.util.List;

public interface IReportCommand {
	public Object execute(List<Person> list);
}
