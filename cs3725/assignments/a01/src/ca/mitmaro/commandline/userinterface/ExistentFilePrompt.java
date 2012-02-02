/**
 * Tim Oram's Commons Libray - Command Line Interface
 * By: Tim Oram
 */
package ca.mitmaro.commandline.userinterface;

import java.io.IOException;
import java.io.File;

import ca.mitmaro.commandline.term.Terminal;

public class ExistentFilePrompt extends FilePrompt {
	
	
	public ExistentFilePrompt(String question, Terminal term) {
		super(question, term);
	}
	
	public File waitForResponse() throws IOException {
		
		File f;
		
		do {
			f = super.waitForResponse();
			
			if (f.isFile() && f.canRead()) {
				return f;
			}
			
			this.terminal.out.println("File does not exist or is not readable");
			this.terminal.out.flush();
		} while (true);
	}
	
}
