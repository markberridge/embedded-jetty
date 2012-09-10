package uk.co.markberridge.jmx;

import com.google.common.cache.CacheStats;

/**
 * @author mberridge
 */
public interface ApplicationCacheManagementInterface {

    public long getMaxCacheSize();

    public long getCurrentCachedSize();

    public String dumpCache();

    public void clearCache();

    public CacheStats getStats();

    public void dontExposeMe();
}
