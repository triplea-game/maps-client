package org.triplea.http.client.maps.tag.admin;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UpdateMapTagResponse {
  boolean success;

  /** Optional error message from server */
  @Nullable String message;
}
