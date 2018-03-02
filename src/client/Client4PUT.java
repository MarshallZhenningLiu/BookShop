package client;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class Client4PUT {

  public static void main(String[] args) {
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());

    System.out.println(service.path("rest").path("books")
        .accept(MediaType.APPLICATION_XML).get(String.class));

    // PUT
    Form form = new Form();
    form.add("name", "Lucky Book");
    form.add("author", "Lucky");
    form.add("year", "2026");
    service.path("rest").path("books").path("26")
        .type(MediaType.APPLICATION_FORM_URLENCODED)
        .put(ClientResponse.class, form);

    System.out.println(service.path("rest").path("books")
        .accept(MediaType.APPLICATION_XML).get(String.class));
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/r6booksCrud")
        .build();
  }
}
