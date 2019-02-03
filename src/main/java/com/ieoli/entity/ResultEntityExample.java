package com.ieoli.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultEntityExample() {
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

        public Criteria andResultidIsNull() {
            addCriterion("resultID is null");
            return (Criteria) this;
        }

        public Criteria andResultidIsNotNull() {
            addCriterion("resultID is not null");
            return (Criteria) this;
        }

        public Criteria andResultidEqualTo(Integer value) {
            addCriterion("resultID =", value, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidNotEqualTo(Integer value) {
            addCriterion("resultID <>", value, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidGreaterThan(Integer value) {
            addCriterion("resultID >", value, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidGreaterThanOrEqualTo(Integer value) {
            addCriterion("resultID >=", value, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidLessThan(Integer value) {
            addCriterion("resultID <", value, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidLessThanOrEqualTo(Integer value) {
            addCriterion("resultID <=", value, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidIn(List<Integer> values) {
            addCriterion("resultID in", values, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidNotIn(List<Integer> values) {
            addCriterion("resultID not in", values, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidBetween(Integer value1, Integer value2) {
            addCriterion("resultID between", value1, value2, "resultid");
            return (Criteria) this;
        }

        public Criteria andResultidNotBetween(Integer value1, Integer value2) {
            addCriterion("resultID not between", value1, value2, "resultid");
            return (Criteria) this;
        }

        public Criteria andTextidIsNull() {
            addCriterion("textID is null");
            return (Criteria) this;
        }

        public Criteria andTextidIsNotNull() {
            addCriterion("textID is not null");
            return (Criteria) this;
        }

        public Criteria andTextidEqualTo(Integer value) {
            addCriterion("textID =", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidNotEqualTo(Integer value) {
            addCriterion("textID <>", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidGreaterThan(Integer value) {
            addCriterion("textID >", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidGreaterThanOrEqualTo(Integer value) {
            addCriterion("textID >=", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidLessThan(Integer value) {
            addCriterion("textID <", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidLessThanOrEqualTo(Integer value) {
            addCriterion("textID <=", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidIn(List<Integer> values) {
            addCriterion("textID in", values, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidNotIn(List<Integer> values) {
            addCriterion("textID not in", values, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidBetween(Integer value1, Integer value2) {
            addCriterion("textID between", value1, value2, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidNotBetween(Integer value1, Integer value2) {
            addCriterion("textID not between", value1, value2, "textid");
            return (Criteria) this;
        }

        public Criteria andModelidIsNull() {
            addCriterion("modelID is null");
            return (Criteria) this;
        }

        public Criteria andModelidIsNotNull() {
            addCriterion("modelID is not null");
            return (Criteria) this;
        }

        public Criteria andModelidEqualTo(Integer value) {
            addCriterion("modelID =", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotEqualTo(Integer value) {
            addCriterion("modelID <>", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidGreaterThan(Integer value) {
            addCriterion("modelID >", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("modelID >=", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLessThan(Integer value) {
            addCriterion("modelID <", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLessThanOrEqualTo(Integer value) {
            addCriterion("modelID <=", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidIn(List<Integer> values) {
            addCriterion("modelID in", values, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotIn(List<Integer> values) {
            addCriterion("modelID not in", values, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidBetween(Integer value1, Integer value2) {
            addCriterion("modelID between", value1, value2, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotBetween(Integer value1, Integer value2) {
            addCriterion("modelID not between", value1, value2, "modelid");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueIsNull() {
            addCriterion("isStrictTrue is null");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueIsNotNull() {
            addCriterion("isStrictTrue is not null");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueEqualTo(Boolean value) {
            addCriterion("isStrictTrue =", value, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueNotEqualTo(Boolean value) {
            addCriterion("isStrictTrue <>", value, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueGreaterThan(Boolean value) {
            addCriterion("isStrictTrue >", value, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isStrictTrue >=", value, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueLessThan(Boolean value) {
            addCriterion("isStrictTrue <", value, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueLessThanOrEqualTo(Boolean value) {
            addCriterion("isStrictTrue <=", value, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueIn(List<Boolean> values) {
            addCriterion("isStrictTrue in", values, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueNotIn(List<Boolean> values) {
            addCriterion("isStrictTrue not in", values, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueBetween(Boolean value1, Boolean value2) {
            addCriterion("isStrictTrue between", value1, value2, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIsstricttrueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isStrictTrue not between", value1, value2, "isstricttrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueIsNull() {
            addCriterion("isEasyTrue is null");
            return (Criteria) this;
        }

        public Criteria andIseasytrueIsNotNull() {
            addCriterion("isEasyTrue is not null");
            return (Criteria) this;
        }

        public Criteria andIseasytrueEqualTo(Boolean value) {
            addCriterion("isEasyTrue =", value, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueNotEqualTo(Boolean value) {
            addCriterion("isEasyTrue <>", value, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueGreaterThan(Boolean value) {
            addCriterion("isEasyTrue >", value, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isEasyTrue >=", value, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueLessThan(Boolean value) {
            addCriterion("isEasyTrue <", value, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueLessThanOrEqualTo(Boolean value) {
            addCriterion("isEasyTrue <=", value, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueIn(List<Boolean> values) {
            addCriterion("isEasyTrue in", values, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueNotIn(List<Boolean> values) {
            addCriterion("isEasyTrue not in", values, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueBetween(Boolean value1, Boolean value2) {
            addCriterion("isEasyTrue between", value1, value2, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andIseasytrueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isEasyTrue not between", value1, value2, "iseasytrue");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsefulIsNull() {
            addCriterion("useful is null");
            return (Criteria) this;
        }

        public Criteria andUsefulIsNotNull() {
            addCriterion("useful is not null");
            return (Criteria) this;
        }

        public Criteria andUsefulEqualTo(Boolean value) {
            addCriterion("useful =", value, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulNotEqualTo(Boolean value) {
            addCriterion("useful <>", value, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulGreaterThan(Boolean value) {
            addCriterion("useful >", value, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulGreaterThanOrEqualTo(Boolean value) {
            addCriterion("useful >=", value, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulLessThan(Boolean value) {
            addCriterion("useful <", value, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulLessThanOrEqualTo(Boolean value) {
            addCriterion("useful <=", value, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulIn(List<Boolean> values) {
            addCriterion("useful in", values, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulNotIn(List<Boolean> values) {
            addCriterion("useful not in", values, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulBetween(Boolean value1, Boolean value2) {
            addCriterion("useful between", value1, value2, "useful");
            return (Criteria) this;
        }

        public Criteria andUsefulNotBetween(Boolean value1, Boolean value2) {
            addCriterion("useful not between", value1, value2, "useful");
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