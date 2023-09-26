package dev.brella.vba

import com.intellij.icons.AllIcons
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object VBALanguage : Language("vba") {
    private fun readResolve(): Any = VBALanguage

    object UserFormModuleFileType : LanguageFileType(VBALanguage) {
        override fun getName(): String = "UserForm"
        override fun getDisplayName(): String = "VBA User Form"
        override fun getDescription(): String = "User form"
        override fun getDefaultExtension(): String = "frm"
        override fun getIcon(): Icon? = AllIcons.Nodes.Class
    }
    object NormalModuleFileType : LanguageFileType(VBALanguage) {
        override fun getName(): String = "NormalModule"
        override fun getDisplayName(): String = "VBA Normal Module"
        override fun getDescription(): String = "Normal module"
        override fun getDefaultExtension(): String = "bas"
        override fun getIcon(): Icon? = AllIcons.Nodes.Class
    }
    object ClassModuleFileType : LanguageFileType(VBALanguage) {
        override fun getName(): String = "ClassModule"
        override fun getDisplayName(): String = "VBA Class Module"
        override fun getDescription(): String = "Class module"
        override fun getDefaultExtension(): String = "cls"
        override fun getIcon(): Icon? = AllIcons.Nodes.Class
    }
}