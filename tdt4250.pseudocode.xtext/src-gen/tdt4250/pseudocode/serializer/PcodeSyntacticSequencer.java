/*
 * generated by Xtext 2.23.0
 */
package tdt4250.pseudocode.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import tdt4250.pseudocode.services.PcodeGrammarAccess;

@SuppressWarnings("all")
public class PcodeSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PcodeGrammarAccess grammarAccess;
	protected AbstractElementAlias match_MethodBody_EqualsParserRuleCall_1_0_or_IfParserRuleCall_1_1;
	protected AbstractElementAlias match_Method_LineFeedKeyword_5_a;
	protected AbstractElementAlias match_Method_LineFeedKeyword_6_1_0_a;
	protected AbstractElementAlias match_Method___ReturnKeyword_7_0___DOUBLETerminalRuleCall_7_1_1_or_EStringParserRuleCall_7_1_0_or_INTTerminalRuleCall_7_1_2____a;
	protected AbstractElementAlias match_PseudoClass_LineFeedKeyword_3_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PcodeGrammarAccess) access;
		match_MethodBody_EqualsParserRuleCall_1_0_or_IfParserRuleCall_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getMethodBodyAccess().getEqualsParserRuleCall_1_0()), new TokenAlias(false, false, grammarAccess.getMethodBodyAccess().getIfParserRuleCall_1_1()));
		match_Method_LineFeedKeyword_5_a = new TokenAlias(true, true, grammarAccess.getMethodAccess().getLineFeedKeyword_5());
		match_Method_LineFeedKeyword_6_1_0_a = new TokenAlias(true, true, grammarAccess.getMethodAccess().getLineFeedKeyword_6_1_0());
		match_Method___ReturnKeyword_7_0___DOUBLETerminalRuleCall_7_1_1_or_EStringParserRuleCall_7_1_0_or_INTTerminalRuleCall_7_1_2____a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getMethodAccess().getReturnKeyword_7_0()), new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getMethodAccess().getDOUBLETerminalRuleCall_7_1_1()), new TokenAlias(false, false, grammarAccess.getMethodAccess().getEStringParserRuleCall_7_1_0()), new TokenAlias(false, false, grammarAccess.getMethodAccess().getINTTerminalRuleCall_7_1_2())));
		match_PseudoClass_LineFeedKeyword_3_a = new TokenAlias(true, true, grammarAccess.getPseudoClassAccess().getLineFeedKeyword_3());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getDOUBLERule())
			return getDOUBLEToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEStringRule())
			return getEStringToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEqualsRule())
			return getEqualsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getIfRule())
			return getIfToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal DOUBLE:
	 *     INT '.' INT;
	 */
	protected String getDOUBLEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * EString returns ecore::EString:
	 * 	STRING | ID;
	 */
	protected String getEStringToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	/**
	 * Equals:
	 * 	EString '=' (EString | DOUBLE | INT)
	 * ;
	 */
	protected String getEqualsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\" =";
	}
	
	/**
	 * terminal INT returns ecore::EInt: ('0'..'9')+;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * If:
	 * 	'if' Type ('==' |'<' |'<=' | '>' | '>=') Type
	 * ;
	 */
	protected String getIfToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "if \"\" ==";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_MethodBody_EqualsParserRuleCall_1_0_or_IfParserRuleCall_1_1.equals(syntax))
				emit_MethodBody_EqualsParserRuleCall_1_0_or_IfParserRuleCall_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Method_LineFeedKeyword_5_a.equals(syntax))
				emit_Method_LineFeedKeyword_5_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Method_LineFeedKeyword_6_1_0_a.equals(syntax))
				emit_Method_LineFeedKeyword_6_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Method___ReturnKeyword_7_0___DOUBLETerminalRuleCall_7_1_1_or_EStringParserRuleCall_7_1_0_or_INTTerminalRuleCall_7_1_2____a.equals(syntax))
				emit_Method___ReturnKeyword_7_0___DOUBLETerminalRuleCall_7_1_1_or_EStringParserRuleCall_7_1_0_or_INTTerminalRuleCall_7_1_2____a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PseudoClass_LineFeedKeyword_3_a.equals(syntax))
				emit_PseudoClass_LineFeedKeyword_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     Equals | If
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_MethodBody_EqualsParserRuleCall_1_0_or_IfParserRuleCall_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '
	  *     '*
	 *
	 * This ambiguous syntax occurs at:
	 *     name=EString '(' ')' (ambiguity) ('return' (EString | DOUBLE | INT))* (rule end)
	 *     name=EString '(' ')' (ambiguity) parameters+=MethodBody
	 *     parameters+=Parameter ')' (ambiguity) ('return' (EString | DOUBLE | INT))* (rule end)
	 *     parameters+=Parameter ')' (ambiguity) parameters+=MethodBody
	 */
	protected void emit_Method_LineFeedKeyword_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '
	  *     '*
	 *
	 * This ambiguous syntax occurs at:
	 *     parameters+=MethodBody (ambiguity) parameters+=MethodBody
	 */
	protected void emit_Method_LineFeedKeyword_6_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('return' (EString | DOUBLE | INT))*
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         name=EString 
	 *         '(' 
	 *         ')' 
	 *         '
	 *         '* 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         parameters+=Parameter 
	 *         ')' 
	 *         '
	 *         '* 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     parameters+=MethodBody (ambiguity) (rule end)
	 */
	protected void emit_Method___ReturnKeyword_7_0___DOUBLETerminalRuleCall_7_1_1_or_EStringParserRuleCall_7_1_0_or_INTTerminalRuleCall_7_1_2____a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '
	  *     '*
	 *
	 * This ambiguous syntax occurs at:
	 *     members+=Constructor (ambiguity) (rule end)
	 *     members+=Constructor (ambiguity) members+=Method
	 *     name=EString (ambiguity) (rule end)
	 *     name=EString (ambiguity) members+=Method
	 */
	protected void emit_PseudoClass_LineFeedKeyword_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}