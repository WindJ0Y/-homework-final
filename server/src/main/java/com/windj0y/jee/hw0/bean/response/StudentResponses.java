package com.windj0y.jee.hw0.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class StudentResponses {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListHomeworkResponse {
        int state;
        String msg;
        List<elm> list;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class elm {
            int id;
            String name;
            boolean submited;
            boolean bbed;
            String content;
        }

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoHomeworkResponse {
        int state;
        String msg;
        int id;
        String name;
        boolean submited;
        boolean bbed;
        String stutext;
        String tectext;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubmitHomeworkResponse {
        int state;
        String msg;
    }

}
