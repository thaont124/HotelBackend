package com.g11.LanguageLearn.dto.request;

import lombok.Data;

@Data
public class SettingUpdateRequest {
    private Integer noticeCheckin; //chi co 0 va 1

    private Integer timeBeforeCheckin; //bao truoc gio checkin

    private Integer noticePoint; //chi co 0 va 1
}
