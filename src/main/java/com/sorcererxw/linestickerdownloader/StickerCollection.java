package com.sorcererxw.linestickerdownloader;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2017/2/1
 * Description:
 */
public class StickerCollection {

    /**
     * packageId : 7776
     * onSale : true
     * validDays : 0
     * title : {"en":"Brown & Cony's Heaps of Hearts!","es":"Brown y Cony, con todo corazón","in":"Brown & Cony Mesra Penuh Cinta","ja":"スキスキブラコニ☆ハートがいっぱい","ko":"브라운 & 코니 하트 팡팡 스티커","th":"บราวน์&โคนี่☆หัวใจเลิฟๆ","zh_CN":"布朗熊&可妮兔☆ 爱心满满♪","zh_TW":"熊大＆兔兔（最喜歡你了☆滿滿愛心篇）"}
     * author : {"en":"LINE","ja":"LINE","ko":"LINE","zh_CN":"LINE","zh_TW":"LINE"}
     * price : [{"country":"@@","currency":"NLC","symbol":"NLC","price":0},{"country":"ID","currency":"IDR","symbol":"Rp","price":0},{"country":"JP","currency":"JPY","symbol":"￥","price":0},{"country":"TH","currency":"THB","symbol":"THB","price":0},{"country":"TW","currency":"TWD","symbol":"NT$","price":0},{"country":"US","currency":"USD","symbol":"$","price":0}]
     * stickers : [{"id":14585982,"width":203,"height":225},{"id":14585983,"width":278,"height":225},{"id":14585984,"width":263,"height":225},{"id":14585985,"width":248,"height":225},{"id":14585986,"width":240,"height":225},{"id":14585987,"width":233,"height":225},{"id":14585988,"width":233,"height":225},{"id":14585989,"width":255,"height":225},{"id":14585990,"width":278,"height":225},{"id":14585991,"width":233,"height":225},{"id":14585992,"width":233,"height":225},{"id":14585993,"width":278,"height":225},{"id":14585994,"width":240,"height":225},{"id":14585995,"width":218,"height":225},{"id":14585996,"width":278,"height":203},{"id":14585997,"width":243,"height":225},{"id":14585998,"width":263,"height":225},{"id":14585999,"width":278,"height":225},{"id":14586000,"width":248,"height":225},{"id":14586001,"width":278,"height":225},{"id":14586002,"width":233,"height":225},{"id":14586003,"width":246,"height":225},{"id":14586004,"width":270,"height":225},{"id":14586005,"width":278,"height":225}]
     * hasAnimation : true
     * hasSound : false
     * stickerResourceType : ANIMATION
     */

    private int packageId;
    private boolean onSale;
    private int validDays;
    private TitleBean title;
    private AuthorBean author;
    private boolean hasAnimation;
    private boolean hasSound;
    private String stickerResourceType;
    private List<StickersBean> stickers;

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getValidDays() {
        return validDays;
    }

    public void setValidDays(int validDays) {
        this.validDays = validDays;
    }

    public TitleBean getTitle() {
        return title;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public boolean isHasAnimation() {
        return hasAnimation;
    }

    public void setHasAnimation(boolean hasAnimation) {
        this.hasAnimation = hasAnimation;
    }

    public boolean isHasSound() {
        return hasSound;
    }

    public void setHasSound(boolean hasSound) {
        this.hasSound = hasSound;
    }

    public String getStickerResourceType() {
        return stickerResourceType;
    }

    public void setStickerResourceType(String stickerResourceType) {
        this.stickerResourceType = stickerResourceType;
    }

    public List<StickersBean> getStickers() {
        return stickers;
    }

    public void setStickers(List<StickersBean> stickers) {
        this.stickers = stickers;
    }

    public static class TitleBean {
        /**
         * en : Brown & Cony's Heaps of Hearts!
         * es : Brown y Cony, con todo corazón
         * in : Brown & Cony Mesra Penuh Cinta
         * ja : スキスキブラコニ☆ハートがいっぱい
         * ko : 브라운 & 코니 하트 팡팡 스티커
         * th : บราวน์&โคนี่☆หัวใจเลิฟๆ
         * zh_CN : 布朗熊&可妮兔☆ 爱心满满♪
         * zh_TW : 熊大＆兔兔（最喜歡你了☆滿滿愛心篇）
         */

        private String en;
        private String es;
        private String in;
        private String ja;
        private String ko;
        private String th;
        private String zh_CN;
        private String zh_TW;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getEs() {
            return es;
        }

        public void setEs(String es) {
            this.es = es;
        }

        public String getIn() {
            return in;
        }

        public void setIn(String in) {
            this.in = in;
        }

        public String getJa() {
            return ja;
        }

        public void setJa(String ja) {
            this.ja = ja;
        }

        public String getKo() {
            return ko;
        }

        public void setKo(String ko) {
            this.ko = ko;
        }

        public String getTh() {
            return th;
        }

        public void setTh(String th) {
            this.th = th;
        }

        public String getZh_CN() {
            return zh_CN;
        }

        public void setZh_CN(String zh_CN) {
            this.zh_CN = zh_CN;
        }

        public String getZh_TW() {
            return zh_TW;
        }

        public void setZh_TW(String zh_TW) {
            this.zh_TW = zh_TW;
        }
    }

    public static class AuthorBean {
        /**
         * en : LINE
         * ja : LINE
         * ko : LINE
         * zh_CN : LINE
         * zh_TW : LINE
         */

        private String en;
        private String ja;
        private String ko;
        private String zh_CN;
        private String zh_TW;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getJa() {
            return ja;
        }

        public void setJa(String ja) {
            this.ja = ja;
        }

        public String getKo() {
            return ko;
        }

        public void setKo(String ko) {
            this.ko = ko;
        }

        public String getZh_CN() {
            return zh_CN;
        }

        public void setZh_CN(String zh_CN) {
            this.zh_CN = zh_CN;
        }

        public String getZh_TW() {
            return zh_TW;
        }

        public void setZh_TW(String zh_TW) {
            this.zh_TW = zh_TW;
        }
    }

    public static class StickersBean {
        /**
         * id : 14585982
         * width : 203
         * height : 225
         */

        private int id;
        private int width;
        private int height;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
