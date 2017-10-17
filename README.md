# ENV
    1、jdk1.7+
    2、tomcat7.0+
    3、maven3.0+
    4、mysql5.71+
    5、jfianl3.2+

# 数据交互模板

1、配置sql语句

    > resources/mappers/police/police.sql
```$xslt
#sql("queryData")
SELECT * FROM T_SHUNFENG
#end
```    

2、语句执行
```$xslt
cn.com.showclear.police.dao.police.ShunFengMapperImpl
...

    /**
     * 查询模版 [测试]
     * @return
     */
    @Override
    public List<Record> queryData() {
        String sql = Db.use(AppConstants.DB_KEY_POLICE).getSql("queryData");
        return Db.use(AppConstants.DB_KEY_POLICE).find(sql);
    }    
...
```

3、数据解析

```$xslt
record 数据对象 [Record] -> 可看作一行数据
column 表字段名 [String]

.getStr(column) [获取字符串]
.getInt(column) [获取int数据]

```

4、触发方法 MVC
> index.js
```$xslt
queryData:function(){
    $.post(window.main.contextPath+"/data/police/queryData",{},function(){
    });
}

接口地址 [/data/police/queryData] -> cn.com.showclear.police.controller.data.DataController
```
> DataController
```$xslt
/**
 * 通用数据接口
 * Created by Yiyuery on 2017/10/17.
 */
public class DataController extends Controller{

    /**
     * 数据查询测试模版
     */
    public void queryData(){
        AppManagers.getPoliceManager().queryDispatcher(DataTypes.DATA_TYPE_SHUNFENG.getValue());
        renderJson(0);
    }
}

1、queryData 与接口最后一个斜杠后字符保持一致 [ 路由映射 ]
2、queryData() 方法中自定义实现方式
```

5、接口管理类(辅助代码管理：仅关注数据查询可跳过)
> AppManagers 
    模块、库、业务转发
> MapperManager
    数据库查询针对表进行sql查询接口管理
