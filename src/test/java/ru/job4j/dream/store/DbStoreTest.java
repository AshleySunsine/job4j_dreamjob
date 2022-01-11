package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.Candidate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class DbStoreTest {

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        Post postInDb = store.findByIdPost(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenDeletePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        store.deletePost(post.getId());
        Post postInDb = store.findByIdPost(post.getId());
        assertNull(postInDb);
    }

    @Test
    public void findByIdPost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        Post candidateInDb = store.findByIdPost(post.getId());
        assertEquals(candidateInDb, post);
    }


    @Test
    public void findByIdCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Java Job", 0);
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertEquals(candidateInDb, candidate);
    }

    @Test
    public void whenCreateCandidates() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Java Job", 0);
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Java Job", 0);
        store.saveCandidate(candidate);
        store.deleteCandidate(candidate.getId());
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertNull(candidateInDb);
    }
}