package com.wzz.blog.vo;

/**
 * @author wzzap
 * @date 2019/6/24
 **/
public class BlogSearch {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogSearch() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
