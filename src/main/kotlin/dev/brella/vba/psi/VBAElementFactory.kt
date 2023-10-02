package dev.brella.vba.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.descendants
import com.intellij.psi.util.elementType
import dev.brella.vba.VBALanguage
import dev.brella.vba.psi.impl.VBASubStatementImpl
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

object VBAElementFactory {
    @JvmStatic
    public fun createAmbiguousIdentifier(project: Project, identifier: String) =
        createFile(project, "DIM $identifier")
            .descendants()
            .single { it.elementType == VBATypes.AMBIGUOUS_IDENTIFIER }

    @JvmStatic
    public fun createFile(project: Project, text: String) =
        PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.bas", VBALanguage.NormalModuleFileType, text) as VBAPsiFileRoot

    @JvmStatic
    fun createElement(node: ASTNode): PsiElement =
        when (node.elementType) {
            VBATypes.SUB_STATEMENT -> VBASubStatementImpl(node)
            else -> ANTLRPsiNode(node)
        }
}