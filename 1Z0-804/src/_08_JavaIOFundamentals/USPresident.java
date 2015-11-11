package _08_JavaIOFundamentals;

import java.io.Serializable;

class USPresident implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private String period;
	private transient String term;

	public USPresident(String name, String period, String term) {
		this.name = name;
		this.period = period;
		this.term = term;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
return "US President [name=" + name + ", period=" + period + ", term=" + term + "]";
	}

}