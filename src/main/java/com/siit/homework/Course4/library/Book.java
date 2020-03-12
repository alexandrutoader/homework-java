package com.siit.homework.Course4.library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private int pages;
    private String type;
    private List<Novel>attachedNovel;
    private List<Album>attachedAlbum;

    public Book() {
        this.attachedNovel = new ArrayList<Novel>();
        this.attachedAlbum = new ArrayList<Album>();
    }

    public void addNovel(Novel novel) {
        this.attachedNovel.add(novel);
    }

    public void deleteNovel(Novel novel) {
        this.attachedNovel.remove(novel);
    }

    public void addAlbum(Album album) {
        this.attachedAlbum.add(album);
    }

    public void deleteAlbum(Album album) {
        this.attachedAlbum.remove(album);
    }

    public void listBooks() {
        if (!this.getAttachedNovel().isEmpty()) {
            System.out.println("\nNovels:");
        }
        for (Novel novel:this.getAttachedNovel()) {
            System.out.println("Name: " + novel.getName());
            System.out.println("Number of pages: " + novel.getPages());
            System.out.println("Type: " + novel.getType() + "\n");
        }

        if (!this.getAttachedAlbum().isEmpty()) {
            System.out.println("--------------------------\n");
            System.out.println("Albums:");
        }

        for (Album album:this.getAttachedAlbum()) {
            System.out.println("Name: " + album.getName());
            System.out.println("Number of pages: " + album.getPages());
            System.out.println("Paper quality: " + album.getPaperQuality() + "\n");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Novel> getAttachedNovel() {
        return attachedNovel;
    }

    public void setAttachedNovel(List<Novel> attachedNovel) {
        this.attachedNovel = attachedNovel;
    }

    public List<Album> getAttachedAlbum() {
        return attachedAlbum;
    }

    public void setAttachedAlbum(List<Album> attachedAlbum) {
        this.attachedAlbum = attachedAlbum;
    }
}
