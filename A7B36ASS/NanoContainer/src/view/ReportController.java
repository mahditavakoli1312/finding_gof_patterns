package view;
import java.util.LinkedList;
import java.util.List;

import business.IPersonService;
import business.IReportCommand;

import model.Person;




public class ReportController {
	
	private IPersonService service = null;
	private List<Person> personList = null;
	private IReportCommand sallaryReportCommand;
	private IReportCommand marriedReportCommand;
	
	public void setMarriedReportCommand(IReportCommand marriedReportCommand) {
		this.marriedReportCommand = marriedReportCommand;
	}

	public void setSallaryReportCommand(IReportCommand sallaryReportCommand) {
		this.sallaryReportCommand = sallaryReportCommand;
	}

	public IPersonService getService() {
		return service;
	}

	public void setService(IPersonService service) {
		this.service = service;
	}

	public List<Person> getPersonList() {
		if(null == personList){
			
			List<Person> persons = service.getPersonList();
			personList= new LinkedList<Person>();
			for(Person p : persons){
				if(p.getAge() >= 30)
					personList.add(p);
			}
			
		}
		
		return personList;
	}


	public Long getReportPersonSalaryTotal() {
		 return (Long) getReport(sallaryReportCommand);
	}
	
	private Object getReport(IReportCommand command){
		return command.execute(personList);
	}

	public String getReportPersonMarriedStat() {
		return (String) getReport(marriedReportCommand);

	}
	
}
