package com.doobalro.my.biz.server.vo;

public class WeatherVO {
	double lat;
	double lon;
	String name;
	String nowTime;
	String status;
	double tmp;
	double wind;
	String info;
	public WeatherVO() {
	}
	public WeatherVO(double lat, double lon, String name, String nowTime, String status, double tmp, double wind,
			String info) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
		this.nowTime = nowTime;
		this.status = status;
		this.tmp = tmp;
		this.wind = wind;
		this.info = info;
	}

	public WeatherVO(double lat, double lon, String name, String nowTime, String status, double tmp, double wind) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
		this.nowTime = nowTime;
		this.status = status;
		this.tmp = tmp;
		this.wind = wind;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNowTime() {
		return nowTime;
	}
	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTmp() {
		return tmp;
	}
	public void setTmp(double tmp) {
		this.tmp = tmp;
	}
	public double getWind() {
		return wind;
	}
	public void setWind(double wind) {
		this.wind = wind;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "WeatherVO [lat=" + lat + ", lon=" + lon + ", name=" + name + ", nowTime=" + nowTime + ", status="
				+ status + ", tmp=" + tmp + ", wind=" + wind + ", info=" + info + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nowTime == null) ? 0 : nowTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(tmp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wind);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherVO other = (WeatherVO) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nowTime == null) {
			if (other.nowTime != null)
				return false;
		} else if (!nowTime.equals(other.nowTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(tmp) != Double.doubleToLongBits(other.tmp))
			return false;
		if (Double.doubleToLongBits(wind) != Double.doubleToLongBits(other.wind))
			return false;
		return true;
	}
	
}
