package cn.itcast.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestIndexManager {
    @Test
    public void testIndexCreateAndUpdate() throws Exception {
        /**
         * 创建和solr服务器连接
         * http://192.168.200.128:8080/solr是连接的默认实例也就是collection1实例
         * http://192.168.200.128:8080/solr/collection2实例
         */
        SolrServer solrServer = new HttpSolrServer("http://192.168.200.128:8080/solr");

        //创建文档对象
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "004");
        doc.addField("title", "大话西游");
        doc.addField("price", "50");
        //添加或者修改
        solrServer.add(doc);
        //提交
        solrServer.commit();
    }

    @Test
    public void testIndexDelete() throws Exception {
        /**
         * 创建和solr服务器连接
         * http://192.168.200.128:8080/solr是连接的默认实例也就是collection1实例
         * http://192.168.200.128:8080/solr/collection2实例
         */
        SolrServer solrServer = new HttpSolrServer("http://192.168.200.128:8080/solr");

        //单个删除
        //solrServer.deleteById("001");

        //删除所有
        solrServer.deleteByQuery("*:*");

        //提交
        solrServer.commit();
    }
}
