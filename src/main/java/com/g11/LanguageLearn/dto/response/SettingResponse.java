package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SettingResponse {
    private Integer noticeCheckin; //chi co 0 va 1

    private Integer timeBeforeCheckin; //bao truoc gio checkin

    private Integer noticePoint; //chi co 0 va 1
}
