package com.fviel.jsonmngr.FinEvents.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinancialEvent(
    Long id,
    LocalDateTime timestamp,
    String type,
    String category,
    String description,
    BigDecimal value
) {}
