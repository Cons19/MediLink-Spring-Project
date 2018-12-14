package com.exam.medilink.repositories;

import com.exam.medilink.models.News;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NewsRepositoryTest {

    private NewsRepository mNewsCrudRepository;
    private Lorem mLorem;
    private List<News> mPlaceholderNews;

    @Before
    public void setUp() {
        mNewsCrudRepository = (NewsRepository) NewsRepository.getInstance();
        mLorem = LoremIpsum.getInstance();
        mPlaceholderNews = new ArrayList<>();

        Lorem lorem = LoremIpsum.getInstance();
        for (int i = 0; i < 10; i++) {
            mPlaceholderNews.add(new News(mPlaceholderNews.size(), lorem.getTitle(5, 10), lorem.getParagraphs(1, 4)));
        }
        mNewsCrudRepository.saveItems(mPlaceholderNews);
    }

    @Test
    public void create() {
        News item = new News(-1, mLorem.getTitle(5), mLorem.getParagraphs(1, 4));
        mPlaceholderNews.add(item);
        int id = mPlaceholderNews.indexOf(item);
        int id2 = mNewsCrudRepository.create(item);
        assertEquals(id, id2);
        assertNotEquals(-1, id2);
        assertEquals(mNewsCrudRepository.read(id2), mPlaceholderNews.get(id2));
    }

    @Test
    public void readAll() {
        assertNotNull(mNewsCrudRepository.readAll());
        assertEquals(mNewsCrudRepository.readAll(), mPlaceholderNews);
    }

    @Test
    public void readOne() {
        for (int i = 0; i < mPlaceholderNews.size(); i++) {
            assertEquals(mNewsCrudRepository.read(i), mPlaceholderNews.get(i));
        }
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}