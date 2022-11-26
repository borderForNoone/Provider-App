package com.entity;

public class ServiceDetails {
	
	private int serviceId;
	private String serviceName;
	private String provider;
	private String price;
	private String serviceCategory;
	private String status;
	private String photoName;
	private String email;
	
	public ServiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceDetails(String serviceName, String provider, String price, String serviceCategory, String status,
			String photoName, String email) {
		super();
		this.serviceName = serviceName;
		this.provider = provider;
		this.price = price;
		this.serviceCategory = serviceCategory;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ServiceDetails [serviceId=" + serviceId + ", serviceName=" + serviceName + ", provider=" + provider
				+ ", price=" + price + ", serviceCategory=" + serviceCategory + ", status=" + status + ", photoName="
				+ photoName + ", email=" + email + "]";
	}
	
	
	

}
