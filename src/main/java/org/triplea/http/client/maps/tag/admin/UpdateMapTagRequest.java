package org.triplea.http.client.maps.tag.admin;

import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class UpdateMapTagRequest {
  private String mapName;
  private String tagName;
  private String newTagValue;


  boolean success;

  /**
   * May be null, any message the server wishes to return, eg: if success then this value could be
   * null or a confirmation message, otherwise if not success, then the value should be an error
   * message back to the user.
   */
  @Nullable
  String message;
}
