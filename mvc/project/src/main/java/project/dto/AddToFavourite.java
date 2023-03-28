package project.dto;

public class AddToFavourite {
	private int user_id;
	private int mission_id;
	public AddToFavourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddToFavourite(int user_id, int mission_id) {
		super();
		this.user_id = user_id;
		this.mission_id = mission_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMission_id() {
		return mission_id;
	}
	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}
	@Override
	public String toString() {
		return "AddToFavourite [user_id=" + user_id + ", mission_id=" + mission_id + "]";
	}
	
}
