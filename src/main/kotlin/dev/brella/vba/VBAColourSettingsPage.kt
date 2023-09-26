package dev.brella.vba

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class VBAColourSettingsPage : ColorSettingsPage {
    object Util : HighlightingBuilder() {
        internal val TAG_HIGHLIGHTING_MAP by lazy { highlightingTagDescriptors }
        internal val INLINE_ELEMENTS by lazy { inlineElementDescriptors }

        @JvmStatic
        internal val DESCRIPTORS = arrayOf(
            AttributesDescriptor(VBA.messagePointer("options.vba.color.descriptor.comments.commentLine"), VBAHighlighterColours.Comments.APOSTROPHE_COMMENT),
            AttributesDescriptor(VBA.messagePointer("options.vba.color.descriptor.keywords.keyword"), VBAHighlighterColours.Keywords.KEYWORD),
            AttributesDescriptor(VBA.messagePointer("options.vba.color.descriptor.operators.operator"), VBAHighlighterColours.BracesAndOperators.OPERATOR_SIGN),
            AttributesDescriptor(VBA.messagePointer("options.vba.color.descriptor.identifiers.default"), VBAHighlighterColours.IDENTIFIER)
        )

        private val KEYWORD = highlightingTagDescriptor("keyword", VBAHighlighterColours.Keywords.KEYWORD)


        private val Private = KEYWORD("Private")
        private val Sub = KEYWORD("Sub")
        private val If = KEYWORD("If")
        private val Then = KEYWORD("Then")
        private val Dim = KEYWORD("Dim")
        private val As = KEYWORD("As")
        private val String = KEYWORD("String")
        private val Boolean = KEYWORD("Boolean")
        private val And = KEYWORD("And")
        private val EndIf = KEYWORD("End If")
        private val EndSub = KEYWORD("End Sub")
        private val ExitSub = KEYWORD("Exit Sub")

        @JvmStatic
        internal val DEMO_TEXT = """
            $Private $Sub mTextBox_Change()
                Debug.Print "Change:" & mDerive & " -> " & mTextBox.Text & "{" & mCurrentSuggestions.Count & "/" & mIgnore & "}"
                $If mIgnore $Then $ExitSub
            
                $Dim sWord $As $String
                sWord = mTextBox.Text
            
                $Dim bUpdate $As $Boolean
                bUpdate = sWord <> mDerive $And Len(sWord) > 0
                $If bUpdate $Then
                    $If mCurrentSuggestions.Count() > 0 $And mCurrentSuggestionIndex $Then
                        bUpdate = sWord <> mCurrentSuggestions(mCurrentSuggestionIndex)
                    $EndIf
                $EndIf
            
                mDerive = sWord
                $If bUpdate $Then
                    FindSuggestions sWord
            
                    If mCurrentSuggestions.Count > 0 $Then UpdateWithSuggestion
                $EndIf
            $EndSub
        """.trimIndent()
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = Util.DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "VBA"

    override fun getIcon(): Icon? = VBALanguage.NormalModuleFileType.icon

    override fun getHighlighter(): SyntaxHighlighter = VBASyntaxHighlighter

    override fun getDemoText(): String = Util.DEMO_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> = Util.TAG_HIGHLIGHTING_MAP
    override fun getAdditionalInlineElementToDescriptorMap(): MutableMap<String, TextAttributesKey> = Util.INLINE_ELEMENTS
}