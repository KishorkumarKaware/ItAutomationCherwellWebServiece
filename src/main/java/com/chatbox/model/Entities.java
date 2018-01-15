package com.chatbox.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {
	 private String platform;

	    private String locale;

	    private String type;

	    private String country;

	    public String getPlatform ()
	    {
	        return platform;
	    }

	    public void setPlatform (String platform)
	    {
	        this.platform = platform;
	    }

	    public String getLocale ()
	    {
	        return locale;
	    }

	    public void setLocale (String locale)
	    {
	        this.locale = locale;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    public String getCountry ()
	    {
	        return country;
	    }

	    public void setCountry (String country)
	    {
	        this.country = country;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [platform = "+platform+", locale = "+locale+", type = "+type+", country = "+country+"]";
	    }
	}

