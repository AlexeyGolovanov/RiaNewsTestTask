package com.TestTask.RiaNewsFeedCatcher.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "news")
public class NewsRecord
{
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String Title;
    @Column(name = "text")
    private String Text;
    @Column(name = "date_time")
    private LocalDateTime DateTime;


    public NewsRecord() {
    }
    public NewsRecord (String id, String title, String text, LocalDateTime date)
    {
        this.id = id;
        this.Title = title;
        this.Text = text;
        this.DateTime = date;
    }

    public String GetId()
    {
        return id;
    }
    public String GetTitle()
    {
        return Title;
    }
    public void SetTitle(String title)
    {
        this.Title = title;
    }
    public String GetText()
    {
        return Text;
    }
    public void SetText(String text)
    {
        this.Text = text;
    }
    public LocalDateTime GetDateTime()
    {
        return DateTime;
    }
    public void SetDateTime(LocalDateTime dateTime)
    {
        this.DateTime = dateTime;
    }

    @Override
    public String toString() {
        return "NewsRecord [id=" + id + ", title=" + Title + ", text=" + Text + ", dateTime=" + DateTime.toString() + "]";
    }

}
