package app.web.form;

import org.apache.struts.action.ActionForm;

import app.util.Constant;

public class BaseForm extends ActionForm {

	private static final long serialVersionUID = 3324174335977806119L;
	
	private int offset;
	private int pageSize;
	
	public int getOffset() {
		return offset <= 0 ? 0 : offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public int getPageSize() {
		return pageSize <= 0 ? Constant.DEFAULT_PAGE_SIZE : pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
