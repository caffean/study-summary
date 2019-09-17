//package com.example.studydemo.service.impl;
//
//import com.example.studydemo.domain.Commodity;
//import com.example.studydemo.repository.CommodityRepository;
//import com.example.studydemo.service.CommodityService;
//import org.elasticsearch.index.query.MatchQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Classname CommodityServiceImpl
// * @Description TODO
// * @Date 2019/9/11 15:14
// * @Author lyn
// */
//@Service
//public class CommodityServiceImpl implements CommodityService {
//
//    private CommodityRepository commodityRepository;
//
//    public CommodityServiceImpl(CommodityRepository commodityRepository) {
//        this.commodityRepository = commodityRepository;
//    }
//
//
//    @Override
//    public long count() {
//        return commodityRepository.count();
//    }
//
//    @Override
//    public Commodity save(Commodity commodity) {
//        return commodityRepository.save(commodity);
//    }
//
//    @Override
//    public void delete(Commodity commodity) {
//        commodityRepository.delete(commodity);
////        commodityRepository.deleteById(commodity.getSkuId());
//    }
//
//    @Override
//    public Iterable<Commodity> getAll() {
//        return commodityRepository.findAll();
//    }
//
//    @Override
//    public List<Commodity> getByName(String name) {
//        List<Commodity> list = new ArrayList<>();
//        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
//        Iterable<Commodity> iterable = commodityRepository.search(matchQueryBuilder);
//        iterable.forEach(e->list.add(e));
//        return list;
//    }
//
//    @Override
//    public Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw) {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
//                .withPageable(PageRequest.of(pageNo, pageSize))
//                .build();
//        return commodityRepository.search(searchQuery);
//    }
//}
