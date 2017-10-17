package cn.com.showclear.common;

/**
 * Created by Yiyuery on 2017/10/16.
 */
public enum DataTypes {
    /**
     * 测试数据
     * 1、西安到深圳
     * 2、大于1公斤
     * 3、根据号码或手机号统计每一年的数据
     * 4、图表展示
     */
    DATA_TYPE_SHUNFENG("SHUNFENG",1);

    private String key;
    private int value;

    private DataTypes(String key,int value) {
        this.key = key;
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
