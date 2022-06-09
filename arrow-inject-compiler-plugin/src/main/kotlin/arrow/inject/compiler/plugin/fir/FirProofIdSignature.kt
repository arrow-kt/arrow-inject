package arrow.inject.compiler.plugin.fir

import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.backend.Fir2IrSignatureComposer
import org.jetbrains.kotlin.fir.backend.jvm.FirJvmKotlinMangler
import org.jetbrains.kotlin.fir.declarations.FirDeclaration
import org.jetbrains.kotlin.fir.signaturer.FirBasedSignatureComposer
import org.jetbrains.kotlin.ir.util.IdSignature

/**
 * (FIR API review and comments)
 *
 * We tried getting signatures or the composer from the FIR session
 * but could not find a better way, so we create our own here.
 * The generated signatures are used to look up declarations in backend IR related
 * to the providers found suitable for resolved calls
 */
interface FirProofIdSignature {

  val session: FirSession

  val composer: Fir2IrSignatureComposer
    get() = FirBasedSignatureComposer(FirJvmKotlinMangler(session))

  val FirDeclaration.idSignature: IdSignature
    get() = checkNotNull(composer.composeSignature(this))
}
