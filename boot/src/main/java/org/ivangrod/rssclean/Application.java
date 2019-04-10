package org.ivangrod.rssclean;

import org.ivangrod.rssclean.usecases.rss.CollectFeed;
import org.ivangrod.rssclean.usecases.rss.params.CollectingFeedParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CollectFeed collectFeed;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        collectFeed.execute(new CollectingFeedParams("Netflix", "https://medium.com/feed/netflix-techblog"));
    }
}
