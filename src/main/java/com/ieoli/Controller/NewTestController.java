package com.ieoli.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewTestController {
    @RequestMapping(value= "/testing")
    void handleRequestInternal(HttpServletRequest request,
                               HttpServletResponse response, HttpSession session) throws Exception {
        String a ="This is a String";
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        Map<String,Integer> siMap = new HashMap<>();
        siMap.put("first",1);
        siMap.put("second",2);
        siMap.put("third",3);
        Map<String,Object> returnList = new HashMap<>();
        returnList.put("a",a);
        returnList.put("list1",list1);
        returnList.put("siMap",siMap);
       // response.getWriter().write(JSON.toJSONString(returnList));
        JSONObject jobj = new JSONObject();
        jobj.put("siMap",siMap);
        jobj.put("a",a);
        jobj.put("list1",list1);
        response.getWriter().write(jobj.toJSONString());
    }
}
