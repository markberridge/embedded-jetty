package uk.co.markberridge.struts;

import org.springframework.util.StringUtils;

import uk.co.markberridge.service.ApplicationCacheService;

import com.opensymphony.xwork2.ActionSupport;

public class CacheAction extends ActionSupport {

    private ApplicationCacheService applicationCacheService;

    private String value;

    @Override
    public String execute() throws Exception {
        if (StringUtils.hasText(value)) {
            applicationCacheService.put(value);
        }
        return SUCCESS;
    }

    public ApplicationCacheService getApplicationCacheService() {
        return applicationCacheService;
    }

    public void setApplicationCacheService(ApplicationCacheService applicationCacheService) {
        this.applicationCacheService = applicationCacheService;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCache() {
        return applicationCacheService.dumpCache();
    }
}
