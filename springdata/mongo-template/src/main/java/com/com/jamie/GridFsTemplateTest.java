package com.com.jamie;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Zjm
 * @Date: 2021/6/30 10:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GridFsTemplateTest {
    @Resource
    private GridFsTemplate gridFsTemplate;


    public void download(String id) throws IOException {
        Query query = Query.query(Criteria.where("_id").is(id));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);

        GridFsResource resource =  gridFsTemplate.getResource(gridFSFile);
        String filename = resource.getFilename();
        String ext = filename.substring(filename.lastIndexOf("."));
        InputStream in = resource.getInputStream();

        FileOutputStream out = new FileOutputStream("D:/laws/"+id+ext);
        byte[] b = new byte[1024];
        while (true) {
            int len = in.read(b);
            if (len != -1) {
                out.write(b, 0, len);
            } else {
                break;
            }
        }
    }

    @Test
    public void downloadFiles() throws IOException {
//        download("605aea3ec8c76d4d318d9d0b");
        download("605aea72c4bf9cb3841dae0a");
        download("605aed1dd5dc8c42b0261eca");
        download("605aed1ed5dc8c42b0261ece");
        download("605aeee9290b5dd12a6b9be7");
        download("605aeeea290b5dd12a6b9bed");
        download("605aeeeb290b5dd12a6b9bf1");
        download("605aeeec290b5dd12a6b9bf5");
        download("605aeeee290b5dd12a6b9bf9");
        download("605aeeef290b5dd12a6b9bfd");
        download("605aeef0290b5dd12a6b9c01");
        download("605aeef2290b5dd12a6b9c05");
        download("605aeef3290b5dd12a6b9c09");
        download("605aeef4290b5dd12a6b9c0d");
    }

}
