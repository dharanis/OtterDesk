package com.example.otterdesk.Entity;


import lombok.Builder;
import lombok.Data;

@Data
public class Message {

    String bluePrintId;
    String currentProcessingState;
    String fileLocation;
    Long createTime;

    @Builder
    public Message(String bluePrintId, String currentProcessingState, String fileLocation, Long createTime) {
        this.bluePrintId = bluePrintId;
        this.currentProcessingState = currentProcessingState;
        this.fileLocation = fileLocation;
        this.createTime = createTime;
    }
}
