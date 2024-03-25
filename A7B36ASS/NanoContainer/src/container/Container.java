package container;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.ReportController;
import view.page.Page;
import view.page.PersonListPage;
import view.page.ReportPage;
import business.IPersonService;
import business.MarriedReportCommand;
import business.PersonService;
import business.SallaryReportCommand;


public class Container {
	
	public static Map<String, Object> context = new HashMap<String, Object>();
	public static List<Page> pages = Arrays.asList(new Page[]{new PersonListPage(),new ReportPage()});
	

	private static void bootstrap() {
		// bootstrap normally in XML
		IPersonService personService = new PersonService();
		context.put("personService", personService);
		
		ReportController controller = new ReportController();
		controller.setService(personService);
		controller.setSallaryReportCommand(new SallaryReportCommand());
		controller.setMarriedReportCommand(new MarriedReportCommand());
		context.put("reportController", controller);
	}

	public static void main(String[] args) {
		bootstrap();
		
		for (Page page : pages) {
			page.render();
		}
	}
}
