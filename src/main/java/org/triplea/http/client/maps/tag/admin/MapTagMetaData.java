package org.triplea.http.client.maps.tag.admin;

import java.util.List;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data about a map tag useful for moderator toolbox. Data drives the ability for moderators to be
 * able to change map tag information.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapTagMetaData {
  @Nonnull String tagName;
  @Nonnull Integer displayOrder;
  @Nonnull List<String> allowedValues;
}
