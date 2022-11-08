package org.triplea.http.client.maps.listing;

import feign.Feign;
import feign.FeignException;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import java.net.URI;
import java.util.List;
import feign.gson.GsonEncoder;
/**
 * Http client to communicate with the maps server and get a listing of maps available for download.
 */
public interface MapsClient {
  String MAPS_LISTING_PATH = "/maps/listing";

  static MapsClient newClient(URI mapsServerUri) {
    return Feign.builder()
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .requestInterceptor(
            requestTemplate -> {
              requestTemplate.header("Content-Type", "application/json");
              requestTemplate.header("Accept", "application/json");
            })
        .target(MapsClient.class, mapsServerUri.toString());
  }

  /**
   * Fetches a list of available maps from the server.
   *
   * @throws FeignException Thrown on non-2xx responses.
   */
  @RequestLine("GET " + MapsClient.MAPS_LISTING_PATH)
  List<MapDownloadItem> fetchMapListing();
}
