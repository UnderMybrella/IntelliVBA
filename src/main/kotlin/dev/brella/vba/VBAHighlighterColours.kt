package dev.brella.vba

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object VBAHighlighterColours {
    private fun create(name: String, fallback: TextAttributesKey): TextAttributesKey =
        createTextAttributesKey("VBA_$name", fallback)

    val BAD_CHARACTER = create("BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

    object BracesAndOperators {
        val BRACES = create("BRACES", DefaultLanguageHighlighterColors.BRACES)
        val BRACKETS = create("BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val COMMA = create("COMMA", DefaultLanguageHighlighterColors.COMMA)
        val DOT = create("DOT", DefaultLanguageHighlighterColors.DOT)
        val OPERATOR_SIGN = create("OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val PARENTHESES = create("PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
    }

    object Comments {
        val APOSTROPHE_COMMENT = create("COMMA_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val REM_COMMENT = create("REM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    }

    object Keywords {
        val KEYWORD = create("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    }

    val DEFAULT = create("DEFAULT", HighlighterColors.TEXT)
    val IDENTIFIER = create("IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
}