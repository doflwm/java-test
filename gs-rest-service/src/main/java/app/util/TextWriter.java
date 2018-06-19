package app.util;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TextWriter implements Closeable {
	private BufferedWriter fw;
	
	/**
	 * 
	 * @param filename
	 * @param charset
	 * 	(ex) "euc-kr"
	 * @throws IOException
	 */
    public void open(String filename, String charset) throws IOException {
    	Path path = Paths.get(filename);
        fw = Files.newBufferedWriter(path, Charset.forName(charset)
        		, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
    
    public void write(String str) throws IOException {
		fw.write(str);
//		fw.flush();
	}

	@Override
	public void close() throws IOException {
		fw.close();
	}
    
}
