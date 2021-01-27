/**
 * @Title: CkEditorUploadResp.java
 * @Package cn.osxm.springboot.model
 * @Description: TODO
 * @author oscarchen
 * @date 2021年1月23日
 * @version V1.0
 */
package cn.osxm.springboot.model;

/**
 * @ClassName: CkEditorUploadResp
 * @Description: TODO
 * @author oscarchen
 */
public class CkEditorUploadResp {

	private boolean uploaded;

	private String url;

	public boolean isUploaded() {
		return uploaded;
	}

	public void setUploaded(boolean uploaded) {
		this.uploaded = uploaded;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
