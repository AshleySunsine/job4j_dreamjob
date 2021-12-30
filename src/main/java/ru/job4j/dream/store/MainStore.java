package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.savePost(new Post(0, "Java Job"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        store.savePost(new Post(1, "Jaga-Jaga Job"));
        System.out.println(store.findByIdPost(1).getId() + " " + store.findByIdPost(1).getName());
    }
}