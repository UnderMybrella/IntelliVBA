package dev.brella.vba

import com.intellij.openapi.editor.colors.ColorKey
import com.intellij.openapi.editor.colors.TextAttributesKey

@JvmInline
value class HighlightingTag(val tag: String) {
    public operator fun invoke(text: String): String = "<$tag>$text</$tag>"
    public inline operator fun invoke(block: () -> Any): String = invoke(block().toString())
    public operator fun invoke(): String = invoke(tag)
}

open class HighlightingBuilder {
    private val _highlightingTagDescriptors: MutableMap<String, TextAttributesKey> = HashMap()
    private val _inlineElementDescriptors: MutableMap<String, TextAttributesKey> = HashMap()
    private val _highlightingTagColourKeys: MutableMap<String, ColorKey> = HashMap()

    protected val highlightingTagDescriptors get() = HashMap(_highlightingTagDescriptors)
    protected val inlineElementDescriptors get() = HashMap(_inlineElementDescriptors)
    protected val highlightingTagColourKeys get() = HashMap(_highlightingTagColourKeys)

    protected fun highlightingTagDescriptor(tag: String, key: TextAttributesKey): HighlightingTag {
        _highlightingTagDescriptors[tag] = key
        return HighlightingTag(tag)
    }

    protected fun inlineElementDescriptor(tag: String, key: TextAttributesKey): HighlightingTag {
        _inlineElementDescriptors[tag] = key
        return HighlightingTag(tag)
    }

    protected fun highlightingTagColourKey(tag: String, key: ColorKey): HighlightingTag {
        _highlightingTagColourKeys[tag] = key
        return HighlightingTag(tag)
    }
}