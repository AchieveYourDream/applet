package com.kute.appletcore.vo;

import com.kute.appletcore.entity.AppStitchWork;
import com.kute.appletcore.entity.AppStitchWorkPosition;

import java.util.List;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class AppStitchWorkVO extends AppStitchWorkPosition {

   private List<AppStitchWork> list;

    public List<AppStitchWork> getList() {
        return list;
    }

    public void setList(List<AppStitchWork> list) {
        this.list = list;
    }
}
