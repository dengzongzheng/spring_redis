package com.dzz.config;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * Created by dengzongzheng on 16-7-21.
 */
@Configuration
public class SolrClientConfig {


    @Value("${spring.data.solr.host}")
    private String host;

    @Value("${spring.data.solr.zkHost}")
    private String zkHost;



    private CloudSolrServer cloudSolrServer;

    @PreDestroy
    public void close() {
        if (this.cloudSolrServer != null) {
            try {
                this.cloudSolrServer.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Bean
    public CloudSolrServer SolrServer(){
        if (StringUtils.hasText(this.zkHost)) {
            //solrClient = new CloudSolrClient(this.solrConfig.getZkHost());
            cloudSolrServer = new CloudSolrServer(this.zkHost);
            cloudSolrServer.setDefaultCollection("new-house");

        }
        return this.cloudSolrServer;
    }


}
