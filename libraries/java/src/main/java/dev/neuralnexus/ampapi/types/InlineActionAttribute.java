/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * An inline action object
 *
 * @param Argument The argument
 * @param Caption The caption
 * @param IsClientSide Whether the action is client-side
 * @param Method The method
 * @param Module The module
 */
public record InlineActionAttribute(
        String Argument, String Caption, Boolean IsClientSide, String Method, String Module) {}
