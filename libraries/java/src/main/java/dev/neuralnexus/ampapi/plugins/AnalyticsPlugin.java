/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class AnalyticsPlugin extends AMPAPI {
    public AnalyticsPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     *
     * @param PeriodDays
     * @param StartDate
     * @param Filters
     * @return Object
     */
    public Object GetAnalyticsSummary(
            @Nullable Integer PeriodDays,
            @Nullable String StartDate,
            @Nullable Map<String, String> Filters) {
        Map<String, Object> args = new HashMap<>();
        args.put("PeriodDays", PeriodDays);
        args.put("StartDate", StartDate);
        args.put("Filters", Filters);
        Type type = new TypeToken<Object>() {}.getType();
        return this.APICall("AnalyticsPlugin/GetAnalyticsSummary", args, type);
    }
}
