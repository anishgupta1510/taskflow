package com.greening_india.interfaces.advice;

import java.util.Map;

public record ValidationErrorResponse(
        String error,
        Map<String, String> fields
) {}
