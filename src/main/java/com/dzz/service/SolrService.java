package com.dzz.service;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dengzongzheng on 16-7-21.
 */
@Service
public class SolrService {

    @Autowired
    private CloudSolrServer cloudSolrServer;

    public String getHouse(){

        ModifiableSolrParams params =new ModifiableSolrParams();
//        params.add("q","*:*");
        QueryResponse response=null;

        try{
            response=cloudSolrServer.query(params);
            SolrDocumentList results = response.getResults();
            for (SolrDocument document:results) {
                System.out.println( document.getFieldValue("demo"));
                System.out.println(document.getFieldValue("id"));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        System.out.println(response.toString());
        return "OK";
    }

}
