package project.dto;

public class PostCommentDto {
	private int mission_id;
	private String comment;
	public PostCommentDto() {
		super();
	}
	public PostCommentDto(int mission_id, String comment) {
		super();
		this.mission_id = mission_id;
		this.comment = comment;
	}
	public int getMission_id() {
		return mission_id;
	}
	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "PostCommentDto [mission_id=" + mission_id + ", comment=" + comment + "]";
	}
	
	
}
