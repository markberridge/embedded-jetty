package uk.co.markberridge.jmx;

import com.google.common.cache.CacheStats;

public interface ApplicationCacheMBean {

    public long getMaxCacheSize();

    public long getCurrentCachedSize();

    public String dumpCache();

    public void clearCache();

    public CacheStats getStats();
}
