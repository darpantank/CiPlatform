package project.dto;

public class MissionVolunteerIncomingDto {
	private int missionId;
	private int pageNumber;
	public MissionVolunteerIncomingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionVolunteerIncomingDto(int missionId, int pageNumber) {
		super();
		this.missionId = missionId;
		this.pageNumber = pageNumber;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	@Override
	public String toString() {
		return "MissionVolunteerIncomingDto [missionId=" + missionId + ", pageNumber=" + pageNumber + "]";
	}
	
}
