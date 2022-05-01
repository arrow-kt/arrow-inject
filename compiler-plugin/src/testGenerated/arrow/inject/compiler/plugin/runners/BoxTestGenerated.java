

package arrow.inject.compiler.plugin.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link GenerateNewCompilerTests.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("src/testData/box/context")
@TestDataPath("$PROJECT_ROOT")
public class BoxTestGenerated extends AbstractBoxTest {
    @Test
    public void testAllFilesPresentInContext() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("src/testData/box/context"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @Test
    @TestMetadata("class_provider.kt")
    public void testClass_provider() throws Exception {
        runTest("src/testData/box/context/class_provider.kt");
    }

    @Test
    @TestMetadata("coherent_concrete_identity.kt")
    public void testCoherent_concrete_identity() throws Exception {
        runTest("src/testData/box/context/coherent_concrete_identity.kt");
    }

    @Test
    @TestMetadata("coherent_polymorphic_identity.kt")
    public void testCoherent_polymorphic_identity() throws Exception {
        runTest("src/testData/box/context/coherent_polymorphic_identity.kt");
    }

    @Test
    @TestMetadata("coherent_polymorphic_identity_inference.kt")
    public void testCoherent_polymorphic_identity_inference() throws Exception {
        runTest("src/testData/box/context/coherent_polymorphic_identity_inference.kt");
    }

    @Test
    @TestMetadata("different_context_providers_of_the_same_type_are_not_ambiguous.kt")
    public void testDifferent_context_providers_of_the_same_type_are_not_ambiguous() throws Exception {
        runTest("src/testData/box/context/different_context_providers_of_the_same_type_are_not_ambiguous.kt");
    }

    @Test
    @TestMetadata("fun_provider.kt")
    public void testFun_provider() throws Exception {
        runTest("src/testData/box/context/fun_provider.kt");
    }

    @Test
    @TestMetadata("member_injection_class_.kt")
    public void testMember_injection_class_() throws Exception {
        runTest("src/testData/box/context/member_injection_class_.kt");
    }

    @Test
    @TestMetadata("member_injection_class_with_injected_args_and_members.kt")
    public void testMember_injection_class_with_injected_args_and_members() throws Exception {
        runTest("src/testData/box/context/member_injection_class_with_injected_args_and_members.kt");
    }

    @Test
    @TestMetadata("member_injection_class_with_injected_args_and_members_re_scoped_.kt")
    public void testMember_injection_class_with_injected_args_and_members_re_scoped_() throws Exception {
        runTest("src/testData/box/context/member_injection_class_with_injected_args_and_members_re_scoped_.kt");
    }

    @Test
    @TestMetadata("member_injection_object_.kt")
    public void testMember_injection_object_() throws Exception {
        runTest("src/testData/box/context/member_injection_object_.kt");
    }

    @Test
    @TestMetadata("member_injection_object_inference.kt")
    public void testMember_injection_object_inference() throws Exception {
        runTest("src/testData/box/context/member_injection_object_inference.kt");
    }

    @Test
    @TestMetadata("multiple_context_providers_are_supported.kt")
    public void testMultiple_context_providers_are_supported() throws Exception {
        runTest("src/testData/box/context/multiple_context_providers_are_supported.kt");
    }

    @Test
    @TestMetadata("object_provider.kt")
    public void testObject_provider() throws Exception {
        runTest("src/testData/box/context/object_provider.kt");
    }

    @Test
    @TestMetadata("provider_supports_multiple_contexts.kt")
    public void testProvider_supports_multiple_contexts() throws Exception {
        runTest("src/testData/box/context/provider_supports_multiple_contexts.kt");
    }

    @Test
    @TestMetadata("user_explicit_local_override.kt")
    public void testUser_explicit_local_override() throws Exception {
        runTest("src/testData/box/context/user_explicit_local_override.kt");
    }

    @Test
    @TestMetadata("value_provider.kt")
    public void testValue_provider() throws Exception {
        runTest("src/testData/box/context/value_provider.kt");
    }
}
