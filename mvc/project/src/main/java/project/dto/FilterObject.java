package project.dto;

import java.util.List;

public class FilterObject {
	private String keyword;
	private int country_id;
	private List<Integer> cities;
	private List<Integer> themes;
	private List<Integer> skills;
	public FilterObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterObject(String keyword, int country_id, List<Integer> cities, List<Integer> themes,
			List<Integer> skills) {
		super();
		this.keyword = keyword;
		this.country_id = country_id;
		this.cities = cities;
		this.themes = themes;
		this.skills = skills;
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
	@Override
	public String toString() {
		return "FilterObject [keyword=" + keyword + ", country_id=" + country_id + ", cities=" + cities + ", themes="
				+ themes + ", skills=" + skills + "]";
	}
	
	
	
}
