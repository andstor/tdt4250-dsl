/**
 * generated by Xtext 2.22.0
 */
package tdt4250.pseudocode.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringJoiner;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import tdt4250.pseudocode.AndOrExpression;
import tdt4250.pseudocode.ArithmeticSigned;
import tdt4250.pseudocode.BooleanLiteral;
import tdt4250.pseudocode.BooleanNegation;
import tdt4250.pseudocode.CollectionAccessor;
import tdt4250.pseudocode.CollectionAdd;
import tdt4250.pseudocode.CollectionRemove;
import tdt4250.pseudocode.Comparison;
import tdt4250.pseudocode.DoubleLiteral;
import tdt4250.pseudocode.Equals;
import tdt4250.pseudocode.Expression;
import tdt4250.pseudocode.Feature;
import tdt4250.pseudocode.ForStatement;
import tdt4250.pseudocode.Function;
import tdt4250.pseudocode.FunctionCall;
import tdt4250.pseudocode.IfStatement;
import tdt4250.pseudocode.List;
import tdt4250.pseudocode.ListLitteral;
import tdt4250.pseudocode.Minus;
import tdt4250.pseudocode.Model;
import tdt4250.pseudocode.MultiOrDiv;
import tdt4250.pseudocode.NumberLiteral;
import tdt4250.pseudocode.ParenthesizedExpression;
import tdt4250.pseudocode.Plus;
import tdt4250.pseudocode.Print;
import tdt4250.pseudocode.SetLitteral;
import tdt4250.pseudocode.SizeExpression;
import tdt4250.pseudocode.Statement;
import tdt4250.pseudocode.Stop;
import tdt4250.pseudocode.StringLiteral;
import tdt4250.pseudocode.ValueExchange;
import tdt4250.pseudocode.Variable;
import tdt4250.pseudocode.VariableReference;
import tdt4250.pseudocode.WhileStatement;
import tdt4250.pseudocode.generator.PcodeGeneratorUtils;
import tdt4250.pseudocode.generator.PcodeTypeInferencer;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class PcodeGenerator extends AbstractGenerator {
  private PcodeTypeInferencer typeInferencer = new PcodeTypeInferencer();
  
  private int varCounter = 0;
  
  private ArrayList<String> varList = new ArrayList<String>();
  
  private HashSet<String> importTypes = new HashSet<String>();
  
  private String packageName = "";
  
  /**
   * Da har jeg  fikset litt til :)
   * 
   * - Parametere i funksjonskall funker
   * - Main fuunksjon er da good to go! Ble ganske fancy :)  Va litt jobb her ettersom man kan kalle main med  argumenter
   *     (gjøres i Run Configuration,eller når man  kjører via kommandolinje)
   *     Har pr. nå støtte for String, int, double og boolean. Dette er dynamisk  basert på parameterene til funksjonen som er satt til "executable".
   *     Man kan ikke lage ister som argument (har brukt mye tid på dette, men d gikk ikke .. ARRRG!)
   * - Man  kan nå skrive print line "xxx"  og  det svarer til System.out.println. \n er også nå riktig escapet.
   * 
   * 
   * Prøvde å fikse times og divide keywords, men  dette tror jeg vi må gjøre med enums ;) .... ble veldig rotete
   * Skal få satt opp readme struktur i morra (den 7. des.).
   * 
   * 
   * Så også på  validering med Acceleo query language (AQL) (constraints),  men dette viste seg å være VELDIG
   * vankselig å koble inn  i xtext prosjektet... Så tror vi dropper dette...
   * Det får holde  med enums (og forhåpentligvis operasjoner når jeg kommer så langt) :)
   * 
   * btw så kom jeg på at man kan lage TYPER i ecore... Er dette noe vi kunna brukt? (må isåfall sjekke at typer faktisk virker i Xtext)
   * eks for TypeLiteral? - istedenfor enums? åsså kan vi heller ha enums til eks operasjons tegn ol.? eks for =,  + "pluss", - "minus"?? idk..
   * Du får styre på slik du vill ;)
   * 
   * 
   * Snakes!
   */
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String resPrint = "";
    Iterable<Function> _filter = Iterables.<Function>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Function.class);
    for (final Function e : _filter) {
      {
        this.varCounter = 0;
        this.varList.clear();
        this.importTypes.clear();
        this.packageName = null;
        EObject _eContainer = e.eContainer();
        this.packageName = ((Model) _eContainer).getPackage();
        String folder = "";
        if ((this.packageName != null)) {
          String _folder = folder;
          String _replace = this.packageName.replace(".", "/");
          String _plus = (_replace + "/");
          folder = (_folder + _plus);
        }
        String res = this.generate(e);
        String _resPrint = resPrint;
        resPrint = (_resPrint + res);
        String _name = e.getName();
        String _plus_1 = (folder + _name);
        String _plus_2 = (_plus_1 + ".java");
        fsa.generateFile(_plus_2, res);
      }
    }
    InputOutput.<String>println(resPrint);
    InputOutput.<String>println("--------------------------------------------------");
    InputOutput.<String>println(("Variable counter: " + Integer.valueOf(this.varCounter)));
    InputOutput.<String>println(("Variables: " + this.varList));
    InputOutput.<String>println(("Import types: " + this.importTypes));
  }
  
  public String generate(final Function e) {
    String string = "";
    String type = this.typeInferencer.infer(e);
    String params = "";
    boolean _isEmpty = e.getParameters().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _params = params;
      String _generateParameters = this.generateParameters(e.getParameters());
      params = (_params + _generateParameters);
    }
    String body = "";
    EList<Feature> _features = e.getFeatures();
    for (final Feature f : _features) {
      String _body = body;
      CharSequence _generateFeature = this.generateFeature(f);
      body = (_body + _generateFeature);
    }
    String main = "";
    boolean _isExecutable = e.isExecutable();
    if (_isExecutable) {
      main = this.generateMainFunction(e);
    }
    String _string = string;
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((this.packageName != null)) {
        _builder.append(" package ");
        _builder.append(this.packageName);
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final String importType : this.importTypes) {
        _builder.append("import ");
        _builder.append(importType);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("public static ");
    _builder.append(type, "    ");
    _builder.append(" run(");
    _builder.append(params, "    ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append(body, "        ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(main, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    string = (_string + _builder);
    return string;
  }
  
  public String generateMainFunction(final Function function) {
    String _xblockexpression = null;
    {
      String string = "";
      String argString = "";
      StringJoiner argList = new StringJoiner(",");
      boolean _isEmpty = function.getParameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        for (int i = 0; (i < ((Object[])Conversions.unwrapArray(function.getParameters(), Object.class)).length); i++) {
          {
            Expression param = function.getParameters().get(i);
            final Variable variable = ((Variable) param);
            final String type = this.typeInferencer.infer(variable.getType());
            final String convertedType = this.generateTypeConvertionCode((("args[" + Integer.valueOf(i)) + "]"), type);
            String arg = ("ARG" + Integer.valueOf(i));
            String _argString = argString;
            argString = (_argString + (((((type + " ") + arg) + " = ") + convertedType) + ";\n"));
            argList.add(arg);
          }
        }
      }
      String _string = string;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public static void main(final String[] args) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append(argString, "    ");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("run(");
      String _string_1 = argList.toString();
      _builder.append(_string_1, "    ");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = string = (_string + _builder);
    }
    return _xblockexpression;
  }
  
  public String generateTypeConvertionCode(final String value, final String type) {
    if (type != null) {
      switch (type) {
        case "String":
          return value;
        case "int":
          return (("Integer.parseInt(" + value) + ")");
        case "double":
          return (("Double.parseDouble(" + value) + ")");
        case "boolean":
          return (("Boolean.parseBoolean(" + value) + ")");
        default:
          return value;
      }
    } else {
      return value;
    }
  }
  
  public String generateParameters(final EList<Expression> variables) {
    String parameters = "";
    for (final Expression v : variables) {
      {
        final Variable variable = ((Variable) v);
        final String type = this.typeInferencer.infer(variable.getType());
        String _jvmType = this.typeInferencer.toJvmType(type);
        String _plus = (_jvmType + " ");
        String _name = variable.getName();
        String _plus_1 = (_plus + _name);
        String param = (_plus_1 + ", ");
        String _parameters = parameters;
        parameters = (_parameters + param);
        boolean _contains = param.contains("List");
        if (_contains) {
          this.importTypes.add("java.util.List");
        }
        boolean _contains_1 = param.contains("Set");
        if (_contains_1) {
          this.importTypes.add("java.util.Set");
        }
        this.varList.add(variable.getName());
      }
    }
    int _length = parameters.length();
    int _minus = (_length - 2);
    parameters = parameters.substring(0, _minus);
    return parameters;
  }
  
  protected CharSequence _generateFeature(final Statement e) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateStatement = this.generateStatement(e);
    _builder.append(_generateStatement);
    return _builder;
  }
  
  protected CharSequence _generateFeature(final Expression e) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateExpression = this.generateExpression(e);
    _builder.append(_generateExpression);
    return _builder;
  }
  
  protected CharSequence _generateStatement(final IfStatement e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    Object _LiteralExpression = this.LiteralExpression(e.getCondition());
    _builder.append(_LiteralExpression);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<Feature> _then = e.getThen();
      for(final Feature f : _then) {
        _builder.append("    ");
        Object _generateFeature = this.generateFeature(f);
        _builder.append(_generateFeature, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    {
      boolean _isEmpty = e.getOtherwise().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append(" else {");
        _builder.newLineIfNotEmpty();
        _builder.append("             ");
        {
          EList<Feature> _otherwise = e.getOtherwise();
          for(final Feature f2 : _otherwise) {
            Object _generateFeature_1 = this.generateFeature(f2);
            _builder.append(_generateFeature_1, "             ");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _generateStatement(final ForStatement e) {
    String variable = this.uniqueVariable();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (int ");
    _builder.append(variable);
    _builder.append(" = ");
    Object _LiteralExpression = this.LiteralExpression(e.getFrom());
    _builder.append(_LiteralExpression);
    _builder.append("; ");
    _builder.append(variable);
    _builder.append(" <= ");
    Object _LiteralExpression_1 = this.LiteralExpression(e.getTo());
    _builder.append(_LiteralExpression_1);
    _builder.append("; ");
    _builder.append(variable);
    _builder.append("++) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Feature> _block = e.getBlock();
      for(final Feature b : _block) {
        _builder.append("    ");
        Object _generateFeature = this.generateFeature(b);
        _builder.append(_generateFeature, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String uniqueVariable() {
    int _plusPlus = this.varCounter++;
    return ("VAR" + Integer.valueOf(_plusPlus));
  }
  
  protected CharSequence _generateStatement(final WhileStatement e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (");
    Object _LiteralExpression = this.LiteralExpression(e.getCondition());
    _builder.append(_LiteralExpression);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<Feature> _block = e.getBlock();
      for(final Feature b : _block) {
        _builder.append("\t");
        Object _generateFeature = this.generateFeature(b);
        _builder.append(_generateFeature, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateStatement(final Stop e) {
    String string = "";
    String _string = string;
    String _replace = e.getType().replace("stop", "return");
    string = (_string + _replace);
    Expression _value = e.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      String _string_1 = string;
      Object _LiteralExpression = this.LiteralExpression(e.getValue());
      String _plus = (" " + _LiteralExpression);
      String _plus_1 = (_plus + ";");
      string = (_string_1 + _plus_1);
    } else {
      String _string_2 = string;
      string = (_string_2 + ";");
    }
    return string;
  }
  
  public String printvarList() {
    int v = this.varList.size();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(v);
    return _builder.toString();
  }
  
  protected CharSequence _generateExpression(final Variable e) {
    String string = "";
    boolean _contains = this.varList.contains(e.getName());
    boolean _not = (!_contains);
    if (_not) {
      String _string = string;
      String _infer = this.typeInferencer.infer(e.getValue());
      String _plus = (_infer + " ");
      String _name = e.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + " = ");
      Object _LiteralExpression = this.LiteralExpression(e.getValue());
      String _plus_3 = (_plus_2 + _LiteralExpression);
      String _plus_4 = (_plus_3 + ";");
      string = (_string + _plus_4);
      this.varList.add(e.getName());
    } else {
      if ((e.getOp().equals("++") || e.getOp().equals("--"))) {
        String _string_1 = string;
        String _name_1 = e.getName();
        String _op = e.getOp();
        String _plus_5 = (_name_1 + _op);
        String _plus_6 = (_plus_5 + ";");
        string = (_string_1 + _plus_6);
      } else {
        if ((e.getOp().equals("equals") || e.getOp().equals("is"))) {
          String _string_2 = string;
          String _name_2 = e.getName();
          String _plus_7 = (_name_2 + " ");
          String _plus_8 = (_plus_7 + "=");
          String _plus_9 = (_plus_8 + " ");
          Object _LiteralExpression_1 = this.LiteralExpression(e.getValue());
          String _plus_10 = (_plus_9 + _LiteralExpression_1);
          String _plus_11 = (_plus_10 + ";");
          string = (_string_2 + _plus_11);
        } else {
          String _string_3 = string;
          String _name_3 = e.getName();
          String _plus_12 = (_name_3 + " ");
          String _op_1 = e.getOp();
          String _plus_13 = (_plus_12 + _op_1);
          String _plus_14 = (_plus_13 + " ");
          Object _LiteralExpression_2 = this.LiteralExpression(e.getValue());
          String _plus_15 = (_plus_14 + _LiteralExpression_2);
          String _plus_16 = (_plus_15 + ";");
          string = (_string_3 + _plus_16);
        }
      }
    }
    return (string + "\n");
  }
  
  protected CharSequence _generateExpression(final Print e) {
    boolean _isNewline = e.isNewline();
    if (_isNewline) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("System.out.println(");
      Object _LiteralExpression = this.LiteralExpression(e.getValue());
      _builder.append(_LiteralExpression);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("System.out.print(");
      Object _LiteralExpression_1 = this.LiteralExpression(e.getValue());
      _builder_1.append(_LiteralExpression_1);
      _builder_1.append(");");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    }
  }
  
  protected CharSequence _generateExpression(final CollectionAdd e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getCollection().getName();
    _builder.append(_name);
    _builder.append(".add(");
    Object _LiteralExpression = this.LiteralExpression(e.getValue());
    _builder.append(_LiteralExpression);
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence _generateExpression(final CollectionRemove e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getCollection().getName();
    _builder.append(_name);
    _builder.append(".remove(");
    Object _LiteralExpression = this.LiteralExpression(e.getValue());
    _builder.append(_LiteralExpression);
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence _generateExpression(final FunctionCall e) {
    Object _LiteralExpression = this.LiteralExpression(e);
    String _plus = (_LiteralExpression + ";");
    return (_plus + "\n");
  }
  
  protected CharSequence _generateExpression(final ValueExchange e) {
    String variable1 = this.uniqueVariable();
    String variable2 = this.uniqueVariable();
    String exp1 = this.LiteralExpression(e.getCollection()).toString();
    String exp2 = this.LiteralExpression(e.getValue()).toString();
    Expression _collection = e.getCollection();
    if ((_collection instanceof CollectionAccessor)) {
      exp1 = PcodeGeneratorUtils.replaceLast("get", "set", exp1);
      exp1 = PcodeGeneratorUtils.replaceLast(")", (("," + variable2) + ")"), exp1);
    } else {
      exp1 = ((exp1 + "=") + variable2);
    }
    Expression _value = e.getValue();
    if ((_value instanceof CollectionAccessor)) {
      exp2 = PcodeGeneratorUtils.replaceLast("get", "set", exp2);
      exp2 = PcodeGeneratorUtils.replaceLast(")", (("," + variable1) + ")"), exp2);
    } else {
      exp2 = ((exp2 + "=") + variable1);
    }
    StringConcatenation _builder = new StringConcatenation();
    String _infer = this.typeInferencer.infer(e.getCollection());
    _builder.append(_infer);
    _builder.append(" ");
    _builder.append(variable1);
    _builder.append(" = ");
    Object _LiteralExpression = this.LiteralExpression(e.getCollection());
    _builder.append(_LiteralExpression);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _infer_1 = this.typeInferencer.infer(e.getValue());
    _builder.append(_infer_1);
    _builder.append(" ");
    _builder.append(variable2);
    _builder.append(" = ");
    Object _LiteralExpression_1 = this.LiteralExpression(e.getValue());
    _builder.append(_LiteralExpression_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append(exp1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append(exp2);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _LiteralExpression(final List e) {
    String string = "";
    String listType = this.typeInferencer.autobox(this.typeInferencer.infer(e.getType()));
    String _string = string;
    string = (_string + (("new ArrayList<" + listType) + ">"));
    this.importTypes.add("java.util.ArrayList");
    this.importTypes.add("java.util.List");
    boolean _isEmpty = e.getElements().isEmpty();
    if (_isEmpty) {
      String _string_1 = string;
      string = (_string_1 + "()");
    } else {
      String _string_2 = string;
      string = (_string_2 + "(Arrays.asList(");
      this.importTypes.add("java.util.Arrays");
      StringJoiner joiner = new StringJoiner(",");
      EList<Expression> _elements = e.getElements();
      for (final Expression element : _elements) {
        joiner.add(this.LiteralExpression(element).toString());
      }
      String _string_3 = string;
      String _string_4 = joiner.toString();
      String _plus = (_string_4 + "))");
      string = (_string_3 + _plus);
    }
    return string;
  }
  
  protected Object _LiteralExpression(final SetLitteral e) {
    String string = "";
    String listType = this.typeInferencer.autobox(this.typeInferencer.infer(e.getElements().get(0)).toString());
    String _string = string;
    string = (_string + (("new HashSet<" + listType) + ">"));
    this.importTypes.add("java.util.HashSet");
    this.importTypes.add("java.util.Set");
    boolean _isEmpty = e.getElements().isEmpty();
    if (_isEmpty) {
      String _string_1 = string;
      string = (_string_1 + "()");
    } else {
      String _string_2 = string;
      string = (_string_2 + "(Arrays.asList(");
      this.importTypes.add("java.util.Arrays");
      StringJoiner joiner = new StringJoiner(",");
      EList<Expression> _elements = e.getElements();
      for (final Expression element : _elements) {
        joiner.add(this.LiteralExpression(element).toString());
      }
      String _string_3 = string;
      String _string_4 = joiner.toString();
      String _plus = (_string_4 + "))");
      string = (_string_3 + _plus);
    }
    return string;
  }
  
  protected Object _LiteralExpression(final ListLitteral e) {
    String string = "";
    String listType = this.typeInferencer.autobox(this.typeInferencer.infer(e.getElements().get(0)).toString());
    String _string = string;
    string = (_string + (("new ArrayList<" + listType) + ">"));
    this.importTypes.add("java.util.ArrayList");
    this.importTypes.add("java.util.List");
    boolean _isEmpty = e.getElements().isEmpty();
    if (_isEmpty) {
      String _string_1 = string;
      string = (_string_1 + "()");
    } else {
      String _string_2 = string;
      string = (_string_2 + "(Arrays.asList(");
      this.importTypes.add("java.util.Arrays");
      StringJoiner joiner = new StringJoiner(",");
      EList<Expression> _elements = e.getElements();
      for (final Expression element : _elements) {
        joiner.add(this.LiteralExpression(element).toString());
      }
      String _string_3 = string;
      String _string_4 = joiner.toString();
      String _plus = (_string_4 + "))");
      string = (_string_3 + _plus);
    }
    return string;
  }
  
  protected Object _LiteralExpression(final CollectionAccessor e) {
    String string = "";
    String _string = string;
    String _name = e.getCollection().getName();
    string = (_string + _name);
    EList<Expression> _accessor = e.getAccessor();
    for (final Expression accessor : _accessor) {
      String _string_1 = string;
      Object _LiteralExpression = this.LiteralExpression(accessor);
      String _plus = (".get(" + _LiteralExpression);
      String _plus_1 = (_plus + ")");
      string = (_string_1 + _plus_1);
    }
    return string;
  }
  
  public String checkAndORType(final AndOrExpression e) {
    boolean _equals = e.getOp().equals("or");
    if (_equals) {
      return "|";
    } else {
      boolean _equals_1 = e.getOp().equals("and");
      if (_equals_1) {
        return "&";
      } else {
        return e.getOp();
      }
    }
  }
  
  public String checkMultiOrDiv(final MultiOrDiv e) {
    boolean _equals = e.getOp().equals("times");
    if (_equals) {
      return "*";
    } else {
      boolean _equals_1 = e.getOp().equals("divide");
      if (_equals_1) {
        return "/";
      } else {
        boolean _equals_2 = e.getOp().equals("modulo");
        if (_equals_2) {
          return "%";
        } else {
          return e.getOp();
        }
      }
    }
  }
  
  public String checkComparison(final Comparison e) {
    boolean _equals = e.getOp().equals("lessThen");
    if (_equals) {
      return "<";
    } else {
      boolean _equals_1 = e.getOp().equals("biggerThen");
      if (_equals_1) {
        return ">";
      } else {
        return e.getOp();
      }
    }
  }
  
  protected Object _LiteralExpression(final AndOrExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    Object _LiteralExpression = this.LiteralExpression(e.getLeft());
    _builder.append(_LiteralExpression);
    String _checkAndORType = this.checkAndORType(e);
    _builder.append(_checkAndORType);
    Object _LiteralExpression_1 = this.LiteralExpression(e.getRight());
    _builder.append(_LiteralExpression_1);
    return _builder;
  }
  
  protected Object _LiteralExpression(final Comparison e) {
    StringConcatenation _builder = new StringConcatenation();
    Object _LiteralExpression = this.LiteralExpression(e.getLeft());
    _builder.append(_LiteralExpression);
    String _checkComparison = this.checkComparison(e);
    _builder.append(_checkComparison);
    Object _LiteralExpression_1 = this.LiteralExpression(e.getRight());
    _builder.append(_LiteralExpression_1);
    return _builder;
  }
  
  protected Object _LiteralExpression(final Equals e) {
    StringConcatenation _builder = new StringConcatenation();
    Object _LiteralExpression = this.LiteralExpression(e.getLeft());
    _builder.append(_LiteralExpression);
    String _op = e.getOp();
    _builder.append(_op);
    Object _LiteralExpression_1 = this.LiteralExpression(e.getRight());
    _builder.append(_LiteralExpression_1);
    return _builder;
  }
  
  protected Object _LiteralExpression(final ParenthesizedExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Object _LiteralExpression = this.LiteralExpression(e.getExpression());
    _builder.append(_LiteralExpression);
    _builder.append(")");
    return _builder;
  }
  
  protected Object _LiteralExpression(final Plus e) {
    StringConcatenation _builder = new StringConcatenation();
    Object _LiteralExpression = this.LiteralExpression(e.getLeft());
    _builder.append(_LiteralExpression);
    _builder.append("+");
    Object _LiteralExpression_1 = this.LiteralExpression(e.getRight());
    _builder.append(_LiteralExpression_1);
    return _builder;
  }
  
  protected Object _LiteralExpression(final Minus e) {
    StringConcatenation _builder = new StringConcatenation();
    Object _LiteralExpression = this.LiteralExpression(e.getLeft());
    _builder.append(_LiteralExpression);
    _builder.append("-");
    Object _LiteralExpression_1 = this.LiteralExpression(e.getRight());
    _builder.append(_LiteralExpression_1);
    return _builder;
  }
  
  protected Object _LiteralExpression(final MultiOrDiv e) {
    StringConcatenation _builder = new StringConcatenation();
    Object _LiteralExpression = this.LiteralExpression(e.getLeft());
    _builder.append(_LiteralExpression);
    String _checkMultiOrDiv = this.checkMultiOrDiv(e);
    _builder.append(_checkMultiOrDiv);
    Object _LiteralExpression_1 = this.LiteralExpression(e.getRight());
    _builder.append(_LiteralExpression_1);
    return _builder;
  }
  
  protected Object _LiteralExpression(final BooleanNegation e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("!");
    Object _LiteralExpression = this.LiteralExpression(e.getExpression());
    _builder.append(_LiteralExpression);
    return _builder;
  }
  
  protected Object _LiteralExpression(final ArithmeticSigned e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-");
    Object _LiteralExpression = this.LiteralExpression(e.getExpression());
    _builder.append(_LiteralExpression);
    return _builder;
  }
  
  protected Object _LiteralExpression(final NumberLiteral e) {
    return Integer.valueOf(e.getValue());
  }
  
  protected Object _LiteralExpression(final DoubleLiteral e) {
    return e.getValue();
  }
  
  protected Object _LiteralExpression(final StringLiteral e) {
    String _escape = PcodeGeneratorUtils.escape(e.getValue());
    String _plus = ("\"" + _escape);
    return (_plus + "\"");
  }
  
  protected Object _LiteralExpression(final BooleanLiteral e) {
    return e.getValue();
  }
  
  protected Object _LiteralExpression(final VariableReference e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getRef().getName();
    _builder.append(_name);
    return _builder;
  }
  
  protected Object _LiteralExpression(final FunctionCall e) {
    String string = "";
    String _string = string;
    String _name = e.getRef().getName();
    String _plus = (_name + ".run(");
    string = (_string + _plus);
    EObject _eContainer = e.getRef().eContainer();
    String refPackageName = ((Model) _eContainer).getPackage();
    if (((refPackageName != null) && (!refPackageName.equals(this.packageName)))) {
      String _name_1 = e.getRef().getName();
      String _plus_1 = ((refPackageName + ".") + _name_1);
      this.importTypes.add(_plus_1);
    }
    boolean _isEmpty = e.getArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringJoiner joiner = new StringJoiner(",");
      EList<Expression> _arguments = e.getArguments();
      for (final Expression param : _arguments) {
        joiner.add(this.LiteralExpression(param).toString());
      }
      String _string_1 = string;
      String _string_2 = joiner.toString();
      string = (_string_1 + _string_2);
    }
    String _string_3 = string;
    string = (_string_3 + ")");
    return string;
  }
  
  protected Object _LiteralExpression(final SizeExpression e) {
    Object _LiteralExpression = this.LiteralExpression(e.getValue());
    return (_LiteralExpression + ".size()");
  }
  
  public CharSequence generateFeature(final Feature e) {
    if (e instanceof Expression) {
      return _generateFeature((Expression)e);
    } else if (e instanceof Statement) {
      return _generateFeature((Statement)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public CharSequence generateStatement(final Statement e) {
    if (e instanceof ForStatement) {
      return _generateStatement((ForStatement)e);
    } else if (e instanceof IfStatement) {
      return _generateStatement((IfStatement)e);
    } else if (e instanceof Stop) {
      return _generateStatement((Stop)e);
    } else if (e instanceof WhileStatement) {
      return _generateStatement((WhileStatement)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public CharSequence generateExpression(final Expression e) {
    if (e instanceof CollectionAdd) {
      return _generateExpression((CollectionAdd)e);
    } else if (e instanceof CollectionRemove) {
      return _generateExpression((CollectionRemove)e);
    } else if (e instanceof FunctionCall) {
      return _generateExpression((FunctionCall)e);
    } else if (e instanceof Print) {
      return _generateExpression((Print)e);
    } else if (e instanceof ValueExchange) {
      return _generateExpression((ValueExchange)e);
    } else if (e instanceof Variable) {
      return _generateExpression((Variable)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public Object LiteralExpression(final Expression e) {
    if (e instanceof List) {
      return _LiteralExpression((List)e);
    } else if (e instanceof ListLitteral) {
      return _LiteralExpression((ListLitteral)e);
    } else if (e instanceof SetLitteral) {
      return _LiteralExpression((SetLitteral)e);
    } else if (e instanceof AndOrExpression) {
      return _LiteralExpression((AndOrExpression)e);
    } else if (e instanceof ArithmeticSigned) {
      return _LiteralExpression((ArithmeticSigned)e);
    } else if (e instanceof BooleanLiteral) {
      return _LiteralExpression((BooleanLiteral)e);
    } else if (e instanceof BooleanNegation) {
      return _LiteralExpression((BooleanNegation)e);
    } else if (e instanceof CollectionAccessor) {
      return _LiteralExpression((CollectionAccessor)e);
    } else if (e instanceof Comparison) {
      return _LiteralExpression((Comparison)e);
    } else if (e instanceof DoubleLiteral) {
      return _LiteralExpression((DoubleLiteral)e);
    } else if (e instanceof Equals) {
      return _LiteralExpression((Equals)e);
    } else if (e instanceof FunctionCall) {
      return _LiteralExpression((FunctionCall)e);
    } else if (e instanceof Minus) {
      return _LiteralExpression((Minus)e);
    } else if (e instanceof MultiOrDiv) {
      return _LiteralExpression((MultiOrDiv)e);
    } else if (e instanceof NumberLiteral) {
      return _LiteralExpression((NumberLiteral)e);
    } else if (e instanceof ParenthesizedExpression) {
      return _LiteralExpression((ParenthesizedExpression)e);
    } else if (e instanceof Plus) {
      return _LiteralExpression((Plus)e);
    } else if (e instanceof SizeExpression) {
      return _LiteralExpression((SizeExpression)e);
    } else if (e instanceof StringLiteral) {
      return _LiteralExpression((StringLiteral)e);
    } else if (e instanceof VariableReference) {
      return _LiteralExpression((VariableReference)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
