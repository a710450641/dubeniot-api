/**
 * 
 */
package com.dubeniot.result.pojo;

import com.dubeniot.pojo.IotHouse;

/**
 * @author BUB-4
 *
 */
public class HouseResult {
	 private Integer id;

	    private Integer userid;

	    private String housename;

	    private String picurl;
	    public HouseResult(){
	    	
	    }
	    
	    public HouseResult(IotHouse house){
	    	this.id=house.getHouseid();
	    	this.userid=house.getUserid();
	    	this.housename=house.getHousename();
	    	this.picurl=house.getPicurl();
	    }
	    public static HouseResult getHouse(IotHouse house){
			return new HouseResult(house);
	    	
	    }
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * @return the userid
		 */
		public Integer getUserid() {
			return userid;
		}

		/**
		 * @param userid the userid to set
		 */
		public void setUserid(Integer userid) {
			this.userid = userid;
		}

		/**
		 * @return the housename
		 */
		public String getHousename() {
			return housename;
		}

		/**
		 * @param housename the housename to set
		 */
		public void setHousename(String housename) {
			this.housename = housename;
		}

		/**
		 * @return the picurl
		 */
		public String getPicurl() {
			return picurl;
		}

		/**
		 * @param picurl the picurl to set
		 */
		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}

}
