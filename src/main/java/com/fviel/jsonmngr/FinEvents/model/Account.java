package com.fviel.jsonmngr.FinEvents.model;

import java.math.BigDecimal;
import java.util.List;

public record Account(
    Long id,
    String ownnerName,
    BigDecimal initialValue,
    String coin,
    List<FinancialEvent> events
) {}
