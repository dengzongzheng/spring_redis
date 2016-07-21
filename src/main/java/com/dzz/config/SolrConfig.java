package com.dzz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dengzongzheng on 16-7-21.
 */
@Configuration
//@ConfigurationProperties(prefix = "spring.data.solr")
public class SolrConfig {

    private String host;

    private String zkHost;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getZkHost() {
        return zkHost;
    }

    public void setZkHost(String zkHost) {
        this.zkHost = zkHost;
    }
}
