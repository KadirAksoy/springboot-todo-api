package com.kadiraksoy.springboottodoapi.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TodoResponseDTO implements Serializable {
    @JsonProperty("id")
    @NotBlank
    String id;
    @JsonProperty("title")
    @NotBlank
    String title;
    @JsonProperty("date")
    @NotNull
    LocalDate date;
    @JsonProperty("description")
    String description;
    @JsonProperty("completed")
    @NotNull
    @Builder.Default
    Boolean completed = false;
}
