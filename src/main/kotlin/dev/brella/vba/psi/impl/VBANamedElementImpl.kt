package dev.brella.vba.psi.impl

import com.intellij.lang.ASTNode
import dev.brella.vba.psi.VBANamedElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

abstract class VBANamedElementImpl(node: ASTNode): ANTLRPsiNode(node), VBANamedElement {
}