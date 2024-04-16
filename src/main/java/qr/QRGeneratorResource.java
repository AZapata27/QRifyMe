package qr;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/qr-generator")
public class QRGeneratorResource {

    private final QRGeneratorService qrGeneratorService;

    public QRGeneratorResource(QRGeneratorService qrGeneratorService) {
        this.qrGeneratorService = qrGeneratorService;
    }

    @POST
    public QRResponse generateQRCode(String input) {
        return qrGeneratorService.generateQRCode(input);
    }
}
