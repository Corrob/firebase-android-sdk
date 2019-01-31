package com.google.firebase.functions;

import static com.google.common.truth.Truth.assertThat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.platforminfo.UserAgentPublisher;
import org.junit.Test;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@org.junit.runner.RunWith(RobolectricTestRunner.class)
public class FunctionsRegistrarTest {
  @Test
  public void storageRegistrar_getComponents_publishesLibVersionComponent() {
    FirebaseApp app =
        FirebaseApp.initializeApp(
            RuntimeEnvironment.application.getApplicationContext(),
            new FirebaseOptions.Builder()
                .setApplicationId("1:196403931065:android:60949756fbe381ea")
                .build());
    TestUserAgentDependentComponent userAgentDependant =
        app.get(TestUserAgentDependentComponent.class);

    UserAgentPublisher userAgentPublisher = userAgentDependant.getUserAgentPublisher();
    String actualUserAgent = userAgentPublisher.getUserAgent();

    assertThat(actualUserAgent).contains("firebase-functions");
  }
}
