package com.blueaxis.blueaxisapi.dto;

public class BlogSummaryDto {
    private Long id;
    private String title;
    private String category;
    private String imageUrl;

    public BlogSummaryDto(Long id, String title, String category, String imageUrl) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
