/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service.environment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
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

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Deployment extends Resource {
    private static final long serialVersionUID = 221470253748944L;

    /**
     * Create a DeploymentReader to execute read.
     *
     * @param pathServiceSid The SID of the Service to read the Deployment
     *                       resources from
     * @param pathEnvironmentSid The SID of the Environment used by the Deployment
     *                           resources to read
     * @return DeploymentReader capable of executing the read
     */
    public static DeploymentReader reader(final String pathServiceSid,
                                          final String pathEnvironmentSid) {
        return new DeploymentReader(pathServiceSid, pathEnvironmentSid);
    }

    /**
     * Create a DeploymentFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the Service to fetch the Deployment
     *                       resource from
     * @param pathEnvironmentSid The SID of the Environment used by the Deployment
     *                           to fetch
     * @param pathSid The SID that identifies the Deployment resource to fetch
     * @return DeploymentFetcher capable of executing the fetch
     */
    public static DeploymentFetcher fetcher(final String pathServiceSid,
                                            final String pathEnvironmentSid,
                                            final String pathSid) {
        return new DeploymentFetcher(pathServiceSid, pathEnvironmentSid, pathSid);
    }

    /**
     * Create a DeploymentCreator to execute create.
     *
     * @param pathServiceSid The SID of the Service to create the Deployment
     *                       resource under
     * @param pathEnvironmentSid The SID of the Environment for the Deployment
     * @return DeploymentCreator capable of executing the create
     */
    public static DeploymentCreator creator(final String pathServiceSid,
                                            final String pathEnvironmentSid) {
        return new DeploymentCreator(pathServiceSid, pathEnvironmentSid);
    }

    /**
     * Converts a JSON String into a Deployment object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Deployment object represented by the provided JSON
     */
    public static Deployment fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Deployment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Deployment object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Deployment object represented by the provided JSON
     */
    public static Deployment fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Deployment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String environmentSid;
    private final String buildSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Deployment(@JsonProperty("sid")
                       final String sid,
                       @JsonProperty("account_sid")
                       final String accountSid,
                       @JsonProperty("service_sid")
                       final String serviceSid,
                       @JsonProperty("environment_sid")
                       final String environmentSid,
                       @JsonProperty("build_sid")
                       final String buildSid,
                       @JsonProperty("date_created")
                       final String dateCreated,
                       @JsonProperty("date_updated")
                       final String dateUpdated,
                       @JsonProperty("url")
                       final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.environmentSid = environmentSid;
        this.buildSid = buildSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The unique string that identifies the Deployment resource.
     *
     * @return The unique string that identifies the Deployment resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Account that created the Deployment resource.
     *
     * @return The SID of the Account that created the Deployment resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The SID of the Service that the Deployment resource is associated
     * with.
     *
     * @return The SID of the Service that the Deployment resource is associated
     *         with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The SID of the Environment for the Deployment.
     *
     * @return The SID of the Environment for the Deployment
     */
    public final String getEnvironmentSid() {
        return this.environmentSid;
    }

    /**
     * Returns The SID of the Build for the deployment.
     *
     * @return The SID of the Build for the deployment
     */
    public final String getBuildSid() {
        return this.buildSid;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Deployment resource was
     * created.
     *
     * @return The ISO 8601 date and time in GMT when the Deployment resource was
     *         created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Deployment resource was
     * last updated.
     *
     * @return The ISO 8601 date and time in GMT when the Deployment resource was
     *         last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the Deployment resource.
     *
     * @return The absolute URL of the Deployment resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Deployment other = (Deployment) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(environmentSid, other.environmentSid) &&
               Objects.equals(buildSid, other.buildSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            environmentSid,
                            buildSid,
                            dateCreated,
                            dateUpdated,
                            url);
    }
}