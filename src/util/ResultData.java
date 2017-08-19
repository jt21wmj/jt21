package util;

import java.io.Serializable;

public class ResultData implements Serializable{
	private static final long serialVersionUID = -7743917494685712071L;
	private Integer flag;
	private String msg;
	private Object data;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultData [flag=" + flag + ", msg=" + msg + ", data=" + data
				+ "]";
	}
}
