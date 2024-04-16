package url;

import jakarta.enterprise.context.ApplicationScoped;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@ApplicationScoped
public class ShortenerService {

    public UrlResponse shortenUrl(UrlRequest urlRequest) {

        String longUrl = urlRequest.orignalUrl();
        String shortenedUrl = generateShortUrl(longUrl);
        return new UrlResponse(shortenedUrl);
    }

    // Generate an MD5 hash from the long URL and return the first 8 characters
    private String generateShortUrl(String longUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(longUrl.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                String hex = Integer.toHexString(0xff & hashBytes[i]);
                if (hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // In case of error, we simply return the original URL
            return longUrl;
        }
    }
}
