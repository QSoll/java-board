package br.com.dio.dto;

import java.time.OffsetDateTime;

import br.com.dio.persistence.entity.CardPriority;

public record CardDetailsDTO(Long id,
        String title,
        String description,
                CardPriority priority, 
        boolean blocked,
        OffsetDateTime blockedAt,
        String blockReason,
        int blocksAmount,
        Long columnId,
        String columnName) {
}
