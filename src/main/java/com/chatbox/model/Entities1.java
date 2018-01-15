package com.chatbox.model;

public class Entities1
{
    private String start;

    private String extractor;

    private String entity;

    private String value;

    private String end;

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getExtractor ()
    {
        return extractor;
    }

    public void setExtractor (String extractor)
    {
        this.extractor = extractor;
    }

    public String getEntity ()
    {
        return entity;
    }

    public void setEntity (String entity)
    {
        this.entity = entity;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getEnd ()
    {
        return end;
    }

    public void setEnd (String end)
    {
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [start = "+start+", extractor = "+extractor+", entity = "+entity+", value = "+value+", end = "+end+"]";
    }
}
			
		