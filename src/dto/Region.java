package dto;

public class Region {
	private String regionName;
	public String getRegionEndpoint() {
		return regionEndpoint;
	}
	public void setRegionEndpoint(String regionEndpoint) {
		this.regionEndpoint = regionEndpoint;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	private String regionEndpoint;

}
