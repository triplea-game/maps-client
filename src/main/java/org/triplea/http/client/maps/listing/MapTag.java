package org.triplea.http.client.maps.listing;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 'Map Tag' data as attached to a specific map. A map will contain a set of 'MapTag' data items.
 * This data represents the current value of a specific tag and the necessary information to display
 * a tags value to user.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapTag {
  /** The human readable name of the tag */
  String name;

  /** The actual value of the tag */
  String value;

  /**
   * The ordering to display this map tag in relative to other map tags. Lower values should be
   * displayed first. displayOrder is greater than zero.
   */
  int displayOrder;

  public String getValue() {
    return Optional.ofNullable(value).orElse("");
  }
}
