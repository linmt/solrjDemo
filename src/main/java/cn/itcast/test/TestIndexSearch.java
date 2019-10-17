package cn.itcast.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class TestIndexSearch {
    @Test
    public void testIndexSearch() throws Exception {
        /**
         * 创建和solr服务器连接
         * http://192.168.200.128:8080/solr是连接的默认实例也就是collection1实例
         * http://192.168.200.128:8080/solr/collection2实例
         */
        SolrServer solrServer = new HttpSolrServer("http://192.168.200.128:8080/solr");

        //创建查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery("*:*");
        //查询并返回响应
        QueryResponse queryResponse = solrServer.query(query);

        //从响应中获取结果集
        SolrDocumentList results = queryResponse.getResults();
        System.out.println("====count======" + results.getNumFound());
        for (SolrDocument result : results) {
            System.out.println("===id====" + result.get("id"));
            System.out.println("====title===" + result.get("title"));
        }
    }
}
