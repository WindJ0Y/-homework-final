package com.windj0y.jee.hw0.bean.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBsubmit {
    @NonNull int sid;
    @NonNull int hid;
    @NonNull int uid;
    @NonNull String stutext;
    @NonNull String tchtext;
}
