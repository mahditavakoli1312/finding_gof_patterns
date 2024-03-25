package cz.cvut.fel.ass.parser;


// VZOR: Observable
public class KarelParser {
	protected SourceCode source;
	protected ParserEventHandler eventHandler;

	public void parse(SourceCode source, ParserEventHandler eventHandler) {
		this.source = source;
		this.eventHandler = eventHandler;

		SourceIterator sourceIterator = this.source.getSourceIterator();

		eventHandler.startSource();

		while (sourceIterator.hasNext()) {
			LineOfCode loc = sourceIterator.next();
			String line = loc.getLine().trim();
			if (line.equals(""))
				continue;
			if (line.startsWith("%")) {
				eventHandler.startComment(line, loc.getLineNumber());
			} else {
				// Příkaz
				String[] splitedLine = line.split(" ");
				Attributes attr = new Attributes();
				for (int i = 1; i < splitedLine.length; i++)
					attr.addAttribute(splitedLine[i]);
				eventHandler.startCommand(splitedLine[0], loc.getLineNumber(),
						attr);
			}
			if (!eventHandler.check())
				break;
		}

		eventHandler.endSource();
	}
}
