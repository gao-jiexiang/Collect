package com.example.collect.bean;

import java.io.Serializable;
import java.util.List;

public class SortItemBean implements Serializable {
    /**
     * errno : 0
     * errmsg :
     * data : {"currentCategory":{"id":1005001,"name":"餐厨","keywords":"","front_desc":"厨房","parent_id":0,"sort_order":3,"show_index":2,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/f4ff8b3d5b0767d4e578575c1fd6b921.jpg","icon_url":"http://yanxuan.nosdn.127.net/ad8b00d084cb7d0958998edb5fee9c0a.png","img_url":"//nos.netease.com/yanxuan/88855173a0cfcfd889ee6394a3259c4f.jpg","wap_banner_url":"http://yanxuan.nosdn.127.net/3708dbcb35ad5abf9e001500f73db615.png","level":"L1","type":0,"front_name":"爱，囿于厨房","subCategoryList":[{"id":1005007,"name":"锅具","keywords":"","front_desc":"中华铸铁、精选不锈钢、进口珐琅","parent_id":1005001,"sort_order":1,"show_index":1,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/4aab4598017b5749e3b63309d25e9f6b.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/d2db0d1d0622c621a8aa5a7c06b0fc6d.png","level":"L2","type":0,"front_name":"一口好锅，炖煮生活一日三餐"},{"id":1005008,"name":"餐具","keywords":"","front_desc":"皇家道尔顿、日本KEYUCA制造商出品","parent_id":1005001,"sort_order":4,"show_index":4,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/f109afbb7e7a00c243c1da29991a5aa3.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/695ed861a63d8c0fc51a51f42a5a993b.png","level":"L2","type":0,"front_name":"餐桌上的舞蹈"},{"id":1005009,"name":"清洁","keywords":"","front_desc":"特殊材质，做家务更简单","parent_id":1005001,"sort_order":9,"show_index":9,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/e8b67fe8b8db2ecc2e126a0aa631def0.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/3a40faaef0a52627357d98ceed7a3c45.png","level":"L2","type":0,"front_name":"环保便利，聪明之选"},{"id":1007000,"name":"杯壶","keywords":"","front_desc":"10Q品质控制系统","parent_id":1005001,"sort_order":2,"show_index":2,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/0b244d3575b737c8f0ed7e84c5c4abd2.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/ec53828a3814171079178a59fb2593da.png","level":"L2","type":0,"front_name":"精工生产制作，匠人手艺"},{"id":1008011,"name":"清洁保鲜","keywords":"","front_desc":"让厨房整洁又新鲜，防尘防潮","parent_id":1005001,"sort_order":6,"show_index":6,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/dc4d6c35b9f4abb42d2eeaf345710589.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/04cd632e1589adcc4345e40e8ad75d2b.png","level":"L2","type":0,"front_name":"真空保鲜，美味不限时"},{"id":1008012,"name":"功能厨具","keywords":"","front_desc":"日日使用的物件，制作精良才能更耐用","parent_id":1005001,"sort_order":3,"show_index":3,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/22db4ccbf52dc62c723ac83aa587812a.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/5b94463017437467a93ae4af17c2ba4f.png","level":"L2","type":0,"front_name":"下厨省力小帮手"},{"id":1008013,"name":"茶具咖啡具","keywords":"","front_desc":"好茶配好器","parent_id":1005001,"sort_order":5,"show_index":5,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/9ea192cd2719c8348f42ec17842ba763.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/be3ba4056e274e311d1c23bd2931018d.png","level":"L2","type":0,"front_name":"先进工艺制造，功夫体验"},{"id":1013005,"name":"刀剪砧板","keywords":"","front_desc":"厨房实用利器","parent_id":1005001,"sort_order":7,"show_index":7,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/9d481ea4c2e9e6eda35aa720d407332e.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/555afbfe05dab48c1a3b90dcaf89b4f2.png","level":"L2","type":0,"front_name":"传统工艺 源自中国刀城"},{"id":1023000,"name":"厨房小电","keywords":"","front_desc":"省心省力，厨房高效能手","parent_id":1005001,"sort_order":8,"show_index":8,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/521bd0c02d283b80ba49e73ca84df250.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/c09d784ba592e4fadabbaef6b2e95a95.png","level":"L2","type":0,"front_name":"厨房里的省心小电器"}]}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * currentCategory : {"id":1005001,"name":"餐厨","keywords":"","front_desc":"厨房","parent_id":0,"sort_order":3,"show_index":2,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/f4ff8b3d5b0767d4e578575c1fd6b921.jpg","icon_url":"http://yanxuan.nosdn.127.net/ad8b00d084cb7d0958998edb5fee9c0a.png","img_url":"//nos.netease.com/yanxuan/88855173a0cfcfd889ee6394a3259c4f.jpg","wap_banner_url":"http://yanxuan.nosdn.127.net/3708dbcb35ad5abf9e001500f73db615.png","level":"L1","type":0,"front_name":"爱，囿于厨房","subCategoryList":[{"id":1005007,"name":"锅具","keywords":"","front_desc":"中华铸铁、精选不锈钢、进口珐琅","parent_id":1005001,"sort_order":1,"show_index":1,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/4aab4598017b5749e3b63309d25e9f6b.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/d2db0d1d0622c621a8aa5a7c06b0fc6d.png","level":"L2","type":0,"front_name":"一口好锅，炖煮生活一日三餐"},{"id":1005008,"name":"餐具","keywords":"","front_desc":"皇家道尔顿、日本KEYUCA制造商出品","parent_id":1005001,"sort_order":4,"show_index":4,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/f109afbb7e7a00c243c1da29991a5aa3.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/695ed861a63d8c0fc51a51f42a5a993b.png","level":"L2","type":0,"front_name":"餐桌上的舞蹈"},{"id":1005009,"name":"清洁","keywords":"","front_desc":"特殊材质，做家务更简单","parent_id":1005001,"sort_order":9,"show_index":9,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/e8b67fe8b8db2ecc2e126a0aa631def0.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/3a40faaef0a52627357d98ceed7a3c45.png","level":"L2","type":0,"front_name":"环保便利，聪明之选"},{"id":1007000,"name":"杯壶","keywords":"","front_desc":"10Q品质控制系统","parent_id":1005001,"sort_order":2,"show_index":2,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/0b244d3575b737c8f0ed7e84c5c4abd2.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/ec53828a3814171079178a59fb2593da.png","level":"L2","type":0,"front_name":"精工生产制作，匠人手艺"},{"id":1008011,"name":"清洁保鲜","keywords":"","front_desc":"让厨房整洁又新鲜，防尘防潮","parent_id":1005001,"sort_order":6,"show_index":6,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/dc4d6c35b9f4abb42d2eeaf345710589.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/04cd632e1589adcc4345e40e8ad75d2b.png","level":"L2","type":0,"front_name":"真空保鲜，美味不限时"},{"id":1008012,"name":"功能厨具","keywords":"","front_desc":"日日使用的物件，制作精良才能更耐用","parent_id":1005001,"sort_order":3,"show_index":3,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/22db4ccbf52dc62c723ac83aa587812a.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/5b94463017437467a93ae4af17c2ba4f.png","level":"L2","type":0,"front_name":"下厨省力小帮手"},{"id":1008013,"name":"茶具咖啡具","keywords":"","front_desc":"好茶配好器","parent_id":1005001,"sort_order":5,"show_index":5,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/9ea192cd2719c8348f42ec17842ba763.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/be3ba4056e274e311d1c23bd2931018d.png","level":"L2","type":0,"front_name":"先进工艺制造，功夫体验"},{"id":1013005,"name":"刀剪砧板","keywords":"","front_desc":"厨房实用利器","parent_id":1005001,"sort_order":7,"show_index":7,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/9d481ea4c2e9e6eda35aa720d407332e.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/555afbfe05dab48c1a3b90dcaf89b4f2.png","level":"L2","type":0,"front_name":"传统工艺 源自中国刀城"},{"id":1023000,"name":"厨房小电","keywords":"","front_desc":"省心省力，厨房高效能手","parent_id":1005001,"sort_order":8,"show_index":8,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/521bd0c02d283b80ba49e73ca84df250.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/c09d784ba592e4fadabbaef6b2e95a95.png","level":"L2","type":0,"front_name":"厨房里的省心小电器"}]}
         */

        private CurrentCategoryBean currentCategory;

        public CurrentCategoryBean getCurrentCategory() {
            return currentCategory;
        }

        public void setCurrentCategory(CurrentCategoryBean currentCategory) {
            this.currentCategory = currentCategory;
        }

        public static class CurrentCategoryBean implements Serializable {
            /**
             * id : 1005001
             * name : 餐厨
             * keywords :
             * front_desc : 厨房
             * parent_id : 0
             * sort_order : 3
             * show_index : 2
             * is_show : 1
             * banner_url : http://yanxuan.nosdn.127.net/f4ff8b3d5b0767d4e578575c1fd6b921.jpg
             * icon_url : http://yanxuan.nosdn.127.net/ad8b00d084cb7d0958998edb5fee9c0a.png
             * img_url : //nos.netease.com/yanxuan/88855173a0cfcfd889ee6394a3259c4f.jpg
             * wap_banner_url : http://yanxuan.nosdn.127.net/3708dbcb35ad5abf9e001500f73db615.png
             * level : L1
             * type : 0
             * front_name : 爱，囿于厨房
             * subCategoryList : [{"id":1005007,"name":"锅具","keywords":"","front_desc":"中华铸铁、精选不锈钢、进口珐琅","parent_id":1005001,"sort_order":1,"show_index":1,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/4aab4598017b5749e3b63309d25e9f6b.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/d2db0d1d0622c621a8aa5a7c06b0fc6d.png","level":"L2","type":0,"front_name":"一口好锅，炖煮生活一日三餐"},{"id":1005008,"name":"餐具","keywords":"","front_desc":"皇家道尔顿、日本KEYUCA制造商出品","parent_id":1005001,"sort_order":4,"show_index":4,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/f109afbb7e7a00c243c1da29991a5aa3.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/695ed861a63d8c0fc51a51f42a5a993b.png","level":"L2","type":0,"front_name":"餐桌上的舞蹈"},{"id":1005009,"name":"清洁","keywords":"","front_desc":"特殊材质，做家务更简单","parent_id":1005001,"sort_order":9,"show_index":9,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/e8b67fe8b8db2ecc2e126a0aa631def0.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/3a40faaef0a52627357d98ceed7a3c45.png","level":"L2","type":0,"front_name":"环保便利，聪明之选"},{"id":1007000,"name":"杯壶","keywords":"","front_desc":"10Q品质控制系统","parent_id":1005001,"sort_order":2,"show_index":2,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/0b244d3575b737c8f0ed7e84c5c4abd2.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/ec53828a3814171079178a59fb2593da.png","level":"L2","type":0,"front_name":"精工生产制作，匠人手艺"},{"id":1008011,"name":"清洁保鲜","keywords":"","front_desc":"让厨房整洁又新鲜，防尘防潮","parent_id":1005001,"sort_order":6,"show_index":6,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/dc4d6c35b9f4abb42d2eeaf345710589.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/04cd632e1589adcc4345e40e8ad75d2b.png","level":"L2","type":0,"front_name":"真空保鲜，美味不限时"},{"id":1008012,"name":"功能厨具","keywords":"","front_desc":"日日使用的物件，制作精良才能更耐用","parent_id":1005001,"sort_order":3,"show_index":3,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/22db4ccbf52dc62c723ac83aa587812a.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/5b94463017437467a93ae4af17c2ba4f.png","level":"L2","type":0,"front_name":"下厨省力小帮手"},{"id":1008013,"name":"茶具咖啡具","keywords":"","front_desc":"好茶配好器","parent_id":1005001,"sort_order":5,"show_index":5,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/9ea192cd2719c8348f42ec17842ba763.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/be3ba4056e274e311d1c23bd2931018d.png","level":"L2","type":0,"front_name":"先进工艺制造，功夫体验"},{"id":1013005,"name":"刀剪砧板","keywords":"","front_desc":"厨房实用利器","parent_id":1005001,"sort_order":7,"show_index":7,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/9d481ea4c2e9e6eda35aa720d407332e.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/555afbfe05dab48c1a3b90dcaf89b4f2.png","level":"L2","type":0,"front_name":"传统工艺 源自中国刀城"},{"id":1023000,"name":"厨房小电","keywords":"","front_desc":"省心省力，厨房高效能手","parent_id":1005001,"sort_order":8,"show_index":8,"is_show":1,"banner_url":"http://yanxuan.nosdn.127.net/521bd0c02d283b80ba49e73ca84df250.png","icon_url":"","img_url":"","wap_banner_url":"http://yanxuan.nosdn.127.net/c09d784ba592e4fadabbaef6b2e95a95.png","level":"L2","type":0,"front_name":"厨房里的省心小电器"}]
             */

            private int id;
            private String name;
            private String keywords;
            private String front_desc;
            private int parent_id;
            private int sort_order;
            private int show_index;
            private int is_show;
            private String banner_url;
            private String icon_url;
            private String img_url;
            private String wap_banner_url;
            private String level;
            private int type;
            private String front_name;
            private List<SubCategoryListBean> subCategoryList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getFront_desc() {
                return front_desc;
            }

            public void setFront_desc(String front_desc) {
                this.front_desc = front_desc;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }

            public int getShow_index() {
                return show_index;
            }

            public void setShow_index(int show_index) {
                this.show_index = show_index;
            }

            public int getIs_show() {
                return is_show;
            }

            public void setIs_show(int is_show) {
                this.is_show = is_show;
            }

            public String getBanner_url() {
                return banner_url;
            }

            public void setBanner_url(String banner_url) {
                this.banner_url = banner_url;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getWap_banner_url() {
                return wap_banner_url;
            }

            public void setWap_banner_url(String wap_banner_url) {
                this.wap_banner_url = wap_banner_url;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getFront_name() {
                return front_name;
            }

            public void setFront_name(String front_name) {
                this.front_name = front_name;
            }

            public List<SubCategoryListBean> getSubCategoryList() {
                return subCategoryList;
            }

            public void setSubCategoryList(List<SubCategoryListBean> subCategoryList) {
                this.subCategoryList = subCategoryList;
            }

            public static class SubCategoryListBean implements Serializable {
                /**
                 * id : 1005007
                 * name : 锅具
                 * keywords :
                 * front_desc : 中华铸铁、精选不锈钢、进口珐琅
                 * parent_id : 1005001
                 * sort_order : 1
                 * show_index : 1
                 * is_show : 1
                 * banner_url : http://yanxuan.nosdn.127.net/4aab4598017b5749e3b63309d25e9f6b.png
                 * icon_url :
                 * img_url :
                 * wap_banner_url : http://yanxuan.nosdn.127.net/d2db0d1d0622c621a8aa5a7c06b0fc6d.png
                 * level : L2
                 * type : 0
                 * front_name : 一口好锅，炖煮生活一日三餐
                 */

                private int id;
                private String name;
                private String keywords;
                private String front_desc;
                private int parent_id;
                private int sort_order;
                private int show_index;
                private int is_show;
                private String banner_url;
                private String icon_url;
                private String img_url;
                private String wap_banner_url;
                private String level;
                private int type;
                private String front_name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }

                public String getFront_desc() {
                    return front_desc;
                }

                public void setFront_desc(String front_desc) {
                    this.front_desc = front_desc;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getSort_order() {
                    return sort_order;
                }

                public void setSort_order(int sort_order) {
                    this.sort_order = sort_order;
                }

                public int getShow_index() {
                    return show_index;
                }

                public void setShow_index(int show_index) {
                    this.show_index = show_index;
                }

                public int getIs_show() {
                    return is_show;
                }

                public void setIs_show(int is_show) {
                    this.is_show = is_show;
                }

                public String getBanner_url() {
                    return banner_url;
                }

                public void setBanner_url(String banner_url) {
                    this.banner_url = banner_url;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getWap_banner_url() {
                    return wap_banner_url;
                }

                public void setWap_banner_url(String wap_banner_url) {
                    this.wap_banner_url = wap_banner_url;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getFront_name() {
                    return front_name;
                }

                public void setFront_name(String front_name) {
                    this.front_name = front_name;
                }
            }
        }
    }
}
