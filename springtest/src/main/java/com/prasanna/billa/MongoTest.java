package com.prasanna.billa;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import static com.mongodb.MongoClientOptions.builder;
import static javax.net.ssl.SSLSocketFactory.getDefault;

import com.mongodb.client.MongoDatabase;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MongoTest {
    private static final MongoClientOptions.Builder options = builder().socketFactory(getDefault());
    public static void main(String[] args) {
       /* MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin123@192.168.10.151:27017/admin?ssl=true");
        MongoClient client = new MongoClient(uri);
        MongoDatabase  database = client.getDatabase("mule");
        System.out.println(database.getName());*/
        //getDBConnection();
        //sslEncrypt();


    }

    public static void getDBConnection(){
        List<ServerAddress> seeds = new ArrayList<ServerAddress>();
        seeds.add( new ServerAddress( "localhost" ));
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(
                        "admin",
                        "admin",
                        "admin123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        MongoClient mongo = new MongoClient( seeds, mongoCredential, options);
        System.out.println(mongo.getDatabase("mule").listCollections());
    }

    public static void sslEncrypt(){
        MongoCredential credential =  MongoCredential.createMongoCRCredential(
                "admin",
                "admin",
                "admin123".toCharArray()
        );
        MongoClient mongoClient = new MongoClient(
                new ServerAddress("localhost"),
                credential,
                MongoClientOptions.builder().
                sslEnabled(true)
                .build());
        mongoClient.getDatabase("mule").getName();
        System.out.println("executed");
    }

    private static SSLSocketFactory getNoopSslSocketFactory() {
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("SSL");

            // set up a TrustManager that trusts everything
            sslContext.init(null, new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException { }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException { }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            System.out.println("Couldn't create SSL Context for MongoDB connection "+ e.getCause());
            throw new RuntimeException(e);
        }
        return sslContext.getSocketFactory();
    }
}
