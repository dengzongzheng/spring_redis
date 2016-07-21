package com.dzz.resource;

import com.dzz.service.SolrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dengzongzheng on 16-7-21.
 */
@Controller
@RequestMapping(value="/solr")
@Api(description = "solr服务接口",value = "/solr")
public class SolrResource {

    @Autowired
    private SolrService solrService;

    @RequestMapping(value = "/getHouse",method = RequestMethod.GET)
    @ApiOperation(value =  "/getHouse",httpMethod = "GET")
    @ResponseBody
    public String getHouse(){

        solrService.getHouse();
        return "OK";
    }

}
