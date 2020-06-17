package com.windj0y.jee.hw0.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class TeacherResponses {

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
            int submitcnt;
            int readcnt;
            int total;
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
        List<elm> list;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class elm {
            int sid;
            String name;
            String stutext;
            String tchtext;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubmitHomeworkResponse {
        int state;
        String msg;
    }

}
