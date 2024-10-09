// Generated from c:/Users/USER/OneDrive/Documents/CS/UiO/IN2130/Oblig 2/DSL/aeroscript/src/main/antlr/AeroScript.g4 by ANTLR 4.13.1

package no.uio.aeroscript.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AeroScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, LCURL=4, RCURL=5, LSQUARE=6, RSQUARE=7, 
		LPAREN=8, RPAREN=9, NEG=10, SEMI=11, COMMA=12, GREATER=13, PLUS=14, MINUS=15, 
		TIMES=16, NEXT=17, RANDOM=18, POINT=19, OBSTACLE=20, BATTERY=21, MESSAGE=22, 
		ON=23, FOR=24, S=25, SPEED=26, RETURN=27, MOVE=28, TO=29, BY=30, TURN=31, 
		RIGHT=32, LEFT=33, ASCEND=34, DESCEND=35, GROUND=36, ID=37, NUMBER=38;
	public static final int
		RULE_program = 0, RULE_execution = 1, RULE_statement = 2, RULE_reaction = 3, 
		RULE_event = 4, RULE_action = 5, RULE_acDock = 6, RULE_acMove = 7, RULE_acTurn = 8, 
		RULE_acAscend = 9, RULE_acDescend = 10, RULE_expression = 11, RULE_point = 12, 
		RULE_range = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "execution", "statement", "reaction", "event", "action", "acDock", 
			"acMove", "acTurn", "acAscend", "acDescend", "expression", "point", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'{'", "'}'", "'['", "']'", "'('", "')'", "'--'", 
			"';'", "','", "'>'", "'+'", "'-'", "'*'", "'->'", "'random'", "'point'", 
			"'obstacle'", "'low battery'", "'message'", "'on'", "'for'", "'s'", "'at speed'", 
			"'return to base'", "'move'", "'to'", "'by'", "'turn'", "'right'", "'left'", 
			"'ascend by'", "'descend by'", "'descend to ground'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "LINE_COMMENT", "LCURL", "RCURL", "LSQUARE", "RSQUARE", 
			"LPAREN", "RPAREN", "NEG", "SEMI", "COMMA", "GREATER", "PLUS", "MINUS", 
			"TIMES", "NEXT", "RANDOM", "POINT", "OBSTACLE", "BATTERY", "MESSAGE", 
			"ON", "FOR", "S", "SPEED", "RETURN", "MOVE", "TO", "BY", "TURN", "RIGHT", 
			"LEFT", "ASCEND", "DESCEND", "GROUND", "ID", "NUMBER"
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
	public String getGrammarFileName() { return "AeroScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AeroScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<ExecutionContext> execution() {
			return getRuleContexts(ExecutionContext.class);
		}
		public ExecutionContext execution(int i) {
			return getRuleContext(ExecutionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				execution();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEXT || _la==ID );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExecutionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AeroScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AeroScriptParser.ID, i);
		}
		public TerminalNode LCURL() { return getToken(AeroScriptParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(AeroScriptParser.RCURL, 0); }
		public List<TerminalNode> NEXT() { return getTokens(AeroScriptParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(AeroScriptParser.NEXT, i);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public List<ReactionContext> reaction() {
			return getRuleContexts(ReactionContext.class);
		}
		public ReactionContext reaction(int i) {
			return getRuleContext(ReactionContext.class,i);
		}
		public List<ExecutionContext> execution() {
			return getRuleContexts(ExecutionContext.class);
		}
		public ExecutionContext execution(int i) {
			return getRuleContext(ExecutionContext.class,i);
		}
		public ExecutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execution; }
	}

	public final ExecutionContext execution() throws RecognitionException {
		ExecutionContext _localctx = new ExecutionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_execution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEXT) {
				{
				setState(33);
				match(NEXT);
				}
			}

			setState(36);
			match(ID);
			setState(37);
			match(LCURL);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 260256694272L) != 0)) {
				{
				setState(41);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RETURN:
				case MOVE:
				case TURN:
				case ASCEND:
				case DESCEND:
				case GROUND:
					{
					setState(38);
					action();
					}
					break;
				case ON:
					{
					setState(39);
					reaction();
					}
					break;
				case NEXT:
				case ID:
					{
					setState(40);
					execution();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(RCURL);
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(47);
				match(NEXT);
				setState(48);
				match(ID);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ReactionContext reaction() {
			return getRuleContext(ReactionContext.class,0);
		}
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				reaction();
				}
				break;
			case OBSTACLE:
			case BATTERY:
			case MESSAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				event();
				}
				break;
			case RETURN:
			case MOVE:
			case TURN:
			case ASCEND:
			case DESCEND:
			case GROUND:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				action();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReactionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(AeroScriptParser.ON, 0); }
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(AeroScriptParser.NEXT, 0); }
		public TerminalNode ID() { return getToken(AeroScriptParser.ID, 0); }
		public ReactionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reaction; }
	}

	public final ReactionContext reaction() throws RecognitionException {
		ReactionContext _localctx = new ReactionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reaction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(ON);
			setState(57);
			event();
			setState(58);
			match(NEXT);
			setState(59);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EventContext extends ParserRuleContext {
		public TerminalNode OBSTACLE() { return getToken(AeroScriptParser.OBSTACLE, 0); }
		public TerminalNode BATTERY() { return getToken(AeroScriptParser.BATTERY, 0); }
		public TerminalNode MESSAGE() { return getToken(AeroScriptParser.MESSAGE, 0); }
		public TerminalNode LSQUARE() { return getToken(AeroScriptParser.LSQUARE, 0); }
		public TerminalNode ID() { return getToken(AeroScriptParser.ID, 0); }
		public TerminalNode RSQUARE() { return getToken(AeroScriptParser.RSQUARE, 0); }
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_event);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBSTACLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(OBSTACLE);
				}
				break;
			case BATTERY:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(BATTERY);
				}
				break;
			case MESSAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(MESSAGE);
				setState(64);
				match(LSQUARE);
				setState(65);
				match(ID);
				setState(66);
				match(RSQUARE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public AcDockContext acDock() {
			return getRuleContext(AcDockContext.class,0);
		}
		public AcMoveContext acMove() {
			return getRuleContext(AcMoveContext.class,0);
		}
		public AcTurnContext acTurn() {
			return getRuleContext(AcTurnContext.class,0);
		}
		public AcAscendContext acAscend() {
			return getRuleContext(AcAscendContext.class,0);
		}
		public AcDescendContext acDescend() {
			return getRuleContext(AcDescendContext.class,0);
		}
		public TerminalNode FOR() { return getToken(AeroScriptParser.FOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode S() { return getToken(AeroScriptParser.S, 0); }
		public TerminalNode SPEED() { return getToken(AeroScriptParser.SPEED, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				{
				setState(69);
				acDock();
				}
				break;
			case MOVE:
				{
				setState(70);
				acMove();
				}
				break;
			case TURN:
				{
				setState(71);
				acTurn();
				}
				break;
			case ASCEND:
				{
				setState(72);
				acAscend();
				}
				break;
			case DESCEND:
			case GROUND:
				{
				setState(73);
				acDescend();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(76);
				match(FOR);
				setState(77);
				expression(0);
				setState(78);
				match(S);
				}
				break;
			case SPEED:
				{
				setState(80);
				match(SPEED);
				setState(81);
				expression(0);
				}
				break;
			case EOF:
			case RCURL:
			case NEXT:
			case ON:
			case RETURN:
			case MOVE:
			case TURN:
			case ASCEND:
			case DESCEND:
			case GROUND:
			case ID:
				break;
			default:
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcDockContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(AeroScriptParser.RETURN, 0); }
		public AcDockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acDock; }
	}

	public final AcDockContext acDock() throws RecognitionException {
		AcDockContext _localctx = new AcDockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_acDock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(RETURN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcMoveContext extends ParserRuleContext {
		public TerminalNode MOVE() { return getToken(AeroScriptParser.MOVE, 0); }
		public TerminalNode TO() { return getToken(AeroScriptParser.TO, 0); }
		public TerminalNode POINT() { return getToken(AeroScriptParser.POINT, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode BY() { return getToken(AeroScriptParser.BY, 0); }
		public TerminalNode NUMBER() { return getToken(AeroScriptParser.NUMBER, 0); }
		public AcMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acMove; }
	}

	public final AcMoveContext acMove() throws RecognitionException {
		AcMoveContext _localctx = new AcMoveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_acMove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(MOVE);
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TO:
				{
				setState(87);
				match(TO);
				setState(88);
				match(POINT);
				setState(89);
				point();
				}
				break;
			case BY:
				{
				setState(90);
				match(BY);
				setState(91);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcTurnContext extends ParserRuleContext {
		public TerminalNode TURN() { return getToken(AeroScriptParser.TURN, 0); }
		public TerminalNode BY() { return getToken(AeroScriptParser.BY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(AeroScriptParser.RIGHT, 0); }
		public TerminalNode LEFT() { return getToken(AeroScriptParser.LEFT, 0); }
		public AcTurnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acTurn; }
	}

	public final AcTurnContext acTurn() throws RecognitionException {
		AcTurnContext _localctx = new AcTurnContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_acTurn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(TURN);
			setState(95);
			_la = _input.LA(1);
			if ( !(_la==RIGHT || _la==LEFT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(96);
			match(BY);
			setState(97);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcAscendContext extends ParserRuleContext {
		public TerminalNode ASCEND() { return getToken(AeroScriptParser.ASCEND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AcAscendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acAscend; }
	}

	public final AcAscendContext acAscend() throws RecognitionException {
		AcAscendContext _localctx = new AcAscendContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_acAscend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ASCEND);
			setState(100);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AcDescendContext extends ParserRuleContext {
		public TerminalNode DESCEND() { return getToken(AeroScriptParser.DESCEND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUND() { return getToken(AeroScriptParser.GROUND, 0); }
		public AcDescendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acDescend; }
	}

	public final AcDescendContext acDescend() throws RecognitionException {
		AcDescendContext _localctx = new AcDescendContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_acDescend);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DESCEND:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(DESCEND);
				setState(103);
				expression(0);
				}
				break;
			case GROUND:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(GROUND);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NEG() { return getToken(AeroScriptParser.NEG, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RANDOM() { return getToken(AeroScriptParser.RANDOM, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode POINT() { return getToken(AeroScriptParser.POINT, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(AeroScriptParser.NUMBER, 0); }
		public TerminalNode LPAREN() { return getToken(AeroScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AeroScriptParser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(AeroScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AeroScriptParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(AeroScriptParser.TIMES, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEG:
				{
				setState(108);
				match(NEG);
				setState(109);
				expression(5);
				}
				break;
			case RANDOM:
				{
				setState(110);
				match(RANDOM);
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(111);
					range();
					}
					break;
				}
				}
				break;
			case POINT:
				{
				setState(114);
				match(POINT);
				setState(115);
				point();
				}
				break;
			case NUMBER:
				{
				setState(116);
				match(NUMBER);
				}
				break;
			case LPAREN:
				{
				setState(117);
				match(LPAREN);
				setState(118);
				expression(0);
				setState(119);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(123);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(124);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(125);
					expression(7);
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PointContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(AeroScriptParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(AeroScriptParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(AeroScriptParser.RPAREN, 0); }
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(LPAREN);
			setState(132);
			expression(0);
			setState(133);
			match(COMMA);
			setState(134);
			expression(0);
			setState(135);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RangeContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(AeroScriptParser.LSQUARE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(AeroScriptParser.COMMA, 0); }
		public TerminalNode RSQUARE() { return getToken(AeroScriptParser.RSQUARE, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(LSQUARE);
			setState(138);
			expression(0);
			setState(139);
			match(COMMA);
			setState(140);
			expression(0);
			setState(141);
			match(RSQUARE);
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0090\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0004\u0000\u001e\b\u0000\u000b"+
		"\u0000\f\u0000\u001f\u0001\u0001\u0003\u0001#\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001*\b\u0001\n\u0001"+
		"\f\u0001-\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004D\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"K\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005S\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"]\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0003\nj\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bq\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000bz\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u007f"+
		"\b\u000b\n\u000b\f\u000b\u0082\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0000\u0001\u0016\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u0000\u0002\u0001\u0000 !\u0001\u0000\u000e\u0010"+
		"\u0099\u0000\u001d\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000"+
		"\u00046\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000\bC\u0001"+
		"\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000"+
		"\u000eV\u0001\u0000\u0000\u0000\u0010^\u0001\u0000\u0000\u0000\u0012c"+
		"\u0001\u0000\u0000\u0000\u0014i\u0001\u0000\u0000\u0000\u0016y\u0001\u0000"+
		"\u0000\u0000\u0018\u0083\u0001\u0000\u0000\u0000\u001a\u0089\u0001\u0000"+
		"\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0001\u0001\u0000\u0000\u0000"+
		"!#\u0005\u0011\u0000\u0000\"!\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$%\u0005%\u0000\u0000%+\u0005\u0004\u0000"+
		"\u0000&*\u0003\n\u0005\u0000\'*\u0003\u0006\u0003\u0000(*\u0003\u0002"+
		"\u0001\u0000)&\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)(\u0001"+
		"\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		"+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000.1\u0005\u0005\u0000\u0000/0\u0005\u0011\u0000\u000002\u0005%\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0003\u0001"+
		"\u0000\u0000\u000037\u0003\u0006\u0003\u000047\u0003\b\u0004\u000057\u0003"+
		"\n\u0005\u000063\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000065\u0001"+
		"\u0000\u0000\u00007\u0005\u0001\u0000\u0000\u000089\u0005\u0017\u0000"+
		"\u00009:\u0003\b\u0004\u0000:;\u0005\u0011\u0000\u0000;<\u0005%\u0000"+
		"\u0000<\u0007\u0001\u0000\u0000\u0000=D\u0005\u0014\u0000\u0000>D\u0005"+
		"\u0015\u0000\u0000?@\u0005\u0016\u0000\u0000@A\u0005\u0006\u0000\u0000"+
		"AB\u0005%\u0000\u0000BD\u0005\u0007\u0000\u0000C=\u0001\u0000\u0000\u0000"+
		"C>\u0001\u0000\u0000\u0000C?\u0001\u0000\u0000\u0000D\t\u0001\u0000\u0000"+
		"\u0000EK\u0003\f\u0006\u0000FK\u0003\u000e\u0007\u0000GK\u0003\u0010\b"+
		"\u0000HK\u0003\u0012\t\u0000IK\u0003\u0014\n\u0000JE\u0001\u0000\u0000"+
		"\u0000JF\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JI\u0001\u0000\u0000\u0000KR\u0001\u0000\u0000\u0000LM\u0005"+
		"\u0018\u0000\u0000MN\u0003\u0016\u000b\u0000NO\u0005\u0019\u0000\u0000"+
		"OS\u0001\u0000\u0000\u0000PQ\u0005\u001a\u0000\u0000QS\u0003\u0016\u000b"+
		"\u0000RL\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000S\u000b\u0001\u0000\u0000\u0000TU\u0005\u001b\u0000\u0000"+
		"U\r\u0001\u0000\u0000\u0000V\\\u0005\u001c\u0000\u0000WX\u0005\u001d\u0000"+
		"\u0000XY\u0005\u0013\u0000\u0000Y]\u0003\u0018\f\u0000Z[\u0005\u001e\u0000"+
		"\u0000[]\u0005&\u0000\u0000\\W\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000]\u000f\u0001\u0000\u0000\u0000^_\u0005\u001f\u0000\u0000"+
		"_`\u0007\u0000\u0000\u0000`a\u0005\u001e\u0000\u0000ab\u0003\u0016\u000b"+
		"\u0000b\u0011\u0001\u0000\u0000\u0000cd\u0005\"\u0000\u0000de\u0003\u0016"+
		"\u000b\u0000e\u0013\u0001\u0000\u0000\u0000fg\u0005#\u0000\u0000gj\u0003"+
		"\u0016\u000b\u0000hj\u0005$\u0000\u0000if\u0001\u0000\u0000\u0000ih\u0001"+
		"\u0000\u0000\u0000j\u0015\u0001\u0000\u0000\u0000kl\u0006\u000b\uffff"+
		"\uffff\u0000lm\u0005\n\u0000\u0000mz\u0003\u0016\u000b\u0005np\u0005\u0012"+
		"\u0000\u0000oq\u0003\u001a\r\u0000po\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qz\u0001\u0000\u0000\u0000rs\u0005\u0013\u0000\u0000sz\u0003"+
		"\u0018\f\u0000tz\u0005&\u0000\u0000uv\u0005\b\u0000\u0000vw\u0003\u0016"+
		"\u000b\u0000wx\u0005\t\u0000\u0000xz\u0001\u0000\u0000\u0000yk\u0001\u0000"+
		"\u0000\u0000yn\u0001\u0000\u0000\u0000yr\u0001\u0000\u0000\u0000yt\u0001"+
		"\u0000\u0000\u0000yu\u0001\u0000\u0000\u0000z\u0080\u0001\u0000\u0000"+
		"\u0000{|\n\u0006\u0000\u0000|}\u0007\u0001\u0000\u0000}\u007f\u0003\u0016"+
		"\u000b\u0007~{\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0017\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005\b\u0000\u0000\u0084\u0085\u0003\u0016\u000b\u0000\u0085\u0086"+
		"\u0005\f\u0000\u0000\u0086\u0087\u0003\u0016\u000b\u0000\u0087\u0088\u0005"+
		"\t\u0000\u0000\u0088\u0019\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0006"+
		"\u0000\u0000\u008a\u008b\u0003\u0016\u000b\u0000\u008b\u008c\u0005\f\u0000"+
		"\u0000\u008c\u008d\u0003\u0016\u000b\u0000\u008d\u008e\u0005\u0007\u0000"+
		"\u0000\u008e\u001b\u0001\u0000\u0000\u0000\u000e\u001f\")+16CJR\\ipy\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}