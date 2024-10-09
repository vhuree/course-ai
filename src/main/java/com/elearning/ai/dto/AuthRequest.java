package com.elearning.ai.dto;

import jakarta.annotation.Nonnull;

public record AuthRequest(@Nonnull String username, @Nonnull String password){}

