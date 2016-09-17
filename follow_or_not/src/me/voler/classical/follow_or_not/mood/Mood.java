package me.voler.classical.follow_or_not.mood;

public class Mood {
	private String mid;// 心情编号
	private String subject;// 主题（可以为空）
	private String body;// 内容（不可为空）

	/* 其他性质暂时省略 */

	public Mood(String mid, String subject, String body) {
		this.setMid(mid);
		this.setSubject(subject);
		this.setBody(body);
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
