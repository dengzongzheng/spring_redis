package com.dzz.resource;

import com.dzz.domain.Book;
import com.dzz.service.HelloWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dengzongzheng on 16-7-20.
 */

@Controller
@RequestMapping(value = "")
@Api(value = "/",description = "helloWord接口说明",position = 1)
public class HelloWordResource {

    @Autowired
    private HelloWordService helloWordService;

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    @ApiOperation(value = "/sayHello",notes = "测试处理",response = String.class)
    @ResponseBody
    public String sayHello(@ApiParam(value = "姓名",required = true,name = "name") @RequestParam(name = "name") String name,
                           @ApiParam(value = "密码",required = true,name = "passWord") @RequestParam(name = "passWord") String passWord){
        return helloWordService.getUser(name,passWord).toString();
    }

    @RequestMapping(value = "/getBooks",method = RequestMethod.GET)
    @ApiOperation(value = "/getBooks",notes = "获取books数据",response = String.class)
    @ResponseBody
    public List<Book> getBooks(){

        List<Book> books = helloWordService.getBooks();
        return books;
    }

}
