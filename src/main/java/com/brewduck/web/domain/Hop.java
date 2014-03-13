package com.brewduck.web.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;


/**
 * <pre>
 * 홉 Value Object.
 * </pre>
 *
 * @author  chacha
 * @version 1.0, 2014.02.16
 */
public class Hop implements Serializable {
    private static final long serialVersionUID = 1L;

    // 홉 영문명
    private String name;
    // 홉 한글명
    private String koreanName;
    // 홉 버전
    private Integer version;
    // 홉 투명도
    private Double alpha;
    // 홉 량
    private Double amount;
    // 홉 사용 용도
    private String hopsUse;
    // 홉 사용 용도의 시간(단위:분)
    private Integer time;
    // 설명
    private String notes;
    // 홉의 용도 (쓴맛,향,둘다)
    private String type;
    // 홉의 형태(Pellet, Plug, Leaf)
    private String form;
    // 홉 베타값(단위: %)
    private Double beta;
    // 홉 알파값 손실율(단위: %)
    private Double hsi;
    // 홉 원산지
    private String origin;
    // 홉 대체 재료
    private String substitutes;
    // Humulene 함량 (단위 : %) 향기의 주성분
    private Double humulene;
    // Caryophyllene 함량 (단위 : %)
    private Double caryophyllene;
    // Cohumulone 함량 (단위 :%)
    private Double cohumulone;
    // Myrcene 함량 (단위 : %) 항기의 주성분
    private Double myrcene;
    // 작성자 아이디
    private String insertId;
    // 작성자 날짜
    private Date insertDate;
    // 수정자 아이디
    private String updateId;
    // 수정자 날짜
    private Date updateDate;
    // 삭제자 아이디
    private String deleteId;
    // 삭제자 날짜
    private Date deleteDate;
    // 저장 성공 여부
    private Boolean insertFlag;
    // 수정 성공 여부
    private Boolean updateFlag;
    // 삭제 성공 여부
    private Boolean deleteFlag;


    /**
     * 홉 영문명
     *
     * @return 홉 영문명
     */
    public String getName() {
        return name;
    }

    /**
     * 홉 영문명
     *
     * @param name 홉 영문명
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 홉 한글명
     *
     * @return 홉 한글명
     */
    public String getKoreanName() {
        return koreanName;
    }

    /**
     * 홉 한글명
     *
     * @param koreanName 홉 한글명
     */
    public void setKoreanName(String koreanName) {
        this.koreanName = koreanName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getHopsUse() {
        return hopsUse;
    }

    public void setHopsUse(String hopsUse) {
        this.hopsUse = hopsUse;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getHsi() {
        return hsi;
    }

    public void setHsi(Double hsi) {
        this.hsi = hsi;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(String substitutes) {
        this.substitutes = substitutes;
    }

    public Double getHumulene() {
        return humulene;
    }

    public void setHumulene(Double humulene) {
        this.humulene = humulene;
    }

    public Double getCaryophyllene() {
        return caryophyllene;
    }

    public void setCaryophyllene(Double caryophyllene) {
        this.caryophyllene = caryophyllene;
    }

    public Double getCohumulone() {
        return cohumulone;
    }

    public void setCohumulone(Double cohumulone) {
        this.cohumulone = cohumulone;
    }

    public Double getMyrcene() {
        return myrcene;
    }

    public void setMyrcene(Double myrcene) {
        this.myrcene = myrcene;
    }

    /**
     * 작성자 아이디
     *
     * @return 작성자 아이디
     */
    public String getInsertId() {
        return insertId;
    }

    /**
     * 작성자 아이디
     *
     * @param insertId 작성자 아이디
     */
    public void setInsertId(String insertId) {
        this.insertId = insertId;
    }

    /**
     * 작성 날짜
     *
     * @return 작성 날짜
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * 작성 날짜
     *
     * @param insertDate 작성 날짜
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * 수정자 아이디
     *
     * @return 수정자 아이디
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 수정자 아이디
     *
     * @param updateId 수정자 아이디
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    /**
     * 수정 날짜
     *
     * @return 수정 날짜
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 수정 날짜
     *
     * @param updateDate 수정 날짜
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 삭제자 아이디
     *
     * @return 삭제자 아이디
     */
    public String getDeleteId() {
        return deleteId;
    }

    /**
     * 삭제자 아이디
     *
     * @param deleteId 삭제자 아이디
     */
    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }

    /**
     * 삭제 날짜
     *
     * @return 삭제 날짜
     */
    public Date getDeleteDate() {
        return deleteDate;
    }

    /**
     * 삭제 날짜
     *
     * @param deleteDate 삭제 날짜
     */
    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    /**
     * 저장 성공 여부.
     *
     * @return 저장 성공 여부
     */
    public Boolean getInsertFlag() {
        return insertFlag;
    }

    /**
     * 저장 성공 여부.
     *
     * @param insertFlag 저장 성공 여부
     */
    public void setInsertFlag(Boolean insertFlag) {
        this.insertFlag = insertFlag;
    }

    /**
     * 수정 성공 여부.
     *
     * @return 수정 성공 여부
     */
    public Boolean getUpdateFlag() {
        return updateFlag;
    }

    /**
     * 수정 성공 여부.
     *
     * @param updateFlag 수정 성공 여부
     */
    public void setUpdateFlag(Boolean updateFlag) {
        this.updateFlag = updateFlag;
    }

    /**
     * 삭제 성공 여부.
     *
     * @return 삭제 성공 여부
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 삭제 성공 여부.
     *
     * @param deleteFlag 삭제 성공 여부
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
