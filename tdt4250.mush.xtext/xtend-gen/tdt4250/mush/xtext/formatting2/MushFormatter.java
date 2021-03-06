/**
 * generated by Xtext 2.22.0
 */
package tdt4250.mush.xtext.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import tdt4250.mush.model.Expression;
import tdt4250.mush.model.Feature;
import tdt4250.mush.model.Function;
import tdt4250.mush.model.Model;
import tdt4250.mush.xtext.services.MushGrammarAccess;

@SuppressWarnings("all")
public class MushFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private MushGrammarAccess _mushGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    EList<Function> _functions = model.getFunctions();
    for (final Function function : _functions) {
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.setNewLines(1, 1, 2);
        }
      };
      document.<Function>append(document.<Function>format(function), _function);
    }
  }
  
  protected void _format(final Function function, @Extension final IFormattableDocument document) {
    EList<Expression> _parameters = function.getParameters();
    for (final Expression expression : _parameters) {
      document.<Expression>format(expression);
    }
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(function).ruleCallTo(this._mushGrammarAccess.getBEGINRule());
    final ISemanticRegion end = this.textRegionExtensions.regionFor(function).ruleCallTo(this._mushGrammarAccess.getENDRule());
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.append(this.textRegionExtensions.regionFor(function).keyword("synthetic:BEGIN"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.prepend(this.textRegionExtensions.regionFor(function).keyword("synthetic:END"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_2);
    EList<Feature> _features = function.getFeatures();
    for (final Feature feature : _features) {
      document.<Feature>format(feature);
    }
  }
  
  public void format(final Object function, final IFormattableDocument document) {
    if (function instanceof XtextResource) {
      _format((XtextResource)function, document);
      return;
    } else if (function instanceof Function) {
      _format((Function)function, document);
      return;
    } else if (function instanceof Model) {
      _format((Model)function, document);
      return;
    } else if (function instanceof EObject) {
      _format((EObject)function, document);
      return;
    } else if (function == null) {
      _format((Void)null, document);
      return;
    } else if (function != null) {
      _format(function, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(function, document).toString());
    }
  }
}
