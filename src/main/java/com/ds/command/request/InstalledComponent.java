package com.ds.command.request;

import java.util.Objects;

public class InstalledComponent {

	private String name;
	private Boolean isExplicit = false;

	public InstalledComponent(String name) {
		this.name = name;
	}

	public InstalledComponent(String name, boolean isExplicit) {
		this.name = name;
		this.isExplicit = isExplicit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsExplicit() {
		return isExplicit;
	}

	public void setIsExplicit(Boolean isExplicit) {
		this.isExplicit = isExplicit;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.name);
		hash = 97 * hash + Objects.hashCode(this.isExplicit);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final InstalledComponent other = (InstalledComponent) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return true;
	}

}
