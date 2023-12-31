package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NASAResponse {
    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

    public NASAResponse(
                        @JsonProperty("copyright") String copyright,
                        @JsonProperty("date") String date,
                        @JsonProperty("explanation") String explanation,
                        @JsonProperty("hdurl") String hdurl,
                        @JsonProperty("media_type") String mediaType,
                        @JsonProperty("service_version") String serviceVersion,
                        @JsonProperty("title") String title,
                        @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return mediaType;
    }

    public String getService_version() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
    @Override
    public String toString() {
        return "NASAResponse{" +
                "\ncopyright=" + copyright +
                "\ndate=" + date +
                "\nexplanation=" + explanation +
                "\nhdurl=" + hdurl +
                "\nmedia_type=" + mediaType +
                "\nservice_version=" + serviceVersion +
                "\ntitle=" + title +
                "\nurl=" + url +
                '}';
    }
}
