//package com.example.studydemo;
//
//import com.example.studydemo.domain.Commodity;
//import com.example.studydemo.service.CommodityService;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.query.IndexQuery;
//import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * @Classname ElasticsearchExampleApplicationTests
// * @Description TODO
// * @Date 2019/9/11 15:16
// * @Author lyn
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ElasticsearchExampleApplicationTests {
//
//    @Autowired
//    private CommodityService commodityService;
//
//    @Test
//    public void contextLoads() {
//        System.out.println(commodityService.count());
//    }
//
//    @Test
//    public void testInsert() {
//        Commodity commodity = new Commodity();
//        commodity.setSkuId("1501009001");
//        commodity.setName("原味切片面包（10片装）");
//        commodity.setCategory("101");
//        commodity.setPrice(880);
//        commodity.setBrand("良品铺子");
//        commodityService.save(commodity);
//
//        commodity = new Commodity();
//        commodity.setSkuId("1501009002");
//        commodity.setName("原味切片面包（6片装）");
//        commodity.setCategory("101");
//        commodity.setPrice(680);
//        commodity.setBrand("良品铺子");
//        commodityService.save(commodity);
//
//        commodity = new Commodity();
//        commodity.setSkuId("1501009004");
//        commodity.setName("元气吐司850g");
//        commodity.setCategory("101");
//        commodity.setPrice(120);
//        commodity.setBrand("百草味");
//        commodityService.save(commodity);
//
//    }
//
//    @Test
//    public void testDelete() {
//        Commodity commodity = new Commodity();
//        commodity.setSkuId("1501009002");
//        commodityService.delete(commodity);
//    }
//
//    @Test
//    public void testGetAll() {
//        Iterable<Commodity> iterable = commodityService.getAll();
//        iterable.forEach(e->System.out.println(e.toString()));
//    }
//
//    @Test
//    public void testGetByName() {
//        List<Commodity> list = commodityService.getByName("面包");
//        System.out.println(list);
//    }
//
//    @Test
//    public void testPage() {
//        Page<Commodity> page = commodityService.pageQuery(0, 10, "切片");
//        System.out.println(page.getTotalPages());
//        System.out.println(page.getNumber());
//        System.out.println(page.getContent());
//    }
//
//
//    @Autowired
//    public ElasticsearchTemplate elasticsearchTemplate;
//
//    @Test
//    public void testInsert1() {
//        Commodity commodity = new Commodity();
//        commodity.setSkuId("1501009005");
//        commodity.setName("葡萄吐司面包（10片装）");
//        commodity.setCategory("101");
//        commodity.setPrice(160);
//        commodity.setBrand("良品铺子");
//
//        IndexQuery indexQuery = new IndexQueryBuilder().withObject(commodity).build();
//        elasticsearchTemplate.index(indexQuery);
//    }
//
//    @Test
//    public void testQuery() {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.matchQuery("name", "吐司"))
//                .build();
//        List<Commodity> list = elasticsearchTemplate.queryForList(searchQuery, Commodity.class);
//        System.out.println(list);
//    }
//}
