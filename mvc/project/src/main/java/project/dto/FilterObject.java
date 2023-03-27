package project.dto;

import java.util.List;

public class FilterObject {
	private String keyword;
	private int country_id;
	private List<Integer> cities;
	private List<Integer> themes;
	private List<Integer> skills;
	private int currentPage;
	private String sortBy;
	String[] ORDER_BY={"NO_ORDER","NEWEST","OLDEST"};
	public FilterObject(){
		super();
	}
	
	public FilterObject(String keyword, int country_id, List<Integer> cities, List<Integer> themes,
			List<Integer> skills, int currentPage, String sortBy) {
		super();
		this.keyword = keyword;
		this.country_id = country_id;
		this.cities = cities;
		this.themes = themes;
		this.skills = skills;
		this.currentPage = currentPage;
		this.sortBy = sortBy;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public List<Integer> getCities() {
		return cities;
	}
	public void setCities(List<Integer> cities) {
		this.cities = cities;
	}
	public List<Integer> getThemes() {
		return themes;
	}
	public void setThemes(List<Integer> themes) {
		this.themes = themes;
	}
	public List<Integer> getSkills() {
		return skills;
	}
	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(int sortBy) {
		if(sortBy<0||sortBy>6) {
			sortBy=0;
		}			
		this.sortBy = ORDER_BY[sortBy];
	}
	@Override
	public String toString() {
		return "FilterObject [keyword=" + keyword + ", country_id=" + country_id + ", cities=" + cities + ", themes="
				+ themes + ", skills=" + skills + "]";
	}
	
}
