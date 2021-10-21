package com.jamie;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticTest {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void createDoc() throws IOException {
        IndexRequest request = new IndexRequest("my_index", "_doc").source("{\"name\":1,\"age\":2}", XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println( "created".equals(response.getResult().getLowercase()));
    }

    @Test
    public void list() throws IOException {
        SearchSourceBuilder builder = new SearchSourceBuilder();
        SearchRequest request = new SearchRequest();
        request.indices("my_index").types("_doc").source(builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        List<String> collect = Arrays.stream(response.getHits().getHits()).map(SearchHit::getSourceAsString).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest().indices("my_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }
}
