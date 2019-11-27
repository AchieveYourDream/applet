package com.kute.appletcore.entity;

public class AppStitchWorkRelation {
    /**
     * 刺绣ID
     */
    private Integer stitchWorkId;

    /**
     * 位置ID
     */
    private Integer positionId;

    /**
     * 刺绣ID
     * @return stitchWork_id 刺绣ID
     */
    public Integer getStitchWorkId() {
        return stitchWorkId;
    }

    /**
     * 刺绣ID
     * @param stitchWorkId 刺绣ID
     */
    public void setStitchWorkId(Integer stitchWorkId) {
        this.stitchWorkId = stitchWorkId;
    }

    /**
     * 位置ID
     * @return position_id 位置ID
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 位置ID
     * @param positionId 位置ID
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}