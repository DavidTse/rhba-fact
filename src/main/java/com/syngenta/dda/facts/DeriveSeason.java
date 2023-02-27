package com.syngenta.dda.facts;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeriveSeason implements Serializable {

	private static final long serialVersionUID = 2133005614530205705L;

	private Integer harvestYear;
	private String month;
	private String country;
	private String season;
	private Boolean isValid = false;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> errorList = new ArrayList<>();

	public Integer getHarvestYear() {
		return harvestYear;
	}

	public void setHarvestYear(Integer harvestYear) {
		this.harvestYear = harvestYear;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {

		if (season != null) {
			if (season.equals("UNDEFINED")) {
				this.season = season;
			} else if (season.equals("Dry") || 
					   season.equals("Wet") || 
					   season.equals("Winter") ||
					   season.equals("Summer")) {
				this.season = season + "-" + this.harvestYear;
			} else {
				this.season = season;
			}
		}
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
