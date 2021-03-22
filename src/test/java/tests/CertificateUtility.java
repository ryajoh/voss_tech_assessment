package tests;

import objetcs.CertificateInfo;
import org.testng.annotations.Test;

public class CertificateUtility {

    public CertificateUtility() {

    }

    @Test
    public void getCertificateExpiryDate() throws Exception {
        CertificateInfo cert = new CertificateInfo();

        cert.certInformation("https://ultimateqa.com");
    }
}
