package com.windj0y.jee.hw0.bean.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBuser_reg {
    @NonNull int uid;
    @NonNull String nickname;
    @NonNull String password;
    @NonNull int role;
}
