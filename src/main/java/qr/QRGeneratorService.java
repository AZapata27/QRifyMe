package qr;

import jakarta.enterprise.context.ApplicationScoped;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@ApplicationScoped
public class QRGeneratorService {

    public QRResponse generateQRCode(String url) {
        ByteArrayOutputStream stream = QRCode.from(url).to(ImageType.PNG).stream();
        byte[] qrCodeBytes = stream.toByteArray();
        String imageBase64 = Base64.getEncoder().encodeToString(qrCodeBytes);

        return new QRResponse(imageBase64);
    }
}
