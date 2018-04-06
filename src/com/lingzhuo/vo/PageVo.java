package com.lingzhuo.vo;
//封装分页参数，页码、总页数，总记录数，偏移量，每页显示的行记录数
public class PageVo {
	private Integer pageNow;//当前页码
	private  Integer total;//总记录数；查询
	private Integer pageSize=5;//每页显示几条记录
	private Integer offset;//每页第一条记录，在数据库是第几条（计算）
	private Integer pageTotal;//总页数（计算）
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
		//封装页码时，直接结算偏移量offset
		this.offset=this.pageSize*(this.pageNow-1)+1;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
		//计算总页数
		if(this.total%this.pageSize==0){
			this.pageTotal=this.total/this.pageSize;
		}else{
			this.pageTotal=this.total/this.pageSize+1;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	
  
}
