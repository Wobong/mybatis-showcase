package com.cheer.mybatis.util;

public class Page {
    private int count;
    private int pagesize;
    private int pagenum;
    private int offset;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int pagenum) {
        this.offset = (pagenum-1)*this.pagesize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("共计{");
        sb.append(count);
        sb.append("条,").append(pagesize);
        sb.append("页");
        return sb.toString();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int count,int pagesize) {
        this.pagenum =count % pagesize==0? (count / pagesize) + 1 : count / pagesize;
    }

}
