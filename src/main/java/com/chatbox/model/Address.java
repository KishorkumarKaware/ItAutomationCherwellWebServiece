package com.chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
	private String id;

    private String channelId;

    private Bot bot;

    private Conversation conversation;

    private String serviceUrl;

    private User user;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getChannelId ()
    {
        return channelId;
    }

    public void setChannelId (String channelId)
    {
        this.channelId = channelId;
    }

    public Bot getBot ()
    {
        return bot;
    }

    public void setBot (Bot bot)
    {
        this.bot = bot;
    }

    public Conversation getConversation ()
    {
        return conversation;
    }

    public void setConversation (Conversation conversation)
    {
        this.conversation = conversation;
    }

    public String getServiceUrl ()
    {
        return serviceUrl;
    }

    public void setServiceUrl (String serviceUrl)
    {
        this.serviceUrl = serviceUrl;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", channelId = "+channelId+", bot = "+bot+", conversation = "+conversation+", serviceUrl = "+serviceUrl+", user = "+user+"]";
    }
}

