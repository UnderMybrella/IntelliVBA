package dev.brella.vba

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.util.containers.MultiMap
import com.intellij.util.containers.toArray
import dev.brella.vba.psi.VBATypes

object VBASyntaxHighlighter : SyntaxHighlighterBase() {
    private val ourMap: MultiMap<IElementType, TextAttributesKey> = MultiMap.create()
    class Factory : SyntaxHighlighterFactory() {
        override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter =
            VBASyntaxHighlighter
    }

    override fun getHighlightingLexer(): Lexer =
        VBALexerAdaptor()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        synchronized(this::class) {
            return pack(VBAHighlighterColours.DEFAULT, ourMap[tokenType].toArray(TextAttributesKey.EMPTY_ARRAY))
        }
    }

    init {
        ourMap.putValue(VBATypes.COMMENT, VBAHighlighterColours.Comments.APOSTROPHE_COMMENT)
        ourMap.putValue(VBATypes.REM_COMMENT, VBAHighlighterColours.Comments.REM_COMMENT)

        VBATypes.Sets.GUARANTEED_KEYWORDS.types.forEach { ourMap.putValue(it, VBAHighlighterColours.Keywords.KEYWORD) }
        VBATypes.Sets.OPERATORS.types.forEach { ourMap.putValue(it, VBAHighlighterColours.BracesAndOperators.OPERATOR_SIGN) }
        VBATypes.Sets.IDENTIFIERS.types.forEach { ourMap.putValue(it, VBAHighlighterColours.IDENTIFIER) }

        ourMap.putValue(TokenType.BAD_CHARACTER, VBAHighlighterColours.BAD_CHARACTER)
    }
}