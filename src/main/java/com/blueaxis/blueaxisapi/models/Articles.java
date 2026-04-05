package com.blueaxis.blueaxisapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="articles")
public class Articles {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String category;
	
	private String title;
	
	 @Column(name = "image_url")
	    private String imageUrl;

	    @Column(columnDefinition = "LONGTEXT")
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
