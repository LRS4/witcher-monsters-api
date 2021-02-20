package com.example.monsters.util;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static com.example.monsters.util.StringUtils.capitalise;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
public class StringUtilsTests {

    @Test
    void itShouldCapitaliseAString() {
        // Arrange
        String monsterName = "bears";

        // Act
        String capitalisedString = capitalise(monsterName);
        Character firstLetter = capitalisedString.charAt(0);

        // Assert
        assertThat(firstLetter).isUpperCase();
    }
}
