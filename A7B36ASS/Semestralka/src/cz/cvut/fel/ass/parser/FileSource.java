package cz.cvut.fel.ass.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import cz.cvut.fel.ass.ServiceLocator;

public class FileSource implements SourceCode {

	protected List<LineOfCode> lines;
	protected File sourceFile;
	protected boolean isLoaded;
	protected ServiceLocator serviceLocator;

	public FileSource(File file, ServiceLocator sl) {
		this.sourceFile = file;
		this.serviceLocator = sl;
		this.lines = sl.getList();
		this.isLoaded = false;
	}

	protected void loadFile() throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(sourceFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String aLine = null;
		int lineNumber = 1;

		while ((aLine = reader.readLine()) != null) {
			lines.add(new LineOfCode(aLine, lineNumber));
			lineNumber++;
		}

		reader.close();
		isLoaded = true;
	}

	protected static class SourceFileIterator implements SourceIterator {

		private int pointer;
		private FileSource fs;

		public SourceFileIterator(FileSource source) {
			this.fs = source;
			pointer = 0;
		}

		@Override
		public boolean hasNext() {
			try {
				if(!fs.isLoaded)
					fs.loadFile();
			} catch (Exception e) {
				return false;
			}
			if (fs.lines.size() > pointer)
				return true;
			return false;
		}

		@Override
		public LineOfCode next() {
			try {
				if(!fs.isLoaded)
					fs.loadFile();
				return fs.lines.get(pointer++);
			} catch (Exception e) {
				return null;
			}
		}
	}

	@Override
	public SourceIterator getSourceIterator() {
		return new SourceFileIterator(this);
	}

}
