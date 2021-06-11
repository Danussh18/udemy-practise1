package com.example.udemypractise1.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class InQueryRequest {
    List<String> firstNames;
}
