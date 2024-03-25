package cz.cvut.fel.ass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

import cz.cvut.fel.ass.interpreter.GameContext;
import cz.cvut.fel.ass.interpreter.Interpreter;

/*
 * Třída, která bude injectována do tříd, pomocí nichž, se budou vkládat závislosti
 */
public class ServiceLocator {

	HashMap<String, HashMap<String, String>> config;

	public ServiceLocator(File configFile) {
		try {
			config = new HashMap<String, HashMap<String, String>>();
			parseConfigFile(configFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private void parseConfigFile(File configFile) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(configFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String aLine = null;

		while ((aLine = reader.readLine()) != null) {
			aLine = aLine.trim();
			if (aLine.equals("") || aLine.startsWith("#")) // Prázdné řádky a
															// komentáře
				continue;
			String[] split = aLine.split(" ");
			// split[0] : jméno třídy
			// split [1] : jméno vlastnosti
			// split[2] : hodnota
			HashMap<String, String> classConfig = config.get(split[0]);
			if (classConfig == null) {
				config.put(split[0], new HashMap<String, String>());
			}
			classConfig = config.get(split[0]);
			classConfig.put(split[1], split[2]);
		}

		reader.close();

	}

	// Funguje jen, když se volá z metod getList, getMap atd
	protected String getCallerClassName() {
		/*StackTraceElement[] stackTraceElements = Thread.currentThread()
				.getStackTrace();
		
		for(int i = 0; i < stackTraceElements.length; i++)
				System.out.println("\t"+stackTraceElements[i]);
		System.out.println("--------------------------------------------");
		return stackTraceElements[stackTraceElements.length - 2].getClassName();
		*/
		return sun.reflect.Reflection.getCallerClass(4).getName();

	}

	protected Object getProperty(String prop) {
		String className = getCallerClassName();
		HashMap<String, String> classConfig = config.get(className);
		if (classConfig == null) {
			className = "default";
			classConfig = config.get(className);
		}
		String value = classConfig.get(prop);
		if (value == null) {
			className = "default";
			classConfig = config.get(className);
			value = classConfig.get(prop);
		}
		
		Class cl;
		Object l = null;
		try {
			cl = Class.forName(value);
			java.lang.reflect.Constructor co = cl.getConstructor(null);
			l = co.newInstance(null);
			
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
		}
		return l;

	}

	public List getList() {
			return (List) getProperty("list");
	}

	public AbstractMap getMap() {
		return (AbstractMap) getProperty("map");
	}

	public Interpreter getInterpreter() {
		Interpreter i = (Interpreter) getProperty("interpreter");
		i.setServiceLocator(this);
		return i;
	}

	public GameContext getGame() {
		return (GameContext) getProperty("game");
	}
}
