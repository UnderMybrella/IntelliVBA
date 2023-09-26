package dev.brella.vba

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import dev.brella.vba.psi.VBATypes

class VBADumbAnnotator : Annotator, DumbAware {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element.elementType) {
            in VBATypes.Sets.AMBIGUOUS_KEYWORDS -> {
                holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                    .range(element)
                    .textAttributes(
                        if (element.parent.elementType == VBATypes.AMBIGUOUS_KEYWORD) VBAHighlighterColours.IDENTIFIER
                        else VBAHighlighterColours.Keywords.KEYWORD
                    )
                    .create()
            }
        }
    }
}