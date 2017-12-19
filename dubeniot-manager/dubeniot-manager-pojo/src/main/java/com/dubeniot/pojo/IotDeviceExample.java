package com.dubeniot.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IotDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IotDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Integer value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Integer value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Integer value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Integer value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Integer value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Integer> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Integer> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Integer value1, Integer value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDevicemacIsNull() {
            addCriterion("deviceMac is null");
            return (Criteria) this;
        }

        public Criteria andDevicemacIsNotNull() {
            addCriterion("deviceMac is not null");
            return (Criteria) this;
        }

        public Criteria andDevicemacEqualTo(String value) {
            addCriterion("deviceMac =", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacNotEqualTo(String value) {
            addCriterion("deviceMac <>", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacGreaterThan(String value) {
            addCriterion("deviceMac >", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacGreaterThanOrEqualTo(String value) {
            addCriterion("deviceMac >=", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacLessThan(String value) {
            addCriterion("deviceMac <", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacLessThanOrEqualTo(String value) {
            addCriterion("deviceMac <=", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacLike(String value) {
            addCriterion("deviceMac like", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacNotLike(String value) {
            addCriterion("deviceMac not like", value, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacIn(List<String> values) {
            addCriterion("deviceMac in", values, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacNotIn(List<String> values) {
            addCriterion("deviceMac not in", values, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacBetween(String value1, String value2) {
            addCriterion("deviceMac between", value1, value2, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDevicemacNotBetween(String value1, String value2) {
            addCriterion("deviceMac not between", value1, value2, "devicemac");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberIsNull() {
            addCriterion("deviceSerialNumber is null");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberIsNotNull() {
            addCriterion("deviceSerialNumber is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberEqualTo(String value) {
            addCriterion("deviceSerialNumber =", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberNotEqualTo(String value) {
            addCriterion("deviceSerialNumber <>", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberGreaterThan(String value) {
            addCriterion("deviceSerialNumber >", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberGreaterThanOrEqualTo(String value) {
            addCriterion("deviceSerialNumber >=", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberLessThan(String value) {
            addCriterion("deviceSerialNumber <", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberLessThanOrEqualTo(String value) {
            addCriterion("deviceSerialNumber <=", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberLike(String value) {
            addCriterion("deviceSerialNumber like", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberNotLike(String value) {
            addCriterion("deviceSerialNumber not like", value, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberIn(List<String> values) {
            addCriterion("deviceSerialNumber in", values, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberNotIn(List<String> values) {
            addCriterion("deviceSerialNumber not in", values, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberBetween(String value1, String value2) {
            addCriterion("deviceSerialNumber between", value1, value2, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDeviceserialnumberNotBetween(String value1, String value2) {
            addCriterion("deviceSerialNumber not between", value1, value2, "deviceserialnumber");
            return (Criteria) this;
        }

        public Criteria andDevicetypeIsNull() {
            addCriterion("deviceType is null");
            return (Criteria) this;
        }

        public Criteria andDevicetypeIsNotNull() {
            addCriterion("deviceType is not null");
            return (Criteria) this;
        }

        public Criteria andDevicetypeEqualTo(String value) {
            addCriterion("deviceType =", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotEqualTo(String value) {
            addCriterion("deviceType <>", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeGreaterThan(String value) {
            addCriterion("deviceType >", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("deviceType >=", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeLessThan(String value) {
            addCriterion("deviceType <", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeLessThanOrEqualTo(String value) {
            addCriterion("deviceType <=", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeLike(String value) {
            addCriterion("deviceType like", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotLike(String value) {
            addCriterion("deviceType not like", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeIn(List<String> values) {
            addCriterion("deviceType in", values, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotIn(List<String> values) {
            addCriterion("deviceType not in", values, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeBetween(String value1, String value2) {
            addCriterion("deviceType between", value1, value2, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotBetween(String value1, String value2) {
            addCriterion("deviceType not between", value1, value2, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDeviceversionIsNull() {
            addCriterion("deviceVersion is null");
            return (Criteria) this;
        }

        public Criteria andDeviceversionIsNotNull() {
            addCriterion("deviceVersion is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceversionEqualTo(String value) {
            addCriterion("deviceVersion =", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionNotEqualTo(String value) {
            addCriterion("deviceVersion <>", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionGreaterThan(String value) {
            addCriterion("deviceVersion >", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionGreaterThanOrEqualTo(String value) {
            addCriterion("deviceVersion >=", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionLessThan(String value) {
            addCriterion("deviceVersion <", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionLessThanOrEqualTo(String value) {
            addCriterion("deviceVersion <=", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionLike(String value) {
            addCriterion("deviceVersion like", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionNotLike(String value) {
            addCriterion("deviceVersion not like", value, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionIn(List<String> values) {
            addCriterion("deviceVersion in", values, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionNotIn(List<String> values) {
            addCriterion("deviceVersion not in", values, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionBetween(String value1, String value2) {
            addCriterion("deviceVersion between", value1, value2, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andDeviceversionNotBetween(String value1, String value2) {
            addCriterion("deviceVersion not between", value1, value2, "deviceversion");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}