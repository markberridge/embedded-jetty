package uk.co.markberridge.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

/**
 * Basic demo MBean<br />
 * TODO wire in a service<br />
 * <br />
 * Make sure that an MBean (or its interface) doesn't contain 'MBean' in its name as it will be treated as a
 * StandardMBean causing annotations not to work!
 */
@ManagedResource(objectName = "app:bean=Cache", description = "Bean for managing application cache")
public class ApplicationCache implements ApplicationCacheManagementInterface, ApplicationCacheService {

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
    @ManagedOperation
    public void clearCache() {
        cache.invalidateAll();
    }

    @Override
    @ManagedAttribute(description = "The current cache size")
    public long getCurrentCachedSize() {
        return cache.size();
    }

    @Override
    @ManagedAttribute(description = "The maximum cache size")
    public long getMaxCacheSize() {
        return maxCacheSize;
    }

    @Override
    @ManagedAttribute
    public CacheStats getStats() {
        return cache.stats();
    }

    @Override
    public void put(String s) {
        cache.put(s, s);
    }

    @Override
    @ManagedOperation
    public String dumpCache() {
        return Joiner.on(" | ").join(cache.asMap().keySet());
    }

    @Override
    public void dontExposeMe() {
        throw new UnsupportedOperationException();
    }
}
