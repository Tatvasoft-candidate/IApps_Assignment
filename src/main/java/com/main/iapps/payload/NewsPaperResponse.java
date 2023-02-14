package com.main.iapps.payload;

import java.util.List;

import com.main.iapps.dto.NewsPaperDTO;

public class NewsPaperResponse {

	private List<NewsPaperDTO> newsPapers;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    
    public NewsPaperResponse() {}

	public NewsPaperResponse(List<NewsPaperDTO> newsPapers, int pageNo, int pageSize, long totalElements,
			int totalPages, boolean last) {
		this.newsPapers = newsPapers;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}

	public List<NewsPaperDTO> getNewsPapers() {
		return newsPapers;
	}

	public void setNewsPapers(List<NewsPaperDTO> newsPapers) {
		this.newsPapers = newsPapers;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
    
    
}
