package dev.brella.vba

import VBAParser
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class VBAParserAdaptor : ANTLRParserAdaptor(VBALanguage, VBAParser(null)) {
    override fun parse(parser: Parser?, root: IElementType?): ParseTree {
        return (parser as VBAParser).module()
    }
}