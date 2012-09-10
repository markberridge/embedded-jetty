package uk.co.markberridge.jmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import uk.co.markberridge.service.ApplicationCacheService;

import com.google.common.cache.CacheStats;

/**
 * Make sure that an MBean (or its interface) doesn't contain 'MBean' in its name as it will be treated as a
 * StandardMBean causing annotations not to work!
 */
@ManagedResource(objectName = "app:bean=Cache", description = "Bean for managing application cache")
public class ApplicationCacheManagement {

    @Autowired
    private ApplicationCacheService applicationCacheService;

    @ManagedOperation
    public void clearCache() {
        applicationCacheService.clearCache();
    }

    @ManagedAttribute(description = "The current cache size")
    public long getCurrentCachedSize() {
        return applicationCacheService.getCurrentCachedSize();
    }

    @ManagedAttribute(description = "The maximum cache size")
    public long getMaxCacheSize() {
        return applicationCacheService.getMaxCacheSize();
    }

    @ManagedAttribute
    public CacheStats getStats() {
        return applicationCacheService.getStats();
    }

    @ManagedOperation
    public String dumpCache() {
        return applicationCacheService.dumpCache();
    }

    public void dontExposeMe() {
        throw new UnsupportedOperationException();
    }
}
