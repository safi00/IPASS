package nl.hu.bep.taxiboeking.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.bep.taxiboeking.domain.TaxiCompany;

import java.io.*;

public class PersistenceManager {
    private final static String ENDPOINT  = "https://bepcountrysafi.blob.core.windows.net/";
    private final static String SASTOKEN  = "?sv=2019-10-10&ss=bfqt&srt=co&sp=rwdlacupx&se=2021-07-17T11:44:42Z&st=2020-07-17T03:44:42Z&spr=https&sig=IuMetyXzPVdiHvq2C%2BKDaCYmsLW5UB7rgnyLih9fBw8%3D";
    private final static String CONTAINER = "worldcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void saveDataToAzure() throws IOException {
        if (blobContainer.exists()){
            blobContainer.create();
        }

        BlobClient blob = blobContainer.getBlobClient("company_blob");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(TaxiCompany.getTaxiCompany());

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        oos.close();
        bais.close();
    }

    public static void loadDataFromAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()){
            BlobClient blob = blobContainer.getBlobClient("company_blob");

            if (blob.exists()){

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                byte[] bytez = baos.toByteArray();

                ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
                ObjectInputStream ois = new ObjectInputStream(bais);
                Object obj = ois.readObject();

                if (obj instanceof TaxiCompany){
                    TaxiCompany loadedCompany = (TaxiCompany)obj;
                    TaxiCompany.setTaxiCompany(loadedCompany);
                }

                ois.close();
                baos.close();
            }
        }
    }
}
