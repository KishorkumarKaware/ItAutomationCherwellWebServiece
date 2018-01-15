package com.chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status
{
	 private String errorType;

	    private String code;

	    private String webhookTimedOut;

	    public String getErrorType ()
	    {
	        return errorType;
	    }

	    public void setErrorType (String errorType)
	    {
	        this.errorType = errorType;
	    }

	    public String getCode ()
	    {
	        return code;
	    }

	    public void setCode (String code)
	    {
	        this.code = code;
	    }

	    public String getWebhookTimedOut ()
	    {
	        return webhookTimedOut;
	    }

	    public void setWebhookTimedOut (String webhookTimedOut)
	    {
	        this.webhookTimedOut = webhookTimedOut;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [errorType = "+errorType+", code = "+code+", webhookTimedOut = "+webhookTimedOut+"]";
	    }
	}
		