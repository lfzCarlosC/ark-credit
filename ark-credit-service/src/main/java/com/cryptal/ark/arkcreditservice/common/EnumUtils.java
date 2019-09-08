package com.cryptal.ark.arkcreditservice.common;

public class EnumUtils {

    /**
     * 返回指定编码的'枚举'
     * @param code
     * @return SharedObjTypeEnum
     * @throws
     */
    public static <T extends CommonEnum> T getEnumBycode(Class<T> clazz, int code) {
        for(T enumInstance : clazz.getEnumConstants()){
            if(code == enumInstance.getCode()){
                return enumInstance;
            }
        }
        return null;
    }

    /**
     * 返回指定名称的'枚举'
     * @param name
     * @return SharedObjTypeEnum
     * @throws
     */
    public static <T extends CommonEnum> T getEnumByName(Class<T> clazz, String name) {
        for(T enumInstance : clazz.getEnumConstants()) {
            if (enumInstance.getName().equalsIgnoreCase(name)) {
                return enumInstance;
            }
        }
        return null;
    }

    /**
     * 返回指定描述的'枚举'
     * @param desc
     * @return SharedObjTypeEnum
     * @throws
     */
    public static <T extends CommonEnum> T getEnumByDesc(Class<T> clazz, String desc) {
        for(T enumInstance : clazz.getEnumConstants()) {
            if (enumInstance.getDesc().equalsIgnoreCase(desc)) {
                return enumInstance;
            }
        }
        return null;
    }

}
