package com.random.modnar.team;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerRequest {

    @NotBlank(message = "Player name is required")
    private String name;

    @NotBlank(message = "Position is required")
    private String position;

    @Min(value = 16, message = "Player must be at least 16")
    @Max(value = 50, message = "Invalid age")
    private int age;

    @NotNull(message = "Team id is required")
    private Long teamId;
}
