package com.doobalro.my.biz.server.vo;

public class BikeStatusVO {
	String station_name;
	String address;
	double lat;
	double lon;
	int total_bike;
	int available_bike;
	String nowdate;
	String info;
	String location;
	
	public BikeStatusVO() {
		super();
	}

	public BikeStatusVO(String station_name, String address, double lat, double lon, int total_bike, int available_bike,
			String nowdate, String info, String location) {
		super();
		this.station_name = station_name;
		this.address = address;
		this.lat = lat;
		this.lon = lon;
		this.total_bike = total_bike;
		this.available_bike = available_bike;
		this.nowdate = nowdate;
		this.info = info;
		this.location = location;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getTotal_bike() {
		return total_bike;
	}

	public void setTotal_bike(int total_bike) {
		this.total_bike = total_bike;
	}

	public int getAvailable_bike() {
		return available_bike;
	}

	public void setAvailable_bike(int available_bike) {
		this.available_bike = available_bike;
	}

	public String getNowdate() {
		return nowdate;
	}

	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + available_bike;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nowdate == null) ? 0 : nowdate.hashCode());
		result = prime * result + ((station_name == null) ? 0 : station_name.hashCode());
		result = prime * result + total_bike;
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
		BikeStatusVO other = (BikeStatusVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (available_bike != other.available_bike)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (nowdate == null) {
			if (other.nowdate != null)
				return false;
		} else if (!nowdate.equals(other.nowdate))
			return false;
		if (station_name == null) {
			if (other.station_name != null)
				return false;
		} else if (!station_name.equals(other.station_name))
			return false;
		if (total_bike != other.total_bike)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BikeStatusVO [station_name=" + station_name + ", address=" + address + ", lat=" + lat + ", lon=" + lon
				+ ", total_bike=" + total_bike + ", available_bike=" + available_bike + ", nowdate=" + nowdate
				+ ", info=" + info + ", location=" + location + "]";
	}
	
	
}
