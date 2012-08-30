package uk.co.markberridge.activiti;

import java.util.Collections;
import java.util.List;

import org.activiti.engine.repository.ProcessDefinition;

public class StuubedProcessDefinitionQuery implements org.activiti.engine.repository.ProcessDefinitionQuery {

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery asc() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery desc() {
        return this;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public ProcessDefinition singleResult() {
        return null;
    }

    @Override
    public List<ProcessDefinition> list() {
        return Collections.emptyList();
    }

    @Override
    public List<ProcessDefinition> listPage(int firstResult, int maxResults) {
        return Collections.emptyList();
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionId(String processDefinitionId) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionCategory(String processDefinitionCategory) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionCategoryLike(String processDefinitionCategoryLike) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionName(String processDefinitionName) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionNameLike(String processDefinitionNameLike) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery deploymentId(String deploymentId) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionKey(String processDefinitionKey) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionKeyLike(String processDefinitionKeyLike) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionVersion(Integer processDefinitionVersion) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery latestVersion() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionResourceName(String resourceName) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionResourceNameLike(String resourceNameLike) {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery orderByProcessDefinitionCategory() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery orderByProcessDefinitionKey() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery orderByProcessDefinitionId() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery orderByProcessDefinitionVersion() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery orderByProcessDefinitionName() {
        return this;
    }

    @Override
    public org.activiti.engine.repository.ProcessDefinitionQuery orderByDeploymentId() {
        return this;
    }
}
