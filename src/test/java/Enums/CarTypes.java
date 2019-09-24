package Enums;

public enum CarTypes {
	LITE("Lite"), EXECUTIVE("Executive");
	
	private String carType;
	
	private CarTypes(String carType) {
		this.carType = carType;
	}
	
	public String getCarType() {
		return this.carType;
	}
}
