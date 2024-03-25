package view.page;

import view.ReportController;
import container.Container;

public class ReportPage implements Page {
	
	/* (non-Javadoc)
	 * @see view.Page#render()
	 */
	@Override
	public String render() {
		System.out.println("---------Report page--------");
		System.out.println("\nReport:");
		System.out.println("\tTotal salary:"+((ReportController) Container.context.get("reportController")).getReportPersonSalaryTotal());
		System.out.println("\tMarriage stat:"+((ReportController) Container.context.get("reportController")).getReportPersonMarriedStat());
		System.out.println("\n---------           --------");
		return null;
	}
}
