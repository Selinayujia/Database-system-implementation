// Generated from /Users/yujiazhang/Documents/GitHub/Database-system-implementation/src/main/resources/antlr4/XQueryGrammar.g4 by ANTLR 4.9.2

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
public class XQueryGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, VAR=36, TAGNAME=37, ATTRNAME=38, 
		TEXT=39, FILENAME=40, STRINGCONSTANT=41, WHITESPACE=42;
	public static final int
		RULE_xq = 0, RULE_joinClause = 1, RULE_idList = 2, RULE_forClause = 3, 
		RULE_letClause = 4, RULE_whereClause = 5, RULE_returnClause = 6, RULE_cond = 7, 
		RULE_ap = 8, RULE_rp = 9, RULE_f = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "joinClause", "idList", "forClause", "letClause", "whereClause", 
			"returnClause", "cond", "ap", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'('", "')'", "','", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'join'", "'['", "']'", "'for'", "'in'", "'let'", "':='", "'where'", 
			"'return'", "'='", "'eq'", "'=='", "'is'", "'empty'", "'some'", "'satisfies'", 
			"'and'", "'or'", "'not'", "'doc'", "'document'", "'*'", "'.'", "'..'", 
			"'text()'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"VAR", "TAGNAME", "ATTRNAME", "TEXT", "FILENAME", "STRINGCONSTANT", "WHITESPACE"
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
	public String getGrammarFileName() { return "XQueryGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringXQContext extends XqContext {
		public TerminalNode STRINGCONSTANT() { return getToken(XQueryGrammarParser.STRINGCONSTANT, 0); }
		public StringXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class SingleSlashXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SingleSlashXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class ApXQContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public ApXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class JoinXQContext extends XqContext {
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public JoinXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class VarXQContext extends XqContext {
		public TerminalNode VAR() { return getToken(XQueryGrammarParser.VAR, 0); }
		public VarXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class SequenceXQContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public SequenceXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class BracketXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public BracketXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class FlworXQContext extends XqContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public FlworXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class TagXQContext extends XqContext {
		public List<TerminalNode> TAGNAME() { return getTokens(XQueryGrammarParser.TAGNAME); }
		public TerminalNode TAGNAME(int i) {
			return getToken(XQueryGrammarParser.TAGNAME, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TagXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class LetClauseXQContext extends XqContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public LetClauseXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class DoubleSlashXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DoubleSlashXQContext(XqContext ctx) { copyFrom(ctx); }
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				_localctx = new VarXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(23);
				match(VAR);
				}
				break;
			case STRINGCONSTANT:
				{
				_localctx = new StringXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(STRINGCONSTANT);
				}
				break;
			case T__29:
			case T__30:
				{
				_localctx = new ApXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				ap();
				}
				break;
			case T__2:
				{
				_localctx = new BracketXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__2);
				setState(27);
				xq(0);
				setState(28);
				match(T__3);
				}
				break;
			case T__5:
				{
				_localctx = new TagXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__5);
				setState(31);
				match(TAGNAME);
				setState(32);
				match(T__6);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(33);
					match(T__7);
					}
				}

				setState(36);
				xq(0);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(37);
					match(T__8);
					}
				}

				setState(40);
				match(T__9);
				setState(41);
				match(TAGNAME);
				setState(42);
				match(T__6);
				}
				break;
			case T__13:
				{
				_localctx = new FlworXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				forClause();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(45);
					letClause();
					}
				}

				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(48);
					whereClause();
					}
				}

				setState(51);
				returnClause();
				}
				break;
			case T__15:
				{
				_localctx = new LetClauseXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				letClause();
				setState(54);
				xq(2);
				}
				break;
			case T__10:
				{
				_localctx = new JoinXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				joinClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(68);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new SequenceXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(59);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(60);
						match(T__4);
						setState(61);
						xq(6);
						}
						break;
					case 2:
						{
						_localctx = new SingleSlashXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(62);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(63);
						match(T__0);
						setState(64);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new DoubleSlashXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(65);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(66);
						match(T__1);
						setState(67);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(72);
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

	public static class JoinClauseContext extends ParserRuleContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<IdListContext> idList() {
			return getRuleContexts(IdListContext.class);
		}
		public IdListContext idList(int i) {
			return getRuleContext(IdListContext.class,i);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_joinClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__10);
			setState(74);
			match(T__2);
			setState(75);
			xq(0);
			setState(76);
			match(T__4);
			setState(77);
			xq(0);
			setState(78);
			match(T__4);
			setState(79);
			idList();
			setState(80);
			match(T__4);
			setState(81);
			idList();
			setState(82);
			match(T__3);
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

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> TAGNAME() { return getTokens(XQueryGrammarParser.TAGNAME); }
		public TerminalNode TAGNAME(int i) {
			return getToken(XQueryGrammarParser.TAGNAME, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__11);
			setState(85);
			match(TAGNAME);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(86);
				match(T__4);
				setState(87);
				match(TAGNAME);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(T__12);
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

	public static class ForClauseContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(XQueryGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(XQueryGrammarParser.VAR, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__13);
			setState(96);
			match(VAR);
			setState(97);
			match(T__14);
			setState(98);
			xq(0);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(99);
				match(T__4);
				setState(100);
				match(VAR);
				setState(101);
				match(T__14);
				setState(102);
				xq(0);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class LetClauseContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(XQueryGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(XQueryGrammarParser.VAR, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__15);
			setState(109);
			match(VAR);
			setState(110);
			match(T__16);
			setState(111);
			xq(0);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(112);
				match(T__4);
				setState(113);
				match(VAR);
				setState(114);
				match(T__16);
				setState(115);
				xq(0);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__17);
			setState(122);
			cond(0);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__18);
			setState(125);
			xq(0);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultipleCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<TerminalNode> VAR() { return getTokens(XQueryGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(XQueryGrammarParser.VAR, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public MultipleCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class OrCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public OrCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class EqualCondContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public EqualCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class AndCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public AndCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class NotCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public NotCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class EmptyCondContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public EmptyCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class BracketCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public BracketCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class IsCondContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public IsCondContext(CondContext ctx) { copyFrom(ctx); }
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new EqualCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(128);
				xq(0);
				setState(129);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(130);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new IsCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				xq(0);
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new EmptyCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__23);
				setState(137);
				match(T__2);
				setState(138);
				xq(0);
				setState(139);
				match(T__3);
				}
				break;
			case 4:
				{
				_localctx = new MultipleCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(T__24);
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(142);
					match(VAR);
					setState(143);
					match(T__14);
					setState(144);
					xq(0);
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__4) {
						{
						setState(145);
						match(T__4);
						}
					}

					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VAR );
				setState(152);
				match(T__25);
				setState(153);
				cond(5);
				}
				break;
			case 5:
				{
				_localctx = new BracketCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(T__2);
				setState(156);
				cond(0);
				setState(157);
				match(T__3);
				}
				break;
			case 6:
				{
				_localctx = new NotCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__28);
				setState(160);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new AndCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(163);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(164);
						match(T__26);
						setState(165);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new OrCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(166);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(167);
						match(T__27);
						setState(168);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public TerminalNode FILENAME() { return getToken(XQueryGrammarParser.FILENAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DoubleSlashAPContext(ApContext ctx) { copyFrom(ctx); }
	}
	public static class SingleSlashAPContext extends ApContext {
		public TerminalNode FILENAME() { return getToken(XQueryGrammarParser.FILENAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SingleSlashAPContext(ApContext ctx) { copyFrom(ctx); }
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ap);
		int _la;
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new SingleSlashAPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(175);
				match(T__2);
				setState(176);
				match(FILENAME);
				setState(177);
				match(T__3);
				setState(178);
				match(T__0);
				setState(179);
				rp(0);
				}
				break;
			case 2:
				_localctx = new DoubleSlashAPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(181);
				match(T__2);
				setState(182);
				match(FILENAME);
				setState(183);
				match(T__3);
				setState(184);
				match(T__1);
				setState(185);
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
		public TerminalNode TAGNAME() { return getToken(XQueryGrammarParser.TAGNAME, 0); }
		public TagRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class TextRPContext extends RpContext {
		public TextRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class AttributeRPContext extends RpContext {
		public TerminalNode ATTRNAME() { return getToken(XQueryGrammarParser.ATTRNAME, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				_localctx = new TagRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(189);
				match(TAGNAME);
				}
				break;
			case T__31:
				{
				_localctx = new AllChildrenRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(T__31);
				}
				break;
			case T__32:
				{
				_localctx = new SelfRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(T__32);
				}
				break;
			case T__33:
				{
				_localctx = new ParentRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(T__33);
				}
				break;
			case T__34:
				{
				_localctx = new TextRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(T__34);
				}
				break;
			case ATTRNAME:
				{
				_localctx = new AttributeRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(ATTRNAME);
				}
				break;
			case T__2:
				{
				_localctx = new BracketRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(T__2);
				setState(196);
				rp(0);
				setState(197);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(215);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new SingleSlashRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						match(T__0);
						setState(203);
						rp(6);
						}
						break;
					case 2:
						{
						_localctx = new DoubleSlashRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						match(T__1);
						setState(206);
						rp(5);
						}
						break;
					case 3:
						{
						_localctx = new SequenceRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(207);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(208);
						match(T__4);
						setState(209);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilteredRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(210);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(211);
						match(T__11);
						setState(212);
						f(0);
						setState(213);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public TerminalNode STRINGCONSTANT() { return getToken(XQueryGrammarParser.STRINGCONSTANT, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new RPFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(221);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new ConstantFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				rp(0);
				setState(223);
				match(T__19);
				setState(224);
				match(STRINGCONSTANT);
				}
				break;
			case 3:
				{
				_localctx = new EqualFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				rp(0);
				setState(227);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(228);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new IsFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				rp(0);
				setState(231);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(232);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new BracketFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(T__2);
				setState(235);
				f(0);
				setState(236);
				match(T__3);
				}
				break;
			case 6:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(T__28);
				setState(239);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(248);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(242);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(243);
						match(T__26);
						setState(244);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(245);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(246);
						match(T__27);
						setState(247);
						f(3);
						}
						break;
					}
					} 
				}
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 7:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 9:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 10:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0100\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2%\n\2\3"+
		"\2\3\2\5\2)\n\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\61\n\2\3\2\5\2\64\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2<\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2"+
		"G\n\2\f\2\16\2J\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\7\4[\n\4\f\4\16\4^\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5j\n\5\f\5\16\5m\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6w\n\6"+
		"\f\6\16\6z\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0095\n\t\6\t\u0097"+
		"\n\t\r\t\16\t\u0098\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a4\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ac\n\t\f\t\16\t\u00af\13\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bd\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ca\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00da\n\13\f\13"+
		"\16\13\u00dd\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f3\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f"+
		"\u00fb\n\f\f\f\16\f\u00fe\13\f\3\f\2\6\2\20\24\26\r\2\4\6\b\n\f\16\20"+
		"\22\24\26\2\5\3\2\26\27\3\2\30\31\3\2 !\2\u0120\2;\3\2\2\2\4K\3\2\2\2"+
		"\6V\3\2\2\2\ba\3\2\2\2\nn\3\2\2\2\f{\3\2\2\2\16~\3\2\2\2\20\u00a3\3\2"+
		"\2\2\22\u00bc\3\2\2\2\24\u00c9\3\2\2\2\26\u00f2\3\2\2\2\30\31\b\2\1\2"+
		"\31<\7&\2\2\32<\7+\2\2\33<\5\22\n\2\34\35\7\5\2\2\35\36\5\2\2\2\36\37"+
		"\7\6\2\2\37<\3\2\2\2 !\7\b\2\2!\"\7\'\2\2\"$\7\t\2\2#%\7\n\2\2$#\3\2\2"+
		"\2$%\3\2\2\2%&\3\2\2\2&(\5\2\2\2\')\7\13\2\2(\'\3\2\2\2()\3\2\2\2)*\3"+
		"\2\2\2*+\7\f\2\2+,\7\'\2\2,-\7\t\2\2-<\3\2\2\2.\60\5\b\5\2/\61\5\n\6\2"+
		"\60/\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\64\5\f\7\2\63\62\3\2\2\2\63"+
		"\64\3\2\2\2\64\65\3\2\2\2\65\66\5\16\b\2\66<\3\2\2\2\678\5\n\6\289\5\2"+
		"\2\49<\3\2\2\2:<\5\4\3\2;\30\3\2\2\2;\32\3\2\2\2;\33\3\2\2\2;\34\3\2\2"+
		"\2; \3\2\2\2;.\3\2\2\2;\67\3\2\2\2;:\3\2\2\2<H\3\2\2\2=>\f\7\2\2>?\7\7"+
		"\2\2?G\5\2\2\b@A\f\n\2\2AB\7\3\2\2BG\5\24\13\2CD\f\t\2\2DE\7\4\2\2EG\5"+
		"\24\13\2F=\3\2\2\2F@\3\2\2\2FC\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I"+
		"\3\3\2\2\2JH\3\2\2\2KL\7\r\2\2LM\7\5\2\2MN\5\2\2\2NO\7\7\2\2OP\5\2\2\2"+
		"PQ\7\7\2\2QR\5\6\4\2RS\7\7\2\2ST\5\6\4\2TU\7\6\2\2U\5\3\2\2\2VW\7\16\2"+
		"\2W\\\7\'\2\2XY\7\7\2\2Y[\7\'\2\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3"+
		"\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7\17\2\2`\7\3\2\2\2ab\7\20\2\2bc\7&\2\2"+
		"cd\7\21\2\2dk\5\2\2\2ef\7\7\2\2fg\7&\2\2gh\7\21\2\2hj\5\2\2\2ie\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\t\3\2\2\2mk\3\2\2\2no\7\22\2\2op\7&"+
		"\2\2pq\7\23\2\2qx\5\2\2\2rs\7\7\2\2st\7&\2\2tu\7\23\2\2uw\5\2\2\2vr\3"+
		"\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\13\3\2\2\2zx\3\2\2\2{|\7\24\2\2"+
		"|}\5\20\t\2}\r\3\2\2\2~\177\7\25\2\2\177\u0080\5\2\2\2\u0080\17\3\2\2"+
		"\2\u0081\u0082\b\t\1\2\u0082\u0083\5\2\2\2\u0083\u0084\t\2\2\2\u0084\u0085"+
		"\5\2\2\2\u0085\u00a4\3\2\2\2\u0086\u0087\5\2\2\2\u0087\u0088\t\3\2\2\u0088"+
		"\u0089\5\2\2\2\u0089\u00a4\3\2\2\2\u008a\u008b\7\32\2\2\u008b\u008c\7"+
		"\5\2\2\u008c\u008d\5\2\2\2\u008d\u008e\7\6\2\2\u008e\u00a4\3\2\2\2\u008f"+
		"\u0096\7\33\2\2\u0090\u0091\7&\2\2\u0091\u0092\7\21\2\2\u0092\u0094\5"+
		"\2\2\2\u0093\u0095\7\7\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0090\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\34\2\2\u009b"+
		"\u009c\5\20\t\7\u009c\u00a4\3\2\2\2\u009d\u009e\7\5\2\2\u009e\u009f\5"+
		"\20\t\2\u009f\u00a0\7\6\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a2\7\37\2\2\u00a2"+
		"\u00a4\5\20\t\3\u00a3\u0081\3\2\2\2\u00a3\u0086\3\2\2\2\u00a3\u008a\3"+
		"\2\2\2\u00a3\u008f\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00ad\3\2\2\2\u00a5\u00a6\f\5\2\2\u00a6\u00a7\7\35\2\2\u00a7\u00ac\5"+
		"\20\t\6\u00a8\u00a9\f\4\2\2\u00a9\u00aa\7\36\2\2\u00aa\u00ac\5\20\t\5"+
		"\u00ab\u00a5\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\21\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b1\t\4\2\2\u00b1\u00b2\7\5\2\2\u00b2\u00b3\7*\2\2\u00b3\u00b4\7\6"+
		"\2\2\u00b4\u00b5\7\3\2\2\u00b5\u00bd\5\24\13\2\u00b6\u00b7\t\4\2\2\u00b7"+
		"\u00b8\7\5\2\2\u00b8\u00b9\7*\2\2\u00b9\u00ba\7\6\2\2\u00ba\u00bb\7\4"+
		"\2\2\u00bb\u00bd\5\24\13\2\u00bc\u00b0\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bd"+
		"\23\3\2\2\2\u00be\u00bf\b\13\1\2\u00bf\u00ca\7\'\2\2\u00c0\u00ca\7\"\2"+
		"\2\u00c1\u00ca\7#\2\2\u00c2\u00ca\7$\2\2\u00c3\u00ca\7%\2\2\u00c4\u00ca"+
		"\7(\2\2\u00c5\u00c6\7\5\2\2\u00c6\u00c7\5\24\13\2\u00c7\u00c8\7\6\2\2"+
		"\u00c8\u00ca\3\2\2\2\u00c9\u00be\3\2\2\2\u00c9\u00c0\3\2\2\2\u00c9\u00c1"+
		"\3\2\2\2\u00c9\u00c2\3\2\2\2\u00c9\u00c3\3\2\2\2\u00c9\u00c4\3\2\2\2\u00c9"+
		"\u00c5\3\2\2\2\u00ca\u00db\3\2\2\2\u00cb\u00cc\f\7\2\2\u00cc\u00cd\7\3"+
		"\2\2\u00cd\u00da\5\24\13\b\u00ce\u00cf\f\6\2\2\u00cf\u00d0\7\4\2\2\u00d0"+
		"\u00da\5\24\13\7\u00d1\u00d2\f\3\2\2\u00d2\u00d3\7\7\2\2\u00d3\u00da\5"+
		"\24\13\4\u00d4\u00d5\f\4\2\2\u00d5\u00d6\7\16\2\2\u00d6\u00d7\5\26\f\2"+
		"\u00d7\u00d8\7\17\2\2\u00d8\u00da\3\2\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00ce"+
		"\3\2\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d4\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\25\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00de\u00df\b\f\1\2\u00df\u00f3\5\24\13\2\u00e0\u00e1\5\24\13\2\u00e1"+
		"\u00e2\7\26\2\2\u00e2\u00e3\7+\2\2\u00e3\u00f3\3\2\2\2\u00e4\u00e5\5\24"+
		"\13\2\u00e5\u00e6\t\2\2\2\u00e6\u00e7\5\24\13\2\u00e7\u00f3\3\2\2\2\u00e8"+
		"\u00e9\5\24\13\2\u00e9\u00ea\t\3\2\2\u00ea\u00eb\5\24\13\2\u00eb\u00f3"+
		"\3\2\2\2\u00ec\u00ed\7\5\2\2\u00ed\u00ee\5\26\f\2\u00ee\u00ef\7\6\2\2"+
		"\u00ef\u00f3\3\2\2\2\u00f0\u00f1\7\37\2\2\u00f1\u00f3\5\26\f\3\u00f2\u00de"+
		"\3\2\2\2\u00f2\u00e0\3\2\2\2\u00f2\u00e4\3\2\2\2\u00f2\u00e8\3\2\2\2\u00f2"+
		"\u00ec\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00fc\3\2\2\2\u00f4\u00f5\f\5"+
		"\2\2\u00f5\u00f6\7\35\2\2\u00f6\u00fb\5\26\f\6\u00f7\u00f8\f\4\2\2\u00f8"+
		"\u00f9\7\36\2\2\u00f9\u00fb\5\26\f\5\u00fa\u00f4\3\2\2\2\u00fa\u00f7\3"+
		"\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\27\3\2\2\2\u00fe\u00fc\3\2\2\2\30$(\60\63;FH\\kx\u0094\u0098\u00a3\u00ab"+
		"\u00ad\u00bc\u00c9\u00d9\u00db\u00f2\u00fa\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}