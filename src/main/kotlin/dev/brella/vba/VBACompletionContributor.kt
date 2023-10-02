package dev.brella.vba

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import dev.brella.vba.psi.VBATypes

class VBACompletionContributor : CompletionContributor() {
    private object IdentifierCompletion : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            result.addElement(LookupElementBuilder.create("Hello"))
        }
    }
    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(VBATypes.IDENTIFIER), IdentifierCompletion)
    }
}