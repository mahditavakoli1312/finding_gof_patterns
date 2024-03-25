package cz.cvut.fel;

import java.lang.reflect.*;

public class Serializer {
	public String getValName(String getterName){
		return 	getterName.replace("get", "")
				.replaceAll("([a-z])([A-Z])", "$1-$2")
				.toLowerCase();
	}

	public void serialize(Object o) {
		Class c = o.getClass();
		String className = c.getSimpleName().toLowerCase();
		System.out.println("<" + className + ">");
		Method m[] = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			try {
				Type t = m[i].getGenericReturnType();
				if(!void.class.equals(t)){
					String valName = this.getValName(m[i].getName());
					Object ob = m[i].invoke(o, null);
					if(!ob.getClass().toString().startsWith("class java")){ // Pokud to není javovský typ
						this.serialize(ob);
					}else{ 
						System.out.println("<" + valName + ">");
						System.out.println(ob);
						System.out.println("</" + valName + ">");
					}
				}
			} catch (Exception e) {}
		}
		System.out.println("</" +className+ ">");
	}
}
