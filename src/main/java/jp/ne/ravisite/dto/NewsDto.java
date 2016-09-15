package jp.ne.ravisite.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class NewsDto implements Serializable{

	private static final long serialVersionUID = -1344133557230294718L;

	private Integer seqNo;

	private String title;

	private String url;

	private String newFlag;

	private Timestamp createTime;

	private Timestamp updateTime;

	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

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

	public String getNewFlag() {
		return this.newFlag;
	}

 	public void setNewFlag(String newFlag) {
 		this.newFlag = newFlag;
 	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
