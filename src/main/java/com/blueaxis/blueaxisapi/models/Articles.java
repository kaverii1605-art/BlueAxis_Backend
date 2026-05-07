package com.blueaxis.blueaxisapi.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "articles")
public class Articles {
	


	private Long id;

	private String category;
	
	private String title;
	

	    private String imageUrl;


	    private String content;

	    private LocalDateTime createdAt;
	    
	    public Articles() {
	        this.createdAt = LocalDateTime.now();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "Articles [id=" + id + ", category=" + category + ", title=" + title + ", imageUrl=" + imageUrl
					+ ", content=" + content + ", createdAt=" + createdAt + "]";
		}
	    
	    

}
