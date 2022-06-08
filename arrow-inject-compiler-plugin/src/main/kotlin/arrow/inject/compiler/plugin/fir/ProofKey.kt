package arrow.inject.compiler.plugin.fir

import org.jetbrains.kotlin.fir.declarations.FirPluginKey

/**
 * (FIR API review and comments)
 *
 * # what's the plugin key for?
 *
 * We have used this one across the frontend to set the `origin`
 * property in nodes, but we are not sure what good it does or if
 * it's needed at all
 */
internal object ProofKey : FirPluginKey()
