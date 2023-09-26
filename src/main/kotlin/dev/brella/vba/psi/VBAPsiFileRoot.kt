package dev.brella.vba.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import dev.brella.vba.VBALanguage

class VBAPsiFileRoot(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VBALanguage) {
    override fun getFileType(): FileType = VBALanguage.NormalModuleFileType
    override fun toString(): String = "VBA Psi File Root"
}