/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Task extends Resource {
    private static final long serialVersionUID = 238267579862423L;

    public enum Status {
        PENDING("pending"),
        RESERVED("reserved"),
        ASSIGNED("assigned"),
        CANCELED("canceled"),
        COMPLETED("completed"),
        WRAPPING("wrapping");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a TaskFetcher to execute fetch.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the Task to fetch
     * @param pathSid The SID of the resource to fetch
     * @return TaskFetcher capable of executing the fetch
     */
    public static TaskFetcher fetcher(final String pathWorkspaceSid,
                                      final String pathSid) {
        return new TaskFetcher(pathWorkspaceSid, pathSid);
    }

    /**
     * Create a TaskUpdater to execute update.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the Task to update
     * @param pathSid The SID of the resource to update
     * @return TaskUpdater capable of executing the update
     */
    public static TaskUpdater updater(final String pathWorkspaceSid,
                                      final String pathSid) {
        return new TaskUpdater(pathWorkspaceSid, pathSid);
    }

    /**
     * Create a TaskDeleter to execute delete.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the Task to delete
     * @param pathSid The SID of the resource to delete
     * @return TaskDeleter capable of executing the delete
     */
    public static TaskDeleter deleter(final String pathWorkspaceSid,
                                      final String pathSid) {
        return new TaskDeleter(pathWorkspaceSid, pathSid);
    }

    /**
     * Create a TaskReader to execute read.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the Tasks to read
     * @return TaskReader capable of executing the read
     */
    public static TaskReader reader(final String pathWorkspaceSid) {
        return new TaskReader(pathWorkspaceSid);
    }

    /**
     * Create a TaskCreator to execute create.
     *
     * @param pathWorkspaceSid The SID of the Workspace that the new Task belongs to
     * @return TaskCreator capable of executing the create
     */
    public static TaskCreator creator(final String pathWorkspaceSid) {
        return new TaskCreator(pathWorkspaceSid);
    }

    /**
     * Converts a JSON String into a Task object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Task object represented by the provided JSON
     */
    public static Task fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Task.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Task object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Task object represented by the provided JSON
     */
    public static Task fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Task.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Integer age;
    private final Task.Status assignmentStatus;
    private final String attributes;
    private final String addons;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final ZonedDateTime taskQueueEnteredDate;
    private final Integer priority;
    private final String reason;
    private final String sid;
    private final String taskQueueSid;
    private final String taskQueueFriendlyName;
    private final String taskChannelSid;
    private final String taskChannelUniqueName;
    private final Integer timeout;
    private final String workflowSid;
    private final String workflowFriendlyName;
    private final String workspaceSid;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Task(@JsonProperty("account_sid")
                 final String accountSid,
                 @JsonProperty("age")
                 final Integer age,
                 @JsonProperty("assignment_status")
                 final Task.Status assignmentStatus,
                 @JsonProperty("attributes")
                 final String attributes,
                 @JsonProperty("addons")
                 final String addons,
                 @JsonProperty("date_created")
                 final String dateCreated,
                 @JsonProperty("date_updated")
                 final String dateUpdated,
                 @JsonProperty("task_queue_entered_date")
                 final String taskQueueEnteredDate,
                 @JsonProperty("priority")
                 final Integer priority,
                 @JsonProperty("reason")
                 final String reason,
                 @JsonProperty("sid")
                 final String sid,
                 @JsonProperty("task_queue_sid")
                 final String taskQueueSid,
                 @JsonProperty("task_queue_friendly_name")
                 final String taskQueueFriendlyName,
                 @JsonProperty("task_channel_sid")
                 final String taskChannelSid,
                 @JsonProperty("task_channel_unique_name")
                 final String taskChannelUniqueName,
                 @JsonProperty("timeout")
                 final Integer timeout,
                 @JsonProperty("workflow_sid")
                 final String workflowSid,
                 @JsonProperty("workflow_friendly_name")
                 final String workflowFriendlyName,
                 @JsonProperty("workspace_sid")
                 final String workspaceSid,
                 @JsonProperty("url")
                 final URI url,
                 @JsonProperty("links")
                 final Map<String, String> links) {
        this.accountSid = accountSid;
        this.age = age;
        this.assignmentStatus = assignmentStatus;
        this.attributes = attributes;
        this.addons = addons;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.taskQueueEnteredDate = DateConverter.iso8601DateTimeFromString(taskQueueEnteredDate);
        this.priority = priority;
        this.reason = reason;
        this.sid = sid;
        this.taskQueueSid = taskQueueSid;
        this.taskQueueFriendlyName = taskQueueFriendlyName;
        this.taskChannelSid = taskChannelSid;
        this.taskChannelUniqueName = taskChannelUniqueName;
        this.timeout = timeout;
        this.workflowSid = workflowSid;
        this.workflowFriendlyName = workflowFriendlyName;
        this.workspaceSid = workspaceSid;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The number of seconds since the Task was created.
     *
     * @return The number of seconds since the Task was created
     */
    public final Integer getAge() {
        return this.age;
    }

    /**
     * Returns The current status of the Task's assignment.
     *
     * @return The current status of the Task's assignment
     */
    public final Task.Status getAssignmentStatus() {
        return this.assignmentStatus;
    }

    /**
     * Returns The JSON string with custom attributes of the work.
     *
     * @return The JSON string with custom attributes of the work
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns An object that contains the addon data for all installed addons.
     *
     * @return An object that contains the addon data for all installed addons
     */
    public final String getAddons() {
        return this.addons;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Task entered the
     * TaskQueue..
     *
     * @return The ISO 8601 date and time in GMT when the Task entered the
     *         TaskQueue.
     */
    public final ZonedDateTime getTaskQueueEnteredDate() {
        return this.taskQueueEnteredDate;
    }

    /**
     * Returns Retrieve the list of all Tasks in the Workspace with the specified
     * priority.
     *
     * @return Retrieve the list of all Tasks in the Workspace with the specified
     *         priority
     */
    public final Integer getPriority() {
        return this.priority;
    }

    /**
     * Returns The reason the Task was canceled or completed.
     *
     * @return The reason the Task was canceled or completed
     */
    public final String getReason() {
        return this.reason;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the TaskQueue.
     *
     * @return The SID of the TaskQueue
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
    }

    /**
     * Returns The friendly name of the TaskQueue.
     *
     * @return The friendly name of the TaskQueue
     */
    public final String getTaskQueueFriendlyName() {
        return this.taskQueueFriendlyName;
    }

    /**
     * Returns The SID of the TaskChannel.
     *
     * @return The SID of the TaskChannel
     */
    public final String getTaskChannelSid() {
        return this.taskChannelSid;
    }

    /**
     * Returns The unique name of the TaskChannel.
     *
     * @return The unique name of the TaskChannel
     */
    public final String getTaskChannelUniqueName() {
        return this.taskChannelUniqueName;
    }

    /**
     * Returns The amount of time in seconds that the Task is allowed to live.
     *
     * @return The amount of time in seconds that the Task is allowed to live
     */
    public final Integer getTimeout() {
        return this.timeout;
    }

    /**
     * Returns The SID of the Workflow that is controlling the Task.
     *
     * @return The SID of the Workflow that is controlling the Task
     */
    public final String getWorkflowSid() {
        return this.workflowSid;
    }

    /**
     * Returns The friendly name of the Workflow that is controlling the Task.
     *
     * @return The friendly name of the Workflow that is controlling the Task
     */
    public final String getWorkflowFriendlyName() {
        return this.workflowFriendlyName;
    }

    /**
     * Returns The SID of the Workspace that contains the Task.
     *
     * @return The SID of the Workspace that contains the Task
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The absolute URL of the Task resource.
     *
     * @return The absolute URL of the Task resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The URLs of related resources.
     *
     * @return The URLs of related resources
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task other = (Task) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(age, other.age) &&
               Objects.equals(assignmentStatus, other.assignmentStatus) &&
               Objects.equals(attributes, other.attributes) &&
               Objects.equals(addons, other.addons) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(taskQueueEnteredDate, other.taskQueueEnteredDate) &&
               Objects.equals(priority, other.priority) &&
               Objects.equals(reason, other.reason) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(taskQueueSid, other.taskQueueSid) &&
               Objects.equals(taskQueueFriendlyName, other.taskQueueFriendlyName) &&
               Objects.equals(taskChannelSid, other.taskChannelSid) &&
               Objects.equals(taskChannelUniqueName, other.taskChannelUniqueName) &&
               Objects.equals(timeout, other.timeout) &&
               Objects.equals(workflowSid, other.workflowSid) &&
               Objects.equals(workflowFriendlyName, other.workflowFriendlyName) &&
               Objects.equals(workspaceSid, other.workspaceSid) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            age,
                            assignmentStatus,
                            attributes,
                            addons,
                            dateCreated,
                            dateUpdated,
                            taskQueueEnteredDate,
                            priority,
                            reason,
                            sid,
                            taskQueueSid,
                            taskQueueFriendlyName,
                            taskChannelSid,
                            taskChannelUniqueName,
                            timeout,
                            workflowSid,
                            workflowFriendlyName,
                            workspaceSid,
                            url,
                            links);
    }
}