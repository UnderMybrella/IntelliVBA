package dev.brella.vba.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import dev.brella.vba.psi.VBAElementFactory
import dev.brella.vba.psi.VBATypes

class VBASubStatementImpl(node: ASTNode): VBANamedElementImpl(node) {
    private fun subIdentifier(): PsiElement? = findChildByType<PsiElement>(VBATypes.AMBIGUOUS_IDENTIFIER)
    override fun getNameIdentifier(): PsiElement? =
        subIdentifier()

    override fun setName(name: String): PsiElement {
        subIdentifier()?.replace(VBAElementFactory.createAmbiguousIdentifier(project, name))

        return this
    }
}