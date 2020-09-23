/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.notify.v1.service;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
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

import java.time.LocalDate;
import java.util.List;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class BindingReader extends Reader<Binding> {
    private final String pathServiceSid;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> identity;
    private List<String> tag;

    /**
     * Construct a new BindingReader.
     *
     * @param pathServiceSid The SID of the Service to read the resource from
     */
    public BindingReader(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    /**
     * Only include usage that has occurred on or after this date. Specify the date
     * in GMT and format as `YYYY-MM-DD`..
     *
     * @param startDate Only include usage that has occurred on or after this date
     * @return this
     */
    public BindingReader setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Only include usage that occurred on or before this date. Specify the date in
     * GMT and format as `YYYY-MM-DD`..
     *
     * @param endDate Only include usage that occurred on or before this date
     * @return this
     */
    public BindingReader setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The <a href="https://www.twilio.com/docs/chat/rest/user-resource">User</a>'s
     * `identity` value of the resources to read..
     *
     * @param identity The `identity` value of the resources to read
     * @return this
     */
    public BindingReader setIdentity(final List<String> identity) {
        this.identity = identity;
        return this;
    }

    /**
     * The <a href="https://www.twilio.com/docs/chat/rest/user-resource">User</a>'s
     * `identity` value of the resources to read..
     *
     * @param identity The `identity` value of the resources to read
     * @return this
     */
    public BindingReader setIdentity(final String identity) {
        return setIdentity(Promoter.listOfOne(identity));
    }

    /**
     * Only list Bindings that have all of the specified Tags. The following
     * implicit tags are available: `all`, `apn`, `fcm`, `gcm`, `sms`,
     * `facebook-messenger`. Up to 5 tags are allowed..
     *
     * @param tag Only list Bindings that have all of the specified Tags
     * @return this
     */
    public BindingReader setTag(final List<String> tag) {
        this.tag = tag;
        return this;
    }

    /**
     * Only list Bindings that have all of the specified Tags. The following
     * implicit tags are available: `all`, `apn`, `fcm`, `gcm`, `sms`,
     * `facebook-messenger`. Up to 5 tags are allowed..
     *
     * @param tag Only list Bindings that have all of the specified Tags
     * @return this
     */
    public BindingReader setTag(final String tag) {
        return setTag(Promoter.listOfOne(tag));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Binding ResourceSet
     */
    @Override
    public ResourceSet<Binding> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Binding ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Binding> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.NOTIFY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Bindings"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Binding ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Binding> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Binding> nextPage(final Page<Binding> page,
                                  final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.NOTIFY.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Binding> previousPage(final Page<Binding> page,
                                      final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.NOTIFY.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Binding Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Binding> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Binding read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "bindings",
            response.getContent(),
            Binding.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (startDate != null) {
            request.addQueryParam("StartDate", DateConverter.dateStringFromLocalDate(startDate));
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", DateConverter.dateStringFromLocalDate(endDate));
        }

        if (identity != null) {
            for (String prop : identity) {
                request.addQueryParam("Identity", prop);
            }
        }

        if (tag != null) {
            for (String prop : tag) {
                request.addQueryParam("Tag", prop);
            }
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}