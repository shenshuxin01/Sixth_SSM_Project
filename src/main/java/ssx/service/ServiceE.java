package ssx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ssx.dao.IDaoE;
import ssx.entity.DBScheamE;
import ssx.util.UtilRedisE;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceE {

    @Autowired
    @Qualifier("iDaoE")
    IDaoE iDaoE;

    public Map add(DBScheamE scheamE){
        boolean b = iDaoE.addOne(scheamE);
        HashMap map = new HashMap();
        map.put("isok","ok");
        return map;
    }

    public Map que(HttpSession session,ServletContext servletContext){

        HashMap map = new HashMap();


        String id = session.getId();
        String s = UtilRedisE.saddSet(id);
        String contextSt = servletContext.toString();


        if ("N".equals(s)){
            map.put("se",id);
            map.put("co",contextSt);
            return map;
        }



        List<DBScheamE> dbScheamES = iDaoE.queryAll();
        String reS="";
        for (int i = 0; i < dbScheamES.size(); i++) {
            reS= reS+" \n "+dbScheamES.get(i).toString();
        }

        map.put("alls",reS);
        map.put("se",id);
        map.put("co",contextSt);


        //获取当前session所有属性
        Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }


        return map;
    }
}
