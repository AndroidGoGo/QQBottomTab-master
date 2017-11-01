package com.lzq.modle;

import java.util.List;

/**
 * Created by CC on 2016/11/15.
 * 首页轮播图返回的数据
 */

public class HomeResponse extends BaseResponse {

    public List<HomeTopicBean> homeTopic;

    public List<HomeTopicBean> getHomeTopic() {
        return homeTopic;
    }

    public void setHomeTopic(List<HomeTopicBean> homeTopic) {
        this.homeTopic = homeTopic;
    }

    public static class HomeTopicBean {
        /**
         * id : 123
         * pic : /images/home/image1.jpg
         * title : 活动1
         */

        private int id;
        private String pic;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }






}




