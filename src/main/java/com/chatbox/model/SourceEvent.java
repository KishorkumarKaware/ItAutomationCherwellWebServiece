package com.chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceEvent {
	private String text;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+"]";
    }
}
