package com.TestTask.RiaNewsFeedCatcher;

import com.TestTask.RiaNewsFeedCatcher.model.NewsRecord;
import com.TestTask.RiaNewsFeedCatcher.repository.NewsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class RiaNewsFeedCatcherApplicationTests {

	@Autowired
	private NewsRepository news;

	@Test
	void contextLoads() {
	}

}
