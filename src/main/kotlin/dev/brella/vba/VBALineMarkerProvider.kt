package dev.brella.vba

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.elementType
import dev.brella.vba.psi.VBATypes

class VBALineMarkerProvider : RelatedItemLineMarkerProvider() {
    override fun collectNavigationMarkers(
        element: PsiElement,
        result: MutableCollection<in RelatedItemLineMarkerInfo<*>>
    ) {
        if (element is LeafPsiElement) {
            when (element.elementType) {
                VBATypes.IDENTIFIER -> collectForIdentifier(element, result)
            }
        }
    }

    private fun collectForIdentifier(element: LeafPsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<*>>) {
        val parentElement = if (element.parent.elementType == VBATypes.AMBIGUOUS_IDENTIFIER) element.parent.parent else element.parent

        if (parentElement.elementType == VBATypes.SUB_STATEMENT) {
            result.add(NavigationGutterIconBuilder.create(AllIcons.Nodes.Method)
                .setTarget(element)
                .setTooltipText("Navigate to self")
                .createLineMarkerInfo(element))
        }
    }
}