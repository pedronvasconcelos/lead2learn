package com.vascontech.lead2learn

import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import org.junit.jupiter.api.Test

class ModularityTests {
    companion object {
        val modules = ApplicationModules.of(Lead2learnApplication::class.java)
    }

    @Test
    fun verifiesModularStructure() {
        modules.verify()
    }

    @Test
    fun createModuleDocumentation() {
        Documenter(modules).writeDocumentation()
    }
}