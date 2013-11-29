package dto;

public class Instancetype {
 public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
@Override
	public String toString() {
		return "Instancetype [resId=" + resId + ", InstanceType="
				+ InstanceType + ", imgId=" + imgId + "]";
	}
private String resId;
 private String InstanceType;
 private String imgId;
 private String keyname;
public String getImgId() {
	return imgId;
}
public void setImgId(String imgId) {
	this.imgId = imgId;
}
public String getResId() {
	return resId;
}
public void setResId(String resId) {
	this.resId = resId;
}
public String getInstanceType() {
	return InstanceType;
}
public void setInstanceType(String instanceType) {
	InstanceType = instanceType;
}
}
