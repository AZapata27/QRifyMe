package qr;

import jakarta.enterprise.context.ApplicationScoped;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import qr.model.QRRequest;
import qr.model.QRResponse;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@ApplicationScoped
public class QRGeneratorService {

    public QRResponse generateQRCode(QRRequest qrRequest) {
        ByteArrayOutputStream stream = QRCode.from(qrRequest.originalUrl()).to(ImageType.PNG).stream();
        byte[] qrCodeBytes = stream.toByteArray();
        String imageBase64 = Base64.getEncoder().encodeToString(qrCodeBytes);

        return new QRResponse(imageBase64);
    }
}
