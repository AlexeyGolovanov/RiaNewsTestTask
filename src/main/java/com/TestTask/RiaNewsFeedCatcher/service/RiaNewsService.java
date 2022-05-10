package com.TestTask.RiaNewsFeedCatcher.service;

import com.TestTask.RiaNewsFeedCatcher.HtmlDoc;
import com.TestTask.RiaNewsFeedCatcher.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiaNewsService {
    @Autowired
    private NewsRepository newsRepository;

    public void FillNewsTable()
    {
        var doc = new HtmlDoc("https://ria.ru/");
        for (var record:doc.records)
        {
            newsRepository.save(record);
        }
    }
}
