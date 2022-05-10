package com.TestTask.RiaNewsFeedCatcher.controller;

import com.TestTask.RiaNewsFeedCatcher.service.RiaNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class NewsController
{
    @Autowired
    private RiaNewsService service = new RiaNewsService();

    @PostMapping("/riaNews")
    public ResponseEntity<HttpStatus> SaveCurrentNews()
    {
        try
        {
            service.FillNewsTable();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
