package view.page;

import view.ReportController;
import container.Container;
import model.Person;

public class PersonListPage implements Page {
	
	/* (non-Javadoc)
	 * @see view.Page#render()
	 */
	@Override
	public String render() {
		System.out.println("---------Person list-------");
		System.out.println("\nPeople:");
		System.out.println("\t---------------------------------");
		for (Person person : ((ReportController) Container.context.get("reportController")).getPersonList()) {
			System.out.println("\t|ID="+person.getId()+"\t|"+person.getfName()+"\t|"+person.getAge()+"\t|"+person.getlName()+"\t|..\t|");
		}
		System.out.println("\t---------------------------------");
		System.out.println("\n---------          --------");
		return null;
	}
}
