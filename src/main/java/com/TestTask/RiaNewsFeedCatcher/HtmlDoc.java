package com.TestTask.RiaNewsFeedCatcher;

import com.TestTask.RiaNewsFeedCatcher.model.NewsRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class HtmlDoc
{
    public String WebPath;
    public ArrayList<NewsRecord> records;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");

    public HtmlDoc (String webPath)
    {
        WebPath = webPath;
        records = new ArrayList<>() {
        };
        FillRecords();
    }

    private void FillRecords()
    {
        try
        {
                Document mainPage = Jsoup.connect(WebPath)
                        .get();
                var newsList = Objects.requireNonNull(mainPage.select("div.cell-list__list").first()).select("div.cell-list__item.m-no-image");
                for (var element: newsList)
                {
                    var id = element.select("span.share").attr("data-id");
                    var reference = element.select("a.cell-list__item-link").attr("href");
                    var recPage = Jsoup.connect(reference).get();
                    var title = recPage.select("div.article__title").text();
                    var textBlocks = recPage.select("div.article__block[data-type=text]");
                    StringBuilder text = new StringBuilder();
                    for (var block:textBlocks)
                    {
                        text.append(block.text()).append("\n");
                    }
                    var dateString = recPage.select("div.article__info-date").select("a").text();
                    var date = LocalDateTime.parse(dateString, formatter);

                    records.add(new NewsRecord(id,title, text.toString(), date));
                }

        }
        catch (Exception exception)
        {
        }
    }
}
