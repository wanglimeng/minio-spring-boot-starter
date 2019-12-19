package com.wanglimeng.minio.service;


import com.wanglimeng.minio.config.MinioConfig;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.messages.Item;
import org.xmlpull.v1.XmlPullParserException;

public class MinioService {

    private MinioConfig minioConfig;

    private MinioClient minioClient;


    public MinioService() {

    }


    public MinioService(MinioConfig minioConfig) {
        this.minioConfig = minioConfig;
        try {
            minioClient = new MinioClient(this.minioConfig.getUrl(), this.minioConfig.getUsername(), this.minioConfig.getPassword());
        } catch (InvalidEndpointException e) {
            e.printStackTrace();
        } catch (InvalidPortException e) {
            e.printStackTrace();
        }

    }


    public Iterable<Result<Item>> list(String bucketName) throws XmlPullParserException {

        return this.minioClient.listObjects(bucketName);
    }



}
