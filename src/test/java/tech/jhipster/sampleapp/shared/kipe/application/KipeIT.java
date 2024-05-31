package tech.jhipster.sampleapp.shared.kipe.application;

import static org.assertj.core.api.Assertions.*;

import tech.jhipster.sampleapp.IntegrationTest;
import tech.jhipster.sampleapp.shared.kipe.domain.KipeDummy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

@IntegrationTest
class KipeIT {

  @Autowired
  private KipeApplicationService service;

  @Test
  void shouldNotBeAbleToMakeUpdateWithoutAuthentication() {
    assertThatThrownBy(() -> service.update(new KipeDummy("value"))).isExactlyInstanceOf(AuthorizationDeniedException.class);
  }

  @Test
  @WithMockUser
  void shouldNotBeAbleToMakeUnauthorizedUpdate() {
    assertThatThrownBy(() -> service.update(new KipeDummy("unauthorized"))).isExactlyInstanceOf(AuthorizationDeniedException.class);
  }

  @Test
  @WithMockUser
  void shouldBeAbleToMakeAuthorizedUpdate() {
    assertThatCode(() -> service.update(new KipeDummy("authorized"))).doesNotThrowAnyException();
  }
}
