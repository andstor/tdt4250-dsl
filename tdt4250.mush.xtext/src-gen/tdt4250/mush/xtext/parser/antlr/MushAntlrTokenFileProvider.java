/*
 * generated by Xtext 2.22.0
 */
package tdt4250.mush.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MushAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("tdt4250/mush/xtext/parser/antlr/internal/InternalMushParser.tokens");
	}
}