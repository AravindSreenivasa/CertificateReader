import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;


public class CertificateReader {
	
	public static Certificate GetCertificateObject(String filePath) throws CertificateException, IOException{
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream file = new FileInputStream(filePath);
		java.security.cert.Certificate cert = cf.generateCertificate(file);
		file.close();
		
		return cert;
	}
	
	public static void printCertificate(Certificate cert){
		System.out.println("Certificate Information: ");
	    System.out.println("Certificate Type = "+cert.getType());
	    System.out.println("Cetrificate toString = "+cert.toString());
	        
	}
	
	public static void printPublicKey(PublicKey pubKey){
		RSAPublicKey RSAPubKey = (RSAPublicKey)pubKey;
		System.out.println("\nPublic Key Information: ");
		System.out.println("Public Key = "+RSAPubKey.getModulus());
	    System.out.println("Public Key Algorithm = "+pubKey.getAlgorithm());
	    System.out.println("Public Key Format = "+pubKey.getFormat());
	    //System.out.println("Public Key toString = "+pubKey.toString());
	}
	
	public static void ReadAndPrintCertificate(String filePath){
		try {
			Certificate cert = GetCertificateObject(filePath);
			printCertificate(cert);
			PublicKey pubKey = getPublicKey(cert);
			printPublicKey(pubKey);
		} catch (CertificateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static PublicKey getPublicKey(Certificate cert){
		return cert.getPublicKey();
	}

}
