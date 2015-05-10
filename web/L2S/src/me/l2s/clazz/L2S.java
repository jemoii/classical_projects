package me.l2s.clazz;

public class L2S {
	// 版本信息
	private String version;
	// 短链接路径信息
	private String path;

	public L2S() {
		this.version = "5.0";
	}

	public String getVersion() {
		return version;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
