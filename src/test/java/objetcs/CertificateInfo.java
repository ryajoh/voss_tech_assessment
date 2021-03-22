package objetcs;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;


public class CertificateInfo {

    public CertificateInfo() {
    }

    public void certInformation(String aURL) throws Exception{
        URL destinationURL = new URL(aURL);
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();
        for (Certificate cert : certs) {
            if(cert instanceof X509Certificate) {
                X509Certificate x = (X509Certificate ) cert;
                System.out.println("Certificate Valid until: " + x.getNotAfter());
                break;
            }
        }
    }
}
