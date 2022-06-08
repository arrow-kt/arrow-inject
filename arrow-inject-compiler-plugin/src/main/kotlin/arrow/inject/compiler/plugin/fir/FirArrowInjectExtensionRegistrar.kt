package arrow.inject.compiler.plugin.fir

import arrow.inject.compiler.plugin.fir.codegen.ResolvedFunctionGenerationExtension
import arrow.inject.compiler.plugin.fir.resolution.ProofResolutionCheckerExtension
import arrow.inject.compiler.plugin.fir.resolution.checkers.call.AmbiguousProofsChecker
import arrow.inject.compiler.plugin.fir.resolution.checkers.call.CyclesDetectionChecker
import arrow.inject.compiler.plugin.fir.resolution.checkers.call.MissingInductiveDependenciesChecker
import arrow.inject.compiler.plugin.fir.resolution.checkers.call.UnresolvedCallSiteChecker
import arrow.inject.compiler.plugin.fir.resolution.checkers.declaration.OwnershipViolationsChecker
import arrow.inject.compiler.plugin.fir.resolution.checkers.declaration.PublishedApiViolationsChecker
import arrow.inject.compiler.plugin.fir.resolution.checkers.type.ContextReceiverProofTypeChecker
import arrow.inject.compiler.plugin.fir.resolution.contexts.ContextProvidersResolutionExtension
import arrow.inject.compiler.plugin.fir.resolution.resolver.ProofCache
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar

public class FirArrowInjectExtensionRegistrar(
  private val proofCache: ProofCache,
) : FirExtensionRegistrar() {

  /**
   * (FIR API review and comments)
   *
   * The `+` operator makes for a nice API in simple plugins whose extensions
   * only take a `session` as single argument but becomes more unreadable when like in our
   * case we need to pass extra arguments to the constructor.
   *
   * An alternative could be that our `proofCache` argument becomes a session component.
   * We tried that but then in the IR generation part we don't have access to the session anymore.
   */
  override fun ExtensionRegistrarContext.configurePlugin() {
    +{ session: FirSession -> ContextProvidersResolutionExtension(proofCache, session) }
    +{ session: FirSession -> ResolvedFunctionGenerationExtension(proofCache, session) }
    +{ session: FirSession ->
      ProofResolutionCheckerExtension(
        session = session,
        declarationCheckers =
          listOf(
            OwnershipViolationsChecker(session),
            PublishedApiViolationsChecker(session),
          ),
        callCheckers =
          listOf(
            AmbiguousProofsChecker(proofCache, session),
            CyclesDetectionChecker(proofCache, session),
            MissingInductiveDependenciesChecker(proofCache, session),
            UnresolvedCallSiteChecker(proofCache, session),
          ),
        typeCheckers = listOf(
          ContextReceiverProofTypeChecker()
        )
      )
    }
  }
}
