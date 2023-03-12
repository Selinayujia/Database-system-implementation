// Generated from /Users/yujiazhang/Documents/GitHub/Database-system-implementation/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.9.2

package project.parsers;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPathGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TAGNAME=21, ATTRNAME=22, TEXT=23, FILENAME=24, 
		STRINGCONSTANT=25, WHITESPACE=26;
	public static final int
		RULE_ap = 0, RULE_rp = 1, RULE_f = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc'", "'document'", "'('", "')'", "'/'", "'//'", "'*'", "'.'", 
			"'..'", "'text()'", "'['", "']'", "','", "'='", "'eq'", "'=='", "'is'", 
			"'and'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TAGNAME", "ATTRNAME", 
			"TEXT", "FILENAME", "STRINGCONSTANT", "WHITESPACE"
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

	@Override
	public String getGrammarFileName() { return "XPathGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoubleSlashAPContext extends ApContext {
		public TerminalNode FILENAME() { return getToken(XPathGrammarParser.FILENAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DoubleSlashAPContext(ApContext ctx) { copyFrom(ctx); }
	}
	public static class SingleSlashAPContext extends ApContext {
		public TerminalNode FILENAME() { return getToken(XPathGrammarParser.FILENAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SingleSlashAPContext(ApContext ctx) { copyFrom(ctx); }
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		int _la;
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SingleSlashAPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(7);
				match(T__2);
				setState(8);
				match(FILENAME);
				setState(9);
				match(T__3);
				setState(10);
				match(T__4);
				setState(11);
				rp(0);
				}
				break;
			case 2:
				_localctx = new DoubleSlashAPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(13);
				match(T__2);
				setState(14);
				match(FILENAME);
				setState(15);
				match(T__3);
				setState(16);
				match(T__5);
				setState(17);
				rp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllChildrenRPContext extends RpContext {
		public AllChildrenRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class DoubleSlashRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public DoubleSlashRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class FilteredRPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FilteredRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class TagRPContext extends RpContext {
		public TerminalNode TAGNAME() { return getToken(XPathGrammarParser.TAGNAME, 0); }
		public TagRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class TextRPContext extends RpContext {
		public TextRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class AttributeRPContext extends RpContext {
		public TerminalNode ATTRNAME() { return getToken(XPathGrammarParser.ATTRNAME, 0); }
		public AttributeRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class BracketRPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public BracketRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class SequenceRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public SequenceRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class ParentRPContext extends RpContext {
		public ParentRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class SelfRPContext extends RpContext {
		public SelfRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class SingleSlashRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public SingleSlashRPContext(RpContext ctx) { copyFrom(ctx); }
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				_localctx = new TagRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				match(TAGNAME);
				}
				break;
			case T__6:
				{
				_localctx = new AllChildrenRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(T__6);
				}
				break;
			case T__7:
				{
				_localctx = new SelfRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__7);
				}
				break;
			case T__8:
				{
				_localctx = new ParentRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__8);
				}
				break;
			case T__9:
				{
				_localctx = new TextRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__9);
				}
				break;
			case ATTRNAME:
				{
				_localctx = new AttributeRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(ATTRNAME);
				}
				break;
			case T__2:
				{
				_localctx = new BracketRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(T__2);
				setState(28);
				rp(0);
				setState(29);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new SingleSlashRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(33);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(34);
						match(T__4);
						setState(35);
						rp(6);
						}
						break;
					case 2:
						{
						_localctx = new DoubleSlashRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(36);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(37);
						match(T__5);
						setState(38);
						rp(5);
						}
						break;
					case 3:
						{
						_localctx = new SequenceRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(39);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(40);
						match(T__12);
						setState(41);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilteredRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(42);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(43);
						match(T__10);
						setState(44);
						f(0);
						setState(45);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public AndFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class IsFilterContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public IsFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class BracketFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public BracketFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class RPFilterContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RPFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class NotFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NotFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class ConstantFilterContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode STRINGCONSTANT() { return getToken(XPathGrammarParser.STRINGCONSTANT, 0); }
		public ConstantFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class EqualFilterContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public EqualFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class OrFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public OrFilterContext(FContext ctx) { copyFrom(ctx); }
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new RPFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(53);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new ConstantFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				rp(0);
				setState(55);
				match(T__13);
				setState(56);
				match(STRINGCONSTANT);
				}
				break;
			case 3:
				{
				_localctx = new EqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				rp(0);
				setState(59);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(60);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new IsFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				rp(0);
				setState(63);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(64);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new BracketFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(T__2);
				setState(67);
				f(0);
				setState(68);
				match(T__3);
				}
				break;
			case 6:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(T__19);
				setState(71);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(74);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(75);
						match(T__17);
						setState(76);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(77);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(78);
						match(T__18);
						setState(79);
						f(3);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 2:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\25\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3\16\3\65\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4S\n\4\f\4\16\4V\13\4\3\4"+
		"\2\4\4\6\5\2\4\6\2\5\3\2\3\4\3\2\20\21\3\2\22\23\2f\2\24\3\2\2\2\4!\3"+
		"\2\2\2\6J\3\2\2\2\b\t\t\2\2\2\t\n\7\5\2\2\n\13\7\32\2\2\13\f\7\6\2\2\f"+
		"\r\7\7\2\2\r\25\5\4\3\2\16\17\t\2\2\2\17\20\7\5\2\2\20\21\7\32\2\2\21"+
		"\22\7\6\2\2\22\23\7\b\2\2\23\25\5\4\3\2\24\b\3\2\2\2\24\16\3\2\2\2\25"+
		"\3\3\2\2\2\26\27\b\3\1\2\27\"\7\27\2\2\30\"\7\t\2\2\31\"\7\n\2\2\32\""+
		"\7\13\2\2\33\"\7\f\2\2\34\"\7\30\2\2\35\36\7\5\2\2\36\37\5\4\3\2\37 \7"+
		"\6\2\2 \"\3\2\2\2!\26\3\2\2\2!\30\3\2\2\2!\31\3\2\2\2!\32\3\2\2\2!\33"+
		"\3\2\2\2!\34\3\2\2\2!\35\3\2\2\2\"\63\3\2\2\2#$\f\7\2\2$%\7\7\2\2%\62"+
		"\5\4\3\b&\'\f\6\2\2\'(\7\b\2\2(\62\5\4\3\7)*\f\3\2\2*+\7\17\2\2+\62\5"+
		"\4\3\4,-\f\4\2\2-.\7\r\2\2./\5\6\4\2/\60\7\16\2\2\60\62\3\2\2\2\61#\3"+
		"\2\2\2\61&\3\2\2\2\61)\3\2\2\2\61,\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\5\3\2\2\2\65\63\3\2\2\2\66\67\b\4\1\2\67K\5\4\3\289"+
		"\5\4\3\29:\7\20\2\2:;\7\33\2\2;K\3\2\2\2<=\5\4\3\2=>\t\3\2\2>?\5\4\3\2"+
		"?K\3\2\2\2@A\5\4\3\2AB\t\4\2\2BC\5\4\3\2CK\3\2\2\2DE\7\5\2\2EF\5\6\4\2"+
		"FG\7\6\2\2GK\3\2\2\2HI\7\26\2\2IK\5\6\4\3J\66\3\2\2\2J8\3\2\2\2J<\3\2"+
		"\2\2J@\3\2\2\2JD\3\2\2\2JH\3\2\2\2KT\3\2\2\2LM\f\5\2\2MN\7\24\2\2NS\5"+
		"\6\4\6OP\f\4\2\2PQ\7\25\2\2QS\5\6\4\5RL\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR"+
		"\3\2\2\2TU\3\2\2\2U\7\3\2\2\2VT\3\2\2\2\t\24!\61\63JRT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}