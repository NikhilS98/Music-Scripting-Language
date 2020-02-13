// Generated from Mupl.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MuplLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, COMMENT=3, WHITESPACE=4, INT=5, KEYWORD=6, INSTRUMENT=7, 
		TYPE=8, OPERATOR=9, DELIMITER=10, IDENTIFIER=11, LITERAL=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "COMMENT", "WHITESPACE", "INT", "KEYWORD", "INSTRUMENT", 
			"TYPE", "OPERATOR", "DELIMITER", "IDENTIFIER", "LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'begin'", "'end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "COMMENT", "WHITESPACE", "INT", "KEYWORD", "INSTRUMENT", 
			"TYPE", "OPERATOR", "DELIMITER", "IDENTIFIER", "LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MuplLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mupl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 2:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		case 1:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u009d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\4\3\4\3\4\7\4\64\n\4\f\4"+
		"\16\4\67\13\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\6\5@\n\5\r\5\16\5A\3\5\3\5"+
		"\3\6\6\6G\n\6\r\6\16\6H\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bq\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0088"+
		"\n\t\3\n\3\n\3\13\3\13\3\f\3\f\7\f\u0090\n\f\f\f\16\f\u0093\13\f\3\r\3"+
		"\r\7\r\u0097\n\r\f\r\16\r\u009a\13\r\3\r\3\r\3\65\2\16\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\n\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\3\2\62;\4\2--??\5\2==]]__\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2"+
		"\f\f\17\17$$\2\u00aa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5!\3\2\2\2\7<\3\2\2\2\t"+
		"?\3\2\2\2\13F\3\2\2\2\rY\3\2\2\2\17p\3\2\2\2\21\u0087\3\2\2\2\23\u0089"+
		"\3\2\2\2\25\u008b\3\2\2\2\27\u008d\3\2\2\2\31\u0094\3\2\2\2\33\34\7d\2"+
		"\2\34\35\7g\2\2\35\36\7i\2\2\36\37\7k\2\2\37 \7p\2\2 \4\3\2\2\2!\"\7g"+
		"\2\2\"#\7p\2\2#$\7f\2\2$\6\3\2\2\2%&\7\61\2\2&\'\7\61\2\2\'+\3\2\2\2("+
		"*\n\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2"+
		".=\b\4\2\2/\60\7\61\2\2\60\61\7,\2\2\61\65\3\2\2\2\62\64\13\2\2\2\63\62"+
		"\3\2\2\2\64\67\3\2\2\2\65\66\3\2\2\2\65\63\3\2\2\2\668\3\2\2\2\67\65\3"+
		"\2\2\289\7,\2\29:\7\61\2\2:;\3\2\2\2;=\b\4\3\2<%\3\2\2\2</\3\2\2\2=\b"+
		"\3\2\2\2>@\t\3\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2C"+
		"D\b\5\4\2D\n\3\2\2\2EG\t\4\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2"+
		"I\f\3\2\2\2JK\7r\2\2KL\7n\2\2LM\7c\2\2MZ\7{\2\2NO\7y\2\2OP\7k\2\2PQ\7"+
		"v\2\2QZ\7j\2\2RS\7c\2\2SZ\7v\2\2TU\7v\2\2UV\7k\2\2VW\7o\2\2WX\7g\2\2X"+
		"Z\7u\2\2YJ\3\2\2\2YN\3\2\2\2YR\3\2\2\2YT\3\2\2\2Z\16\3\2\2\2[\\\7r\2\2"+
		"\\]\7k\2\2]^\7c\2\2^_\7p\2\2_q\7q\2\2`a\7i\2\2ab\7w\2\2bc\7k\2\2cd\7v"+
		"\2\2de\7c\2\2eq\7t\2\2fg\7f\2\2gh\7t\2\2hi\7w\2\2iq\7o\2\2jk\7x\2\2kl"+
		"\7k\2\2lm\7q\2\2mn\7n\2\2no\7k\2\2oq\7p\2\2p[\3\2\2\2p`\3\2\2\2pf\3\2"+
		"\2\2pj\3\2\2\2q\20\3\2\2\2rs\7r\2\2st\7t\2\2tu\7q\2\2uv\7i\2\2vw\7t\2"+
		"\2wx\7g\2\2xy\7u\2\2yz\7u\2\2z{\7k\2\2{|\7q\2\2|\u0088\7p\2\2}~\7k\2\2"+
		"~\177\7p\2\2\177\u0080\7u\2\2\u0080\u0081\7v\2\2\u0081\u0082\7t\2\2\u0082"+
		"\u0083\7w\2\2\u0083\u0084\7o\2\2\u0084\u0085\7g\2\2\u0085\u0086\7p\2\2"+
		"\u0086\u0088\7v\2\2\u0087r\3\2\2\2\u0087}\3\2\2\2\u0088\22\3\2\2\2\u0089"+
		"\u008a\t\5\2\2\u008a\24\3\2\2\2\u008b\u008c\t\6\2\2\u008c\26\3\2\2\2\u008d"+
		"\u0091\t\7\2\2\u008e\u0090\t\b\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2"+
		"\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\30\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0094\u0098\7$\2\2\u0095\u0097\n\t\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7$\2\2\u009c\32\3\2\2\2\r\2+\65<"+
		"AHYp\u0087\u0091\u0098\5\3\4\2\3\4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}