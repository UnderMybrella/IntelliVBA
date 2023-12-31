package dev.brella.vba

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import dev.brella.vba.psi.VBAElementFactory
import dev.brella.vba.psi.VBAPsiFileRoot
import dev.brella.vba.psi.VBATypes
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class VBAParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer =
        VBALexerAdaptor()

    override fun createParser(project: Project?): PsiParser =
        VBAParserAdaptor()

    override fun getFileNodeType(): IFileElementType =
        VBATypes.FILE

    override fun getCommentTokens(): TokenSet =
        VBATypes.Sets.COMMENTS

    override fun getStringLiteralElements(): TokenSet =
        TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement =
        VBAElementFactory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile =
        VBAPsiFileRoot(viewProvider)
}