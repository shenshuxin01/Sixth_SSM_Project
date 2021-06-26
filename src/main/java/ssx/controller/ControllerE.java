package ssx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssx.entity.DBScheamE;
import ssx.service.ServiceE;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ControllerE {

    @Resource(name = "serviceE")
    ServiceE serviceE;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "s/addd.do",method = RequestMethod.POST)
    @ResponseBody
    public Map add(@RequestBody DBScheamE requestdb){
        return serviceE.add(requestdb);
    }

    @RequestMapping(value = "s/quee.do",method = RequestMethod.POST)
    @ResponseBody
    public Map que(HttpSession session){
        return serviceE.que(session,servletContext);
    }

}
