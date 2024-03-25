package cz.cvut.fel.stm.kwic.adt;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Input {

	private List<String> lines;
	private String path;

	public Input(String path) {
		this.path = path;
		this.lines = new ArrayList<String>();
	}

	protected void input() {
		try {
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				lines.add(strLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getLines() {
		return lines;
	}

}
