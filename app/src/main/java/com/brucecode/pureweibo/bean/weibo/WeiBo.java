package com.brucecode.pureweibo.bean.weibo;

import java.util.List;

/**
 * Created by bruce on 2016/12/17.
 */

public class WeiBo {

    private int previous_cursor;
    private long next_cursor;
    private int total_number;
    private List<Statuse> statuses;
    private List<AD> ad;

    public int getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(int previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public long getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(long next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<Statuse> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Statuse> statuses) {
        this.statuses = statuses;
    }

    public List<AD> getAd() {
        return ad;
    }

    public void setAd(List<AD> ad) {
        this.ad = ad;
    }
}
