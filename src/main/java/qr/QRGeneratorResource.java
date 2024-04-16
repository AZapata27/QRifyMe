package qr;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import qr.model.QRRequest;
import qr.model.QRResponse;

@Path("/qr-generator")
public class QRGeneratorResource {

    private final QRGeneratorService qrGeneratorService;

    public QRGeneratorResource(QRGeneratorService qrGeneratorService) {
        this.qrGeneratorService = qrGeneratorService;
    }

    @POST
    public QRResponse generateQRCode(QRRequest qrRequest) {
        return qrGeneratorService.generateQRCode(qrRequest);
    }
}
