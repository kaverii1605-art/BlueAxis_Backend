package com.blueaxis.blueaxisapi.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "infographics")

public class Infographic {
	

@Id
		private String id;

	    private String title;

	    private String category;


	    private String imageUrl;


	    private String content;

	    private LocalDateTime createdAt;
	    
	    public Infographic() {
	        this.createdAt = LocalDateTime.now();
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
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
			return "Infographic [id=" + id + ", title=" + title + ", category=" + category + ", imageUrl=" + imageUrl
					+ ", content=" + content + ", createdAt=" + createdAt + "]";
		}

	    

}
