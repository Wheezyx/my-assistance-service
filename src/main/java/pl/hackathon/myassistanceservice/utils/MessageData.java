package pl.hackathon.myassistanceservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageData {
    private final String directPerson;
    private final String helperPersonName;
    private final String helperPersonLink;
}
