package com.example.demo.shared;

public class ErrorResponse {
    private Integer statusCode;
    private String errorMessage;
    private long errorReportTime;

    public ErrorResponse(Integer statusCode, String errorMessage, long errorReportTime) {

        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.errorReportTime = errorReportTime;
    }

    public ErrorResponse() {
        super();
    }

    public Integer getStatusCode(int value) {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getErrorReportTime(long l) {
        return errorReportTime;
    }

    public void setErrorReportTime(long errorReportTime) {
        this.errorReportTime = errorReportTime;
    }
}
