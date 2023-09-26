package dev.brella.vba

import VBALexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class VBALexerAdaptor : ANTLRLexerAdaptor(VBALanguage, VBALexer(null))