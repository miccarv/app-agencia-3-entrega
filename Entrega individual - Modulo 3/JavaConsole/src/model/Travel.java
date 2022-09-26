package model;

public class Travel {
	private String destiny;
	private String date;
	private String duration;
	private String id;

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Travel [destiny=" + destiny + ", date=" + date + ", duration=" + duration + ", id=" + id + "]";
	}

}
