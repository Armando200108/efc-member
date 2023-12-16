package cn.pdteam.efc.member.domain.enums.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

/**
 * 中国少数民族枚举
 */
@Getter
public enum ChineseEthnicityEnum {
    /**
     * 汉族
     */
    HAN("01", "HAN", "汉族"),
    /**
     * 壮族
     */
    ZHUANG("02", "ZHUANG", "壮族"),
    /**
     * 满族
     */
    MAN("03", "MAN", "满族"),
    /**
     * 回族
     */
    HUI("04", "HUI", "回族"),
    /**
     * 苗族
     */
    MIAO("05", "MIAO", "苗族"),
    /**
     * 维吾尔族
     */
    UYGHUR("06", "UYGHUR", "维吾尔族"),
    /**
     * 彝族
     */
    YI("07", "YI", "彝族"),
    /**
     * 土家族
     */
    TUJIA("08", "TUJIA", "土家族"),
    /**
     * 蒙古族
     */
    MONGOL("09", "MONGOL", "蒙古族"),
    /**
     * 藏族
     */
    TIBETAN("10", "TIBETAN", "藏族"),
    /**
     * 布依族
     */
    BUYEI("11", "BUYEI", "布依族"),
    /**
     * 侗族
     */
    DONG("12", "DONG", "侗族"),
    /**
     * 瑶族
     */
    YAO("13", "YAO", "瑶族"),
    /**
     * 朝鲜族
     */
    KOREAN("14", "KOREAN", "朝鲜族"),
    /**
     * 白族
     */
    BAI("15", "BAI", "白族"),
    /**
     * 哈尼族
     */
    HANI("16", "HANI", "哈尼族"),
    /**
     * 黎族
     */
    LI("17", "LI", "黎族"),
    /**
     * 哈萨克族
     */
    KAZAKH("18", "KAZAKH", "哈萨克族"),
    /**
     * 傣族
     */
    DAI("19", "DAI", "傣族"),
    /**
     * 畲族
     */
    SHE("20", "SHE", "畲族"),
    /**
     * 傈僳族
     */
    LISU("21", "LISU", "傈僳族"),
    /**
     * 仡佬族
     */
    GELAO("22", "GELAO", "仡佬族"),
    /**
     * 拉祜族
     */
    LAHU("23", "LAHU", "拉祜族"),
    /**
     * 东乡族
     */
    DONGXIANG("24", "DONGXIANG", "东乡族"),
    /**
     * 佤族
     */
    VA("25", "VA", "佤族"),
    /**
     * 水族
     */
    SUI("26", "SUI", "水族"),
    /**
     * 纳西族
     */
    NAXI("27", "NAXI", "纳西族"),
    /**
     * 羌族
     */
    QIANG("28", "QIANG", "羌族"),
    /**
     * 土族
     */
    TU("29", "TU", "土族"),
    /**
     * 锡伯族
     */
    XIBE("30", "XIBE", "锡伯族"),
    /**
     * 仫佬族
     */
    MULAO("31", "MULAO", "仫佬族"),
    /**
     * 柯尔克孜族
     */
    KIRGIZ("32", "KIRGIZ", "柯尔克孜族"),
    /**
     * 达斡尔族
     */
    DAUR("33", "DAUR", "达斡尔族"),
    /**
     * 景颇族
     */
    JINGPO("34", "JINGPO", "景颇族"),
    /**
     * 撒拉族
     */
    SALAR("35", "SALAR", "撒拉族"),
    /**
     * 布朗族
     */
    BLANG("36", "BLANG", "布朗族"),
    /**
     * 毛南族
     */
    MAONAN("37", "MAONAN", "毛南族"),
    /**
     * 塔吉克族
     */
    TAJIK("38", "TAJIK", "塔吉克族"),
    /**
     * 普米族
     */
    PUMI("39", "PUMI", "普米族"),
    /**
     * 阿昌族
     */
    ACHANG("40", "ACHANG", "阿昌族"),
    /**
     * 怒族
     */
    NU("41", "NU", "怒族"),
    /**
     * 鄂温克族
     */
    EWENKI("42", "EWENKI", "鄂温克族"),
    /**
     * 基诺族
     */
    JINO("43", "JINO", "基诺族"),
    /**
     * 德昂族
     */
    DEANG("44", "DEANG", "德昂族"),
    /**
     * 乌孜别克族
     */
    UZBEK("45", "UZBEK", "乌孜别克族"),
    /**
     * 俄罗斯族
     */
    RUSSIAN("46", "RUSSIAN", "俄罗斯族"),
    /**
     * 裕固族
     */
    YUGUR("47", "YUGUR", "裕固族"),
    /**
     * 保安族
     */
    BONAN("48", "BONAN", "保安族"),
    /**
     * 门巴族
     */
    MONBA("49", "MONBA", "门巴族"),
    /**
     * 鄂伦春族
     */
    OROQEN("50", "OROQEN", "鄂伦春族"),
    /**
     * 独龙族
     */
    DERUNG("51", "DERUNG", "独龙族"),
    /**
     * 塔塔尔族
     */
    TATAR("52", "TATAR", "塔塔尔族"),
    /**
     * 赫哲族
     */
    HEZHEN("53", "HEZHEN", "赫哲族"),
    /**
     * 珞巴族
     */
    LHOBA("54", "LHOBA", "珞巴族"),
    /**
     * 京族
     */
    JING("55", "JING", "京族"),
    /**
     * 其他
     */
    OTHER("56", "OTHER", "其他");

    /**
     * 代码
     */
    @JsonValue
    private final String code;

    /**
     * 名称
     */
    private final String name;

    /**
     * 描述
     */
    private final String description;

    ChineseEthnicityEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据代码获取枚举
     *
     * @param code 代码
     * @return 枚举
     */
    @JsonCreator
    public static ChineseEthnicityEnum getByCode(String code) {
        for (ChineseEthnicityEnum chineseEthnicityEnum : ChineseEthnicityEnum.values()) {
            if (chineseEthnicityEnum.getCode().equals(code)) {
                return chineseEthnicityEnum;
            }
        }
        return null;
    }
}
