package com.palaziks.sideloader.installer.adb

import com.palaziks.sideloader.core.StorageManager
import com.palaziks.sideloader.model.Session

/**
 * Generate shell script with installation
 * Used only for installing over adb commands
 */
class AdbInstallationHandler(
    private val storageManager: StorageManager,
    val session: Session,
) {
    fun generate(onGenerated: (String) -> Unit) {
        val installationScriptPath = GenerateInstallationScript(
            storageManager,
            session.getInstallationParameters(),
            session.preferences,
        ).writeToFile()
        onGenerated(installationScriptPath)
    }
}
