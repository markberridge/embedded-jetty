package uk.co.markberridge.service;

import com.google.common.cache.CacheStats;

public interface ApplicationCacheService {

    public void put(String s);

    public String dumpCache();

    public long getMaxCacheSize();

    public long getCurrentCachedSize();

    public void clearCache();

    public CacheStats getStats();
}
