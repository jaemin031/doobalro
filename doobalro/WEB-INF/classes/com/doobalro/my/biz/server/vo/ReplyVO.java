package com.doobalro.my.biz.server.vo;

public class ReplyVO {
	private int replyNum;
	private int boardNum;
	private String replyContent;
	private String replyWriter;
	private String replyDate;
	
	public ReplyVO() {	}
	
	public ReplyVO(int replyNum, String replyContent, String replyDate) {
		super();
		this.replyNum = replyNum;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	public ReplyVO(int boardNum, String replyContent, String replyWriter, String replyDate) {
		this.boardNum = boardNum;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.replyDate = replyDate;
	}
	public ReplyVO(int replyNum, int boardNum, String replyContent, String replyWriter, String replyDate) {
		this.replyNum = replyNum;
		this.boardNum = boardNum;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.replyDate = replyDate;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNum;
		result = prime * result + ((replyContent == null) ? 0 : replyContent.hashCode());
		result = prime * result + ((replyDate == null) ? 0 : replyDate.hashCode());
		result = prime * result + replyNum;
		result = prime * result + ((replyWriter == null) ? 0 : replyWriter.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyVO other = (ReplyVO) obj;
		if (boardNum != other.boardNum)
			return false;
		if (replyContent == null) {
			if (other.replyContent != null)
				return false;
		} else if (!replyContent.equals(other.replyContent))
			return false;
		if (replyDate == null) {
			if (other.replyDate != null)
				return false;
		} else if (!replyDate.equals(other.replyDate))
			return false;
		if (replyNum != other.replyNum)
			return false;
		if (replyWriter == null) {
			if (other.replyWriter != null)
				return false;
		} else if (!replyWriter.equals(other.replyWriter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNum=" + replyNum + ", boardNum=" + boardNum + ", replyContent=" + replyContent
				+ ", replyWriter=" + replyWriter + ", replyDate=" + replyDate + "]";
	}
	
}
