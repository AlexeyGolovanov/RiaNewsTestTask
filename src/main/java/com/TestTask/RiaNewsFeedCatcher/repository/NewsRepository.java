package com.TestTask.RiaNewsFeedCatcher.repository;

import com.TestTask.RiaNewsFeedCatcher.model.NewsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsRecord, Long> {
}
