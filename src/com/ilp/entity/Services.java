package com.ilp.entity;

public class Services
{

		private String serviceCode;
		private String serviceName;
		private double rate;
		
		
		public Services(String serviceCode, String serviceName, double rate) 
		
		{
			this.serviceCode = serviceCode;
			this.serviceName = serviceName;
			this.rate = rate;
		}
		
		public String getServiceCode() {
			return serviceCode;
		}
		public void setServiceCode(String serviceCode) {
			this.serviceCode = serviceCode;
		}
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}

		@Override
		public String toString() {
			return "Services [serviceCode=" + serviceCode + ", serviceName=" + serviceName + ", rate=" + rate
					+ ", getServiceCode()=" + getServiceCode() + ", getServiceName()=" + getServiceName()
					+ ", getRate()=" + getRate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
		
		
		
}
