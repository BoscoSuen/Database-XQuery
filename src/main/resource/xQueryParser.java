// Generated from /Users/suen/Desktop/CSE232B/CSE232B-Database/src/resource/xQuery.g4 by ANTLR 4.8
package main.resource;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class xQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, NAME=37, WS=38, STRINGCONSTANT=39;
	public static final int
		RULE_ap = 0, RULE_filename = 1, RULE_rp = 2, RULE_filter = 3, RULE_var = 4, 
		RULE_xq = 5, RULE_forClause = 6, RULE_letClause = 7, RULE_whereClause = 8, 
		RULE_cond = 9, RULE_returnClause = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "filename", "rp", "filter", "var", "xq", "forClause", "letClause", 
			"whereClause", "cond", "returnClause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc(\"'", "'\")'", "'/'", "'//'", "'.'", "'*'", "'..'", "'text()'", 
			"'@'", "'('", "')'", "'['", "']'", "','", "'='", "'eq'", "'=='", "'is'", 
			"'and'", "'or'", "'not'", "'$'", "'<'", "'>'", "'{'", "'}'", "'</'", 
			"'for'", "'in'", "'let'", "':='", "'where'", "'empty'", "'some'", "'satisfies'", 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "NAME", "WS", "STRINGCONSTANT"
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
	public String getGrammarFileName() { return "xQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public xQueryParser(TokenStream input) {
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
	public static class ADesOrSelfContext extends ApContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ADesOrSelfContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterADesOrSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitADesOrSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitADesOrSelf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ADescendentContext extends ApContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ADescendentContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterADescendent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitADescendent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitADescendent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ADescendentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(T__0);
				setState(23);
				filename();
				setState(24);
				match(T__1);
				setState(25);
				match(T__2);
				setState(26);
				rp(0);
				}
				break;
			case 2:
				_localctx = new ADesOrSelfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__0);
				setState(29);
				filename();
				setState(30);
				match(T__1);
				setState(31);
				match(T__3);
				setState(32);
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

	public static class FilenameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(xQueryParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(xQueryParser.NAME, i);
		}
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFilename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFilename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_filename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(NAME);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(37);
				match(T__4);
				setState(38);
				match(NAME);
				}
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
	public static class TagNameContext extends RpContext {
		public TerminalNode NAME() { return getToken(xQueryParser.NAME, 0); }
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentContext extends RpContext {
		public ParentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeContext extends RpContext {
		public TerminalNode NAME() { return getToken(xQueryParser.NAME, 0); }
		public AttributeContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RConcatContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RConcatContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterRConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitRConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitRConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RFilterContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public RFilterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterRFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitRFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitRFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextContext extends RpContext {
		public TextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RDescendentContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RDescendentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterRDescendent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitRDescendent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitRDescendent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChildrenContext extends RpContext {
		public ChildrenContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitChildren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfContext extends RpContext {
		public SelfContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitSelf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RDesOrSelfContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public RDesOrSelfContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterRDesOrSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitRDesOrSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitRDesOrSelf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RBracketContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RBracketContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterRBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitRBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitRBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(42);
				match(NAME);
				}
				break;
			case T__5:
				{
				_localctx = new ChildrenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(T__5);
				}
				break;
			case T__4:
				{
				_localctx = new SelfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(T__4);
				}
				break;
			case T__6:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(T__6);
				}
				break;
			case T__7:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(T__7);
				}
				break;
			case T__8:
				{
				_localctx = new AttributeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(T__8);
				setState(48);
				match(NAME);
				}
				break;
			case T__9:
				{
				_localctx = new RBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(T__9);
				setState(50);
				rp(0);
				setState(51);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(69);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new RDescendentContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(55);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(56);
						match(T__2);
						setState(57);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RDesOrSelfContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(58);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(59);
						match(T__3);
						setState(60);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RConcatContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(61);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(62);
						match(T__13);
						setState(63);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RFilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(64);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(65);
						match(T__11);
						setState(66);
						filter(0);
						setState(67);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class FilterContext extends ParserRuleContext {
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
	 
		public FilterContext() { }
		public void copyFrom(FilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FIsContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public FIsContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FAndContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public FAndContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FRpContext extends FilterContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FRpContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FOrContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public FOrContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FBracketContext extends FilterContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public FBracketContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FEqualContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public FEqualContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FNotContext extends FilterContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public FNotContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterFNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitFNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitFNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		return filter(0);
	}

	private FilterContext filter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FilterContext _localctx = new FilterContext(_ctx, _parentState);
		FilterContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_filter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new FRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(75);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new FEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				rp(0);
				setState(77);
				match(T__14);
				setState(78);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new FEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				rp(0);
				setState(81);
				match(T__15);
				setState(82);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new FIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				rp(0);
				setState(85);
				match(T__16);
				setState(86);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new FIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				rp(0);
				setState(89);
				match(T__17);
				setState(90);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new FBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(T__9);
				setState(93);
				filter(0);
				setState(94);
				match(T__10);
				}
				break;
			case 7:
				{
				_localctx = new FNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(T__20);
				setState(97);
				filter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new FAndContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(100);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(101);
						match(T__18);
						setState(102);
						filter(4);
						}
						break;
					case 2:
						{
						_localctx = new FOrContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(103);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(104);
						match(T__19);
						setState(105);
						filter(3);
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(xQueryParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__21);
			setState(112);
			match(NAME);
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
	public static class XQFLWORContext extends XqContext {
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
		public XQFLWORContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQFLWOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQFLWOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQFLWOR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQApContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public XQApContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQAp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQBracketContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQBracketContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQNodeConstrctorContext extends XqContext {
		public List<TerminalNode> NAME() { return getTokens(xQueryParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(xQueryParser.NAME, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQNodeConstrctorContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQNodeConstrctor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQNodeConstrctor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQNodeConstrctor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQConcatContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XQConcatContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConstantContext extends XqContext {
		public TerminalNode STRINGCONSTANT() { return getToken(xQueryParser.STRINGCONSTANT, 0); }
		public StringConstantContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQDefineContext extends XqContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQDefineContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQValueContext extends XqContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XQValueContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQChildContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XQChildContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQChild(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQChild(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQDescendentContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XQDescendentContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQDescendent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQDescendent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQDescendent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				{
				_localctx = new XQValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				var();
				}
				break;
			case T__0:
				{
				_localctx = new XQApContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				ap();
				}
				break;
			case STRINGCONSTANT:
				{
				_localctx = new StringConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(STRINGCONSTANT);
				}
				break;
			case T__9:
				{
				_localctx = new XQBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(T__9);
				setState(119);
				xq(0);
				setState(120);
				match(T__10);
				}
				break;
			case T__22:
				{
				_localctx = new XQNodeConstrctorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(T__22);
				setState(123);
				match(NAME);
				setState(124);
				match(T__23);
				setState(125);
				match(T__24);
				setState(126);
				xq(0);
				setState(127);
				match(T__25);
				setState(128);
				match(T__26);
				setState(129);
				match(NAME);
				setState(130);
				match(T__23);
				}
				break;
			case T__27:
				{
				_localctx = new XQFLWORContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				forClause();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(133);
					letClause();
					}
				}

				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(136);
					whereClause();
					}
				}

				setState(139);
				returnClause();
				}
				break;
			case T__29:
				{
				_localctx = new XQDefineContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				letClause();
				setState(142);
				xq(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(155);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new XQConcatContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(146);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(147);
						match(T__13);
						setState(148);
						xq(7);
						}
						break;
					case 2:
						{
						_localctx = new XQChildContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(149);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(150);
						match(T__2);
						setState(151);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XQDescendentContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(152);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(153);
						match(T__3);
						setState(154);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class ForClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__27);
			setState(161);
			var();
			setState(162);
			match(T__28);
			setState(163);
			xq(0);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(164);
				match(T__13);
				setState(165);
				var();
				setState(166);
				match(T__28);
				setState(167);
				xq(0);
				}
				}
				setState(173);
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
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__29);
			setState(175);
			var();
			setState(176);
			match(T__30);
			setState(177);
			xq(0);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(178);
				match(T__13);
				setState(179);
				var();
				setState(180);
				match(T__30);
				setState(181);
				xq(0);
				}
				}
				setState(187);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__31);
			setState(189);
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
	public static class XQAndCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public XQAndCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQAndCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQAndCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQAndCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQIsEmptyContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XQIsEmptyContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQIsEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQIsEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQIsEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQNotContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public XQNotContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQEqualContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XQEqualContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQIsContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XQIsContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public XQCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQOrCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public XQOrCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQOrCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQOrCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQOrCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQSatisfyContext extends CondContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public XQSatisfyContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterXQSatisfy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitXQSatisfy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitXQSatisfy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new XQEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(192);
				xq(0);
				setState(193);
				match(T__14);
				setState(194);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new XQEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				xq(0);
				setState(197);
				match(T__15);
				setState(198);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new XQIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				xq(0);
				setState(201);
				match(T__16);
				setState(202);
				xq(0);
				}
				break;
			case 4:
				{
				_localctx = new XQIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				xq(0);
				setState(205);
				match(T__17);
				setState(206);
				xq(0);
				}
				break;
			case 5:
				{
				_localctx = new XQIsEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(T__32);
				setState(209);
				match(T__9);
				setState(210);
				xq(0);
				setState(211);
				match(T__10);
				}
				break;
			case 6:
				{
				_localctx = new XQSatisfyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(T__33);
				setState(214);
				var();
				setState(215);
				match(T__28);
				setState(216);
				xq(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(217);
					match(T__13);
					setState(218);
					var();
					setState(219);
					match(T__28);
					setState(220);
					xq(0);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(227);
				match(T__34);
				setState(228);
				cond(5);
				}
				break;
			case 7:
				{
				_localctx = new XQCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(T__9);
				setState(231);
				cond(0);
				setState(232);
				match(T__10);
				}
				break;
			case 8:
				{
				_localctx = new XQNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(T__20);
				setState(235);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(244);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new XQAndCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(238);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(239);
						match(T__18);
						setState(240);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new XQOrCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(241);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(242);
						match(T__19);
						setState(243);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(248);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xQueryListener ) ((xQueryListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xQueryVisitor ) return ((xQueryVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__35);
			setState(250);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 3:
			return filter_sempred((FilterContext)_localctx, predIndex);
		case 5:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 9:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean filter_sempred(FilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00ff\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2%\n\2\3"+
		"\3\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\48\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4H\n"+
		"\4\f\4\16\4K\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5e\n\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5m\n\5\f\5\16\5p\13\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0089\n\7\3"+
		"\7\5\7\u008c\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u0093\n\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7\u009e\n\7\f\7\16\7\u00a1\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\b\u00ac\n\b\f\b\16\b\u00af\13\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\7\t\u00ba\n\t\f\t\16\t\u00bd\13\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u00e1\n\13\f\13\16\13\u00e4\13\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u00ef\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00f7\n\13\f\13\16\13\u00fa\13\13\3\f\3\f\3\f\3\f\2\6\6\b\f\24\r"+
		"\2\4\6\b\n\f\16\20\22\24\26\2\2\2\u011e\2$\3\2\2\2\4&\3\2\2\2\6\67\3\2"+
		"\2\2\bd\3\2\2\2\nq\3\2\2\2\f\u0092\3\2\2\2\16\u00a2\3\2\2\2\20\u00b0\3"+
		"\2\2\2\22\u00be\3\2\2\2\24\u00ee\3\2\2\2\26\u00fb\3\2\2\2\30\31\7\3\2"+
		"\2\31\32\5\4\3\2\32\33\7\4\2\2\33\34\7\5\2\2\34\35\5\6\4\2\35%\3\2\2\2"+
		"\36\37\7\3\2\2\37 \5\4\3\2 !\7\4\2\2!\"\7\6\2\2\"#\5\6\4\2#%\3\2\2\2$"+
		"\30\3\2\2\2$\36\3\2\2\2%\3\3\2\2\2&)\7\'\2\2\'(\7\7\2\2(*\7\'\2\2)\'\3"+
		"\2\2\2)*\3\2\2\2*\5\3\2\2\2+,\b\4\1\2,8\7\'\2\2-8\7\b\2\2.8\7\7\2\2/8"+
		"\7\t\2\2\608\7\n\2\2\61\62\7\13\2\2\628\7\'\2\2\63\64\7\f\2\2\64\65\5"+
		"\6\4\2\65\66\7\r\2\2\668\3\2\2\2\67+\3\2\2\2\67-\3\2\2\2\67.\3\2\2\2\67"+
		"/\3\2\2\2\67\60\3\2\2\2\67\61\3\2\2\2\67\63\3\2\2\28I\3\2\2\29:\f\6\2"+
		"\2:;\7\5\2\2;H\5\6\4\7<=\f\5\2\2=>\7\6\2\2>H\5\6\4\6?@\f\3\2\2@A\7\20"+
		"\2\2AH\5\6\4\4BC\f\4\2\2CD\7\16\2\2DE\5\b\5\2EF\7\17\2\2FH\3\2\2\2G9\3"+
		"\2\2\2G<\3\2\2\2G?\3\2\2\2GB\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\7"+
		"\3\2\2\2KI\3\2\2\2LM\b\5\1\2Me\5\6\4\2NO\5\6\4\2OP\7\21\2\2PQ\5\6\4\2"+
		"Qe\3\2\2\2RS\5\6\4\2ST\7\22\2\2TU\5\6\4\2Ue\3\2\2\2VW\5\6\4\2WX\7\23\2"+
		"\2XY\5\6\4\2Ye\3\2\2\2Z[\5\6\4\2[\\\7\24\2\2\\]\5\6\4\2]e\3\2\2\2^_\7"+
		"\f\2\2_`\5\b\5\2`a\7\r\2\2ae\3\2\2\2bc\7\27\2\2ce\5\b\5\3dL\3\2\2\2dN"+
		"\3\2\2\2dR\3\2\2\2dV\3\2\2\2dZ\3\2\2\2d^\3\2\2\2db\3\2\2\2en\3\2\2\2f"+
		"g\f\5\2\2gh\7\25\2\2hm\5\b\5\6ij\f\4\2\2jk\7\26\2\2km\5\b\5\5lf\3\2\2"+
		"\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\t\3\2\2\2pn\3\2\2\2qr\7\30"+
		"\2\2rs\7\'\2\2s\13\3\2\2\2tu\b\7\1\2u\u0093\5\n\6\2v\u0093\5\2\2\2w\u0093"+
		"\7)\2\2xy\7\f\2\2yz\5\f\7\2z{\7\r\2\2{\u0093\3\2\2\2|}\7\31\2\2}~\7\'"+
		"\2\2~\177\7\32\2\2\177\u0080\7\33\2\2\u0080\u0081\5\f\7\2\u0081\u0082"+
		"\7\34\2\2\u0082\u0083\7\35\2\2\u0083\u0084\7\'\2\2\u0084\u0085\7\32\2"+
		"\2\u0085\u0093\3\2\2\2\u0086\u0088\5\16\b\2\u0087\u0089\5\20\t\2\u0088"+
		"\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5\22"+
		"\n\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\5\26\f\2\u008e\u0093\3\2\2\2\u008f\u0090\5\20\t\2\u0090\u0091\5"+
		"\f\7\3\u0091\u0093\3\2\2\2\u0092t\3\2\2\2\u0092v\3\2\2\2\u0092w\3\2\2"+
		"\2\u0092x\3\2\2\2\u0092|\3\2\2\2\u0092\u0086\3\2\2\2\u0092\u008f\3\2\2"+
		"\2\u0093\u009f\3\2\2\2\u0094\u0095\f\b\2\2\u0095\u0096\7\20\2\2\u0096"+
		"\u009e\5\f\7\t\u0097\u0098\f\7\2\2\u0098\u0099\7\5\2\2\u0099\u009e\5\6"+
		"\4\2\u009a\u009b\f\6\2\2\u009b\u009c\7\6\2\2\u009c\u009e\5\6\4\2\u009d"+
		"\u0094\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u009a\3\2\2\2\u009e\u00a1\3\2"+
		"\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\r\3\2\2\2\u00a1\u009f"+
		"\3\2\2\2\u00a2\u00a3\7\36\2\2\u00a3\u00a4\5\n\6\2\u00a4\u00a5\7\37\2\2"+
		"\u00a5\u00ad\5\f\7\2\u00a6\u00a7\7\20\2\2\u00a7\u00a8\5\n\6\2\u00a8\u00a9"+
		"\7\37\2\2\u00a9\u00aa\5\f\7\2\u00aa\u00ac\3\2\2\2\u00ab\u00a6\3\2\2\2"+
		"\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\17"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7 \2\2\u00b1\u00b2\5\n\6\2\u00b2"+
		"\u00b3\7!\2\2\u00b3\u00bb\5\f\7\2\u00b4\u00b5\7\20\2\2\u00b5\u00b6\5\n"+
		"\6\2\u00b6\u00b7\7!\2\2\u00b7\u00b8\5\f\7\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b4\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\21\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\"\2\2\u00bf\u00c0"+
		"\5\24\13\2\u00c0\23\3\2\2\2\u00c1\u00c2\b\13\1\2\u00c2\u00c3\5\f\7\2\u00c3"+
		"\u00c4\7\21\2\2\u00c4\u00c5\5\f\7\2\u00c5\u00ef\3\2\2\2\u00c6\u00c7\5"+
		"\f\7\2\u00c7\u00c8\7\22\2\2\u00c8\u00c9\5\f\7\2\u00c9\u00ef\3\2\2\2\u00ca"+
		"\u00cb\5\f\7\2\u00cb\u00cc\7\23\2\2\u00cc\u00cd\5\f\7\2\u00cd\u00ef\3"+
		"\2\2\2\u00ce\u00cf\5\f\7\2\u00cf\u00d0\7\24\2\2\u00d0\u00d1\5\f\7\2\u00d1"+
		"\u00ef\3\2\2\2\u00d2\u00d3\7#\2\2\u00d3\u00d4\7\f\2\2\u00d4\u00d5\5\f"+
		"\7\2\u00d5\u00d6\7\r\2\2\u00d6\u00ef\3\2\2\2\u00d7\u00d8\7$\2\2\u00d8"+
		"\u00d9\5\n\6\2\u00d9\u00da\7\37\2\2\u00da\u00e2\5\f\7\2\u00db\u00dc\7"+
		"\20\2\2\u00dc\u00dd\5\n\6\2\u00dd\u00de\7\37\2\2\u00de\u00df\5\f\7\2\u00df"+
		"\u00e1\3\2\2\2\u00e0\u00db\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e6\7%\2\2\u00e6\u00e7\5\24\13\7\u00e7\u00ef\3\2\2\2\u00e8\u00e9\7"+
		"\f\2\2\u00e9\u00ea\5\24\13\2\u00ea\u00eb\7\r\2\2\u00eb\u00ef\3\2\2\2\u00ec"+
		"\u00ed\7\27\2\2\u00ed\u00ef\5\24\13\3\u00ee\u00c1\3\2\2\2\u00ee\u00c6"+
		"\3\2\2\2\u00ee\u00ca\3\2\2\2\u00ee\u00ce\3\2\2\2\u00ee\u00d2\3\2\2\2\u00ee"+
		"\u00d7\3\2\2\2\u00ee\u00e8\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f8\3\2"+
		"\2\2\u00f0\u00f1\f\5\2\2\u00f1\u00f2\7\25\2\2\u00f2\u00f7\5\24\13\6\u00f3"+
		"\u00f4\f\4\2\2\u00f4\u00f5\7\26\2\2\u00f5\u00f7\5\24\13\5\u00f6\u00f0"+
		"\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\25\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7&\2\2"+
		"\u00fc\u00fd\5\f\7\2\u00fd\27\3\2\2\2\25$)\67GIdln\u0088\u008b\u0092\u009d"+
		"\u009f\u00ad\u00bb\u00e2\u00ee\u00f6\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}