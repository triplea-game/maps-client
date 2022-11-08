package org.triplea.http.client.maps.tag.admin;

import feign.Feign;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import java.net.URI;
import java.util.List;

/** Http client for 'map tag' administrative functionality. EG: updating a maps tag value. */
public interface MapTagAdminClient {
  String GET_MAP_TAGS_META_DATA_PATH = "/maps/list-tags";
  String UPDATE_MAP_TAG_PATH = "/maps/update-tag";

  static MapTagAdminClient newClient(final URI mapsServerUri, final String apiKey) {
    return Feign.builder()
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .requestInterceptor(
            requestTemplate -> {
              requestTemplate.header("Authorization", "Bearer " + apiKey);
              requestTemplate.header("Content-Type", "application/json");
              requestTemplate.header("Accept", "application/json");
            })
        .target(MapTagAdminClient.class, mapsServerUri.toString());
  }

  @RequestLine("GET " + MapTagAdminClient.GET_MAP_TAGS_META_DATA_PATH)
  List<MapTagMetaData> fetchAllowedMapTagValues();

  @RequestLine("POST " + MapTagAdminClient.UPDATE_MAP_TAG_PATH)
  UpdateMapTagResponse updateMapTag(UpdateMapTagRequest updateMapTagRequest);
}
