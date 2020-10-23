package com.doobalro.my.biz.server.vo;

import java.io.Serializable;

public class BoardVO implements Serializable{
	private int boardNum;
	private int userNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private int boardCnt;
	private int boardRCnt;
	
	public BoardVO() {	}
	public BoardVO(int userNum, String boardWriter, String boardTitle, String boardContent, String boardDate,
			int boardCnt, int boardRCnt) {
		this.userNum = userNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCnt = boardCnt;
		this.boardRCnt = boardRCnt;
	}
	public BoardVO(int boardNum, int userNum, String boardWriter, String boardTitle, String boardContent,
			String boardDate, int boardCnt, int boardRCnt) {
		this.boardNum = boardNum;
		this.userNum = userNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCnt = boardCnt;
		this.boardRCnt = boardRCnt;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardCnt() {
		return boardCnt;
	}
	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}
	public int getBoardRCnt() {
		return boardRCnt;
	}
	public void setBoardRCnt(int boardRCnt) {
		this.boardRCnt = boardRCnt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardCnt;
		result = prime * result + ((boardContent == null) ? 0 : boardContent.hashCode());
		result = prime * result + ((boardDate == null) ? 0 : boardDate.hashCode());
		result = prime * result + boardNum;
		result = prime * result + boardRCnt;
		result = prime * result + ((boardTitle == null) ? 0 : boardTitle.hashCode());
		result = prime * result + ((boardWriter == null) ? 0 : boardWriter.hashCode());
		result = prime * result + userNum;
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
		BoardVO other = (BoardVO) obj;
		if (boardCnt != other.boardCnt)
			return false;
		if (boardContent == null) {
			if (other.boardContent != null)
				return false;
		} else if (!boardContent.equals(other.boardContent))
			return false;
		if (boardDate == null) {
			if (other.boardDate != null)
				return false;
		} else if (!boardDate.equals(other.boardDate))
			return false;
		if (boardNum != other.boardNum)
			return false;
		if (boardRCnt != other.boardRCnt)
			return false;
		if (boardTitle == null) {
			if (other.boardTitle != null)
				return false;
		} else if (!boardTitle.equals(other.boardTitle))
			return false;
		if (boardWriter == null) {
			if (other.boardWriter != null)
				return false;
		} else if (!boardWriter.equals(other.boardWriter))
			return false;
		if (userNum != other.userNum)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", userNum=" + userNum + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardCnt=" + boardCnt + ", boardRCnt=" + boardRCnt + "]";
	}
	
}
