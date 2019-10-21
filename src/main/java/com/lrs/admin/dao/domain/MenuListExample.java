package com.lrs.admin.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuListExample() {
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

        public Criteria andMenuidIsNull() {
            addCriterion("menuid is null");
            return (Criteria) this;
        }

        public Criteria andMenuidIsNotNull() {
            addCriterion("menuid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuidEqualTo(Integer value) {
            addCriterion("menuid =", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotEqualTo(Integer value) {
            addCriterion("menuid <>", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThan(Integer value) {
            addCriterion("menuid >", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuid >=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThan(Integer value) {
            addCriterion("menuid <", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThanOrEqualTo(Integer value) {
            addCriterion("menuid <=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidIn(List<Integer> values) {
            addCriterion("menuid in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotIn(List<Integer> values) {
            addCriterion("menuid not in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidBetween(Integer value1, Integer value2) {
            addCriterion("menuid between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotBetween(Integer value1, Integer value2) {
            addCriterion("menuid not between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andParMenuNameIsNull() {
            addCriterion("par_menu_name is null");
            return (Criteria) this;
        }

        public Criteria andParMenuNameIsNotNull() {
            addCriterion("par_menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andParMenuNameEqualTo(String value) {
            addCriterion("par_menu_name =", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameNotEqualTo(String value) {
            addCriterion("par_menu_name <>", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameGreaterThan(String value) {
            addCriterion("par_menu_name >", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("par_menu_name >=", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameLessThan(String value) {
            addCriterion("par_menu_name <", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameLessThanOrEqualTo(String value) {
            addCriterion("par_menu_name <=", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameLike(String value) {
            addCriterion("par_menu_name like", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameNotLike(String value) {
            addCriterion("par_menu_name not like", value, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameIn(List<String> values) {
            addCriterion("par_menu_name in", values, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameNotIn(List<String> values) {
            addCriterion("par_menu_name not in", values, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameBetween(String value1, String value2) {
            addCriterion("par_menu_name between", value1, value2, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuNameNotBetween(String value1, String value2) {
            addCriterion("par_menu_name not between", value1, value2, "parMenuName");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlIsNull() {
            addCriterion("par_menu_url is null");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlIsNotNull() {
            addCriterion("par_menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlEqualTo(String value) {
            addCriterion("par_menu_url =", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlNotEqualTo(String value) {
            addCriterion("par_menu_url <>", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlGreaterThan(String value) {
            addCriterion("par_menu_url >", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("par_menu_url >=", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlLessThan(String value) {
            addCriterion("par_menu_url <", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("par_menu_url <=", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlLike(String value) {
            addCriterion("par_menu_url like", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlNotLike(String value) {
            addCriterion("par_menu_url not like", value, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlIn(List<String> values) {
            addCriterion("par_menu_url in", values, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlNotIn(List<String> values) {
            addCriterion("par_menu_url not in", values, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlBetween(String value1, String value2) {
            addCriterion("par_menu_url between", value1, value2, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andParMenuUrlNotBetween(String value1, String value2) {
            addCriterion("par_menu_url not between", value1, value2, "parMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameIsNull() {
            addCriterion("child_menu_name is null");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameIsNotNull() {
            addCriterion("child_menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameEqualTo(String value) {
            addCriterion("child_menu_name =", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameNotEqualTo(String value) {
            addCriterion("child_menu_name <>", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameGreaterThan(String value) {
            addCriterion("child_menu_name >", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("child_menu_name >=", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameLessThan(String value) {
            addCriterion("child_menu_name <", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameLessThanOrEqualTo(String value) {
            addCriterion("child_menu_name <=", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameLike(String value) {
            addCriterion("child_menu_name like", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameNotLike(String value) {
            addCriterion("child_menu_name not like", value, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameIn(List<String> values) {
            addCriterion("child_menu_name in", values, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameNotIn(List<String> values) {
            addCriterion("child_menu_name not in", values, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameBetween(String value1, String value2) {
            addCriterion("child_menu_name between", value1, value2, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuNameNotBetween(String value1, String value2) {
            addCriterion("child_menu_name not between", value1, value2, "childMenuName");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlIsNull() {
            addCriterion("child_menu_url is null");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlIsNotNull() {
            addCriterion("child_menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlEqualTo(String value) {
            addCriterion("child_menu_url =", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlNotEqualTo(String value) {
            addCriterion("child_menu_url <>", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlGreaterThan(String value) {
            addCriterion("child_menu_url >", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("child_menu_url >=", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlLessThan(String value) {
            addCriterion("child_menu_url <", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("child_menu_url <=", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlLike(String value) {
            addCriterion("child_menu_url like", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlNotLike(String value) {
            addCriterion("child_menu_url not like", value, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlIn(List<String> values) {
            addCriterion("child_menu_url in", values, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlNotIn(List<String> values) {
            addCriterion("child_menu_url not in", values, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlBetween(String value1, String value2) {
            addCriterion("child_menu_url between", value1, value2, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andChildMenuUrlNotBetween(String value1, String value2) {
            addCriterion("child_menu_url not between", value1, value2, "childMenuUrl");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(Integer value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(Integer value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(Integer value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(Integer value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(Integer value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(Integer value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<Integer> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<Integer> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(Integer value1, Integer value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(Integer value1, Integer value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andSteelCordIsNull() {
            addCriterion("steel_cord is null");
            return (Criteria) this;
        }

        public Criteria andSteelCordIsNotNull() {
            addCriterion("steel_cord is not null");
            return (Criteria) this;
        }

        public Criteria andSteelCordEqualTo(Integer value) {
            addCriterion("steel_cord =", value, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordNotEqualTo(Integer value) {
            addCriterion("steel_cord <>", value, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordGreaterThan(Integer value) {
            addCriterion("steel_cord >", value, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordGreaterThanOrEqualTo(Integer value) {
            addCriterion("steel_cord >=", value, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordLessThan(Integer value) {
            addCriterion("steel_cord <", value, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordLessThanOrEqualTo(Integer value) {
            addCriterion("steel_cord <=", value, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordIn(List<Integer> values) {
            addCriterion("steel_cord in", values, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordNotIn(List<Integer> values) {
            addCriterion("steel_cord not in", values, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordBetween(Integer value1, Integer value2) {
            addCriterion("steel_cord between", value1, value2, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSteelCordNotBetween(Integer value1, Integer value2) {
            addCriterion("steel_cord not between", value1, value2, "steelCord");
            return (Criteria) this;
        }

        public Criteria andSbrRubberIsNull() {
            addCriterion("sbr_rubber is null");
            return (Criteria) this;
        }

        public Criteria andSbrRubberIsNotNull() {
            addCriterion("sbr_rubber is not null");
            return (Criteria) this;
        }

        public Criteria andSbrRubberEqualTo(Integer value) {
            addCriterion("sbr_rubber =", value, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberNotEqualTo(Integer value) {
            addCriterion("sbr_rubber <>", value, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberGreaterThan(Integer value) {
            addCriterion("sbr_rubber >", value, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sbr_rubber >=", value, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberLessThan(Integer value) {
            addCriterion("sbr_rubber <", value, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberLessThanOrEqualTo(Integer value) {
            addCriterion("sbr_rubber <=", value, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberIn(List<Integer> values) {
            addCriterion("sbr_rubber in", values, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberNotIn(List<Integer> values) {
            addCriterion("sbr_rubber not in", values, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberBetween(Integer value1, Integer value2) {
            addCriterion("sbr_rubber between", value1, value2, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andSbrRubberNotBetween(Integer value1, Integer value2) {
            addCriterion("sbr_rubber not between", value1, value2, "sbrRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberIsNull() {
            addCriterion("cis_rubber is null");
            return (Criteria) this;
        }

        public Criteria andCisRubberIsNotNull() {
            addCriterion("cis_rubber is not null");
            return (Criteria) this;
        }

        public Criteria andCisRubberEqualTo(Integer value) {
            addCriterion("cis_rubber =", value, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberNotEqualTo(Integer value) {
            addCriterion("cis_rubber <>", value, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberGreaterThan(Integer value) {
            addCriterion("cis_rubber >", value, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cis_rubber >=", value, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberLessThan(Integer value) {
            addCriterion("cis_rubber <", value, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberLessThanOrEqualTo(Integer value) {
            addCriterion("cis_rubber <=", value, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberIn(List<Integer> values) {
            addCriterion("cis_rubber in", values, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberNotIn(List<Integer> values) {
            addCriterion("cis_rubber not in", values, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberBetween(Integer value1, Integer value2) {
            addCriterion("cis_rubber between", value1, value2, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andCisRubberNotBetween(Integer value1, Integer value2) {
            addCriterion("cis_rubber not between", value1, value2, "cisRubber");
            return (Criteria) this;
        }

        public Criteria andNylonCordIsNull() {
            addCriterion("nylon_cord is null");
            return (Criteria) this;
        }

        public Criteria andNylonCordIsNotNull() {
            addCriterion("nylon_cord is not null");
            return (Criteria) this;
        }

        public Criteria andNylonCordEqualTo(Integer value) {
            addCriterion("nylon_cord =", value, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordNotEqualTo(Integer value) {
            addCriterion("nylon_cord <>", value, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordGreaterThan(Integer value) {
            addCriterion("nylon_cord >", value, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordGreaterThanOrEqualTo(Integer value) {
            addCriterion("nylon_cord >=", value, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordLessThan(Integer value) {
            addCriterion("nylon_cord <", value, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordLessThanOrEqualTo(Integer value) {
            addCriterion("nylon_cord <=", value, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordIn(List<Integer> values) {
            addCriterion("nylon_cord in", values, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordNotIn(List<Integer> values) {
            addCriterion("nylon_cord not in", values, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordBetween(Integer value1, Integer value2) {
            addCriterion("nylon_cord between", value1, value2, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andNylonCordNotBetween(Integer value1, Integer value2) {
            addCriterion("nylon_cord not between", value1, value2, "nylonCord");
            return (Criteria) this;
        }

        public Criteria andBeadWireIsNull() {
            addCriterion("bead_wire is null");
            return (Criteria) this;
        }

        public Criteria andBeadWireIsNotNull() {
            addCriterion("bead_wire is not null");
            return (Criteria) this;
        }

        public Criteria andBeadWireEqualTo(Integer value) {
            addCriterion("bead_wire =", value, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireNotEqualTo(Integer value) {
            addCriterion("bead_wire <>", value, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireGreaterThan(Integer value) {
            addCriterion("bead_wire >", value, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireGreaterThanOrEqualTo(Integer value) {
            addCriterion("bead_wire >=", value, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireLessThan(Integer value) {
            addCriterion("bead_wire <", value, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireLessThanOrEqualTo(Integer value) {
            addCriterion("bead_wire <=", value, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireIn(List<Integer> values) {
            addCriterion("bead_wire in", values, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireNotIn(List<Integer> values) {
            addCriterion("bead_wire not in", values, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireBetween(Integer value1, Integer value2) {
            addCriterion("bead_wire between", value1, value2, "beadWire");
            return (Criteria) this;
        }

        public Criteria andBeadWireNotBetween(Integer value1, Integer value2) {
            addCriterion("bead_wire not between", value1, value2, "beadWire");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackIsNull() {
            addCriterion("carbon_black is null");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackIsNotNull() {
            addCriterion("carbon_black is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackEqualTo(Integer value) {
            addCriterion("carbon_black =", value, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackNotEqualTo(Integer value) {
            addCriterion("carbon_black <>", value, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackGreaterThan(Integer value) {
            addCriterion("carbon_black >", value, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackGreaterThanOrEqualTo(Integer value) {
            addCriterion("carbon_black >=", value, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackLessThan(Integer value) {
            addCriterion("carbon_black <", value, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackLessThanOrEqualTo(Integer value) {
            addCriterion("carbon_black <=", value, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackIn(List<Integer> values) {
            addCriterion("carbon_black in", values, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackNotIn(List<Integer> values) {
            addCriterion("carbon_black not in", values, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackBetween(Integer value1, Integer value2) {
            addCriterion("carbon_black between", value1, value2, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andCarbonBlackNotBetween(Integer value1, Integer value2) {
            addCriterion("carbon_black not between", value1, value2, "carbonBlack");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberIsNull() {
            addCriterion("natural_rubber is null");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberIsNotNull() {
            addCriterion("natural_rubber is not null");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberEqualTo(Integer value) {
            addCriterion("natural_rubber =", value, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberNotEqualTo(Integer value) {
            addCriterion("natural_rubber <>", value, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberGreaterThan(Integer value) {
            addCriterion("natural_rubber >", value, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberGreaterThanOrEqualTo(Integer value) {
            addCriterion("natural_rubber >=", value, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberLessThan(Integer value) {
            addCriterion("natural_rubber <", value, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberLessThanOrEqualTo(Integer value) {
            addCriterion("natural_rubber <=", value, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberIn(List<Integer> values) {
            addCriterion("natural_rubber in", values, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberNotIn(List<Integer> values) {
            addCriterion("natural_rubber not in", values, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberBetween(Integer value1, Integer value2) {
            addCriterion("natural_rubber between", value1, value2, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andNaturalRubberNotBetween(Integer value1, Integer value2) {
            addCriterion("natural_rubber not between", value1, value2, "naturalRubber");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianIsNull() {
            addCriterion("tyre_produce_meridian is null");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianIsNotNull() {
            addCriterion("tyre_produce_meridian is not null");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianEqualTo(Integer value) {
            addCriterion("tyre_produce_meridian =", value, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianNotEqualTo(Integer value) {
            addCriterion("tyre_produce_meridian <>", value, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianGreaterThan(Integer value) {
            addCriterion("tyre_produce_meridian >", value, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianGreaterThanOrEqualTo(Integer value) {
            addCriterion("tyre_produce_meridian >=", value, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianLessThan(Integer value) {
            addCriterion("tyre_produce_meridian <", value, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianLessThanOrEqualTo(Integer value) {
            addCriterion("tyre_produce_meridian <=", value, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianIn(List<Integer> values) {
            addCriterion("tyre_produce_meridian in", values, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianNotIn(List<Integer> values) {
            addCriterion("tyre_produce_meridian not in", values, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianBetween(Integer value1, Integer value2) {
            addCriterion("tyre_produce_meridian between", value1, value2, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceMeridianNotBetween(Integer value1, Integer value2) {
            addCriterion("tyre_produce_meridian not between", value1, value2, "tyreProduceMeridian");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeIsNull() {
            addCriterion("tyre_produce_tappe is null");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeIsNotNull() {
            addCriterion("tyre_produce_tappe is not null");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeEqualTo(Integer value) {
            addCriterion("tyre_produce_tappe =", value, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeNotEqualTo(Integer value) {
            addCriterion("tyre_produce_tappe <>", value, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeGreaterThan(Integer value) {
            addCriterion("tyre_produce_tappe >", value, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tyre_produce_tappe >=", value, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeLessThan(Integer value) {
            addCriterion("tyre_produce_tappe <", value, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeLessThanOrEqualTo(Integer value) {
            addCriterion("tyre_produce_tappe <=", value, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeIn(List<Integer> values) {
            addCriterion("tyre_produce_tappe in", values, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeNotIn(List<Integer> values) {
            addCriterion("tyre_produce_tappe not in", values, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeBetween(Integer value1, Integer value2) {
            addCriterion("tyre_produce_tappe between", value1, value2, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andTyreProduceTappeNotBetween(Integer value1, Integer value2) {
            addCriterion("tyre_produce_tappe not between", value1, value2, "tyreProduceTappe");
            return (Criteria) this;
        }

        public Criteria andReclaRubberIsNull() {
            addCriterion("recla_rubber is null");
            return (Criteria) this;
        }

        public Criteria andReclaRubberIsNotNull() {
            addCriterion("recla_rubber is not null");
            return (Criteria) this;
        }

        public Criteria andReclaRubberEqualTo(Integer value) {
            addCriterion("recla_rubber =", value, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberNotEqualTo(Integer value) {
            addCriterion("recla_rubber <>", value, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberGreaterThan(Integer value) {
            addCriterion("recla_rubber >", value, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberGreaterThanOrEqualTo(Integer value) {
            addCriterion("recla_rubber >=", value, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberLessThan(Integer value) {
            addCriterion("recla_rubber <", value, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberLessThanOrEqualTo(Integer value) {
            addCriterion("recla_rubber <=", value, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberIn(List<Integer> values) {
            addCriterion("recla_rubber in", values, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberNotIn(List<Integer> values) {
            addCriterion("recla_rubber not in", values, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberBetween(Integer value1, Integer value2) {
            addCriterion("recla_rubber between", value1, value2, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andReclaRubberNotBetween(Integer value1, Integer value2) {
            addCriterion("recla_rubber not between", value1, value2, "reclaRubber");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNull() {
            addCriterion("inserttime is null");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNotNull() {
            addCriterion("inserttime is not null");
            return (Criteria) this;
        }

        public Criteria andInserttimeEqualTo(Date value) {
            addCriterion("inserttime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterion("inserttime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterion("inserttime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inserttime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterion("inserttime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterion("inserttime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterion("inserttime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterion("inserttime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterion("inserttime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterion("inserttime not between", value1, value2, "inserttime");
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