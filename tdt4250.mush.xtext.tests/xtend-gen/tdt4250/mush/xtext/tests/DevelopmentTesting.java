/**
 * generated by Xtext 2.22.0
 */
package tdt4250.mush.xtext.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tdt4250.mush.model.Model;
import tdt4250.mush.xtext.tests.MushInjectorProvider;

@ExtendWith(InjectionExtension.class)
@InjectWith(MushInjectorProvider.class)
@SuppressWarnings("all")
public class DevelopmentTesting {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Inject
  @Extension
  private ISerializer serializer;
  
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  private final String code = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MatrixAddition()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("newM = new list with list with number");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("m1 = [[1,1],[2,2]]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("m2 = [[1,1],[2,3]]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for 0 to ((size of m2)-1)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("newM add m1[0]");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("l = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("while (x != ((size of m1))) ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("y = 0");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("while (y != ((size of (m1[0])))) ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("l = (m1[x][y]) + (m2[x][y]) ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("print line \"x: \" +x + \", y: \" +y +  \" ,sum: \" + l\t\t ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("newM set x,y to l");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("y++");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x++");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("print line newM ");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  /**
   * val code = '''
   * 	ANNABELLE(nUMBeR alder, Number hoyde)
   * 	i = 2
   * 	i += 8
   * 	i++
   * 	s=9
   * 	if 9==2 then
   * 		s= 0
   * 
   * '''
   */
  @Test
  public void parseModel() {
    try {
      final Model result = this.parseHelper.parse(this.code);
      InputOutput.<String>println(EmfFormatter.objToStr(result));
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", ");
      _builder.append(_join);
      Assertions.assertTrue(_isEmpty, _builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void compileModel() {
    try {
      this.parseModel();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        CompilationTestHelper.Result _println = InputOutput.<CompilationTestHelper.Result>println(it);
        /* Pair.<CompilationTestHelper.Result, CompilationTestHelper.Result>of(it, _println); */
      };
      this._compilationTestHelper.compile(this.code, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void formatModel() {
    try {
      final Model model = this.parseHelper.parse(this.code);
      InputOutput.<String>println(EmfFormatter.objToStr(model));
      final String result = this.serializer.serialize(model, SaveOptions.newBuilder().format().getOptions());
      InputOutput.<String>println(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
