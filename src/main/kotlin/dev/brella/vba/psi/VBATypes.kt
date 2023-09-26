package dev.brella.vba.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import dev.brella.vba.VBALanguage
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import VBAParser as T


object VBATypes {
    private val TOKEN_TYPES: List<TokenIElementType>
    private val RULE_TYPES: List<RuleIElementType>

    val FILE: IFileElementType = IFileElementType(VBALanguage)

    val AMBIGUOUS_KEYWORD by T.RULE_ambiguousKeyword.rule

    val MODULE by T.RULE_module.rule

    val IDENTIFIER by T.IDENTIFIER.token

    val REM_COMMENT by T.REMCOMMENT.token
    val COMMENT by T.COMMENT.token

    val LINE_CONTINUATION by T.LINE_CONTINUATION.token
    val NEWLINE by T.NEWLINE.token
    val WS by T.WS.token

    object Keywords {
        val ACCESS by T.ACCESS.token
        val ADDRESS_OF by T.ADDRESSOF.token
        val ALIAS by T.ALIAS.token
        val AND by T.AND.token
        val ATTRIBUTE by T.ATTRIBUTE.token
        val APP_ACTIVATE by T.APPACTIVATE.token
        val APPEND by T.APPEND.token
        val AS by T.AS.token

        val BEGIN by T.BEGIN.token
        val BEEP by T.BEEP.token
        val BINARY by T.BINARY.token
        val BOOLEAN by T.BOOLEAN.token
        val BY_VAL by T.BYVAL.token
        val BY_REF by T.BYREF.token
        val BYTE by T.BYTE.token

        val CALL by T.CALL.token
        val CASE by T.CASE.token
        val CHDIR by T.CHDIR.token
        val CH_DRIVE by T.CHDRIVE.token
        val CLASS by T.CLASS.token
        val CLOSE by T.CLOSE.token
        val COLLECTION by T.COLLECTION.token
        val CONST by T.CONST.token

        val DATABASE by T.DATABASE.token
        val DATE by T.DATE.token
        val DECLARE by T.DECLARE.token
        val DEF_BOOL by T.DEFBOOL.token
        val DEF_BYTE by T.DEFBYTE.token
        val DEF_DATE by T.DEFDATE.token
        val DEF_DBL by T.DEFDBL.token
        val DEF_DEC by T.DEFDEC.token
        val DEF_CUR by T.DEFCUR.token
        val DEF_INT by T.DEFINT.token
        val DEF_LNG by T.DEFLNG.token
        val DEF_OBJ by T.DEFOBJ.token
        val DEF_SNG by T.DEFSNG.token
        val DEF_STR by T.DEFSTR.token
        val DEF_VAR by T.DEFVAR.token
        val DELETE_SETTING by T.DELETESETTING.token
        val DIM by T.DIM.token
        val DO by T.DO.token
        val DOUBLE by T.DOUBLE.token

        val EACH by T.EACH.token
        val ELSE by T.ELSE.token
        val ELSE_IF by T.ELSEIF.token
        val END_ENUM by T.END_ENUM.token
        val END_FUNCTION by T.END_FUNCTION.token
        val END_IF by T.END_IF.token
        val END_PROPERTY by T.END_PROPERTY.token
        val END_SELECT by T.END_SELECT.token
        val END_SUB by T.END_SUB.token
        val END_TYPE by T.END_TYPE.token
        val END_WITH by T.END_WITH.token
        val END by T.END.token
        val ENUM by T.ENUM.token
        val EQV by T.EQV.token
        val ERASE by T.ERASE.token
        val ERROR by T.ERROR.token
        val EVENT by T.EVENT.token
        val EXIT_DO by T.EXIT_DO.token
        val EXIT_FOR by T.EXIT_FOR.token
        val EXIT_FUNCTION by T.EXIT_FUNCTION.token
        val EXIT_PROPERTY by T.EXIT_PROPERTY.token
        val EXIT_SUB by T.EXIT_SUB.token

        val FALSE by T.FALSE.token
        val FILE_COPY by T.FILECOPY.token
        val FRIEND by T.FRIEND.token
        val FOR by T.FOR.token
        val FUNCTION by T.FUNCTION.token

        val GET by T.GET.token
        val GLOBAL by T.GLOBAL.token
        val GO_SUB by T.GOSUB.token
        val GOTO by T.GOTO.token

        val IF by T.IF.token
        val IMP by T.IMP.token
        val IMPLEMENTS by T.IMPLEMENTS.token
        val IN by T.IN.token
        val INPUT by T.INPUT.token
        val IS by T.IS.token
        val INTEGER by T.INTEGER.token

        val KILL by T.KILL.token

        val LOAD by T.LOAD.token
        val LOCK by T.LOCK.token
        val LONG by T.LONG.token
        val LOOP by T.LOOP.token
        val LEN by T.LEN.token
        val LET by T.LET.token
        val LIB by T.LIB.token
        val LIKE by T.LIKE.token
        val LINE_INPUT by T.LINE_INPUT.token
        val LOCK_READ by T.LOCK_READ.token
        val LOCK_WRITE by T.LOCK_WRITE.token
        val LOCK_READ_WRITE by T.LOCK_READ_WRITE.token
        val LSET by T.LSET.token

        val MACRO_CONST by T.MACRO_CONST.token
        val MACRO_IF by T.MACRO_IF.token
        val MACRO_ELSEIF by T.MACRO_ELSEIF.token
        val MACRO_ELSE by T.MACRO_ELSE.token
        val MACRO_END_IF by T.MACRO_END_IF.token
        val ME by T.ME.token
        val MID by T.MID.token
        val MKDIR by T.MKDIR.token
        val MOD by T.MOD.token

        val NAME by T.NAME.token
        val NEXT by T.NEXT.token
        val NEW by T.NEW.token
        val NOT by T.NOT.token
        val NOTHING by T.NOTHING.token
        val NULL_ by T.NULL_.token

        val ON by T.ON.token
        val ON_ERROR by T.ON_ERROR.token
        val ON_LOCAL_ERROR by T.ON_LOCAL_ERROR.token
        val OPEN by T.OPEN.token
        val OPTIONAL by T.OPTIONAL.token
        val OPTION_BASE by T.OPTION_BASE.token
        val OPTION_EXPLICIT by T.OPTION_EXPLICIT.token
        val OPTION_COMPARE by T.OPTION_COMPARE.token
        val OPTION_PRIVATE_MODULE by T.OPTION_PRIVATE_MODULE.token
        val OR by T.OR.token
        val OUTPUT by T.OUTPUT.token

        val PARAM_ARRAY by T.PARAMARRAY.token
        val PRESERVE by T.PRESERVE.token
        val PRINT by T.PRINT.token
        val PRIVATE by T.PRIVATE.token
        val PROPERTY_GET by T.PROPERTY_GET.token
        val PROPERTY_LET by T.PROPERTY_LET.token
        val PROPERTY_SET by T.PROPERTY_SET.token
        val PTR_SAFE by T.PTRSAFE.token
        val PUBLIC by T.PUBLIC.token
        val PUT by T.PUT.token
        val RANDOM by T.RANDOM.token

        val RANDOMIZE by T.RANDOMIZE.token
        val RAISE_EVENT by T.RAISEEVENT.token
        val READ by T.READ.token
        val READ_WRITE by T.READ_WRITE.token
        val REDIM by T.REDIM.token
        val REM by T.REM.token
        val RESET by T.RESET.token
        val RESUME by T.RESUME.token
        val RETURN by T.RETURN.token
        val RMDIR by T.RMDIR.token
        val RSET by T.RSET.token

        val SAVE_PICTURE by T.SAVEPICTURE.token
        val SAVE_SETTING by T.SAVESETTING.token
        val SEEK by T.SEEK.token
        val SELECT by T.SELECT.token
        val SEND_KEYS by T.SENDKEYS.token
        val SET by T.SET.token
        val SET_ATTR by T.SETATTR.token
        val SHARED by T.SHARED.token
        val SINGLE by T.SINGLE.token
        val SPC by T.SPC.token
        val STATIC by T.STATIC.token
        val STEP by T.STEP.token
        val STOP by T.STOP.token
        val STRING by T.STRING.token
        val SUB by T.SUB.token

        val TAB by T.TAB.token
        val TEXT by T.TEXT.token
        val THEN by T.THEN.token
        val TIME by T.TIME.token
        val TO by T.TO.token
        val TRUE by T.TRUE.token
        val TYPE by T.TYPE.token
        val TYPEOF by T.TYPEOF.token

        val UNLOAD by T.UNLOAD.token
        val UNLOCK by T.UNLOCK.token
        val UNTIL by T.UNTIL.token

        val VARIANT by T.VARIANT.token
        val VERSION by T.VERSION.token

        val WEND by T.WEND.token
        val WHILE by T.WHILE.token
        val WIDTH by T.WIDTH.token
        val WITH by T.WITH.token
        val WITH_EVENTS by T.WITHEVENTS.token
        val WRITE by T.WRITE.token

        val XOR by T.XOR.token
    }

    object Symbols {
        val AMPERSAND by T.AMPERSAND.token
        val ASSIGN by T.ASSIGN.token
        val DIV by T.DIV.token
        val EQ by T.EQ.token
        val GEQ by T.GEQ.token
        val GT by T.GT.token
        val LEQ by T.LEQ.token
        val LPAREN by T.LPAREN.token
        val LT by T.LT.token
        val MINUS by T.MINUS.token
        val MINUS_EQ by T.MINUS_EQ.token
        val MULT by T.MULT.token
        val NEQ by T.NEQ.token
        val PLUS by T.PLUS.token
        val PLUS_EQ by T.PLUS_EQ.token
        val POW by T.POW.token
        val RPAREN by T.RPAREN.token
        val L_SQUARE_BRACKET by T.L_SQUARE_BRACKET.token
        val R_SQUARE_BRACKET by T.R_SQUARE_BRACKET.token
    }

    object Sets {
        val COMMENTS by lazy { of(COMMENT, REM_COMMENT) }
        val WHITESPACES by lazy { of(WS) }
        val IDENTIFIERS by lazy { of(IDENTIFIER) }

        val ALL_KEYWORDS by lazy {
            of(
                Keywords.ACCESS,
                Keywords.ADDRESS_OF,
                Keywords.ALIAS,
                Keywords.AND,
                Keywords.ATTRIBUTE,
                Keywords.APP_ACTIVATE,
                Keywords.APPEND,
                Keywords.AS,

                Keywords.BEGIN,
                Keywords.BEEP,
                Keywords.BINARY,
                Keywords.BOOLEAN,
                Keywords.BY_VAL,
                Keywords.BY_REF,
                Keywords.BYTE,

                Keywords.CALL,
                Keywords.CASE,
                Keywords.CHDIR,
                Keywords.CH_DRIVE,
                Keywords.CLASS,
                Keywords.CLOSE,
                Keywords.COLLECTION,
                Keywords.CONST,

                Keywords.DATABASE,
                Keywords.DATE,
                Keywords.DECLARE,
                Keywords.DEF_BOOL,
                Keywords.DEF_BYTE,
                Keywords.DEF_DATE,
                Keywords.DEF_DBL,
                Keywords.DEF_DEC,
                Keywords.DEF_CUR,
                Keywords.DEF_INT,
                Keywords.DEF_LNG,
                Keywords.DEF_OBJ,
                Keywords.DEF_SNG,
                Keywords.DEF_STR,
                Keywords.DEF_VAR,
                Keywords.DELETE_SETTING,
                Keywords.DIM,
                Keywords.DO,
                Keywords.DOUBLE,

                Keywords.EACH,
                Keywords.ELSE,
                Keywords.ELSE_IF,
                Keywords.END_ENUM,
                Keywords.END_FUNCTION,
                Keywords.END_IF,
                Keywords.END_PROPERTY,
                Keywords.END_SELECT,
                Keywords.END_SUB,
                Keywords.END_TYPE,
                Keywords.END_WITH,
                Keywords.END,
                Keywords.ENUM,
                Keywords.EQV,
                Keywords.ERASE,
                Keywords.ERROR,
                Keywords.EVENT,
                Keywords.EXIT_DO,
                Keywords.EXIT_FOR,
                Keywords.EXIT_FUNCTION,
                Keywords.EXIT_PROPERTY,
                Keywords.EXIT_SUB,

                Keywords.FALSE,
                Keywords.FILE_COPY,
                Keywords.FRIEND,
                Keywords.FOR,
                Keywords.FUNCTION,

                Keywords.GET,
                Keywords.GLOBAL,
                Keywords.GO_SUB,
                Keywords.GOTO,

                Keywords.IF,
                Keywords.IMP,
                Keywords.IMPLEMENTS,
                Keywords.IN,
                Keywords.INPUT,
                Keywords.IS,
                Keywords.INTEGER,

                Keywords.KILL,

                Keywords.LOAD,
                Keywords.LOCK,
                Keywords.LONG,
                Keywords.LOOP,
                Keywords.LEN,
                Keywords.LET,
                Keywords.LIB,
                Keywords.LIKE,
                Keywords.LINE_INPUT,
                Keywords.LOCK_READ,
                Keywords.LOCK_WRITE,
                Keywords.LOCK_READ_WRITE,
                Keywords.LSET,

                Keywords.MACRO_CONST,
                Keywords.MACRO_IF,
                Keywords.MACRO_ELSEIF,
                Keywords.MACRO_ELSE,
                Keywords.MACRO_END_IF,
                Keywords.ME,
                Keywords.MID,
                Keywords.MKDIR,
                Keywords.MOD,

                Keywords.NAME,
                Keywords.NEXT,
                Keywords.NEW,
                Keywords.NOT,
                Keywords.NOTHING,
                Keywords.NULL_,

                Keywords.ON,
                Keywords.ON_ERROR,
                Keywords.ON_LOCAL_ERROR,
                Keywords.OPEN,
                Keywords.OPTIONAL,
                Keywords.OPTION_BASE,
                Keywords.OPTION_EXPLICIT,
                Keywords.OPTION_COMPARE,
                Keywords.OPTION_PRIVATE_MODULE,
                Keywords.OR,
                Keywords.OUTPUT,

                Keywords.PARAM_ARRAY,
                Keywords.PRESERVE,
                Keywords.PRINT,
                Keywords.PRIVATE,
                Keywords.PROPERTY_GET,
                Keywords.PROPERTY_LET,
                Keywords.PROPERTY_SET,
                Keywords.PTR_SAFE,
                Keywords.PUBLIC,
                Keywords.PUT,
                Keywords.RANDOM,

                Keywords.RANDOMIZE,
                Keywords.RAISE_EVENT,
                Keywords.READ,
                Keywords.READ_WRITE,
                Keywords.REDIM,
                Keywords.REM,
                Keywords.RESET,
                Keywords.RESUME,
                Keywords.RETURN,
                Keywords.RMDIR,
                Keywords.RSET,

                Keywords.SAVE_PICTURE,
                Keywords.SAVE_SETTING,
                Keywords.SEEK,
                Keywords.SELECT,
                Keywords.SEND_KEYS,
                Keywords.SET,
                Keywords.SET_ATTR,
                Keywords.SHARED,
                Keywords.SINGLE,
                Keywords.SPC,
                Keywords.STATIC,
                Keywords.STEP,
                Keywords.STOP,
                Keywords.STRING,
                Keywords.SUB,

                Keywords.TAB,
                Keywords.TEXT,
                Keywords.THEN,
                Keywords.TIME,
                Keywords.TO,
                Keywords.TRUE,
                Keywords.TYPE,
                Keywords.TYPEOF,

                Keywords.UNLOAD,
                Keywords.UNLOCK,
                Keywords.UNTIL,

                Keywords.VARIANT,
                Keywords.VERSION,

                Keywords.WEND,
                Keywords.WHILE,
                Keywords.WIDTH,
                Keywords.WITH,
                Keywords.WITH_EVENTS,
                Keywords.WRITE,

                Keywords.XOR,
            )
        }
        val AMBIGUOUS_KEYWORDS by lazy {
            of(
                Keywords.ACCESS,
                Keywords.ADDRESS_OF,
                Keywords.ALIAS,
                Keywords.AND,
                Keywords.ATTRIBUTE,
                Keywords.APP_ACTIVATE,
                Keywords.APPEND,
                Keywords.AS,
                Keywords.BEEP,
                Keywords.BEGIN,
                Keywords.BINARY,
                Keywords.BOOLEAN,
                Keywords.BY_VAL,
                Keywords.BY_REF,
                Keywords.BYTE,
                Keywords.CALL,
                Keywords.CASE,
                Keywords.CLASS,
                Keywords.CLOSE,
                Keywords.CHDIR,
                Keywords.CH_DRIVE,
                Keywords.COLLECTION,
                Keywords.CONST,
                Keywords.DATABASE,
                Keywords.DATE,
                Keywords.DECLARE,
                Keywords.DEF_BOOL,
                Keywords.DEF_BYTE,
                Keywords.DEF_CUR,
                Keywords.DEF_DBL,
                Keywords.DEF_DATE,
                Keywords.DEF_DEC,
                Keywords.DEF_INT,
                Keywords.DEF_LNG,
                Keywords.DEF_OBJ,
                Keywords.DEF_SNG,
                Keywords.DEF_STR,
                Keywords.DEF_VAR,
                Keywords.DELETE_SETTING,
                Keywords.DIM,
                Keywords.DO,
                Keywords.DOUBLE,
                Keywords.EACH,
                Keywords.ELSE,
                Keywords.ELSE_IF,
                Keywords.END,
                Keywords.ENUM,
                Keywords.EQV,
                Keywords.ERASE,
                Keywords.ERROR,
                Keywords.EVENT,
                Keywords.FALSE,
                Keywords.FILE_COPY,
                Keywords.FRIEND,
                Keywords.FOR,
                Keywords.FUNCTION,
                Keywords.GET,
                Keywords.GLOBAL,
                Keywords.GO_SUB,
                Keywords.GOTO,
                Keywords.IF,
                Keywords.IMP,
                Keywords.IMPLEMENTS,
                Keywords.IN,
                Keywords.INPUT,
                Keywords.IS,
                Keywords.INTEGER,
                Keywords.KILL,
                Keywords.LOAD,
                Keywords.LOCK,
                Keywords.LONG,
                Keywords.LOOP,
                Keywords.LEN,
                Keywords.LET,
                Keywords.LIB,
                Keywords.LIKE,
                Keywords.LSET,
                Keywords.ME,
                Keywords.MID,
                Keywords.MKDIR,
                Keywords.MOD,
                Keywords.NAME,
                Keywords.NEXT,
                Keywords.NEW,
                Keywords.NOT,
                Keywords.NOTHING,
                Keywords.NULL_,
                Keywords.ON,
                Keywords.OPEN,
                Keywords.OPTIONAL,
                Keywords.OR,
                Keywords.OUTPUT,
                Keywords.PARAM_ARRAY,
                Keywords.PRESERVE,
                Keywords.PRINT,
                Keywords.PRIVATE,
                Keywords.PUBLIC,
                Keywords.PUT,
                Keywords.RANDOM,
                Keywords.RANDOMIZE,
                Keywords.RAISE_EVENT,
                Keywords.READ,
                Keywords.REDIM,
                Keywords.REM,
                Keywords.RESET,
                Keywords.RESUME,
                Keywords.RETURN,
                Keywords.RMDIR,
                Keywords.RSET,
                Keywords.SAVE_PICTURE,
                Keywords.SAVE_SETTING,
                Keywords.SEEK,
                Keywords.SELECT,
                Keywords.SEND_KEYS,
                Keywords.SET,
                Keywords.SET_ATTR,
                Keywords.SHARED,
                Keywords.SINGLE,
                Keywords.SPC,
                Keywords.STATIC,
                Keywords.STEP,
                Keywords.STOP,
                Keywords.STRING,
                Keywords.SUB,
                Keywords.TAB,
                Keywords.TEXT,
                Keywords.THEN,
                Keywords.TIME,
                Keywords.TO,
                Keywords.TRUE,
                Keywords.TYPE,
                Keywords.TYPEOF,
                Keywords.UNLOAD,
                Keywords.UNLOCK,
                Keywords.UNTIL,
                Keywords.VARIANT,
                Keywords.VERSION,
                Keywords.WEND,
                Keywords.WHILE,
                Keywords.WIDTH,
                Keywords.WITH,
                Keywords.WITH_EVENTS,
                Keywords.WRITE,
                Keywords.XOR
            )
        }
        val GUARANTEED_KEYWORDS by lazy { TokenSet.andNot(ALL_KEYWORDS, AMBIGUOUS_KEYWORDS) }

        val OPERATORS by lazy {
            of(
                Symbols.AMPERSAND,
                Symbols.ASSIGN,
                Symbols.DIV,
                Symbols.EQ,
                Symbols.GEQ,
                Symbols.GT,
                Symbols.LEQ,
                Symbols.LT,
                Symbols.MINUS,
                Symbols.MINUS_EQ,
                Symbols.MULT,
                Symbols.NEQ,
                Symbols.PLUS,
                Symbols.PLUS_EQ,
                Symbols.POW
            )
        }
        val BRACES by lazy { of() }
        val BRACKETS by lazy { of(Symbols.L_SQUARE_BRACKET, Symbols.R_SQUARE_BRACKET) }
        val PARENTHESES by lazy { of(Symbols.LPAREN, Symbols.RPAREN) }

        private fun of(vararg elements: IElementType): TokenSet = TokenSet.create(*elements)
    }

    fun createElement(node: ASTNode): PsiElement =
        when (node.elementType) {
            else -> ANTLRPsiNode(node)
        }

    private val Int.token get(): Lazy<TokenIElementType> = lazy { TOKEN_TYPES[this] }
    private val Int.rule get(): Lazy<RuleIElementType> = lazy { RULE_TYPES[this] }

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(VBALanguage, T.tokenNames, T.ruleNames)

        TOKEN_TYPES = PSIElementTypeFactory.getTokenIElementTypes(VBALanguage)
        RULE_TYPES = PSIElementTypeFactory.getRuleIElementTypes(VBALanguage)
    }
}