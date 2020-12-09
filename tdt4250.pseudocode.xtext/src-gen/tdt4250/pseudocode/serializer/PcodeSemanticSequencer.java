/*
 * generated by Xtext 2.22.0
 */
package tdt4250.pseudocode.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
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
import tdt4250.pseudocode.PseudocodePackage;
import tdt4250.pseudocode.SetLitteral;
import tdt4250.pseudocode.SizeExpression;
import tdt4250.pseudocode.Stop;
import tdt4250.pseudocode.StringLiteral;
import tdt4250.pseudocode.Type;
import tdt4250.pseudocode.ValueExchange;
import tdt4250.pseudocode.Variable;
import tdt4250.pseudocode.VariableReference;
import tdt4250.pseudocode.WhileStatement;
import tdt4250.pseudocode.services.PcodeGrammarAccess;

@SuppressWarnings("all")
public class PcodeSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PcodeGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == PseudocodePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PseudocodePackage.AND_OR_EXPRESSION:
				sequence_BooleanExpression(context, (AndOrExpression) semanticObject); 
				return; 
			case PseudocodePackage.ARITHMETIC_SIGNED:
				sequence_Prefixed(context, (ArithmeticSigned) semanticObject); 
				return; 
			case PseudocodePackage.BOOLEAN_LITERAL:
				sequence_Atomic(context, (BooleanLiteral) semanticObject); 
				return; 
			case PseudocodePackage.BOOLEAN_NEGATION:
				sequence_Prefixed(context, (BooleanNegation) semanticObject); 
				return; 
			case PseudocodePackage.COLLECTION_ACCESSOR:
				sequence_CollectionAccessor(context, (CollectionAccessor) semanticObject); 
				return; 
			case PseudocodePackage.COLLECTION_ADD:
				sequence_CollectionAdd(context, (CollectionAdd) semanticObject); 
				return; 
			case PseudocodePackage.COLLECTION_REMOVE:
				sequence_CollectionRemove(context, (CollectionRemove) semanticObject); 
				return; 
			case PseudocodePackage.COMPARISON:
				sequence_Comparison(context, (Comparison) semanticObject); 
				return; 
			case PseudocodePackage.DOUBLE_LITERAL:
				sequence_Atomic(context, (DoubleLiteral) semanticObject); 
				return; 
			case PseudocodePackage.EQUALS:
				sequence_Equals(context, (Equals) semanticObject); 
				return; 
			case PseudocodePackage.FOR_STATEMENT:
				sequence_ForStatement(context, (ForStatement) semanticObject); 
				return; 
			case PseudocodePackage.FUNCTION:
				sequence_Function(context, (Function) semanticObject); 
				return; 
			case PseudocodePackage.FUNCTION_CALL:
				sequence_FunctionCall(context, (FunctionCall) semanticObject); 
				return; 
			case PseudocodePackage.IF_STATEMENT:
				sequence_IfStatement(context, (IfStatement) semanticObject); 
				return; 
			case PseudocodePackage.LIST:
				sequence_List(context, (List) semanticObject); 
				return; 
			case PseudocodePackage.LIST_LITTERAL:
				sequence_ListLitteral(context, (ListLitteral) semanticObject); 
				return; 
			case PseudocodePackage.MINUS:
				sequence_Addition(context, (Minus) semanticObject); 
				return; 
			case PseudocodePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case PseudocodePackage.MULTI_OR_DIV:
				sequence_Multiplication(context, (MultiOrDiv) semanticObject); 
				return; 
			case PseudocodePackage.NUMBER_LITERAL:
				sequence_Atomic(context, (NumberLiteral) semanticObject); 
				return; 
			case PseudocodePackage.PARENTHESIZED_EXPRESSION:
				sequence_Atomic(context, (ParenthesizedExpression) semanticObject); 
				return; 
			case PseudocodePackage.PLUS:
				sequence_Addition(context, (Plus) semanticObject); 
				return; 
			case PseudocodePackage.PRINT:
				sequence_Print(context, (Print) semanticObject); 
				return; 
			case PseudocodePackage.SET_LITTERAL:
				sequence_SetLitteral(context, (SetLitteral) semanticObject); 
				return; 
			case PseudocodePackage.SIZE_EXPRESSION:
				sequence_SizeExpression(context, (SizeExpression) semanticObject); 
				return; 
			case PseudocodePackage.STOP:
				sequence_Stop(context, (Stop) semanticObject); 
				return; 
			case PseudocodePackage.STRING_LITERAL:
				sequence_Atomic(context, (StringLiteral) semanticObject); 
				return; 
			case PseudocodePackage.TYPE:
				sequence_Type(context, (Type) semanticObject); 
				return; 
			case PseudocodePackage.VALUE_EXCHANGE:
				sequence_ValueExchange(context, (ValueExchange) semanticObject); 
				return; 
			case PseudocodePackage.VARIABLE:
				if (rule == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Variable) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFeatureRule()
						|| rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case PseudocodePackage.VARIABLE_REFERENCE:
				sequence_Atomic(context, (VariableReference) semanticObject); 
				return; 
			case PseudocodePackage.WHILE_STATEMENT:
				sequence_WhileStatement(context, (WhileStatement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     LiteralExpression returns Minus
	 *     BooleanExpression returns Minus
	 *     BooleanExpression.AndOrExpression_1_0_0 returns Minus
	 *     Comparison returns Minus
	 *     Comparison.Comparison_1_0_0 returns Minus
	 *     Equals returns Minus
	 *     Equals.Equals_1_0_0 returns Minus
	 *     ArithmeticExpression returns Minus
	 *     Addition returns Minus
	 *     Addition.Plus_1_0_0_0 returns Minus
	 *     Addition.Minus_1_0_1_0 returns Minus
	 *
	 * Constraint:
	 *     (left=Addition_Minus_1_0_1_0 right=Multiplication)
	 */
	protected void sequence_Addition(ISerializationContext context, Minus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.MINUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.MINUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.MINUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.MINUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns Plus
	 *     BooleanExpression returns Plus
	 *     BooleanExpression.AndOrExpression_1_0_0 returns Plus
	 *     Comparison returns Plus
	 *     Comparison.Comparison_1_0_0 returns Plus
	 *     Equals returns Plus
	 *     Equals.Equals_1_0_0 returns Plus
	 *     ArithmeticExpression returns Plus
	 *     Addition returns Plus
	 *     Addition.Plus_1_0_0_0 returns Plus
	 *     Addition.Minus_1_0_1_0 returns Plus
	 *
	 * Constraint:
	 *     (left=Addition_Plus_1_0_0_0 right=Multiplication)
	 */
	protected void sequence_Addition(ISerializationContext context, Plus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.PLUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.PLUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.PLUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns BooleanLiteral
	 *     BooleanExpression returns BooleanLiteral
	 *     BooleanExpression.AndOrExpression_1_0_0 returns BooleanLiteral
	 *     Comparison returns BooleanLiteral
	 *     Comparison.Comparison_1_0_0 returns BooleanLiteral
	 *     Equals returns BooleanLiteral
	 *     Equals.Equals_1_0_0 returns BooleanLiteral
	 *     ArithmeticExpression returns BooleanLiteral
	 *     Addition returns BooleanLiteral
	 *     Addition.Plus_1_0_0_0 returns BooleanLiteral
	 *     Addition.Minus_1_0_1_0 returns BooleanLiteral
	 *     Multiplication returns BooleanLiteral
	 *     Multiplication.MultiOrDiv_1_0_0 returns BooleanLiteral
	 *     Prefixed returns BooleanLiteral
	 *     Atomic returns BooleanLiteral
	 *
	 * Constraint:
	 *     (value='true' | value='false')
	 */
	protected void sequence_Atomic(ISerializationContext context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns DoubleLiteral
	 *     BooleanExpression returns DoubleLiteral
	 *     BooleanExpression.AndOrExpression_1_0_0 returns DoubleLiteral
	 *     Comparison returns DoubleLiteral
	 *     Comparison.Comparison_1_0_0 returns DoubleLiteral
	 *     Equals returns DoubleLiteral
	 *     Equals.Equals_1_0_0 returns DoubleLiteral
	 *     ArithmeticExpression returns DoubleLiteral
	 *     Addition returns DoubleLiteral
	 *     Addition.Plus_1_0_0_0 returns DoubleLiteral
	 *     Addition.Minus_1_0_1_0 returns DoubleLiteral
	 *     Multiplication returns DoubleLiteral
	 *     Multiplication.MultiOrDiv_1_0_0 returns DoubleLiteral
	 *     Prefixed returns DoubleLiteral
	 *     Atomic returns DoubleLiteral
	 *
	 * Constraint:
	 *     value=DOUBLE
	 */
	protected void sequence_Atomic(ISerializationContext context, DoubleLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.DOUBLE_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.DOUBLE_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAtomicAccess().getValueDOUBLETerminalRuleCall_2_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns NumberLiteral
	 *     BooleanExpression returns NumberLiteral
	 *     BooleanExpression.AndOrExpression_1_0_0 returns NumberLiteral
	 *     Comparison returns NumberLiteral
	 *     Comparison.Comparison_1_0_0 returns NumberLiteral
	 *     Equals returns NumberLiteral
	 *     Equals.Equals_1_0_0 returns NumberLiteral
	 *     ArithmeticExpression returns NumberLiteral
	 *     Addition returns NumberLiteral
	 *     Addition.Plus_1_0_0_0 returns NumberLiteral
	 *     Addition.Minus_1_0_1_0 returns NumberLiteral
	 *     Multiplication returns NumberLiteral
	 *     Multiplication.MultiOrDiv_1_0_0 returns NumberLiteral
	 *     Prefixed returns NumberLiteral
	 *     Atomic returns NumberLiteral
	 *
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Atomic(ISerializationContext context, NumberLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.NUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.NUMBER_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns ParenthesizedExpression
	 *     BooleanExpression returns ParenthesizedExpression
	 *     BooleanExpression.AndOrExpression_1_0_0 returns ParenthesizedExpression
	 *     Comparison returns ParenthesizedExpression
	 *     Comparison.Comparison_1_0_0 returns ParenthesizedExpression
	 *     Equals returns ParenthesizedExpression
	 *     Equals.Equals_1_0_0 returns ParenthesizedExpression
	 *     ArithmeticExpression returns ParenthesizedExpression
	 *     Addition returns ParenthesizedExpression
	 *     Addition.Plus_1_0_0_0 returns ParenthesizedExpression
	 *     Addition.Minus_1_0_1_0 returns ParenthesizedExpression
	 *     Multiplication returns ParenthesizedExpression
	 *     Multiplication.MultiOrDiv_1_0_0 returns ParenthesizedExpression
	 *     Prefixed returns ParenthesizedExpression
	 *     Atomic returns ParenthesizedExpression
	 *
	 * Constraint:
	 *     expression=LiteralExpression
	 */
	protected void sequence_Atomic(ISerializationContext context, ParenthesizedExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.PARENTHESIZED_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.PARENTHESIZED_EXPRESSION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAtomicAccess().getExpressionLiteralExpressionParserRuleCall_0_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns StringLiteral
	 *     BooleanExpression returns StringLiteral
	 *     BooleanExpression.AndOrExpression_1_0_0 returns StringLiteral
	 *     Comparison returns StringLiteral
	 *     Comparison.Comparison_1_0_0 returns StringLiteral
	 *     Equals returns StringLiteral
	 *     Equals.Equals_1_0_0 returns StringLiteral
	 *     ArithmeticExpression returns StringLiteral
	 *     Addition returns StringLiteral
	 *     Addition.Plus_1_0_0_0 returns StringLiteral
	 *     Addition.Minus_1_0_1_0 returns StringLiteral
	 *     Multiplication returns StringLiteral
	 *     Multiplication.MultiOrDiv_1_0_0 returns StringLiteral
	 *     Prefixed returns StringLiteral
	 *     Atomic returns StringLiteral
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_Atomic(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.STRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_3_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns VariableReference
	 *     BooleanExpression returns VariableReference
	 *     BooleanExpression.AndOrExpression_1_0_0 returns VariableReference
	 *     Comparison returns VariableReference
	 *     Comparison.Comparison_1_0_0 returns VariableReference
	 *     Equals returns VariableReference
	 *     Equals.Equals_1_0_0 returns VariableReference
	 *     ArithmeticExpression returns VariableReference
	 *     Addition returns VariableReference
	 *     Addition.Plus_1_0_0_0 returns VariableReference
	 *     Addition.Minus_1_0_1_0 returns VariableReference
	 *     Multiplication returns VariableReference
	 *     Multiplication.MultiOrDiv_1_0_0 returns VariableReference
	 *     Prefixed returns VariableReference
	 *     Atomic returns VariableReference
	 *
	 * Constraint:
	 *     ref=[Variable|ID]
	 */
	protected void sequence_Atomic(ISerializationContext context, VariableReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.VARIABLE_REFERENCE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.VARIABLE_REFERENCE__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAtomicAccess().getRefVariableIDTerminalRuleCall_5_1_0_1(), semanticObject.eGet(PseudocodePackage.Literals.VARIABLE_REFERENCE__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns AndOrExpression
	 *     BooleanExpression returns AndOrExpression
	 *     BooleanExpression.AndOrExpression_1_0_0 returns AndOrExpression
	 *
	 * Constraint:
	 *     (left=BooleanExpression_AndOrExpression_1_0_0 (op=OrOperator | op=AndOperator) right=Comparison)
	 */
	protected void sequence_BooleanExpression(ISerializationContext context, AndOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns CollectionAccessor
	 *     CollectionAccessor returns CollectionAccessor
	 *
	 * Constraint:
	 *     ((collection=[Variable|ID] accessor+=LiteralExpression+) | (collection=[Variable|ID] accessor+=LiteralExpression accessor+=LiteralExpression*))
	 */
	protected void sequence_CollectionAccessor(ISerializationContext context, CollectionAccessor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns CollectionAdd
	 *     Expression returns CollectionAdd
	 *     CollectionAdd returns CollectionAdd
	 *
	 * Constraint:
	 *     (collection=[Variable|ID] value=LiteralExpression)
	 */
	protected void sequence_CollectionAdd(ISerializationContext context, CollectionAdd semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.COLLECTION_ADD__COLLECTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.COLLECTION_ADD__COLLECTION));
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.COLLECTION_ADD__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.COLLECTION_ADD__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCollectionAddAccess().getCollectionVariableIDTerminalRuleCall_1_0_1(), semanticObject.eGet(PseudocodePackage.Literals.COLLECTION_ADD__COLLECTION, false));
		feeder.accept(grammarAccess.getCollectionAddAccess().getValueLiteralExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns CollectionRemove
	 *     Expression returns CollectionRemove
	 *     CollectionRemove returns CollectionRemove
	 *
	 * Constraint:
	 *     (collection=[Variable|ID] value=LiteralExpression)
	 */
	protected void sequence_CollectionRemove(ISerializationContext context, CollectionRemove semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.COLLECTION_REMOVE__COLLECTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.COLLECTION_REMOVE__COLLECTION));
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.COLLECTION_REMOVE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.COLLECTION_REMOVE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCollectionRemoveAccess().getCollectionVariableIDTerminalRuleCall_1_0_1(), semanticObject.eGet(PseudocodePackage.Literals.COLLECTION_REMOVE__COLLECTION, false));
		feeder.accept(grammarAccess.getCollectionRemoveAccess().getValueLiteralExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns Comparison
	 *     BooleanExpression returns Comparison
	 *     BooleanExpression.AndOrExpression_1_0_0 returns Comparison
	 *     Comparison returns Comparison
	 *     Comparison.Comparison_1_0_0 returns Comparison
	 *
	 * Constraint:
	 *     (left=Comparison_Comparison_1_0_0 (op='<' | op='lessThen' | op='>' | op='biggerThen') right=Equals)
	 */
	protected void sequence_Comparison(ISerializationContext context, Comparison semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns Equals
	 *     BooleanExpression returns Equals
	 *     BooleanExpression.AndOrExpression_1_0_0 returns Equals
	 *     Comparison returns Equals
	 *     Comparison.Comparison_1_0_0 returns Equals
	 *     Equals returns Equals
	 *     Equals.Equals_1_0_0 returns Equals
	 *
	 * Constraint:
	 *     (left=Equals_Equals_1_0_0 (op='==' | op='<=' | op='>=' | op='!=') right=Addition)
	 */
	protected void sequence_Equals(ISerializationContext context, Equals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns ForStatement
	 *     Statement returns ForStatement
	 *     ForStatement returns ForStatement
	 *
	 * Constraint:
	 *     (from=ArithmeticExpression to=ArithmeticExpression block+=Feature*)
	 */
	protected void sequence_ForStatement(ISerializationContext context, ForStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns FunctionCall
	 *     Expression returns FunctionCall
	 *     LiteralExpression returns FunctionCall
	 *     BooleanExpression returns FunctionCall
	 *     BooleanExpression.AndOrExpression_1_0_0 returns FunctionCall
	 *     Comparison returns FunctionCall
	 *     Comparison.Comparison_1_0_0 returns FunctionCall
	 *     Equals returns FunctionCall
	 *     Equals.Equals_1_0_0 returns FunctionCall
	 *     ArithmeticExpression returns FunctionCall
	 *     Addition returns FunctionCall
	 *     Addition.Plus_1_0_0_0 returns FunctionCall
	 *     Addition.Minus_1_0_1_0 returns FunctionCall
	 *     Multiplication returns FunctionCall
	 *     Multiplication.MultiOrDiv_1_0_0 returns FunctionCall
	 *     Prefixed returns FunctionCall
	 *     Atomic returns FunctionCall
	 *     FunctionCall returns FunctionCall
	 *
	 * Constraint:
	 *     (ref=[Function|ID] (arguments+=LiteralExpression arguments+=LiteralExpression*)?)
	 */
	protected void sequence_FunctionCall(ISerializationContext context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (executable?='executable'? name=ID (parameters+=Parameter parameters+=Parameter*)? features+=Feature*)
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns IfStatement
	 *     Statement returns IfStatement
	 *     IfStatement returns IfStatement
	 *
	 * Constraint:
	 *     (name='if' condition=LiteralExpression then+=Feature* otherwise+=Feature*)
	 */
	protected void sequence_IfStatement(ISerializationContext context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns ListLitteral
	 *     Collection returns ListLitteral
	 *     CollectionLitteral returns ListLitteral
	 *     ListLitteral returns ListLitteral
	 *
	 * Constraint:
	 *     (elements+=LiteralExpression elements+=LiteralExpression*)
	 */
	protected void sequence_ListLitteral(ISerializationContext context, ListLitteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns List
	 *     Collection returns List
	 *     List returns List
	 *
	 * Constraint:
	 *     (type=Type (elements+=LiteralExpression elements+=LiteralExpression*)?)
	 */
	protected void sequence_List(ISerializationContext context, List semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (package=QualifiedName? functions+=Function*)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns MultiOrDiv
	 *     BooleanExpression returns MultiOrDiv
	 *     BooleanExpression.AndOrExpression_1_0_0 returns MultiOrDiv
	 *     Comparison returns MultiOrDiv
	 *     Comparison.Comparison_1_0_0 returns MultiOrDiv
	 *     Equals returns MultiOrDiv
	 *     Equals.Equals_1_0_0 returns MultiOrDiv
	 *     ArithmeticExpression returns MultiOrDiv
	 *     Addition returns MultiOrDiv
	 *     Addition.Plus_1_0_0_0 returns MultiOrDiv
	 *     Addition.Minus_1_0_1_0 returns MultiOrDiv
	 *     Multiplication returns MultiOrDiv
	 *     Multiplication.MultiOrDiv_1_0_0 returns MultiOrDiv
	 *
	 * Constraint:
	 *     (left=Multiplication_MultiOrDiv_1_0_0 (op=TimesOperator | op=DivideOperator) right=Prefixed)
	 */
	protected void sequence_Multiplication(ISerializationContext context, MultiOrDiv semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns Variable
	 *
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Parameter(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.VARIABLE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.VARIABLE__TYPE));
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.VARIABLE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns ArithmeticSigned
	 *     BooleanExpression returns ArithmeticSigned
	 *     BooleanExpression.AndOrExpression_1_0_0 returns ArithmeticSigned
	 *     Comparison returns ArithmeticSigned
	 *     Comparison.Comparison_1_0_0 returns ArithmeticSigned
	 *     Equals returns ArithmeticSigned
	 *     Equals.Equals_1_0_0 returns ArithmeticSigned
	 *     ArithmeticExpression returns ArithmeticSigned
	 *     Addition returns ArithmeticSigned
	 *     Addition.Plus_1_0_0_0 returns ArithmeticSigned
	 *     Addition.Minus_1_0_1_0 returns ArithmeticSigned
	 *     Multiplication returns ArithmeticSigned
	 *     Multiplication.MultiOrDiv_1_0_0 returns ArithmeticSigned
	 *     Prefixed returns ArithmeticSigned
	 *
	 * Constraint:
	 *     expression=Atomic
	 */
	protected void sequence_Prefixed(ISerializationContext context, ArithmeticSigned semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.ARITHMETIC_SIGNED__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.ARITHMETIC_SIGNED__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns BooleanNegation
	 *     BooleanExpression returns BooleanNegation
	 *     BooleanExpression.AndOrExpression_1_0_0 returns BooleanNegation
	 *     Comparison returns BooleanNegation
	 *     Comparison.Comparison_1_0_0 returns BooleanNegation
	 *     Equals returns BooleanNegation
	 *     Equals.Equals_1_0_0 returns BooleanNegation
	 *     ArithmeticExpression returns BooleanNegation
	 *     Addition returns BooleanNegation
	 *     Addition.Plus_1_0_0_0 returns BooleanNegation
	 *     Addition.Minus_1_0_1_0 returns BooleanNegation
	 *     Multiplication returns BooleanNegation
	 *     Multiplication.MultiOrDiv_1_0_0 returns BooleanNegation
	 *     Prefixed returns BooleanNegation
	 *
	 * Constraint:
	 *     expression=Atomic
	 */
	protected void sequence_Prefixed(ISerializationContext context, BooleanNegation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.BOOLEAN_NEGATION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.BOOLEAN_NEGATION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns Print
	 *     Expression returns Print
	 *     Print returns Print
	 *
	 * Constraint:
	 *     (name='print' newline?='line'? value=LiteralExpression)
	 */
	protected void sequence_Print(ISerializationContext context, Print semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns SetLitteral
	 *     Collection returns SetLitteral
	 *     CollectionLitteral returns SetLitteral
	 *     SetLitteral returns SetLitteral
	 *
	 * Constraint:
	 *     (elements+=LiteralExpression elements+=LiteralExpression*)
	 */
	protected void sequence_SetLitteral(ISerializationContext context, SetLitteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralExpression returns SizeExpression
	 *     BooleanExpression returns SizeExpression
	 *     BooleanExpression.AndOrExpression_1_0_0 returns SizeExpression
	 *     Comparison returns SizeExpression
	 *     Comparison.Comparison_1_0_0 returns SizeExpression
	 *     Equals returns SizeExpression
	 *     Equals.Equals_1_0_0 returns SizeExpression
	 *     ArithmeticExpression returns SizeExpression
	 *     Addition returns SizeExpression
	 *     Addition.Plus_1_0_0_0 returns SizeExpression
	 *     Addition.Minus_1_0_1_0 returns SizeExpression
	 *     Multiplication returns SizeExpression
	 *     Multiplication.MultiOrDiv_1_0_0 returns SizeExpression
	 *     Prefixed returns SizeExpression
	 *     Atomic returns SizeExpression
	 *     SizeExpression returns SizeExpression
	 *
	 * Constraint:
	 *     value=Atomic
	 */
	protected void sequence_SizeExpression(ISerializationContext context, SizeExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.SIZE_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.SIZE_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSizeExpressionAccess().getValueAtomicParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns Stop
	 *     Statement returns Stop
	 *     Stop returns Stop
	 *
	 * Constraint:
	 *     (type='stop' | type='break' | type='continue' | (type='return' value=LiteralExpression))
	 */
	protected void sequence_Stop(ISerializationContext context, Stop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns Type
	 *
	 * Constraint:
	 *     (types+=TypeLiteral types+=TypeLiteral*)
	 */
	protected void sequence_Type(ISerializationContext context, Type semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns ValueExchange
	 *     Expression returns ValueExchange
	 *     ValueExchange returns ValueExchange
	 *
	 * Constraint:
	 *     (collection=LiteralExpression value=LiteralExpression)
	 */
	protected void sequence_ValueExchange(ISerializationContext context, ValueExchange semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.VALUE_EXCHANGE__COLLECTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.VALUE_EXCHANGE__COLLECTION));
			if (transientValues.isValueTransient(semanticObject, PseudocodePackage.Literals.VALUE_EXCHANGE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PseudocodePackage.Literals.VALUE_EXCHANGE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getValueExchangeAccess().getCollectionLiteralExpressionParserRuleCall_2_0(), semanticObject.getCollection());
		feeder.accept(grammarAccess.getValueExchangeAccess().getValueLiteralExpressionParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns Variable
	 *     Expression returns Variable
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     ((name=ID (op='=' | op='equals' | op='is' | op='+=' | op='-=') value=LiteralExpression) | (name=ID (op='++' | op='--')))
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns WhileStatement
	 *     Statement returns WhileStatement
	 *     WhileStatement returns WhileStatement
	 *
	 * Constraint:
	 *     (condition=LiteralExpression block+=Feature*)
	 */
	protected void sequence_WhileStatement(ISerializationContext context, WhileStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
