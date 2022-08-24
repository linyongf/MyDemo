package com.linyf.demo.class_hot_load;

/**
 * 封装加载类的信息
 */
public class LoadInfo {
    /** 记录要加载的类的时间戳-->加载的时间 */
    private long loadTime;

    /** 需要被热加载的类 */
    private BaseManager manager;

    public LoadInfo(long loadTime, BaseManager manager) {
        this.loadTime = loadTime;
        this.manager = manager;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}
