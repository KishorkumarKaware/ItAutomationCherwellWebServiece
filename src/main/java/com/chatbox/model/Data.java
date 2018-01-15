package com.chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data
{
	private String timestamp;

    private String text;

    private String localTimestamp;

    private String source;

    private Address address;

    private String[] attachments;

    private String type;

    private User user;

    private SourceEvent sourceEvent;

    private Entities[] entities;

    private String agent;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getLocalTimestamp ()
    {
        return localTimestamp;
    }

    public void setLocalTimestamp (String localTimestamp)
    {
        this.localTimestamp = localTimestamp;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public Address getAddress ()
    {
        return address;
    }

    public void setAddress (Address address)
    {
        this.address = address;
    }

    public String[] getAttachments ()
    {
        return attachments;
    }

    public void setAttachments (String[] attachments)
    {
        this.attachments = attachments;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    public SourceEvent getSourceEvent ()
    {
        return sourceEvent;
    }

    public void setSourceEvent (SourceEvent sourceEvent)
    {
        this.sourceEvent = sourceEvent;
    }

    public Entities[] getEntities ()
    {
        return entities;
    }

    public void setEntities (Entities[] entities)
    {
        this.entities = entities;
    }

    public String getAgent ()
    {
        return agent;
    }

    public void setAgent (String agent)
    {
        this.agent = agent;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", text = "+text+", localTimestamp = "+localTimestamp+", source = "+source+", address = "+address+", attachments = "+attachments+", type = "+type+", user = "+user+", sourceEvent = "+sourceEvent+", entities = "+entities+", agent = "+agent+"]";
    }
}
	


