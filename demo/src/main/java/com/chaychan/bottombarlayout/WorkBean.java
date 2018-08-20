package com.chaychan.bottombarlayout;
import java.util.Date;

/**
 * @Project:Symphony-m
 * @Package com.sh.ydzy.overhaui.bean
 * @create_time:2017/5/12 12:10
 * @Description: 数据封装
 * @author:lxr
 * @version: v1.0.0
 */
public class WorkBean {

    private long ID;

    private String taskName;

    private Date clikTime;

    private boolean isValid;//判断是否有效

    private int srcImage;
    private String taskNumber;//数目/百分比/份数/小时/张数
    private int workType;
    private boolean isEnableClick = true;

    public WorkBean() {
    }

    public WorkBean(int srcImage, String taskName, boolean isEnableClick) {
        this.srcImage = srcImage;
        this.taskName = taskName;
        this.isEnableClick = isEnableClick;
    }

    public WorkBean(int srcImage, String taskName, boolean isEnableClick, boolean isValid) {
        this.srcImage = srcImage;
        this.taskName = taskName;
        this.isEnableClick = isEnableClick;
        this.isValid = isValid;
    }

    public WorkBean(int srcImage, String taskName, String taskNumber, boolean isEnableClick) {
        this.srcImage = srcImage;
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.isEnableClick = isEnableClick;
    }

    public WorkBean(String taskName, String taskNumber) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
    }

    public WorkBean(String taskName, int workType) {
        this.taskName = taskName;
        this.workType = workType;

    }


    public Date getClikTime() {
        return this.clikTime;
    }

    public void setClikTime(Date clikTime) {
        this.clikTime = clikTime;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public long getID() {
        return this.ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public WorkBean(long ID, String taskName, Date clikTime, boolean isValid) {
        this.ID = ID;
        this.taskName = taskName;
        this.clikTime = clikTime;
        this.isValid = isValid;
    }

    public int getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(int srcImage) {
        this.srcImage = srcImage;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public int getWorkType() {
        return workType;
    }

    public void setWorkType(int workType) {
        this.workType = workType;
    }

    public boolean isEnableClick() {
        return isEnableClick;
    }

    public void setEnableClick(boolean enableClick) {
        isEnableClick = enableClick;
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}
