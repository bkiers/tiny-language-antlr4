// Generated from /Users/yosimycortes/Documents/code/CMPE152/Project4/tiny-language-antlr4/src/main/antlr4/tl/antlr4/TL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Println=1, Print=2, Input=3, Assert=4, Size=5, Def=6, If=7, Else=8, Return=9, 
		For=10, While=11, To=12, Do=13, End=14, In=15, Null=16, Or=17, And=18, 
		Equals=19, NEquals=20, GTEquals=21, LTEquals=22, Pow=23, Excl=24, GT=25, 
		LT=26, Add=27, Subtract=28, Multiply=29, Divide=30, Modulus=31, OBrace=32, 
		CBrace=33, OBracket=34, CBracket=35, OParen=36, CParen=37, SColon=38, 
		Assign=39, Comma=40, QMark=41, Colon=42, Bool=43, Number=44, Identifier=45, 
		String=46, Comment=47, Space=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Println", "Print", "Input", "Assert", "Size", "Def", "If", "Else", "Return", 
			"For", "While", "To", "Do", "End", "In", "Null", "Or", "And", "Equals", 
			"NEquals", "GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", "Add", 
			"Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", "OBracket", 
			"CBracket", "OParen", "CParen", "SColon", "Assign", "Comma", "QMark", 
			"Colon", "Bool", "Number", "Identifier", "String", "Comment", "Space", 
			"Int", "Digit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'println'", "'print'", "'input'", "'assert'", "'size'", "'def'", 
			"'if'", "'else'", "'return'", "'for'", "'while'", "'to'", "'do'", "'end'", 
			"'in'", "'null'", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'^'", 
			"'!'", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'{'", "'}'", 
			"'['", "']'", "'('", "')'", "';'", "'='", "','", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Println", "Print", "Input", "Assert", "Size", "Def", "If", "Else", 
			"Return", "For", "While", "To", "Do", "End", "In", "Null", "Or", "And", 
			"Equals", "NEquals", "GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", 
			"Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", 
			"OBracket", "CBracket", "OParen", "CParen", "SColon", "Assign", "Comma", 
			"QMark", "Colon", "Bool", "Number", "Identifier", "String", "Comment", 
			"Space"
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


	public TLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TL.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u014a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u00fa\n,\3-\3-\3-\7-\u00ff"+
		"\n-\f-\16-\u0102\13-\5-\u0104\n-\3.\3.\7.\u0108\n.\f.\16.\u010b\13.\3"+
		"/\3/\3/\3/\7/\u0111\n/\f/\16/\u0114\13/\3/\3/\3/\3/\3/\7/\u011b\n/\f/"+
		"\16/\u011e\13/\3/\5/\u0121\n/\3\60\3\60\3\60\3\60\7\60\u0127\n\60\f\60"+
		"\16\60\u012a\13\60\3\60\3\60\3\60\3\60\7\60\u0130\n\60\f\60\16\60\u0133"+
		"\13\60\3\60\3\60\5\60\u0137\n\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3"+
		"\62\7\62\u0141\n\62\f\62\16\62\u0144\13\62\3\62\5\62\u0147\n\62\3\63\3"+
		"\63\3\u0131\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\2"+
		"\3\2\f\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\6\2\f\f\17\17$$^^\4\2\f\f\17\17"+
		"\3\2))\6\2\f\f\17\17))^^\5\2\13\f\16\17\"\"\3\2\63;\3\2\62;\2\u0155\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\3g\3\2\2\2\5o\3\2\2\2\7u\3\2\2\2\t{\3\2\2\2\13\u0082\3\2\2\2\r\u0087"+
		"\3\2\2\2\17\u008b\3\2\2\2\21\u008e\3\2\2\2\23\u0093\3\2\2\2\25\u009a\3"+
		"\2\2\2\27\u009e\3\2\2\2\31\u00a4\3\2\2\2\33\u00a7\3\2\2\2\35\u00aa\3\2"+
		"\2\2\37\u00ae\3\2\2\2!\u00b1\3\2\2\2#\u00b6\3\2\2\2%\u00b9\3\2\2\2\'\u00bc"+
		"\3\2\2\2)\u00bf\3\2\2\2+\u00c2\3\2\2\2-\u00c5\3\2\2\2/\u00c8\3\2\2\2\61"+
		"\u00ca\3\2\2\2\63\u00cc\3\2\2\2\65\u00ce\3\2\2\2\67\u00d0\3\2\2\29\u00d2"+
		"\3\2\2\2;\u00d4\3\2\2\2=\u00d6\3\2\2\2?\u00d8\3\2\2\2A\u00da\3\2\2\2C"+
		"\u00dc\3\2\2\2E\u00de\3\2\2\2G\u00e0\3\2\2\2I\u00e2\3\2\2\2K\u00e4\3\2"+
		"\2\2M\u00e6\3\2\2\2O\u00e8\3\2\2\2Q\u00ea\3\2\2\2S\u00ec\3\2\2\2U\u00ee"+
		"\3\2\2\2W\u00f9\3\2\2\2Y\u00fb\3\2\2\2[\u0105\3\2\2\2]\u0120\3\2\2\2_"+
		"\u0136\3\2\2\2a\u013a\3\2\2\2c\u0146\3\2\2\2e\u0148\3\2\2\2gh\7r\2\2h"+
		"i\7t\2\2ij\7k\2\2jk\7p\2\2kl\7v\2\2lm\7n\2\2mn\7p\2\2n\4\3\2\2\2op\7r"+
		"\2\2pq\7t\2\2qr\7k\2\2rs\7p\2\2st\7v\2\2t\6\3\2\2\2uv\7k\2\2vw\7p\2\2"+
		"wx\7r\2\2xy\7w\2\2yz\7v\2\2z\b\3\2\2\2{|\7c\2\2|}\7u\2\2}~\7u\2\2~\177"+
		"\7g\2\2\177\u0080\7t\2\2\u0080\u0081\7v\2\2\u0081\n\3\2\2\2\u0082\u0083"+
		"\7u\2\2\u0083\u0084\7k\2\2\u0084\u0085\7|\2\2\u0085\u0086\7g\2\2\u0086"+
		"\f\3\2\2\2\u0087\u0088\7f\2\2\u0088\u0089\7g\2\2\u0089\u008a\7h\2\2\u008a"+
		"\16\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7h\2\2\u008d\20\3\2\2\2\u008e"+
		"\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090\u0091\7u\2\2\u0091\u0092\7g\2\2"+
		"\u0092\22\3\2\2\2\u0093\u0094\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7"+
		"v\2\2\u0096\u0097\7w\2\2\u0097\u0098\7t\2\2\u0098\u0099\7p\2\2\u0099\24"+
		"\3\2\2\2\u009a\u009b\7h\2\2\u009b\u009c\7q\2\2\u009c\u009d\7t\2\2\u009d"+
		"\26\3\2\2\2\u009e\u009f\7y\2\2\u009f\u00a0\7j\2\2\u00a0\u00a1\7k\2\2\u00a1"+
		"\u00a2\7n\2\2\u00a2\u00a3\7g\2\2\u00a3\30\3\2\2\2\u00a4\u00a5\7v\2\2\u00a5"+
		"\u00a6\7q\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7q\2\2\u00a9"+
		"\34\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7f\2\2\u00ad"+
		"\36\3\2\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7p\2\2\u00b0 \3\2\2\2\u00b1"+
		"\u00b2\7p\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7n\2\2"+
		"\u00b5\"\3\2\2\2\u00b6\u00b7\7~\2\2\u00b7\u00b8\7~\2\2\u00b8$\3\2\2\2"+
		"\u00b9\u00ba\7(\2\2\u00ba\u00bb\7(\2\2\u00bb&\3\2\2\2\u00bc\u00bd\7?\2"+
		"\2\u00bd\u00be\7?\2\2\u00be(\3\2\2\2\u00bf\u00c0\7#\2\2\u00c0\u00c1\7"+
		"?\2\2\u00c1*\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3\u00c4\7?\2\2\u00c4,\3\2"+
		"\2\2\u00c5\u00c6\7>\2\2\u00c6\u00c7\7?\2\2\u00c7.\3\2\2\2\u00c8\u00c9"+
		"\7`\2\2\u00c9\60\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb\62\3\2\2\2\u00cc\u00cd"+
		"\7@\2\2\u00cd\64\3\2\2\2\u00ce\u00cf\7>\2\2\u00cf\66\3\2\2\2\u00d0\u00d1"+
		"\7-\2\2\u00d18\3\2\2\2\u00d2\u00d3\7/\2\2\u00d3:\3\2\2\2\u00d4\u00d5\7"+
		",\2\2\u00d5<\3\2\2\2\u00d6\u00d7\7\61\2\2\u00d7>\3\2\2\2\u00d8\u00d9\7"+
		"\'\2\2\u00d9@\3\2\2\2\u00da\u00db\7}\2\2\u00dbB\3\2\2\2\u00dc\u00dd\7"+
		"\177\2\2\u00ddD\3\2\2\2\u00de\u00df\7]\2\2\u00dfF\3\2\2\2\u00e0\u00e1"+
		"\7_\2\2\u00e1H\3\2\2\2\u00e2\u00e3\7*\2\2\u00e3J\3\2\2\2\u00e4\u00e5\7"+
		"+\2\2\u00e5L\3\2\2\2\u00e6\u00e7\7=\2\2\u00e7N\3\2\2\2\u00e8\u00e9\7?"+
		"\2\2\u00e9P\3\2\2\2\u00ea\u00eb\7.\2\2\u00ebR\3\2\2\2\u00ec\u00ed\7A\2"+
		"\2\u00edT\3\2\2\2\u00ee\u00ef\7<\2\2\u00efV\3\2\2\2\u00f0\u00f1\7v\2\2"+
		"\u00f1\u00f2\7t\2\2\u00f2\u00f3\7w\2\2\u00f3\u00fa\7g\2\2\u00f4\u00f5"+
		"\7h\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7u\2\2\u00f8"+
		"\u00fa\7g\2\2\u00f9\u00f0\3\2\2\2\u00f9\u00f4\3\2\2\2\u00faX\3\2\2\2\u00fb"+
		"\u0103\5c\62\2\u00fc\u0100\7\60\2\2\u00fd\u00ff\5e\63\2\u00fe\u00fd\3"+
		"\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u00fc\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104Z\3\2\2\2\u0105\u0109\t\2\2\2\u0106\u0108\t\3\2\2\u0107\u0106"+
		"\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\\\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0112\t\4\2\2\u010d\u0111\n\5\2\2"+
		"\u010e\u010f\7^\2\2\u010f\u0111\n\6\2\2\u0110\u010d\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0121\t\4\2\2\u0116\u011c\t\7"+
		"\2\2\u0117\u011b\n\b\2\2\u0118\u0119\7^\2\2\u0119\u011b\n\6\2\2\u011a"+
		"\u0117\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0121\t\7\2\2\u0120\u010c\3\2\2\2\u0120\u0116\3\2\2\2\u0121^\3\2\2\2"+
		"\u0122\u0123\7\61\2\2\u0123\u0124\7\61\2\2\u0124\u0128\3\2\2\2\u0125\u0127"+
		"\n\6\2\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u0137\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7\61"+
		"\2\2\u012c\u012d\7,\2\2\u012d\u0131\3\2\2\2\u012e\u0130\13\2\2\2\u012f"+
		"\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u0132\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7,\2\2\u0135"+
		"\u0137\7\61\2\2\u0136\u0122\3\2\2\2\u0136\u012b\3\2\2\2\u0137\u0138\3"+
		"\2\2\2\u0138\u0139\b\60\2\2\u0139`\3\2\2\2\u013a\u013b\t\t\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013d\b\61\2\2\u013db\3\2\2\2\u013e\u0142\t\n\2\2\u013f"+
		"\u0141\5e\63\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0147\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0147\7\62\2\2\u0146\u013e\3\2\2\2\u0146\u0145\3\2\2\2\u0147d\3\2\2\2"+
		"\u0148\u0149\t\13\2\2\u0149f\3\2\2\2\21\2\u00f9\u0100\u0103\u0109\u0110"+
		"\u0112\u011a\u011c\u0120\u0128\u0131\u0136\u0142\u0146\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}