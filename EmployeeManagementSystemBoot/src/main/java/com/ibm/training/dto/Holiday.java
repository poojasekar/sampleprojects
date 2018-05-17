package com.ibm.training.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Holiday {
	
	 	private int e_id; 
		private int no_of_days;
		private String status; 
		
		public Holiday() {}

		public Holiday(int e_id, int no_of_days, String status) {
			super();
			this.e_id = e_id;
			this.no_of_days = no_of_days;
			this.status = status;
		}

		public int getE_id() {
			return e_id;
		}

		public void setE_id(int e_id) {
			this.e_id = e_id;
		}

		public int getNo_of_days() {
			return no_of_days;
		}

		public void setNo_of_days(int no_of_days) {
			this.no_of_days = no_of_days;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
		

}
