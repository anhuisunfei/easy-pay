package com.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.module.sys.es.pojo.Post;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/11 14:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EsTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testInsert() throws IOException {
        Post post = new Post();
        post.setMessage("post");
        post.setPostDate(new Date());
        post.setUser("sf");
        IndexRequest indexRequest = new IndexRequest("posts", "doc", post.getUser())
                .source(objectMapper.convertValue(post, Post.class));

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("118.89.161.66", 9200, "http")).build());

        IndexResponse indexResponse = client.index(indexRequest);
        System.out.println(indexResponse.toString());
    }

    @Test
    public void testCreate() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("118.89.161.66", 9200, "http")).build());
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("user", "kimchy");
            builder.field("postDate", new Date());
            builder.field("message", "trying out Elasticsearch");
        }
        builder.endObject();
        System.out.println(builder.toString());
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("myPost","doc","1");

        IndexRequest indexRequest = new IndexRequest("posts", "doc", "1")
                .source("user", "kimchy",
                        "postDate", new Date(),
                        "message", "trying out Elasticsearch");
//        createIndexRequest.source(builder);
//        createIndexRequest.mapping(
//                "{\n" +
//                        "  \"mappings\": {\n" +
//                        "    \"my_type\": {\n" +
//                        "      \"properties\": {\n" +
//                        "        \"title\": {\n" +
//                        "          \"type\":  \"string\"\n" +
//                        "        }\n" +
//                        "      }\n" +
//                        "    }\n" +
//                        "  }\n" +
//                        "}",
//                XContentType.JSON);
        IndexResponse response = client.index(indexRequest);
        System.out.println(response.toString());
    }
}
