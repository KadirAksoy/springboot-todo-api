package com.kadiraksoy.springboottodoapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.time.LocalDate;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Field("sequence")
    @EqualsAndHashCode.Include
    private String id;
    @Field
    private String userId;
    @Field
    private String title;
    @Field
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDate date;
    @Field
    private String description;
    @Field
    private Boolean completed;
}