package cvut.fel.ass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Main.generate(Person.class);
	}

	public static void generate(Class c) {
		Stack<AnnotationPrinter> s = new Stack<AnnotationPrinter>();
		Annotation[] a = c.getDeclaredAnnotations();

		for (Annotation aa : a) {
			try {

				AnnotationPrinter ap = AnnotationPrinter.getPrinter(aa);
				System.out.println(AnnotationPrinter.getPrinter(aa).startTag());
				ap.startTag();
				s.push(ap);
			} catch (Exception e) {
			}
		}

		Method m[] = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			try {
				Type t = m[i].getGenericReturnType();
				if (!void.class.equals(t)) {
					Annotation[] anots = m[i].getDeclaredAnnotations();
					for (Annotation aa : anots) {
						try {
							AnnotationPrinter ap = AnnotationPrinter
									.getPrinter(aa);
							System.out.println(AnnotationPrinter.getPrinter(aa)
									.startTag());
							ap.startTag();
						} catch (Exception e) {
						}
					}
				}
			} catch (Exception e) {
			}
		}
		while(!s.empty())
			System.out.println(s.pop().endTag());

	}
}

abstract class AnnotationPrinter {
	public abstract String startTag();

	public abstract String endTag();

	public Annotation ant;

	public void setAnt(Annotation ant) {
		this.ant = ant;
	}

	public static AnnotationPrinter getPrinter(Annotation a) throws Exception {
		String[] s = a.annotationType().getName().split("\\.");
		Class c = Class.forName("cvut.fel.ass." + s[s.length - 1] + "Printer");
		AnnotationPrinter o = (AnnotationPrinter) c.newInstance();

		o.setAnt(a);
		return o;
	}
}

class TablePrinter extends AnnotationPrinter {

	@Override
	public String startTag() {
		javax.persistence.Table t = (javax.persistence.Table) ant;
		String tmp = "<h:form";
		if (!t.name().equals(""))
			tmp += " name='" + t.name() + "'";
		if (!t.schema().equals(""))
			tmp += " schema='" + t.schema() + "'";
		tmp += ">";
		return tmp;
	}

	@Override
	public String endTag() {
		return "</h:form>";
	}

}

class ColumnPrinter extends AnnotationPrinter {

	@Override
	public String startTag() {
		javax.persistence.Table t = (javax.persistence.Table) ant;
		String tmp = "<h:form";
		if (!t.name().equals(""))
			tmp += " name='" + t.name() + "'";
		if (!t.schema().equals(""))
			tmp += " schema='" + t.schema() + "'";
		tmp += ">";
		return tmp;
	}

	@Override
	public String endTag() {
		return "</h:form>";
	}

}
