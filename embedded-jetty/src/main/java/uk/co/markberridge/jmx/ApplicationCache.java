package uk.co.markberridge.jmx;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

/**
 * Basic demo MBean<br />
 * TODO wire in a service
 */
public class ApplicationCache implements ApplicationCacheMBean, ApplicationCacheService {

    private long maxCacheSize;
    private Cache<String, String> cache;

    public ApplicationCache(long maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
        this.cache = CacheBuilder.newBuilder().recordStats().maximumSize(maxCacheSize).build();
    }

    public ApplicationCache(long maxCacheSize, String... initialCache) {
        this(maxCacheSize);
        for (int i = 0; i < initialCache.length; i++) {
            cache.put(initialCache[i], initialCache[i]);
        }
    }

    @Override
    public void clearCache() {
        cache.invalidateAll();
    }

    @Override
    public long getCurrentCachedSize() {
        return cache.size();
    }

    @Override
    public long getMaxCacheSize() {
        return maxCacheSize;
    }

    @Override
    public CacheStats getStats() {
        return cache.stats();
    }

    @Override
    public void put(String s) {
        cache.put(s, s);
    }

    @Override
    public String dumpCache() {
        return Joiner.on(" | ").join(cache.asMap().keySet());
    }
}
