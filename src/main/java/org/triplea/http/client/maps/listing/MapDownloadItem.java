package org.triplea.http.client.maps.listing;

import java.util.List;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a map that can be downloaded. This data object contains information on how to render a
 * preview and description of the map, as well as the needed URLs to download the map itself.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapDownloadItem {
  /** URL where the map can be downloaded. */
  @Nonnull private String downloadUrl;
  /** URL of the preview image of the map. */
  @Nonnull private String previewImageUrl;

  @Nonnull private String mapName;
  @Nonnull private Long lastCommitDateEpochMilli;
  /** HTML description of the map. */
  @Nonnull private String description;

  /** Additional meta data about the map, eg: categories, rating, etc... */
  private List<MapTag> mapTags;

  @Nonnull private Long downloadSizeInBytes;

  /**
   * Finds a tag by name and returns its corresponding value. If the tag is not found or has a null
   * value, an empty string is returned instead.
   */
  @Nonnull
  public String getTagValue(final String tagName) {
    return mapTags.stream()
        .filter(tag -> tag.getName().equalsIgnoreCase(tagName))
        .findAny()
        .map(MapTag::getValue)
        .orElse("");
  }
}
