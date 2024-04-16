package urlshortener;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/shortener")
public class ShortenerResource {

    private final ShortenerService shortenerService;

    public ShortenerResource(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @POST
    public UrlResponse shorten(UrlRequest urlRequest) {

        return shortenerService.shortenUrl(urlRequest);
    }

}
