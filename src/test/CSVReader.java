package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;

public class CSVReader<T> {
	public static interface Creator<T> {
		public T fromString(String line);
	}
	
	private Scanner line_scanner;
	private Creator<T> creator;
	
	public CSVReader(InputStream istream, CSVReader.Creator<T> creator)
	{
		line_scanner = new Scanner(istream);
		this.creator = creator;
	}
	
	public CSVReader(File file, CSVReader.Creator<T> creator)
			throws FileNotFoundException
	{
		line_scanner = new Scanner(file);
		this.creator = creator;
	}
	
	public CSVReader(Reader reader, CSVReader.Creator<T> creator) {
		line_scanner = new Scanner(reader);
		this.creator = creator;
	}
	
	public boolean hasNext() {
		return line_scanner.hasNext();
	}
	
	public T next() {
		if (line_scanner.hasNext()) {
			return creator.fromString(line_scanner.nextLine());
		}
		return null;
	}
}
