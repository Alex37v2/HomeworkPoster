package ru.netology.homework.manager;

import org.junit.jupiter.api.Test;
import ru.netology.homework.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();

    private Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    private Movie second = new Movie(2, "Ahead", "http://", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    private Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    private Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    private Movie sixth = new Movie(6, "Trolls", "http://", "cartoon");
    private Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    private Movie eighth = new Movie(8, "NumberTwo", "http://", "actionMovie");
    private Movie ninth = new Movie(9, "NumberThree", "http://", "actionMovie");
    private Movie tenth = new Movie(10, "NumberFour", "http://", "actionMovie");

    Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};


    @Test
    void mustShowTenMovie() {
        PosterManager manager = new PosterManager(10);
        manager.findAll(first);
        manager.findAll(second);
        manager.findAll(third);
        manager.findAll(fourth);
        manager.findAll(fifth);
        manager.findAll(sixth);
        manager.findAll(seventh);
        manager.findAll(eighth);
        manager.findAll(ninth);
        manager.findAll(tenth);
        Movie[] actual = manager.getFindLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNothing() {
        PosterManager manager = new PosterManager(0);
        Movie[] actual = manager.getFindLast();
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowValid() {
        PosterManager manager = new PosterManager(5);
        manager.findAll(first);
        manager.findAll(second);
        manager.findAll(third);
        manager.findAll(fourth);
        manager.findAll(fifth);
        manager.findAll(sixth);
        manager.findAll(seventh);
        manager.findAll(eighth);
        manager.findAll(ninth);
        manager.findAll(tenth);
        Movie movieToAdd = new Movie(11, "NumberFive", "http://", "horrors");
        manager.findAll(movieToAdd);
        Movie[] actual = manager.getFindLast();
        Movie[] expected = {new Movie(11, "NumberFive", "http://", "horrors"), tenth, ninth, eighth, seventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowOverMax() {
        PosterManager manager = new PosterManager(11);
        manager.findAll(first);
        manager.findAll(second);
        manager.findAll(third);
        manager.findAll(fourth);
        manager.findAll(fifth);
        manager.findAll(sixth);
        manager.findAll(seventh);
        manager.findAll(eighth);
        manager.findAll(ninth);
        manager.findAll(tenth);
        Movie[] actual = manager.getFindLast();

        assertArrayEquals(expected, actual);
    }
}