/**
 * Created by Yiyuery on 2017/10/17.
 */

define(['jquery'],function($){

    /**
     * 初始化数据
     */
    function init(){
        privUtils[ENUMS.SHUNFENG].queryData();
    }

    /**
     * 枚举
     * @type {{SHUNFENG: string}}
     */
    var ENUMS={
        SHUNFENG:'SHUNFENG'
    }

    var privUtils={
        SHUNFENG:{
            queryData:function(){
                $.post(window.main.contextPath+"/data/police/queryData",{},function(){
                });
            }
        }
    }

    init();
});