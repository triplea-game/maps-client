package org.triplea.http.client.maps.tag.admin;

import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMapTagResponse {
  boolean success;

  /** Optional error message from server */
  @Nullable String message;
}
