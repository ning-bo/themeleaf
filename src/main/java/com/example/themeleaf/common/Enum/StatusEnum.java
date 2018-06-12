package com.example.themeleaf.common.Enum;

/**
 * Created by NingBo
 * Date 2018/5/2913:37
 *
 * @desc 文章状态的枚举
 */
public enum StatusEnum {

    UNPUBLISH(1,"未发布"),
    PUBLISH(2,"已发布"),
    HIDE(3,"隐藏"),
    DELETE(4,"删除");

    private Integer key;

    private String value;

    StatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    // 通过key 获取value
    public static String getName(Integer key) {
        if( null == key ){
            return  null;
        }
        for (StatusEnum c : StatusEnum.values()) {
            if (c.key.equals(key)) {
                return c.getValue();
            }
        }
        return null;
    }

    public static StatusEnum from(Integer key) {

        StatusEnum[] values = StatusEnum.values();

        for (StatusEnum statusEnum: values) {

            if(statusEnum.getKey().equals(key)) {
                return statusEnum;
            }
        }

        return null;
    }
}
