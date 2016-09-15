package jp.ne.ravisite.dto;

import java.io.Serializable;

public class GetNewsDto implements Serializable{

	private static final long serialVersionUID = -1903623254219728712L;

	private String title;

	private String url;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
