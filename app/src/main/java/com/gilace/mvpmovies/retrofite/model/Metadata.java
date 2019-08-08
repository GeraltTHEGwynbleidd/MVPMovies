
package com.gilace.mvpmovies.retrofite.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Metadata {

    @SerializedName("current_page")
    private String mCurrentPage;
    @SerializedName("page_count")
    private Long mPageCount;
    @SerializedName("per_page")
    private Long mPerPage;
    @SerializedName("total_count")
    private Long mTotalCount;

    public String getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(String currentPage) {
        mCurrentPage = currentPage;
    }

    public Long getPageCount() {
        return mPageCount;
    }

    public void setPageCount(Long pageCount) {
        mPageCount = pageCount;
    }

    public Long getPerPage() {
        return mPerPage;
    }

    public void setPerPage(Long perPage) {
        mPerPage = perPage;
    }

    public Long getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Long totalCount) {
        mTotalCount = totalCount;
    }

}
