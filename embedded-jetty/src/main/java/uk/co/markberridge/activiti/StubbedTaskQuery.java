package uk.co.markberridge.activiti;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class StubbedTaskQuery implements TaskQuery {

    @Override
    public TaskQuery asc() {
        return this;
    }

    @Override
    public TaskQuery desc() {
        return this;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Task singleResult() {
        return null;
    }

    @Override
    public List<Task> list() {
        return Collections.emptyList();
    }

    @Override
    public List<Task> listPage(int firstResult, int maxResults) {
        return Collections.emptyList();
    }

    @Override
    public TaskQuery taskId(String taskId) {
        return this;
    }

    @Override
    public TaskQuery taskName(String name) {
        return this;
    }

    @Override
    public TaskQuery taskNameLike(String nameLike) {
        return this;
    }

    @Override
    public TaskQuery taskDescription(String description) {
        return this;
    }

    @Override
    public TaskQuery taskDescriptionLike(String descriptionLike) {
        return this;
    }

    @Override
    public TaskQuery taskPriority(Integer priority) {
        return this;
    }

    @Override
    public TaskQuery taskMinPriority(Integer minPriority) {
        return this;
    }

    @Override
    public TaskQuery taskMaxPriority(Integer maxPriority) {
        return this;
    }

    @Override
    public TaskQuery taskAssignee(String assignee) {
        return this;
    }

    @Override
    public TaskQuery taskOwner(String owner) {
        return this;
    }

    @Override
    public TaskQuery taskUnnassigned() {
        return this;
    }

    @Override
    public TaskQuery taskCandidateUser(String candidateUser) {
        return this;
    }

    @Override
    public TaskQuery taskInvolvedUser(String involvedUser) {
        return this;
    }

    @Override
    public TaskQuery taskCandidateGroup(String candidateGroup) {
        return this;
    }

    @Override
    public TaskQuery processInstanceId(String processInstanceId) {
        return this;
    }

    @Override
    public TaskQuery executionId(String executionId) {
        return this;
    }

    @Override
    public TaskQuery taskCreatedOn(Date createTime) {
        return this;
    }

    @Override
    public TaskQuery taskCreatedBefore(Date before) {
        return this;
    }

    @Override
    public TaskQuery taskCreatedAfter(Date after) {
        return this;
    }

    @Override
    public TaskQuery taskDefinitionKey(String key) {
        return this;
    }

    @Override
    public TaskQuery taskDefinitionKeyLike(String keyLike) {
        return this;
    }

    @Override
    public TaskQuery taskVariableValueEquals(String variableName, Object variableValue) {
        return this;
    }

    @Override
    public TaskQuery processVariableValueEquals(String variableName, Object variableValue) {
        return this;
    }

    @Override
    public TaskQuery processDefinitionKey(String processDefinitionKey) {
        return this;
    }

    @Override
    public TaskQuery processDefinitionId(String processDefinitionId) {
        return this;
    }

    @Override
    public TaskQuery processDefinitionName(String processDefinitionName) {
        return this;
    }

    @Override
    public TaskQuery dueDate(Date dueDate) {
        return this;
    }

    @Override
    public TaskQuery dueBefore(Date dueDate) {
        return this;
    }

    @Override
    public TaskQuery dueAfter(Date dueDate) {
        return this;
    }

    @Override
    public TaskQuery orderByTaskId() {
        return this;
    }

    @Override
    public TaskQuery orderByTaskName() {
        return this;
    }

    @Override
    public TaskQuery orderByTaskDescription() {
        return this;
    }

    @Override
    public TaskQuery orderByTaskPriority() {
        return this;
    }

    @Override
    public TaskQuery orderByTaskAssignee() {
        return this;
    }

    @Override
    public TaskQuery orderByTaskCreateTime() {
        return this;
    }

    @Override
    public TaskQuery orderByProcessInstanceId() {
        return this;
    }

    @Override
    public TaskQuery orderByExecutionId() {
        return this;
    }

    @Override
    public TaskQuery orderByDueDate() {
        return this;
    }
}
