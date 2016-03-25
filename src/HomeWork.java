import java.security.Key;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;


public class HomeWork {

	public static void main(String[] args) {
		CertificateReader.ReadAndPrintCertificate("Certificates/Trustcenter.cer");
	}

}
